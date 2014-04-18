package cn.lhfei.airqa.service;

import cn.lhfei.airqa.common.Page;
import cn.lhfei.airqa.web.model.CheckRecordBo;

public interface ICheckRecordService {
	/**
	 * 用户注册
	 * @param checkRecord
	 */
	void create(CheckRecordBo checkRecordBo);
	
	
	Page<CheckRecordBo> findListCheck(Page<CheckRecordBo> page,String recordNum);
}
