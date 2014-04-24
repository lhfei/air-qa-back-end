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

package cn.lhfei.airqa.dao.impl;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cn.lhfei.airqa.dao.IMonitorDataExDao;
import cn.lhfei.airqa.dao.support.Hibernate4DaoSupport;
import cn.lhfei.airqa.entity.MonitorData;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 25, 2014
 */
@Repository("monitorDataExDao")
@Transactional
public class MonitorDataExDao extends Hibernate4DaoSupport<MonitorData, Integer> implements
		IMonitorDataExDao {

	protected MonitorDataExDao() {
		super(MonitorData.class);
	}

	@Override
	public void push(List<MonitorData> data) throws ParseException {
		super.batchInsert(data);
	}

}
