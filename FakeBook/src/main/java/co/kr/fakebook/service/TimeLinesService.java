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
	
	// GET MY TIMELINES
	public List<Map<String , String>> getMyTimeLines(int USER_ID);
	
	// INSERT LIKE 
	public int insertLike(Map<String , String> reqParam);
	// DELETE LIKE
	public int deleteLike(Map<String , String> reqParam);
	
	// TIMELINE COMMENT
	// GET TIMELINE COMMENT LIST
	public List<Map<String , String>> getComment(int TIMELINE_ID);
	// INSERT TIMELINE COMMENT
	public int insertComment(Map<String , String> reqParam);
}
