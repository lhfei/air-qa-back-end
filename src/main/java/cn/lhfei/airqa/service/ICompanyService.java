package cn.lhfei.airqa.service;

import java.util.List;

import cn.lhfei.airqa.entity.Company;
import cn.lhfei.airqa.entity.Region;
import cn.lhfei.airqa.web.model.PageModel;

public interface ICompanyService {
	void create(Company company);

	Company findCompany(int id);

	PageModel findCompany(int page, int rows);
	
	void deleteCompany(int id);
}
