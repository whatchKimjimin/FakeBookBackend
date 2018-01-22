package co.kr.fakebook.VO;

import java.sql.Date;

public class CommentsVO {
	private int id;
	private String content;
	private Date created;
	private int Users_id;
	private int TimeLines_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getUsers_id() {
		return Users_id;
	}
	public void setUsers_id(int users_id) {
		Users_id = users_id;
	}
	public int getTimeLines_id() {
		return TimeLines_id;
	}
	public void setTimeLines_id(int timeLines_id) {
		TimeLines_id = timeLines_id;
	}
	
	
}
