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

/**
 * <tt>设备厂商-监测数据推送操作结果<tt>返回消息模型</p>
 * 
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 25, 2014
 */

public class PushResponseModel {
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * 返回结果代码：[成功(0)|失败(1)]
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 返回结果代码：[成功(0)|失败(1)]
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private int total;
	private String code;		// 返回结果代码：[成功(0)|失败(1)]
	private String message;
}
