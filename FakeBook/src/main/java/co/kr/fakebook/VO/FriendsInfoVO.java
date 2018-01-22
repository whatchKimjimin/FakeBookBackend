package co.kr.fakebook.VO;

import java.sql.Date;

public class FriendsInfoVO {
	private int id;
	private int RequestUser_id;
	private int ResponseUser_id;
	private Date created;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRequestUser_id() {
		return RequestUser_id;
	}
	public void setRequestUser_id(int requestUser_id) {
		RequestUser_id = requestUser_id;
	}
	public int getResponseUser_id() {
		return ResponseUser_id;
	}
	public void setResponseUser_id(int responseUser_id) {
		ResponseUser_id = responseUser_id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
