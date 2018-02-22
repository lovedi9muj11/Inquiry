package th.co.maximus.bean;

import java.sql.Timestamp;

public class TrsMethodManualBean {

	private  Long   methodManualId;
	private  String   code;
	private  String   name;
	private  String  chequeNo;
	private  String  accountNo;
	private String creditId;
	private  double   amount;
	private  Timestamp   updateDttm;
	private  String   updateSystem;
	private  String   updateUser;
	private  Long  versionStamp;
	private  String  offsetDocumentNo;
	private  String  offsetAccountCode;
	private  String  offsetAccountName;
	private  String  remark;
	private  String  createBy;
	private  Timestamp  createDate;
	private  String  updateBy;
	private  Timestamp  updateDate;
	private  String  recordStatus;
	private  Long  manualId;
	private long refId;
	private long deductionManualId;
	
	
	public long getRefId() {
		return refId;
	}
	public void setRefId(long refId) {
		this.refId = refId;
	}
	public long getDeductionManualId() {
		return deductionManualId;
	}
	public void setDeductionManualId(long deductionManualId) {
		this.deductionManualId = deductionManualId;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public Long getManualId() {
		return manualId;
	}
	public void setManualId(Long manualId) {
		this.manualId = manualId;
	}
	public Long getMethodManualId() {
		return methodManualId;
	}
	public void setMethodManualId(Long methodManualId) {
		this.methodManualId = methodManualId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
	public String getOffsetDocumentNo() {
		return offsetDocumentNo;
	}
	public void setOffsetDocumentNo(String offsetDocumentNo) {
		this.offsetDocumentNo = offsetDocumentNo;
	}
	public String getOffsetAccountCode() {
		return offsetAccountCode;
	}
	public void setOffsetAccountCode(String offsetAccountCode) {
		this.offsetAccountCode = offsetAccountCode;
	}
	public String getOffsetAccountName() {
		return offsetAccountName;
	}
	public void setOffsetAccountName(String offsetAccountName) {
		this.offsetAccountName = offsetAccountName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	
	
	
	
	
}
