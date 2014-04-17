package cn.lhfei.airqa.service;

import cn.lhfei.airqa.web.model.QaKpiBo;

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
}
