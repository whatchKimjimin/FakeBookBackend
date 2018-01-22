package co.kr.fakebook.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.kr.fakebook.dao.UsersDao;
import co.kr.fakebook.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService{
	
	@Resource(name = "UsersDao")
	private UsersDao usersDao;
	
	@Override
	public int userJoin(Map<String, String> reqParam) {
		return usersDao.userJoin(reqParam);
	}

	@Override
	public int userOverlap(Map<String, String> reqParam) {
		return usersDao.userOverlap(reqParam);
	}

	@Override
	public Map<String , String> userLogin(Map<String, String> reqParam) {
		return usersDao.userLogin(reqParam);
	}

	@Override
	public Map<String, String> userGetProfile(int User_id) {
		return usersDao.userGetProfile(User_id);
	}

	@Override
	public int userInfo(Map<String, String> reqParam) {
		return usersDao.userInfo(reqParam);
	}

	@Override
	public List<Map<String, String>> userSearch(String keyword) {
		return usersDao.userSearch(keyword);
	}

}
