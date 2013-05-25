package com.czajkowski.operation.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.czajkowski.operation.model.Operation;

@Repository
public class OperationDAOImpl implements OperationDAO {
	
	final String OPERATION_QUERY = "select max(op.operation_month), " +
			"max(op.operation_year), " +
			"sum(op.operation_value), " +
			"op.category.category_id " +
			"from Operation op " +
			"where op.operation_year=2013 " +
			"and op.operation_month=3 " +
			"group by op.category.category_id";
	
	final String TITLE_QUERY = "select " +
			"op.category.category_id " +
			"from Operation op " +
			"where op.operation_year=2013 " +
			"and op.operation_month=3 " +
			"group by op.category.category_id";
	
	final String VALUE_QUERY = "select " +
			"sum(op.operation_value) " +
			"from Operation op " +
			"where op.operation_year=2013 " +
			"and op.operation_month=3 " +
			"group by op.category.category_id";
	
	@Autowired
	private SessionFactory sessionFactory;

    @Override
	@SuppressWarnings("unchecked")
	public List<Operation> listOperation() {
		return sessionFactory.getCurrentSession().createQuery(OPERATION_QUERY).list();
	}
    
    @Override
	@SuppressWarnings("unchecked")
	public List<String> listTitle() {
		return sessionFactory.getCurrentSession().createQuery(TITLE_QUERY).list();
	}
    
    @Override
	@SuppressWarnings("unchecked")
	public List<Double> listValue() {
		return sessionFactory.getCurrentSession().createQuery(VALUE_QUERY).list();
	}

}
