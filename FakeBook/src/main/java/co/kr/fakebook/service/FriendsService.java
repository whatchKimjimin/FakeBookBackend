package co.kr.fakebook.service;

import java.util.List;
import java.util.Map;

public interface FriendsService {
		// REQUEST FRIEND
		public int requestFriend(Map<String , String> reqParam);
		// REQUEST FRIEND LIST
		public List<Map<String , String>> getRequestFriendList(int USER_ID);
		// AGREE FRIEND
		public int agreeFriend(int FRIENDSINFO_ID);
		// DELETE FRIEND
		public int deleteFriend(int FRIEND_ID);
		
		// USER FRIENDS LIST
		public List<Map <String , String>> userFriendList(int USER_ID);
		// USER RESPONSE LIST
		public List<Map <String , String>> userResponseFriendList(int USER_ID);
		
		
		// USER FRIENDS CHECK
		public int userFriendCheck(Map<String , String> reqParam);
		
}
