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

package cn.lhfei.airqa.web.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.service.IMonitorDataExService;
import cn.lhfei.airqa.web.model.KPIRecordModel;
import cn.lhfei.airqa.web.model.PushResponseModel;

/**
 * 终端设备厂商-监测数据对接</p>
 * 
 * 以<code>REST WS</code> 对外提供服务.
 * 
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 25, 2014
 */
@Controller
@RequestMapping("/restful")
public class MonitorDataExController {

	private static final Logger log = LoggerFactory.getLogger(MonitorDataExController.class);
	
	/**
	 * 设备厂商-推送数据<code>REST</code>接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/push", method = RequestMethod.POST)
	@ResponseBody
	public PushResponseModel push(@RequestBody List<KPIRecordModel> data){
		
		log.debug(data.toString());
		
		PushResponseModel responseModel = new PushResponseModel();
		
		try {
			monitorDataExService.push(data);
			
			responseModel.setTotal(data.size());
			responseModel.setCode("0");
			responseModel.setMessage("\u64cd\u4f5c\u6210\u529f!");
			
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			
			responseModel.setCode("0");
			responseModel.setMessage("\u64cd\u4f5c\u5931\u8d25!");
		}
		
		return responseModel;
	}
	
	
	@Autowired
	private IMonitorDataExService monitorDataExService;
}
