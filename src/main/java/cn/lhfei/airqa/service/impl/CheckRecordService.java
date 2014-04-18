package cn.lhfei.airqa.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.common.Page;
import cn.lhfei.airqa.dao.ICheckRecordDao;
import cn.lhfei.airqa.entity.CheckRecord;
import cn.lhfei.airqa.service.ICheckRecordService;
import cn.lhfei.airqa.web.model.CheckRecordBo;

@Service
public class CheckRecordService implements ICheckRecordService {

	@Override
	public void create(CheckRecordBo checkRecordBo) {
		CheckRecord checkRecord = new CheckRecord();
		checkRecord.setRecordNum(checkRecordBo.getRecordNum());
		checkRecord.setAgent(checkRecordBo.getAgent());
		checkRecord.setAddress(checkRecordBo.getAddress());
		checkRecord.setContact(checkRecordBo.getContact());
		checkRecord.setDeviceId(checkRecordBo.getDeviceId());
		checkRecord.setLocation(checkRecordBo.getLocation());
		checkRecord.setOperatedTime(checkRecordBo.getOperatedTime());
		checkRecord.setPaid(checkRecordBo.getPaid());
		checkRecord.setPhase(checkRecordBo.getPhase());
		checkRecord.setPhone(checkRecordBo.getPhone());
		checkRecordDao.saveOrUpdate(checkRecord);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<CheckRecordBo> findListCheck(Page<CheckRecordBo> pageBo,String recordNum) {
		Criterion criterion = null;
		if(recordNum != null && recordNum.equals("")){
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
	
	private CheckRecordBo convert(CheckRecord checkRecord){
		CheckRecordBo checkRecordbo = new CheckRecordBo();
		BeanUtils.copyProperties(checkRecord, checkRecordbo);
		return checkRecordbo;
	}

	@Autowired
	private ICheckRecordDao checkRecordDao;
}
