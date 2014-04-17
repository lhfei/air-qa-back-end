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


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.lhfei.airqa.dao.ICheckRecordDao;
import cn.lhfei.airqa.dao.support.Hibernate4DaoSupport;
import cn.lhfei.airqa.entity.CheckRecord;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 7, 2014
 */
@Repository
@Transactional
public class CheckRecordDao extends Hibernate4DaoSupport<CheckRecord, String> implements ICheckRecordDao {

	protected CheckRecordDao() {
		super(CheckRecord.class);
	}

	@Override
	public void create(CheckRecord checkRecord) {
		super.saveOrUpdate(checkRecord);
	}

}
