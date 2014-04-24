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

package cn.lhfei.airqa.web.model;

import java.util.Date;

/**
 * 设备厂商-监测数据模型</p>
 * 
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 25, 2014
 */

public class KPIRecordModel {

	@Override
	public String toString() {
		return "{"
			+"\"userId\": " +userId+", "
			+"\"deviceId\": "+deviceId+", "
			+"\"pm\": "+pm+", "
			+"\"voc\": "+voc+", "
			+"\"tempreture\": "+tempreture+", "
			+"\"humidity\": "+humidity+", "
			+"\"aldehyde\": "+aldehyde+", "
			+"\"monitorDate\": "+monitorDate
			+"}";
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
	public String getMonitorDate() {
		return monitorDate;
	}
	public void setMonitorDate(String monitorDate) {
		this.monitorDate = monitorDate;
	}
	
	//===============PRIVATE FIELDS===============
	
	private int userId;			//设备所属用户ID
	private int deviceId;		//设备ID
	private String pm;			//pm值
	private String voc;			//voc值
	private String tempreture;	//温度值
	private String humidity;	//湿度值
	private String aldehyde;	//甲醛浓度值
	private String monitorDate;	//监测时间
}
