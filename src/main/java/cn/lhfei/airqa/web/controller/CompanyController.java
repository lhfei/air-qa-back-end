package cn.lhfei.airqa.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.entity.Company;
import cn.lhfei.airqa.service.ICompanyService;
import cn.lhfei.airqa.web.model.PageModel;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	private static final Logger logger = LoggerFactory
			.getLogger(CompanyController.class);

	@RequestMapping(value = "/factoryInfo")
	public String userInfo() {
		return "dataMaintenance/factoryInfo";
	}

	@RequestMapping(value = "/saveFactoryInfo")
	public @ResponseBody
	boolean saveFactoryInfo(Company company) {
		logger.debug("保存工厂信息");
		companyService.create(company);
		return true;
	}
	
	@RequestMapping(value = "/deleteFactoryInfo")
	public @ResponseBody
	boolean deleteFactoryInfo(int companyId) {
		logger.debug("删除工厂信息");
		companyService.deleteCompany(companyId);
		return true;
	}

	public Company findCompany(int id) {
		return companyService.findCompany(id);
	}

	@RequestMapping(value = "/findCompany")
	public @ResponseBody
	PageModel findCompany(int page, int rows) {
		return companyService.findCompany(page, rows);
	}

	@Autowired
	private ICompanyService companyService;

}
