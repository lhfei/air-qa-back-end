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

package cn.lhfei.airqa.dao;

import java.util.List;

import cn.lhfei.airqa.dao.support.AbstractHibernate4DaoSupport;
import cn.lhfei.airqa.entity.Region;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 7, 2014
 */
public interface IRegionDao extends AbstractHibernate4DaoSupport<Region,Integer>{
	List<Region> findRegion(int level, int pid);
}