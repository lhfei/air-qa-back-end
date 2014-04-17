package cn.lhfei.airqa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.dao.IQaKpiDao;
import cn.lhfei.airqa.entity.QaKpi;
import cn.lhfei.airqa.service.IQaKpiService;
import cn.lhfei.airqa.web.model.QaKpiBo;

@Service
public class QaKpiService implements IQaKpiService {

	@Override
	public void create(QaKpiBo qaKpiBo) {
		QaKpi qaKpi = new QaKpi();
		qaKpiDao.saveOrUpdate(qaKpi);
	}

	@Autowired
	private IQaKpiDao qaKpiDao;

}
