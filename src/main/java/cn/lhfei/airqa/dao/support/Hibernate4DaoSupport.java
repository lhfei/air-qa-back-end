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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lhfei.airqa.common.Page;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 7, 2014
 */

public abstract class Hibernate4DaoSupport<E, I extends Serializable> implements
		AbstractHibernate4DaoSupport<E, I> {

    protected Hibernate4DaoSupport(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    @Override
    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
    }

    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }

    @Override
    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        if(criterion != null){
        	criteria.add(criterion);	
        }
        return criteria.list();
    }
    
    @Override
    public Page<E> findPageByCriteria(Criterion criterion,Page<E> page){
    	Criteria criteria = getCurrentSession().createCriteria(entityClass);
    	int count = ((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
    	criteria.setProjection(null);
    	if(criterion != null){
    		criteria.add(criterion);
    	}
    	page.setTotalCount(count);
    	int startCount = (page.getCurPage() -1) * page.getPageSize();
    	int endCount = startCount + page.getPageSize();
    	criteria.setFirstResult(startCount);
    	criteria.setMaxResults(endCount);
    	page.setResult(criteria.list());
    	return page;
    }
    
    public Criteria getCriteria() {
		return getCurrentSession().createCriteria(entityClass);
	}
    
    public void batchInsert(List<E> list) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	   
    	for ( int i=0; i<list.size(); i++ ) {
    	    session.save(list.get(i));
    	    if ( i % 50 == 0 ) { //50, same as the JDBC batch size
    	        //flush a batch of inserts and release memory:
    	        session.flush();
    	        session.clear();
    	    }
    	}
    	   
    	tx.commit();
    	session.close();
    }
   
    // PRIVATE FIELDS
    
    private Class<E> entityClass;
    
    @Autowired
    private SessionFactory sessionFactory;
}
