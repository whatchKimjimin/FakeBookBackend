package co.kr.fakebook.dao;

import java.util.List;
import java.util.Map;

import co.kr.fakebook.VO.FriendsInfoVO;

public interface FriendsDao {
	// REQUEST FRIEND
	public int requestFriend(Map<String , String> reqParam);
	// REQUEST FRIEND LIST
	public List<Map<String, String>> requestFriendList(int USER_ID);
	
	
	//------ AGREE FRIEND
	// AGREE REQUEST FRIEND
	public int agreeRequestFriend(FriendsInfoVO friendsInfoVo);
	// AGREE RESPONSE FRIEND
	public int agreeResponseFriend(FriendsInfoVO friendsInfoVo);
	// DELETE FRIENDINFO
	public int deleteFriendsInfo(int FRIENDSINFO_ID);
	// GET AGREE FRIEND DATA
	public FriendsInfoVO getAgreeFriendData(int FRIENDSINFO_ID);
	//------ AGREE FRIEND
	
	// DELETE FRIEND
	public int deleteFriend(int FRIEND_ID);
	
	// USER FRIENDS LIST
	public List<Map <String , String>> userFriendList(int USER_ID);
	// USER RESPONSE LIST
	public List<Map <String , String>> userResponseFriendList(int USER_ID);
	
	
	// USER FRIENDS CHECK
	public int userFriendCheck(Map<String , String> reqParam);
	
}
