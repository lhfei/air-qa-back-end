package cn.lhfei.airqa.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.lhfei.airqa.web.model.SimpleModel;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@RequestMapping(value = "/userInfo")
	public String userInfo() {
		return "user/userInfo";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.POST)
	public String create(@RequestBody SimpleModel model) {
		logger.debug(model.toString());
		return "";
	}

	@RequestMapping(value = "/terminalBinder")
	public String terminalBinder() {
		return "user/terminalBinder";
	}

}
