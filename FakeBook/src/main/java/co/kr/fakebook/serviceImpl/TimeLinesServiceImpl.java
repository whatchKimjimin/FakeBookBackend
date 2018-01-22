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
}
