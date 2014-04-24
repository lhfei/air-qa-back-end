package cn.lhfei.airqa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qa_kpi database table.
 * 
 */
@Entity
@Table(name="qa_kpi")
@NamedQuery(name="QaKpi.findAll", query="SELECT q FROM QaKpi q")
public class QaKpi implements Serializable {
	private static final long serialVersionUID = 1L;

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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="KPI_ID")
	private int kpiId;

	@Column(name="KBI_NAME")
	private String kbiName;

	@Column(name="KPI_CODE")
	private String kpiCode;

	@Column(name="KPI_REMARK")
	private String kpiRemark;

	@Column(name="KPI_VALUE")
	private String kpiValue;

	@Column(name="RECORD_ID")
	private int recordId;
}