package cn.lhfei.airqa.service;

import cn.lhfei.airqa.common.Page;
import cn.lhfei.airqa.web.model.CheckRecordBo;

public interface ICheckRecordService {
	/**
	 * 用户注册
	 * @param checkRecord
	 */
	CheckRecordBo create(CheckRecordBo checkRecordBo);
	
	/**
	 * 方法描述：<根据ID查询检测记录对象>
	 *
	 * @param recordId 检测记录ID
	 * @return 检测记录Bo
	 */
	CheckRecordBo findById(String recordId);
	/**
	 * 方法描述：<检测记录查询>
	 *
	 * @param page  分页对象
	 * @param recordNum 记录单号
	 * @return      检测记录分页对象
	 */
	Page<CheckRecordBo> findListCheck(Page<CheckRecordBo> page,String recordNum);
}
