package cn.lhfei.airqa.service;

import java.util.List;

import cn.lhfei.airqa.web.model.QaKpiBo;
import cn.lhfei.airqa.web.model.QaKpiBos;

/**
 * @author liuwu
 *  description: 检测指标 service接口
 */
public interface IQaKpiService {
	/**
	 * 新增检测指标
	 * @param qaKpiBo
	 */
	void create(QaKpiBo qaKpiBo);
	
	/**
	 * 方法描述：<新增检测指标>
	 *
	 * @param qaKpiBos
	 */
	void create(String recordId,QaKpiBos qaKpiBos);
	
	void create(Integer recordId,QaKpiBos qaKpiBos);
	
	/**
	 * 方法描述：<根据检测ID获取指标值列表>
	 *
	 * @param recordId
	 * @return
	 */
	List<QaKpiBo> findQaKpiList(Integer recordId); 
}
