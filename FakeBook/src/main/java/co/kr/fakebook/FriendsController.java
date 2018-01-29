package co.kr.fakebook;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.kr.fakebook.service.FriendsService;
import co.kr.fakebook.service.TimeLinesService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/friend")
public class FriendsController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private FriendsService friendsService;

	// RESULT
	Map<String, String> result;

	@RequestMapping(value = "/agree/{FRIENDSINFO_ID}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> agreeFriend(@PathVariable(value = "FRIENDSINFO_ID") int FRIENDSINFO_ID) {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("FRIENDS AGREE");

		if (friendsService.agreeFriend(FRIENDSINFO_ID) == 3) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/request", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> requestFriend(@RequestBody Map<String, String> reqParam) {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("REQUEST FRIEND");

		if (friendsService.requestFriend(reqParam) == 1) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/list/{USER_ID}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> userFriendList(@PathVariable(value = "USER_ID") int USER_ID)
			throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("FRIEND LIST");
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		// Friend List
		List<Map<String, String>> friendList = friendsService.userFriendList(USER_ID);

		if (friendList != null) {
			result.put("success", "true");
			result.put("friendData", mapper.writeValueAsString(friendList));
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/list/response/{USER_ID}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getRequestFriendList(@PathVariable(value = "USER_ID") int USER_ID)
			throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("FRIEND REQUEST LIST");
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		// Friend List
		List<Map<String, String>> friendList = friendsService.getRequestFriendList(USER_ID);

		if (friendList != null) {
			result.put("success", "true");
			result.put("requestList", mapper.writeValueAsString(friendList));
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/me", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> userFriendCheck(@RequestBody Map<String, String> reqParam) {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("USER FRIEND CHECK");

		if ( friendsService.userFriendCheck(reqParam) >= 1) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		return result;
	}
}
