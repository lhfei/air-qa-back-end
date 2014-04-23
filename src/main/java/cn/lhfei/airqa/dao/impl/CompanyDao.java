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

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.lhfei.airqa.common.Constants;
import cn.lhfei.airqa.dao.ICompanyDao;
import cn.lhfei.airqa.dao.support.Hibernate4DaoSupport;
import cn.lhfei.airqa.entity.Company;
import cn.lhfei.airqa.web.model.PageModel;

/**
 * @version 0.1
 * 
 * @author Hefei Li
 * 
 * @since Apr 7, 2014
 */
@Repository
@Transactional
public class CompanyDao extends Hibernate4DaoSupport<Company, Integer>
		implements ICompanyDao {

	protected CompanyDao() {
		super(Company.class);
	}

	@Override
	public PageModel findCompany(int page, int rows) {
		PageModel pageModel = new PageModel();

		Criteria criteria = getCriteria();
		criteria.add(Restrictions.ne("dataStatus", Constants.STATUS_DELETE));

		// 统计符合条件数据的总数
		int total = criteria.list().size();
		pageModel.setTotal(total);

		criteria.setFirstResult((page - 1) * rows).setMaxResults(rows);
		pageModel.setRows(criteria.list());

		return pageModel;
	}

}
