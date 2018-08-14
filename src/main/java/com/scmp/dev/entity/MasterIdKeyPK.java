package com.scmp.dev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MasterIdKeyPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="FULL_VISITOR_ID")
	private String fullVisitorId;

	@Column(name="GA_PROPERTY_ID")
	private String ga_property_id;
	
	@Column(name="EMARSYS_ACCOUNT_ID")
	private String emarsysAccountId;

	@Column(name="EMARSYS_HASHED_ID")
	private String emarsysHashedId;
	
	@Column(name="EMARSYS_UNHASHED_ID")
	private String emarsysUnhashedId;
	
	@Column(name="EMARSYS_CAMPAIGN_ID")
	private String emarsysCampaignId;
	
	@Column(name="IDFA")
	private String idfa;
	
	@Column(name="ADID")
	private String adid;
	
	@Column(name="CPJOBS_JOBSEEKER_ID")
	private String cpjobsJobseekerId;
	
	@Column(name="CPJOBS_EMPLOYER_ID")
	private String cpjobsEmployerId;

	@Column(name="CPJOBS_TRACKING_USER_TOKEN")
	private String cpjobsTrackingUserToken;

	@Column(name="LOTAME_ID")
	private String lotameId;
	
	@Column(name="MAGAZINE_ID")
	private String magazine_id;

	public String getFullVisitorId() {
		return fullVisitorId;
	}

	public void setFullVisitorId(String fullVisitorId) {
		this.fullVisitorId = fullVisitorId;
	}

	public String getGa_property_id() {
		return ga_property_id;
	}

	public void setGa_property_id(String ga_property_id) {
		this.ga_property_id = ga_property_id;
	}

	public String getEmarsysAccountId() {
		return emarsysAccountId;
	}

	public void setEmarsysAccountId(String emarsysAccountId) {
		this.emarsysAccountId = emarsysAccountId;
	}

	public String getEmarsysHashedId() {
		return emarsysHashedId;
	}

	public void setEmarsysHashedId(String emarsysHashedId) {
		this.emarsysHashedId = emarsysHashedId;
	}

	public String getEmarsysUnhashedId() {
		return emarsysUnhashedId;
	}

	public void setEmarsysUnhashedId(String emarsysUnhashedId) {
		this.emarsysUnhashedId = emarsysUnhashedId;
	}

	public String getEmarsysCampaignId() {
		return emarsysCampaignId;
	}

	public void setEmarsysCampaignId(String emarsysCampaignId) {
		this.emarsysCampaignId = emarsysCampaignId;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getCpjobsJobseekerId() {
		return cpjobsJobseekerId;
	}

	public void setCpjobsJobseekerId(String cpjobsJobseekerId) {
		this.cpjobsJobseekerId = cpjobsJobseekerId;
	}

	public String getCpjobsEmployerId() {
		return cpjobsEmployerId;
	}

	public void setCpjobsEmployerId(String cpjobsEmployerId) {
		this.cpjobsEmployerId = cpjobsEmployerId;
	}

	public String getCpjobsTrackingUserToken() {
		return cpjobsTrackingUserToken;
	}

	public void setCpjobsTrackingUserToken(String cpjobsTrackingUserToken) {
		this.cpjobsTrackingUserToken = cpjobsTrackingUserToken;
	}

	public String getLotameId() {
		return lotameId;
	}

	public void setLotameId(String lotameId) {
		this.lotameId = lotameId;
	}

	public String getMagazine_id() {
		return magazine_id;
	}

	public void setMagazine_id(String magazine_id) {
		this.magazine_id = magazine_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MasterIdKeyPK)) {
			return false;
		}
		MasterIdKeyPK castOther = (MasterIdKeyPK)other;
		return 
			this.fullVisitorId.equals(castOther.fullVisitorId)
			&& this.ga_property_id.equals(castOther.ga_property_id)
			&& this.emarsysAccountId.equals(castOther.emarsysAccountId)
			&& this.emarsysHashedId.equals(castOther.emarsysHashedId)
			&& this.emarsysUnhashedId.equals(castOther.emarsysUnhashedId)
			&& this.emarsysCampaignId.equals(castOther.emarsysCampaignId)
			&& this.idfa.equals(castOther.idfa)
			&& this.adid.equals(castOther.adid)
			&& this.cpjobsJobseekerId.equals(castOther.cpjobsJobseekerId)
			&& this.cpjobsEmployerId.equals(castOther.cpjobsEmployerId)
			&& this.cpjobsTrackingUserToken.equals(castOther.cpjobsTrackingUserToken)
			&& this.lotameId.equals(castOther.lotameId)
			&& this.magazine_id.equals(castOther.magazine_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fullVisitorId.hashCode();
		hash = hash * prime + this.ga_property_id.hashCode();
		hash = hash * prime + this.emarsysAccountId.hashCode();
		hash = hash * prime + this.emarsysHashedId.hashCode();
		hash = hash * prime + this.emarsysUnhashedId.hashCode();
		hash = hash * prime + this.emarsysCampaignId.hashCode();
		hash = hash * prime + this.idfa.hashCode();
		hash = hash * prime + this.adid.hashCode();
		hash = hash * prime + this.cpjobsJobseekerId.hashCode();
		hash = hash * prime + this.cpjobsEmployerId.hashCode();
		hash = hash * prime + this.cpjobsTrackingUserToken.hashCode();
		hash = hash * prime + this.lotameId.hashCode();
		hash = hash * prime + this.magazine_id.hashCode();
		return hash;
	}
}
