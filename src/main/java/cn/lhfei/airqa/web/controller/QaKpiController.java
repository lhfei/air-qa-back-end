package cn.lhfei.airqa.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.service.IQaKpiService;
import cn.lhfei.airqa.web.model.QaKpiBo;
import cn.lhfei.airqa.web.model.QaKpiBos;

/**
 * @author liuwu description:检测记录
 */
@Controller
public class QaKpiController {

	private static final Logger logger = LoggerFactory
			.getLogger(QaKpiController.class);

	/**
	 * 方法描述：<查找检测记录列表>
	 * 
	 * @param recordNum
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findListQaKpi", method = RequestMethod.POST)
	@ResponseBody
	public List<QaKpiBo> findListQaKpi(Integer recordId,
			HttpServletRequest request) {
		List<QaKpiBo> listBo = null;
		try {
			listBo = qaKpiService.findQaKpiList(recordId);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return listBo;
	}
	
	@RequestMapping(value = "/createQaKpiList", method = RequestMethod.POST)
	@ResponseBody
	public boolean createQaKpiList(QaKpiBos qaKpiBos,Integer recordId){
		return false;
	}

	@Autowired
	private IQaKpiService qaKpiService;
}
