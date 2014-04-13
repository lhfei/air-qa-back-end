package cn.lhfei.airqa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qa_kpi database table.
 * 
 */
/**
 * @author liuwu
 * @description  监测数据指标实体
 */
@Entity
@Table(name="qa_kpi")
@NamedQuery(name="QaKpi.findAll", query="SELECT q FROM QaKpi q")
public class QaKpi implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 指标ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="KPI_ID")
	private int kpiId;

	/**
	 * 指标名称
	 */
	@Column(name="KBI_NAME")
	private String kbiName;

	/**
	 * 指标编码
	 */
	@Column(name="KPI_CODE")
	private String kpiCode;

	/**
	 * 指标检测备注
	 */
	@Column(name="KPI_REMARK")
	private String kpiRemark;

	/**
	 * 指标检测值
	 */
	@Column(name="KPI_VALUE")
	private String kpiValue;

	/**
	 * 记录ID
	 */
	@Column(name="RECORD_ID")
	private int recordId;

	public QaKpi() {
	}

	public int getKpiId() {
		return this.kpiId;
	}

	public void setKpiId(int kpiId) {
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

	public int getRecordId() {
		return this.recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

}