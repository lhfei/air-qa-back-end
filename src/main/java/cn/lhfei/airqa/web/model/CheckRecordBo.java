package cn.lhfei.airqa.web.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

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
	private String recordId;

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
	private String cost;

	/**
	 * 位置
	 */
	private String location;

	private String operatedTime;

	/**
	 * 缴费状态
	 */
	private String paid;

	/**
	 * 检测状态
	 */
	private String phase;

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

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOperatedTime() {
		return operatedTime;
	}

	public void setOperatedTime(String operatedTime) {
		this.operatedTime = operatedTime;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRecordNum() {
		return recordNum;
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