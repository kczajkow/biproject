package com.czajkowski.operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.czajkowski.operation.dao.OperationDAO;
import com.czajkowski.operation.model.Operation;


@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationDAO operationDAO;

	@Override
	@Transactional
	public List<Operation> listOperation() {
		return operationDAO.listOperation();
	}
	
	@Override
	@Transactional
	public List<String> listTitle() {
		return operationDAO.listTitle();
	}
	
	@Override
	@Transactional
	public List<Double> listValue() {
		return operationDAO.listValue();
	}

}
