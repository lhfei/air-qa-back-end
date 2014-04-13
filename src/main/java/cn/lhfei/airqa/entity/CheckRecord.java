package cn.lhfei.airqa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author liuwu
 * @description 表格检测记录
 *
 */
@Entity
@Table(name="check_record")
@NamedQuery(name="CheckRecord.findAll", query="SELECT c FROM CheckRecord c")
public class CheckRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 记录ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RECORD_ID")
	private int recordId;

	/**
	 * 通信地址
	 */
	@Column(name="ADDRESS")
	private String address;

	/**
	 * 委托单位/个人
	 */
	@Column(name="AGENT")
	private String agent;

	/**
	 * 联系人
	 */
	@Column(name="CONTACT")
	private String contact;

	/**
	 * 检测费用
	 */
	@Column(name="COST")
	private BigDecimal cost;

	/**
	 * 位置
	 */
	@Column(name="LOCATION")
	private String location;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OPERATED_TIME")
	private Date operatedTime;

	/**
	 * 缴费状态
	 */
	@Column(name="PAID")
	private int paid;

	/**
	 * 检测状态
	 */
	@Column(name="PHASE")
	private int phase;

	/**
	 * 联系电话
	 */
	@Column(name="PHONE")
	private String phone;

	/**
	 * 检测单号
	 */
	@Column(name="RECORD_NUM")
	private String recordNum;

	/**
	 * 终端对象
	 */
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