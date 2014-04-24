/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.lhfei.airqa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 设备厂商-监测数据模型</p>
 * 
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 25, 2014
 */
@Entity
@Table(name="KPI_RECORD")
public class MonitorData {
	
	public int getKpiId() {
		return kpiId;
	}
	public void setKpiId(int kpiId) {
		this.kpiId = kpiId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public String getVoc() {
		return voc;
	}
	public void setVoc(String voc) {
		this.voc = voc;
	}
	public String getTempreture() {
		return tempreture;
	}
	public void setTempreture(String tempreture) {
		this.tempreture = tempreture;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getAldehyde() {
		return aldehyde;
	}
	public void setAldehyde(String aldehyde) {
		this.aldehyde = aldehyde;
	}
	public Date getMonitorDate() {
		return monitorDate;
	}
	public void setMonitorDate(Date monitorDate) {
		this.monitorDate = monitorDate;
	}
	public String getBack_a() {
		return back_a;
	}
	public void setBack_a(String back_a) {
		this.back_a = back_a;
	}
	public String getBack_b() {
		return back_b;
	}
	public void setBack_b(String back_b) {
		this.back_b = back_b;
	}
	public String getBack_c() {
		return back_c;
	}
	public void setBack_c(String back_c) {
		this.back_c = back_c;
	}
	public String getBack_d() {
		return back_d;
	}
	public void setBack_d(String back_d) {
		this.back_d = back_d;
	}
	public String getBack_e() {
		return back_e;
	}
	public void setBack_e(String back_e) {
		this.back_e = back_e;
	}
	
	//===============PRIVATE FIELDS===============
	@Id
	@Column(name="kpi_id")
	private int kpiId;
	
	@Column(name="user_id")
	private int userId;			//设备所属用户ID
	
	@Column(name="device_id")
	private int deviceId;		//设备ID
	
	@Column(name="pm")
	private String pm;			//pm值
	
	@Column(name="voc")
	private String voc;			//voc值
	
	@Column(name="tempreture")
	private String tempreture;	//温度值
	
	@Column(name="humidity")
	private String humidity;	//湿度值
	
	@Column(name="aldehyde")
	private String aldehyde;	//甲醛浓度值
	
	@Column(name="monitorDate")
	private Date monitorDate;	//监测时间
	
	@Column(name="back_a")
	private String back_a;
	@Column(name="back_b")
	private String back_b;
	@Column(name="back_c")
	private String back_c;
	@Column(name="back_d")
	private String back_d;
	@Column(name="back_e")
	private String back_e;
	
}
