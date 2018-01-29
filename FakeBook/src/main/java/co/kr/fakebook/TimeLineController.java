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

import co.kr.fakebook.service.TimeLinesService;

@Controller
@RequestMapping(value = "/timeline")
public class TimeLineController {

	private static final Logger logger = LoggerFactory.getLogger(TimeLineController.class);

	@Autowired
	private TimeLinesService timelinesService;

	// RESULT
	Map<String, String> result;

	@RequestMapping(value = "", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getTimeLines(@RequestParam Map<String, String> reqParam)
			throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("TimeLine");
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		int User_id = Integer.parseInt(reqParam.get("userid"));
		// TIMELINE DATA
		List<Map<String, String>> timeLineData = timelinesService.getTimeLines(User_id);

		if (timeLineData != null) {
			result.put("success", "true");
			result.put("timeLineData", mapper.writeValueAsString(timeLineData));
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> insertTimeLine(@RequestBody Map<String, String> reqParam)
			throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("insert timeline");
		// DO INSERT
		if (timelinesService.insertTimeLine(reqParam) > 0) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/{timeline_id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteTimeLine(@PathVariable(value = "timeline_id") int TIMELINE_ID)
			throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("delete timeline");
		// DO DELETE
		if (timelinesService.deleteTimeLine(TIMELINE_ID) > 0) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/me/{USER_ID}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getMyTimeline(@PathVariable(value = "USER_ID") int USER_ID)
			throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("MyTimeLine");
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		// TIMELINE DATA
		List<Map<String, String>> timeLineData = timelinesService.getMyTimeLines(USER_ID);

		if (timeLineData != null) {
			result.put("success", "true");
			result.put("timeLineData", mapper.writeValueAsString(timeLineData));
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/like", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> insertLike(@RequestBody Map<String, String> reqParam) {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("insertLike");

		if (timelinesService.insertLike(reqParam) == 1) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/unlike", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> deleteLike(@RequestBody Map<String, String> reqParam) {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("deleteLike");

		if (timelinesService.deleteLike(reqParam) == 1) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/comment/{TIMELINE_ID}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getComment(@PathVariable(value = "TIMELINE_ID") int TIMELINE_ID)
			throws JsonProcessingException {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("getComment");
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();

		List<Map<String, String>> commentData = timelinesService.getComment(TIMELINE_ID);

		if (commentData != null) {
			result.put("success", "true");
			result.put("commentData", mapper.writeValueAsString(commentData));
		} else {
			result.put("success", "false");
		}

		return result;
	}

	@RequestMapping(value = "/comment", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> insertComment(@RequestBody Map<String, String> reqParam) {
		// RESULT
		this.result = new HashMap<String, String>();
		logger.info("insert Comment");

		if ( timelinesService.insertComment(reqParam) == 1) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		return result;
	}

}
