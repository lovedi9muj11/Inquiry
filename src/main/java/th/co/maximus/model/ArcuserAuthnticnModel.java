package th.co.maximus.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "arcuserauthnticn")
public class ArcuserAuthnticnModel {

	private  Long   userAuthnticnId;
	private  Long   offiCerId;
	private  String   password	;
	private  Date  updateDttm;
	private  String  updateSystem;
	private  String   updateUser;
	private  Long   versionStamp;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getUserAuthnticnId() {
		return userAuthnticnId;
	}
	public void setUserAuthnticnId(Long userAuthnticnId) {
		this.userAuthnticnId = userAuthnticnId;
	}
	public Long getOffiCerId() {
		return offiCerId;
	}
	public void setOffiCerId(Long offiCerId) {
		this.offiCerId = offiCerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUpdateDttm() {
		return updateDttm;
	}
	public void setUpdateDttm(Date updateDttm) {
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
	
	
	
}
