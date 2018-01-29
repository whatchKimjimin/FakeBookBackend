package co.kr.fakebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.kr.fakebook.service.UsersService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UsersService usersService;
	
	// RESULT
	Map<String , String> result;
	
	@RequestMapping(value = "",produces="application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> userJoin(@RequestBody Map<String, String> reqParam) {
		// RESULT
		this.result = new HashMap<String , String>();
		logger.info(reqParam.toString());
		
		// user overlap T & F
		if( usersService.userOverlap(reqParam) == 0 ) {
			// user join T & F
			if( usersService.userJoin(reqParam) == 1 ) {
				result.put("success","true");
				// USER INFO INSERT
				usersService.userInfo(reqParam);
			} else {
				result.put("success","false");
			}
		} else {
			result.put("success","false");
			result.put("message","이미 사용중인 이메일입니다.");
		}
		
		return result;
	}
	
	@RequestMapping(value = "",produces="application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> userLogin(@RequestParam Map<String, String> reqParam) throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String , String>();
		logger.info(reqParam.toString());
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		
		// USER DATA GET
		Map<String , String> userData = usersService.userLogin(reqParam);
		
		// USER DATA GET T & F
		if( userData != null ) {
			result.put("success", "true");
			result.put("UserData", mapper.writeValueAsString(userData));
		} else {
			result.put("success", "false");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/profile/{id}",produces="application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> userGetProfile(@PathVariable(value="id") int User_id) throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String , String>();
		logger.info("Profile");
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		// USER PROFILE DATA
		Map<String , String> profileData = usersService.userGetProfile(User_id);
		
		if( profileData != null ) {
			result.put("success","true");
			result.put("ProfileData", mapper.writeValueAsString(profileData) );
		} else {
			result.put("success","false");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/search",produces="application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> userSearch(@RequestParam Map<String , String> reqParam) throws JsonProcessingException {
		// RESULT 
		this.result = new HashMap<String , String>();
		logger.info("search");
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		// SEARCH DATA
		List< Map<String , String> > searchData = usersService.userSearch(reqParam.get("keyword"));
		
		if( searchData != null ) {
			result.put("success", "true");
			result.put("searchData",mapper.writeValueAsString(searchData));
		} else {
			result.put("success","false");
		}	
		
		
		return result;
	}
	
}
