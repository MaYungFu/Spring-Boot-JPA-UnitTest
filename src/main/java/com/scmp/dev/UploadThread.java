package com.scmp.dev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ecwid.maleorang.MailchimpClient;
import com.ecwid.maleorang.MailchimpMethod;
import com.ecwid.maleorang.MailchimpObject;
import com.ecwid.maleorang.method.v3_0.batches.GetBatchStatusMethod;
import com.ecwid.maleorang.method.v3_0.batches.StartBatchMethod;
import com.ecwid.maleorang.method.v3_0.members.EditMemberMethod;
import com.scmp.dev.entity.CubeMailChimpMember;

public class UploadThread implements Runnable{
	private String listId;
	private List<CubeMailChimpMember> cubes;
	
	UploadThread(String listId, List<CubeMailChimpMember> cubes) {
		this.listId = listId;
		this.cubes = cubes;
	}
	
	public void run() {
		MailchimpClient client = new MailchimpClient("b7c83c67e56234c851aabce8930b076b-us19");
		try{
			List<? extends MailchimpMethod<?>> methodList = new ArrayList();
			MethodList list = new MethodList();
			EditMemberMethod.CreateOrUpdate method = null;
			for(CubeMailChimpMember cube : cubes){
				method = new EditMemberMethod.CreateOrUpdate(listId, cube.getEmail());
				method.status = "subscribed";
				method.merge_fields = new MailchimpObject();
				method.merge_fields.mapping.put("FNAME", cube.getFirstName());
				method.merge_fields.mapping.put("LNAME", cube.getLastName());
				method.merge_fields.mapping.put("ADDRESS", cube.getAddress());
				method.merge_fields.mapping.put("PHONE", cube.getPhone());
				method.merge_fields.mapping.put("BU", cube.getBusinessUnit());
				method.merge_fields.mapping.put("SYSTEM", cube.getSourceSystem());
				method.merge_fields.mapping.put("FIELD", cube.getFieldType());
				method.merge_fields.mapping.put("COUNTRY", cube.getCountry());
				method.merge_fields.mapping.put("EDUCATION", cube.getEducation());
				method.merge_fields.mapping.put("MOBILE", cube.getMobile());
				method.merge_fields.mapping.put("AGE", cube.getAge());
				list.add(method);
			}
			methodList.addAll(list);
			StartBatchMethod batch = new StartBatchMethod(methodList);
			String batchId = client.execute(batch).id;
			String status = null;
			do{
 				status = client.execute(new GetBatchStatusMethod(batchId)).status;
				Thread.sleep(3000);
			}while(!status.equals("finished"));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}
	
	public List<CubeMailChimpMember> getCubes() {
		return cubes;
	}

	public void setCubes(List<CubeMailChimpMember> cubes) {
		this.cubes = cubes;
	}
	
}
