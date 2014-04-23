package cn.lhfei.airqa.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.service.IUserService;
import cn.lhfei.airqa.web.model.UserModel;

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

	@RequestMapping(value = "/userInfoForm")
	public @ResponseBody boolean userInfoForm(UserModel user) {
		logger.debug("维护个人信息");
		userService.updateUserInfo(user);
		return true;
	}

	@RequestMapping(value = "/terminalBinder")
	public String terminalBinder() {
		return "user/terminalBinder";
	}

	@Autowired
	private IUserService userService;

}
