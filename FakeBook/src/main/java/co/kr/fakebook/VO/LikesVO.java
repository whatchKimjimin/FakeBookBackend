package co.kr.fakebook.VO;

import java.sql.Date;

public class LikesVO {
	private int id;
	private int Users_id;
	private int TimeLines_id;
	private Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
