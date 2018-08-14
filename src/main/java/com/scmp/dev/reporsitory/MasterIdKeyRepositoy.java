package com.scmp.dev.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scmp.dev.entity.MasterIdKey;
import com.scmp.dev.entity.MasterIdKeyPK;




public interface MasterIdKeyRepositoy extends JpaRepository<MasterIdKey, MasterIdKeyPK> {

	
}
