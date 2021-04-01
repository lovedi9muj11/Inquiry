package th.co.inquiry.model;

import java.util.List;

public class QuestionBean {

	private int id;
	private String groupCode;
	private String seqNo;
	private String score;
	private String type;
	private String userId;
	
	private List<QuestionBean> questList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<QuestionBean> getQuestList() {
		return questList;
	}
	public void setQuestList(List<QuestionBean> questList) {
		this.questList = questList;
	}
	
}
