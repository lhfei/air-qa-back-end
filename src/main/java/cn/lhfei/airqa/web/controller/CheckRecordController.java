package cn.lhfei.airqa.web.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.common.Page;
import cn.lhfei.airqa.service.ICheckRecordService;
import cn.lhfei.airqa.service.IQaKpiService;
import cn.lhfei.airqa.web.model.CheckRecordBo;
import cn.lhfei.airqa.web.model.QaKpiBo;
import cn.lhfei.airqa.web.model.QaKpiBos;

/**
 * @author liuwu description:检测记录
 */
@Controller
@RequestMapping(value = "/checkRecord")
public class CheckRecordController {

	private static final Logger logger = LoggerFactory
			.getLogger(CheckRecordController.class);
	private static final Marker SQL_MARKER = MarkerFactory.getMarker("SQL");
	private static final Marker UPDATE_MARKER = MarkerFactory
			.getMarker("SQL_UPDATE");
	private static final Marker QUERY_MARKER = MarkerFactory
			.getMarker("SQL_QUERY");

	/**
	 * 检测记录申请页面
	 */
	@RequestMapping(value = "/applyingCheck", method = RequestMethod.GET)
	public String applyingCheck(Locale locale, Model model) {
		logger.info("Welcome 检测记录页面! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "checkRecord/applyingCheck";
	}

	/**
	 * 方法描述：<获取检测编号>
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/findCheckRecordById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findCheckRecordById(String recordId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			CheckRecordBo checkRecordBo = checkRecordService.findById(recordId);
			List<QaKpiBo> list = qaKpiService.findQaKpiList(Integer
					.valueOf(recordId));
			QaKpiBos qaKpiBos = new QaKpiBos();
			qaKpiBos.setQaKpiBos(list);
			result.put("recordBo", checkRecordBo);
			result.put("qaList", list);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 方法描述：<获取检测编号>
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/getRecordNum", method = RequestMethod.GET)
	@ResponseBody
	public CheckRecordBo getRecordNum(String type) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);// 获取年份
		int month = cal.get(Calendar.MONTH);// 获取月份
		int day = cal.get(Calendar.DATE);// 获取日
		int hour = cal.get(Calendar.HOUR);// 小时
		int minute = cal.get(Calendar.MINUTE);// 分
		int second = cal.get(Calendar.SECOND);// 秒
		CheckRecordBo checkRecordBo = new CheckRecordBo();
		String recordNum = type + String.valueOf(year) + String.valueOf(month)
				+ String.valueOf(day) + String.valueOf(hour)
				+ String.valueOf(minute) + String.valueOf(second);
		checkRecordBo.setRecordNum(recordNum);
		return checkRecordBo;
	}

	/**
	 * 方法描述：<查找检测记录列表>
	 * 
	 * @param recordNum
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findListCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findListCheck(String recordNum,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			int pageNo = Integer.parseInt(request.getParameter("page"));
			int rows = Integer.parseInt(request.getParameter("rows"));
			Page<CheckRecordBo> page = new Page<CheckRecordBo>();
			page.setCurPage(pageNo);
			page.setPageSize(rows);
			page = checkRecordService.findListCheck(page, recordNum);
			result.put("total", page.getTotalCount());
			result.put("rows", page.getResult());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 方法描述：<创建对象>
	 * 
	 * @param checkBos
	 * @return
	 */
	@RequestMapping(value = "/createCheck", method = RequestMethod.POST)
	@ResponseBody
	public boolean createCheck(CheckRecordBo checkBo, QaKpiBos qaKpiBos) {
		boolean flag = false;
		try {
			checkBo = checkRecordService.create(checkBo);
			qaKpiService.create(checkBo.getRecordId(), qaKpiBos);
			flag = true;
		} catch (RuntimeException e) {
			logger.error(UPDATE_MARKER, "更新检测失败");
		}
		return flag;
	}

	@Autowired
	private ICheckRecordService checkRecordService;

	@Autowired
	private IQaKpiService qaKpiService;
}
