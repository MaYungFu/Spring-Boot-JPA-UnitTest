package com.scmp.dev.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="MASTER_ID_KEYS")
@NamedQuery(name="MasterIdKey.findAll", query="SELECT m FROM MasterIdKey m")
public class MasterIdKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MasterIdKeyPK masterIdKeyPK;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	public MasterIdKey() {
		
	}
	
	public MasterIdKeyPK getMasterIdKeyPK() {
		return masterIdKeyPK;
	}

	public void setMasterIdKeyPK(MasterIdKeyPK masterIdKeyPK) {
		this.masterIdKeyPK = masterIdKeyPK;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}