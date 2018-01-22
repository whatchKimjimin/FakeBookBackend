package co.kr.fakebook.VO;

import java.sql.Date;

public class UsersInfoVO {
	private int id;
	private int profile_id;
	private int cover_id;
	private Date updated;
	private int Users_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public int getCover_id() {
		return cover_id;
	}
	public void setCover_id(int cover_id) {
		this.cover_id = cover_id;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getUsers_id() {
		return Users_id;
	}
	public void setUsers_id(int users_id) {
		Users_id = users_id;
	}
	
	
}
