package cn.lhfei.airqa.web.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.common.Page;
import cn.lhfei.airqa.service.ICheckRecordService;
import cn.lhfei.airqa.web.model.CheckRecordBo;

/**
 * @author liuwu
 *  description:检测记录
 */
@Controller
public class CheckRecordController {

	private static final Logger logger = LoggerFactory
			.getLogger(CheckRecordController.class);

	/**
	 * 检测记录申请页面
	 */
	@RequestMapping(value = "/applyingCheck", method = RequestMethod.GET)
	public String applyedCheck(Locale locale, Model model) {
		logger.info("Welcome 检测记录页面! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
 
		return "checkRecord/applyingCheck";
	}
	
	@RequestMapping(value = "/getRecordNum", method = RequestMethod.GET)
	@ResponseBody
	public String getRecordNum(String type){
		Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month=cal.get(Calendar.MONTH);//获取月份 
        int day=cal.get(Calendar.DATE);//获取日 
        int hour=cal.get(Calendar.HOUR);//小时 
        int minute=cal.get(Calendar.MINUTE);//分            
        int second=cal.get(Calendar.SECOND);//秒
        String recordNum =type + String.valueOf(year)+
        		String.valueOf(month)+String.valueOf(day)
        		+String.valueOf(hour)+String.valueOf(minute)+
        		String.valueOf(second);
        
		return recordNum;
	}
	
	@RequestMapping(value = "/findListCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> findListCheck(String recordNum,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		try{
			int pageNo = Integer.parseInt(request.getParameter("page"));
			int rows = Integer.parseInt(request.getParameter("rows")); 
			Page<CheckRecordBo> page = new Page<CheckRecordBo>();
			page.setCurPage(pageNo);
			page.setPageSize(rows);
			page = checkRecordService.findListCheck(page, recordNum);
			result.put("total", page.getTotalCount());
			result.put("rows", page.getResult());
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value = "/createCheck", method = RequestMethod.POST)
	@ResponseBody//,List<QaKpiBo> kpiBos
	public boolean createCheck(@ModelAttribute CheckRecordBo checkRecordBo) {
		logger.info("检测信息申请.");
		
		return true;
	}

	@Autowired
	private ICheckRecordService checkRecordService;
}
