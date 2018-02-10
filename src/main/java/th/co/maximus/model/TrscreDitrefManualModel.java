package th.co.maximus.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "trscreditref_manual")
public class TrscreDitrefManualModel {
	private  Long   Id;
	private  String   creditNo;
	private  String   publisherdec	;
	private  String  cardType;
	private  Long   aMount;
	private  Timestamp   updateDttm;
	private  String   updateSystem;
	private  String   updateUser;
	private  Long   versionStamp;
	private  String   methodManualId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCreditNo() {
		return creditNo;
	}
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}
	public String getPublisherdec() {
		return publisherdec;
	}
	public void setPublisherdec(String publisherdec) {
		this.publisherdec = publisherdec;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Long getaMount() {
		return aMount;
	}
	public void setaMount(Long aMount) {
		this.aMount = aMount;
	}
	public Timestamp getUpdateDttm() {
		return updateDttm;
	}
	public void setUpdateDttm(Timestamp updateDttm) {
		this.updateDttm = updateDttm;
	}
	public String getUpdateSystem() {
		return updateSystem;
	}
	public void setUpdateSystem(String updateSystem) {
		this.updateSystem = updateSystem;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Long getVersionStamp() {
		return versionStamp;
	}
	public void setVersionStamp(Long versionStamp) {
		this.versionStamp = versionStamp;
	}
	public String getMethodManualId() {
		return methodManualId;
	}
	public void setMethodManualId(String methodManualId) {
		this.methodManualId = methodManualId;
	}
	
	
}
