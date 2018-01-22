package co.kr.fakebook.daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.fakebook.dao.UsersDao;


@Repository("UsersDao")
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	@Override
	public int userJoin(Map<String, String> reqParam) { 
		return sqlSession.insert("insertUser",reqParam);
	}


	@Override
	public int userOverlap(Map<String, String> reqParam) {
		return sqlSession.selectOne("overlapUser",reqParam);
	}


	@Override
	public Map<String , String> userLogin(Map<String, String> reqParam) {
		return sqlSession.selectOne("loginUser",reqParam);
	}


	@Override
	public Map<String, String> userGetProfile(int User_id) {
		return sqlSession.selectOne("getUserProfile",User_id);
	}


	@Override
	public int userInfo(Map<String, String> reqParam) {
		return sqlSession.insert("insertUserInfo",reqParam);
	}


	@Override
	public List<Map<String , String>> userSearch(String keyword) {
		return sqlSession.selectList("searchUser",keyword);
	}

}
