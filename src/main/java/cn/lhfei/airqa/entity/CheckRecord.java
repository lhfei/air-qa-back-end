package cn.lhfei.airqa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the check_record database table.
 * 
 */
@Entity
@Table(name="check_record")
@NamedQuery(name="CheckRecord.findAll", query="SELECT c FROM CheckRecord c")
public class CheckRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RECORD_ID")
	private int recordId;

	private String address;

	private String agent;

	private String contact;

	private BigDecimal cost;

	private String location;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OPERATED_TIME")
	private Date operatedTime;

	private int paid;

	private int phase;

	private String phone;

	@Column(name="RECORD_NUM")
	private String recordNum;

	//bi-directional many-to-one association to Device
	@ManyToOne
	@JoinColumn(name="DEVICE_ID")
	private Device device;

	public CheckRecord() {
	}

	public int getRecordId() {
		return this.recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAgent() {
		return this.agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getOperatedTime() {
		return this.operatedTime;
	}

	public void setOperatedTime(Date operatedTime) {
		this.operatedTime = operatedTime;
	}

	public int getPaid() {
		return this.paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public int getPhase() {
		return this.phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRecordNum() {
		return this.recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}