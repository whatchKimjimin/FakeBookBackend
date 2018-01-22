package co.kr.fakebook.VO;

import java.sql.Date;

public class FriendsVO {
	private int id;
	private int Users_id;
	private int Friends_id;
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
	public int getFriends_id() {
		return Friends_id;
	}
	public void setFriends_id(int friends_id) {
		Friends_id = friends_id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
