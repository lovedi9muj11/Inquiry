package th.co.maximus.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "masofficer")
public class MasOfficerModel {
	private  Long   officerId;
	private  Long   principalId;
	private  Long   sessionId	;
	private  String  userName;
	private  String  officerCode;
	private  String   officergivenName;
	private  String   officerfamilyName;
	private  String   permisSion;
	private  Long   isposiTive;
	private  String   descripTion;
	private  Timestamp   updateDttm;
	private  String   updateSystem;
	private  String   updateUser;
	private  Long   versionStamp;
	private  String   verifyFlag;
	private  String   verifyKey;
	private  String   password;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getOfficerId() {
		return officerId;
	}
	public void setOfficerId(Long officerId) {
		this.officerId = officerId;
	}
	public Long getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(Long principalId) {
		this.principalId = principalId;
	}
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOfficerCode() {
		return officerCode;
	}
	public void setOfficerCode(String officerCode) {
		this.officerCode = officerCode;
	}
	public String getOfficergivenName() {
		return officergivenName;
	}
	public void setOfficergivenName(String officergivenName) {
		this.officergivenName = officergivenName;
	}
	public String getOfficerfamilyName() {
		return officerfamilyName;
	}
	public void setOfficerfamilyName(String officerfamilyName) {
		this.officerfamilyName = officerfamilyName;
	}
	public String getPermisSion() {
		return permisSion;
	}
	public void setPermisSion(String permisSion) {
		this.permisSion = permisSion;
	}
	public Long getIsposiTive() {
		return isposiTive;
	}
	public void setIsposiTive(Long isposiTive) {
		this.isposiTive = isposiTive;
	}
	public String getDescripTion() {
		return descripTion;
	}
	public void setDescripTion(String descripTion) {
		this.descripTion = descripTion;
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
	public String getVerifyFlag() {
		return verifyFlag;
	}
	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}
	public String getVerifyKey() {
		return verifyKey;
	}
	public void setVerifyKey(String verifyKey) {
		this.verifyKey = verifyKey;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
