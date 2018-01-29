package co.kr.fakebook.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.kr.fakebook.VO.FriendsInfoVO;
import co.kr.fakebook.dao.FriendsDao;
import co.kr.fakebook.service.FriendsService;

@Service("FriendsService")
public class FriendsServiceImpl implements FriendsService{
	
	@Resource(name = "FriendsDao")
	private FriendsDao friendsDao;

	@Override
	public int requestFriend(Map<String, String> reqParam) {
		return friendsDao.requestFriend(reqParam);
	}

	@Override
	public int agreeFriend(int FRIENDSINFO_ID) {
		// GET AGREE FRIEND DATA
		FriendsInfoVO friendsInfoVo = friendsDao.getAgreeFriendData(FRIENDSINFO_ID);
		
		// INSERT AGREE FRIENDS
		int AGREE_REQUEST_FRIEND = friendsDao.agreeRequestFriend(friendsInfoVo);
		int AGREE_RESPONSE_FRIEND = friendsDao.agreeResponseFriend(friendsInfoVo);
		
		// DELETE FRIENDSINFO
		int DELETE_FRIENDSINFO = friendsDao.deleteFriendsInfo(FRIENDSINFO_ID);
		
		return AGREE_REQUEST_FRIEND + AGREE_RESPONSE_FRIEND + DELETE_FRIENDSINFO;
	}

	@Override
	public int deleteFriend(int FRIEND_ID) {
		return friendsDao.deleteFriend(FRIEND_ID);
	}

	@Override
	public List<Map<String, String>> userFriendList(int USER_ID) {
		return friendsDao.userFriendList(USER_ID);
	}

	@Override
	public List<Map<String, String>> userResponseFriendList(int USER_ID) {
		return null;
	}

	@Override
	public List<Map<String, String>> getRequestFriendList(int USER_ID) {
		return friendsDao.requestFriendList(USER_ID);
	}

	@Override
	public int userFriendCheck(Map<String, String> reqParam) {
		return friendsDao.userFriendCheck(reqParam);
	}
	
}
