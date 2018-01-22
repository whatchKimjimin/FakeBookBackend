package co.kr.fakebook.daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.fakebook.dao.TimeLinesDao;

@Repository("TimeLinesDao")
public class TimeLinesDaoImpl implements TimeLinesDao{
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Map<String, String>> getTimeLines(int USER_ID) {
		return sqlSession.selectList("getTimeLines", USER_ID);
	}

	@Override
	public int insertTimeLine(Map<String, String> reqParam) {
		return sqlSession.insert("insertTimeLine",reqParam);
	}

	@Override
	public int deleteTimeLine(int TIMELINE_ID) {
		return sqlSession.delete("deleteTimeLine",TIMELINE_ID);
	}
	
}
