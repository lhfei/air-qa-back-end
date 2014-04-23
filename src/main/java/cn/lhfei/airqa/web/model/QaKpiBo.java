package cn.lhfei.airqa.web.model;

import java.io.Serializable;


/**
 * @author liuwu
 * @description  监测数据指标实体
 */
public class QaKpiBo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 指标ID
	 */
	private String kpiId;

	/**
	 * 指标名称
	 */
	private String kbiName;

	/**
	 * 指标编码
	 */
	private String kpiCode;

	/**
	 * 指标检测备注
	 */
	private String kpiRemark;

	/**
	 * 指标检测值
	 */
	private String kpiValue;

	/**
	 * 记录ID
	 */
	private String recordId;

	public QaKpiBo() {
	}

	public String getKpiId() {
		return this.kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getKbiName() {
		return this.kbiName;
	}

	public void setKbiName(String kbiName) {
		this.kbiName = kbiName;
	}

	public String getKpiCode() {
		return this.kpiCode;
	}

	public void setKpiCode(String kpiCode) {
		this.kpiCode = kpiCode;
	}

	public String getKpiRemark() {
		return this.kpiRemark;
	}

	public void setKpiRemark(String kpiRemark) {
		this.kpiRemark = kpiRemark;
	}

	public String getKpiValue() {
		return this.kpiValue;
	}

	public void setKpiValue(String kpiValue) {
		this.kpiValue = kpiValue;
	}

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

}