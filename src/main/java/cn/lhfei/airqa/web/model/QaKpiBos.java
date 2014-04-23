package cn.lhfei.airqa.web.model;

import java.io.Serializable;
import java.util.List;


/**
 * @author liuwu
 * @description  监测数据指标实体集合
 */
public class QaKpiBos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<QaKpiBo> QaKpiBos;

	public List<QaKpiBo> getQaKpiBos() {
		return QaKpiBos;
	}

	public void setQaKpiBos(List<QaKpiBo> qaKpiBos) {
		QaKpiBos = qaKpiBos;
	}

}