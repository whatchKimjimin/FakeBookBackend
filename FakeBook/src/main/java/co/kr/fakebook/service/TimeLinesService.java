package co.kr.fakebook.service;

import java.util.List;
import java.util.Map;

public interface TimeLinesService {
	// GET TIMELINES
	public List< Map<String , String> > getTimeLines(int USER_ID);
	// INSERT TIMELINE
	public int insertTimeLine(Map<String , String> reqParam);
	// DELETE TIMELINE	
	public int deleteTimeLine(int TIMELINE_ID);
	
}
