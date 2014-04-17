package cn.lhfei.airqa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		//checkRecordDao.saveOrUpdate(checkRecord);
	}

	@Autowired
	private ICheckRecordDao checkRecordDao;

}
