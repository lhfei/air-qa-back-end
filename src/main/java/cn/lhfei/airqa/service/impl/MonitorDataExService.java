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

package cn.lhfei.airqa.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.common.DateUtil;
import cn.lhfei.airqa.dao.IMonitorDataExDao;
import cn.lhfei.airqa.entity.MonitorData;
import cn.lhfei.airqa.service.IMonitorDataExService;
import cn.lhfei.airqa.web.model.KPIRecordModel;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 25, 2014
 */
@Service("monitorDataExService")
public class MonitorDataExService implements IMonitorDataExService {

	@Override
	public void push(List<KPIRecordModel> data) throws ParseException {
		List<MonitorData> list = new ArrayList<MonitorData>();
		
		MonitorData monitor;
		for(KPIRecordModel model : data){
			monitor = new MonitorData();
			
			monitor.setUserId(model.getUserId());
			monitor.setDeviceId(model.getDeviceId());
			monitor.setAldehyde(model.getAldehyde());
			monitor.setHumidity(model.getHumidity());
			monitor.setMonitorDate(DateUtil.parse(model.getMonitorDate()));
			monitor.setPm(model.getPm());
			monitor.setTempreture(model.getTempreture());
			monitor.setVoc(model.getVoc());
			
			list.add(monitor);
		}

		monitorDataExDao.push(list);
	}
	
	@Autowired
	private IMonitorDataExDao monitorDataExDao;

}
