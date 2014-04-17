package cn.lhfei.airqa.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.service.IUserService;
import cn.lhfei.airqa.web.model.SimpleModel;
import cn.lhfei.airqa.web.model.UserModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "login";

	}

	@RequestMapping(value = "/loginForm")
	public String loginForm(UserModel user) {
		logger.info("登录认证.");

		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getEmail(), user.getPassword());
		token.setRememberMe(true);
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "redirect:/";
		}
		if (currentUser.isAuthenticated()) {
			return "home";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/register")
	public String register() {
		logger.info("用户注册.");
		return "user/register";
	}

	@RequestMapping(value = "/registerForm", method = RequestMethod.POST)
	public String registerForm(UserModel user, Model model) {
		logger.info("用户提交注册.");

		// 确认用户密码是否输入正确
		if (!StringUtils.isEmpty(user.getPassword())
				&& StringUtils.endsWith(user.getPassword(),
						user.getRePassword())) {
			userService.create(user);
			return "redirect:/";
		} else {
			model.addAttribute("register_msg", "注册信息格式不正确，请重新输入.");
			logger.info("注册信息格式不正确，请重新输入.");
			return "forward:register";
		}

	}

	@RequestMapping(value = "/logout")
	public String logout() {
		logger.info("用户退出系统.");
		// 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
		SecurityUtils.getSubject().logout();
		return "redirect:/";
	}

	@RequestMapping("/get/{name}")
	@ResponseBody
	public SimpleModel get(@PathVariable String name) {
		SimpleModel model = new SimpleModel();
		model.setName(name);
		model.setCreate(new Date());
		model.setDesc("request by get");

		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public SimpleModel create(@RequestBody SimpleModel model) {
		logger.debug(model.toString());
		return model;
	}

	@Autowired
	private IUserService userService;
}
