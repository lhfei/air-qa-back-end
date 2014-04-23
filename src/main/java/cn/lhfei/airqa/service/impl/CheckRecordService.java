package cn.lhfei.airqa.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.common.DateUtil;
import cn.lhfei.airqa.common.Page;
import cn.lhfei.airqa.dao.ICheckRecordDao;
import cn.lhfei.airqa.entity.CheckRecord;
import cn.lhfei.airqa.service.ICheckRecordService;
import cn.lhfei.airqa.web.model.CheckRecordBo;

@Service
public class CheckRecordService implements ICheckRecordService {

	@Override
	public CheckRecordBo create(CheckRecordBo checkRecordBo) {
		CheckRecord checkRecord = convert(checkRecordBo);
		checkRecordDao.saveOrUpdate(checkRecord);
		checkRecordBo.setRecordId(String.valueOf(checkRecord.getRecordId()));
		return checkRecordBo;
	}
	
	@Override
	public Page<CheckRecordBo> findListCheck(Page<CheckRecordBo> pageBo,String recordNum) {
		Criterion criterion = null;
		if(recordNum != null && !recordNum.equals("")){
			criterion = Restrictions.like("recordNum","%'"+recordNum+"'%");
		}
		Page<CheckRecord> page = new Page<CheckRecord>();
		page.setPageSize(pageBo.getPageSize());
		page.setCurPage(pageBo.getCurPage());
		page = checkRecordDao.findPageByCriteria(criterion, page);
		List<CheckRecord> list = page.getResult();
		CheckRecordBo checkRecordbo = null;
		for(CheckRecord checkRecord : list){
			checkRecordbo = convert(checkRecord);
			pageBo.getResult().add(checkRecordbo);
		}
		pageBo.setPageCount(page.getPageCount());
		pageBo.setTotalCount(page.getTotalCount());
		return pageBo;
	} 
	

	@Override
	public CheckRecordBo findById(String recordId) {
		CheckRecord checkRecord = checkRecordDao.findById(recordId);
		CheckRecordBo checkRecordBo = convert(checkRecord);
		return checkRecordBo;
	}
	
	private CheckRecordBo convert(CheckRecord checkRecord){
		CheckRecordBo checkRecordbo = new CheckRecordBo();
		BeanUtils.copyProperties(checkRecord, checkRecordbo);
		checkRecordbo.setCost(String.valueOf(checkRecord.getCost()));
		checkRecordbo.setPaid(String.valueOf(checkRecord.getPaid()));
		checkRecordbo.setPhase(String.valueOf(checkRecord.getPhase()));
		String opratedTime = DateUtil.format(checkRecord.getOperatedTime(), "yyyy-MM-dd HH:mm");
		checkRecordbo.setOperatedTime(opratedTime);
		return checkRecordbo;
	}
	
	private CheckRecord convert(CheckRecordBo checkRecordBo){
		CheckRecord checkRecord = new CheckRecord();
		BeanUtils.copyProperties(checkRecordBo, checkRecord);
		checkRecord.setCost(new BigDecimal(checkRecordBo.getCost()));
		checkRecord.setPaid(Integer.valueOf(checkRecordBo.getPaid()));
		checkRecord.setPhase(Integer.valueOf(checkRecordBo.getPhase()));
		Date opratedTime = null;
		try {
			opratedTime = DateUtil.parse(checkRecordBo.getOperatedTime(), "yyyy-MM-dd HH:mm");
			checkRecord.setOperatedTime(opratedTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return checkRecord;
	}

	@Autowired
	private ICheckRecordDao checkRecordDao;

}
