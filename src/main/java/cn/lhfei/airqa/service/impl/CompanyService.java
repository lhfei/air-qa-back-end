package cn.lhfei.airqa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.common.Constants;
import cn.lhfei.airqa.dao.ICompanyDao;
import cn.lhfei.airqa.entity.Company;
import cn.lhfei.airqa.service.ICompanyService;
import cn.lhfei.airqa.web.model.PageModel;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;

	@Override
	public void create(Company company) {
		companyDao.saveOrUpdate(company);
	}

	@Override
	public Company findCompany(int id) {
		return companyDao.findById(id);
	}

	@Override
	public PageModel findCompany(int page, int rows) {
		return companyDao.findCompany(page, rows);
	}

	@Override
	public void deleteCompany(int id) {
		Company company=companyDao.findById(id);
		company.setDataStatus(Constants.STATUS_DELETE);
		companyDao.saveOrUpdate(company);
		
	}

}
