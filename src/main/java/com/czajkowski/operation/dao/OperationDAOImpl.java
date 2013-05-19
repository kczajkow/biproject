package com.czajkowski.operation.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.czajkowski.operation.model.Operation;

@Repository
public class OperationDAOImpl implements OperationDAO {

	@Autowired
	private SessionFactory sessionFactory;

    @Override
	@SuppressWarnings("unchecked")
	public List<Operation> listOperation() {

		return sessionFactory.getCurrentSession().createQuery("from Operation").list();
	}

}
