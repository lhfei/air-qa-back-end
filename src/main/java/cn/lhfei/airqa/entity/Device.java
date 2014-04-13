package cn.lhfei.airqa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the device database table.
 * 
 */
@Entity
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEVICE_ID")
	private int deviceId;

	@Column(name="COMPANY_ID")
	private int companyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="DATA_STATUS")
	private int dataStatus;

	@Column(name="DEVICE_NAME")
	private String deviceName;

	@Column(name="DEVICE_SID")
	private String deviceSid;

	@Column(name="DEVICE_TYPE")
	private String deviceType;

	private String operator;

	@OneToMany(mappedBy="device")
	private List<CheckRecord> checkRecords;

	public Device() {
	}

	public int getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(int dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceSid() {
		return this.deviceSid;
	}

	public void setDeviceSid(String deviceSid) {
		this.deviceSid = deviceSid;
	}

	public String getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<CheckRecord> getCheckRecords() {
		return this.checkRecords;
	}

	public void setCheckRecords(List<CheckRecord> checkRecords) {
		this.checkRecords = checkRecords;
	}

	public CheckRecord addCheckRecord(CheckRecord checkRecord) {
		getCheckRecords().add(checkRecord);
		checkRecord.setDevice(this);

		return checkRecord;
	}

	public CheckRecord removeCheckRecord(CheckRecord checkRecord) {
		getCheckRecords().remove(checkRecord);
		checkRecord.setDevice(null);

		return checkRecord;
	}

}