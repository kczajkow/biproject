package com.czajkowski.operation.dao;

import java.util.List;

import com.czajkowski.operation.model.Operation;


public interface OperationDAO {
	
	public List<Operation> listOperation();
	public List<String> listTitle();
	public List<Double> listValue();
}
