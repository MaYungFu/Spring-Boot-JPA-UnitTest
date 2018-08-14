package com.scmp.dev;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.scmp.dev.entity.MasterIdKey;
import com.scmp.dev.entity.MasterIdKeyPK;
import com.scmp.dev.reporsitory.MasterIdKeyRepositoy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	
	@Autowired
	private MasterIdKeyRepositoy masterIdKeyRepositoy;
	
	@Test
	public void runTest() {
		try{
			this.insertFromCsv(new File(""));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Finish");
	}

	public void insertFromCsv(File csvFile) throws Exception {
		if(!csvFile.exists()){
			throw new Exception("Can not find Csv File");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Reader reader = Files.newBufferedReader(Paths.get(csvFile.getPath()));
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
        	MasterIdKey masterIdKey = new MasterIdKey();
        	MasterIdKeyPK masterIdKeyPK = new MasterIdKeyPK();
        	masterIdKeyPK.setFullVisitorId(nextRecord[0]);
        	masterIdKeyPK.setEmarsysAccountId(nextRecord[1]);
        	masterIdKeyPK.setEmarsysHashedId(nextRecord[2]);
        	masterIdKeyPK.setEmarsysUnhashedId(nextRecord[3]);
        	masterIdKeyPK.setEmarsysCampaignId(nextRecord[4]);
        	masterIdKeyPK.setIdfa(nextRecord[5]);
        	masterIdKeyPK.setAdid(nextRecord[6]);
        	masterIdKeyPK.setCpjobsJobseekerId(nextRecord[7]);
        	masterIdKeyPK.setCpjobsEmployerId(nextRecord[8]);
        	masterIdKeyPK.setCpjobsTrackingUserToken(nextRecord[9]);
        	masterIdKeyPK.setLotameId(nextRecord[10]);
        	masterIdKey.setMasterIdKeyPK(masterIdKeyPK);
        	masterIdKey.setDate(sdf.parse(nextRecord[9]));
        	masterIdKeyRepositoy.save(masterIdKey);
        }
		csvReader.close();
		reader.close();
		System.gc();
	}
}
