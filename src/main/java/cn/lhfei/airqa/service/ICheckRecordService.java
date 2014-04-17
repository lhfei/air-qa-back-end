package cn.lhfei.airqa.service;

import cn.lhfei.airqa.web.model.CheckRecordBo;

public interface ICheckRecordService {
	/**
	 * 用户注册
	 * @param checkRecord
	 */
	void create(CheckRecordBo checkRecordBo);
}
