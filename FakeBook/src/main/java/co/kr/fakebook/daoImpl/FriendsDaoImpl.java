package co.kr.fakebook.daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.fakebook.VO.FriendsInfoVO;
import co.kr.fakebook.dao.FriendsDao;

@Repository("FriendsDao")
public class FriendsDaoImpl implements FriendsDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int requestFriend(Map<String, String> reqParam) {
		return sqlSession.insert("requestFriend",reqParam);
	}

	@Override
	public int agreeRequestFriend(FriendsInfoVO friendsInfoVo) {
		return sqlSession.insert("insertRequestFriend",friendsInfoVo);
	}

	@Override
	public int agreeResponseFriend(FriendsInfoVO friendsInfoVo) {
		return sqlSession.insert("insertResponseFriend",friendsInfoVo);
	}

	@Override
	public int deleteFriendsInfo(int FRIENDSINFO_ID) {
		return sqlSession.delete("deleteFriendsInfo",FRIENDSINFO_ID);
	}
	
	@Override
	public FriendsInfoVO getAgreeFriendData(int FRIENDSINFO_ID) {
		return sqlSession.selectOne("getAgreeFriendData", FRIENDSINFO_ID);
	}
	

	@Override
	public List<Map<String, String>> userFriendList(int USER_ID) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userFriendList",USER_ID);
	}

	@Override
	public List<Map<String, String>> userResponseFriendList(int USER_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteFriend(int FRIEND_ID) {
		// TODO Auto-generated method stub
		return sqlSession.delete("deleteFriend",FRIEND_ID);
	}

	@Override
	public List<Map<String, String>> requestFriendList(int USER_ID) {
		return sqlSession.selectList("getRequestFriendList",USER_ID);
	}

	@Override
	public int userFriendCheck(Map<String , String> reqParam) {
		return sqlSession.selectOne("userFriendCheck",reqParam);
	}

	

	
	
	
}
