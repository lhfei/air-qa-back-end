package cn.lhfei.airqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.dao.IQaKpiDao;
import cn.lhfei.airqa.entity.QaKpi;
import cn.lhfei.airqa.service.IQaKpiService;
import cn.lhfei.airqa.web.model.QaKpiBo;
import cn.lhfei.airqa.web.model.QaKpiBos;

@Service
public class QaKpiService implements IQaKpiService {

	@Override
	public void create(String recordId,QaKpiBos qaKpiBos) {
		QaKpi qaKpi = new QaKpi();
		List<QaKpiBo> list = qaKpiBos.getQaKpiBos();
		for(QaKpiBo qaKpiBo : list){
			qaKpi = convert(qaKpiBo);
			qaKpi.setRecordId(Integer.valueOf(recordId));
			qaKpiDao.saveOrUpdate(qaKpi);	
		}
	}
	
	@Override
	public void create(QaKpiBo qaKpiBo) {
	}
	
	@Override
	public List<QaKpiBo> findQaKpiList(Integer recordId) {
		Criterion criterion = null;
		if(recordId != 0){
			criterion = Restrictions.eq("recordId", recordId);
		} 
		List<QaKpi> list = qaKpiDao.findByCriteria(criterion);
		List<QaKpiBo> listBo = new ArrayList<QaKpiBo>();
		QaKpiBo qaKpiBo = null;
		for(QaKpi qaKpi : list){
			qaKpiBo = convert(qaKpi);
			listBo.add(qaKpiBo);
		}
		return listBo;
	}
	
	private QaKpi convert(QaKpiBo qaKpiBo){
		QaKpi qaKpi = new QaKpi();
		if(!"".equals(qaKpiBo.getKpiId())){
			qaKpi.setKpiId(Integer.valueOf(qaKpiBo.getKpiId()));	
		}
		qaKpi.setKpiCode(qaKpiBo.getKpiCode());
		qaKpi.setKbiName(qaKpiBo.getKbiName());
		qaKpi.setKpiRemark(qaKpiBo.getKpiRemark());
		qaKpi.setKpiValue(qaKpiBo.getKpiValue());
//		qaKpi.setRecordId(Integer.valueOf(qaKpiBo.getRecordId()));
		return qaKpi;
	}
	
	private QaKpiBo convert(QaKpi qaKpi){
		QaKpiBo qaKpiBo = new QaKpiBo();
		qaKpiBo.setKpiId(String.valueOf(qaKpiBo.getKpiId()));
		qaKpiBo.setKpiCode(qaKpiBo.getKpiCode());
		qaKpiBo.setKbiName(qaKpiBo.getKbiName());
		qaKpiBo.setKpiRemark(qaKpiBo.getKpiRemark());
		qaKpiBo.setKpiValue(qaKpiBo.getKpiValue());
		qaKpiBo.setRecordId(String.valueOf(qaKpiBo.getRecordId()));
		return qaKpiBo;
	}

	@Autowired
	private IQaKpiDao qaKpiDao;

	@Override
	public void create(Integer recordId, QaKpiBos qaKpiBos) {
		// TODO Auto-generated method stub
		
	}
}
