package co.kr.fakebook.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.kr.fakebook.dao.TimeLinesDao;
import co.kr.fakebook.service.TimeLinesService;

@Service("TimeLinesService")
public class TimeLinesServiceImpl implements TimeLinesService{
	
	@Resource(name = "TimeLinesDao")
	private TimeLinesDao timeLinesDao;

	@Override
	public List<Map<String, String>> getTimeLines(int USER_ID) {
		return timeLinesDao.getTimeLines(USER_ID);
	}

	@Override
	public int insertTimeLine(Map<String, String> reqParam) {
		return timeLinesDao.insertTimeLine(reqParam);
	}

	@Override
	public int deleteTimeLine(int TIMELINE_ID) {
		return timeLinesDao.deleteTimeLine(TIMELINE_ID);
	}

	@Override
	public List<Map<String, String>> getMyTimeLines(int USER_ID) {
		return timeLinesDao.getMyTimeLines(USER_ID);
	}

	@Override
	public int insertLike(Map<String, String> reqParam) {
		return timeLinesDao.insertLike(reqParam);
	}

	@Override
	public int deleteLike(Map<String, String> reqParam) {
		return timeLinesDao.deleteLike(reqParam);
	}

	@Override
	public List<Map<String, String>> getComment(int TIMELINE_ID) {
		return timeLinesDao.getComment(TIMELINE_ID);
	}

	@Override
	public int insertComment(Map<String, String> reqParam) {
		return timeLinesDao.insertComment(reqParam);
	}
}
