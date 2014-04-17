package cn.lhfei.airqa.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.lhfei.airqa.web.provider.SimpleJsonDateSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * @author liuwu
 * @description 表格检测记录
 *
 */
@JsonAutoDetect
public class CheckRecordBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 记录ID
	 */
	private int recordId;

	/**
	 * 通信地址
	 */
	private String address;

	/**
	 * 委托单位/个人
	 */
	private String agent;

	/**
	 * 联系人
	 */
	private String contact;

	/**
	 * 检测费用
	 */
	private BigDecimal cost;

	/**
	 * 位置
	 */
	private String location;

	@JsonSerialize(using=SimpleJsonDateSerializer.class)
	private Date operatedTime;

	/**
	 * 缴费状态
	 */
	private int paid;

	/**
	 * 检测状态
	 */
	private int phase;

	/**
	 * 联系电话
	 */
	private String phone;

	/**
	 * 检测单号
	 */
	private String recordNum;

	/**
	 * 终端对象
	 */
	private String deviceId;

	public CheckRecordBo() {
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
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}