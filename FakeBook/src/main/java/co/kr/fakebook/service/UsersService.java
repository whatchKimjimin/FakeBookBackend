package co.kr.fakebook.service;

import java.util.List;
import java.util.Map;


public interface UsersService {
	// USER JOIN
	public int userJoin(Map<String , String> reqParam);
	// INSERT USER INFO
	public int userInfo(Map<String , String> reqParam);
	// EMAIL , NAME OVERLAP
	public int userOverlap(Map<String , String> reqParam);
	// USER LOGIN
	public Map<String , String> userLogin(Map<String , String> reqParam);
	// GET PROFILE
	public Map<String , String> userGetProfile(int User_id);
	// USER SEARCH 
	public List<Map<String , String>> userSearch(String keyword);
}
