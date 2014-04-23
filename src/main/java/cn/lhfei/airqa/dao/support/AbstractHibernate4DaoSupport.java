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

package cn.lhfei.airqa.dao.support;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import cn.lhfei.airqa.common.Page;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 7, 2014
 */

public interface AbstractHibernate4DaoSupport<E, I extends Serializable> {

    /**
     * 方法描述：<根据ID查询实体>
     *
     * @param id
     * @return
     */
    E findById(I id);
    /**
     * 方法描述：<保存以及更新实体>
     *
     * @param e
     */
    void saveOrUpdate(E e);
    /**
     * 方法描述：<删除实体>
     *
     * @param e
     */
    void delete(E e);
    /**
     * 方法描述：<根据查询条件查询实体>
     *
     * @param criterion
     * @return
     */
    List<E> findByCriteria(Criterion criterion);
    /**
     * 方法描述：<根据查询条件查询实体分页对象>
     *
     * @param criterion
     * @param page
     * @return
     */
    Page<E> findPageByCriteria(Criterion criterion,Page<E> page);
}
