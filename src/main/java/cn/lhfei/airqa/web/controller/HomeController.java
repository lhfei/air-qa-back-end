package cn.lhfei.airqa.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.web.model.SimpleModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		
	}
	
	@RequestMapping("/get/{name}")
	@ResponseBody
	public SimpleModel get(@PathVariable String name){
		SimpleModel model = new SimpleModel();
		model.setName(name);
		model.setCreate(new Date());
		model.setDesc("request by get");
		
		return model;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public SimpleModel create(@RequestBody SimpleModel model){
		logger.debug(model.toString());
		return model;
	}
	
}
