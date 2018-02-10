package th.co.maximus.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trsmethod_manual")
public class TrsMethodManualModel {
	private  Long   methodManualId;
	private  String   code;
	private  String   name;
	private  String  chequeNo;
	private  String  accountNo;
	private  Long   amount;
	private  Timestamp   updateDttm;
	private  String   updateSystem;
	private  String   updateUser;
	private  Long  versionStamp;
	private  String  offsetDocumentNo;
	private  String  offsetAccountCode;
	private  String  offsetAccountName;
	private  String  remark;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
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
	
	
	
}
