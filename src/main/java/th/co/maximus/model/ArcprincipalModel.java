package th.co.maximus.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arcprincipal")
public class ArcprincipalModel {
	private  Long   princiPalid;
	private  String   name;
	private  String   desCription;
	private  Timestamp  updatedttm;
	private  String  updateSystem;
	private  String   updateUser;
	private  Long   versionStamp;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPrinciPalid() {
		return princiPalid;
	}
	public void setPrinciPalid(Long princiPalid) {
		this.princiPalid = princiPalid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesCription() {
		return desCription;
	}
	public void setDesCription(String desCription) {
		this.desCription = desCription;
	}
	public Timestamp getUpdatedttm() {
		return updatedttm;
	}
	public void setUpdatedttm(Timestamp updatedttm) {
		this.updatedttm = updatedttm;
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
