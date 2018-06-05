package th.co.maximus.bean;

import java.sql.Timestamp;
import java.util.Date;

public class TrscreDitrefManualBean {
	private  Long   Id;
	private  String   creditNo;
	private  String   publisherdec	;
	private  String  cardType;
	private  Double   aMount;
	private  Timestamp   updateDttm;
	private  String   updateSystem;
	private  String   updateUser;
	private  Long   versionStamp;
	private  String   methodManualId;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	
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

	public double getaMount() {
		return aMount;
	}
	public void setaMount(double aMount) {
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
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setaMount(Double aMount) {
		this.aMount = aMount;
	}
	
	
}
