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

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lhfei.airqa.entity.User;
import cn.lhfei.airqa.test.BaseTestSuit;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 7, 2014
 */

public class UserDaoTest extends BaseTestSuit {

	@Test
	public void create() {
		log.debug("create User start .");
		
		 User user = new User("Hefei Li", "Hefei", "Li", "Lhfei");
		 user.setCreatedOn(new Date());
		 
		 userDao.create(user);
	}
	
	@Autowired
	private IUserDao userDao;
}
