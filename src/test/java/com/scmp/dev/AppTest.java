package com.scmp.dev;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecwid.maleorang.MailchimpClient;
import com.ecwid.maleorang.MailchimpObject;
import com.ecwid.maleorang.method.v3_0.members.EditMemberMethod;
import com.ecwid.maleorang.method.v3_0.members.MemberInfo;
import com.scmp.dev.entity.CubeMailChimpMember;
import com.scmp.dev.reporsitory.CubeMailChimpMemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	
	@Autowired
	private CubeMailChimpMemberRepository cubeMailChimpMemberRepository;
	
	@Test
	public void runTest() throws IOException  {
		long time2, time1;
		try{
			ExecutorService exe = Executors.newFixedThreadPool(50);
			System.out.println(cubeMailChimpMemberRepository.findAll(PageRequest.of(0, 2500)).getTotalElements());
			time1 = System.currentTimeMillis();
			for(int i =0; i <4; i++){
				Page<CubeMailChimpMember> page = cubeMailChimpMemberRepository.findAll(PageRequest.of(i, 2500));
				exe.execute(new UploadThread("1b64edce4f", page.getContent()));
			}
			exe.shutdown();  
	        System.out.println("Shutdown");  
	        while(true){ 
	            if(exe.isTerminated()){  
	                System.out.println("Finish");  
	                break;  
	            }  
	            Thread.sleep(1000);    
	        }
	        time2 = System.currentTimeMillis();
			System.out.println("TIME : " + ((time2 - time1) / 1000) + "second");
		}catch(Exception e){
			e.printStackTrace();
		}finally{

		}
	}

	public void test() throws Exception {

		MailchimpClient client = new MailchimpClient("b7c83c67e56234c851aabce8930b076b-us19");
		try {
			EditMemberMethod.CreateOrUpdate psot = new EditMemberMethod.CreateOrUpdate("758ae3fa17", "vasya.pupkin@gmail.com");
			psot.status = "subscribed";
			psot.merge_fields = new MailchimpObject();
			psot.merge_fields.mapping.put("FNAME", "Vasya");
			psot.merge_fields.mapping.put("LNAME", "Pupkin");
			psot.merge_fields.mapping.put("LNAME", "Pupkin");
			MemberInfo member = client.execute(psot);
            //System.err.println("The user has been successfully subscribed: " + psot);A
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			client.close();
		}
	}
	
}
