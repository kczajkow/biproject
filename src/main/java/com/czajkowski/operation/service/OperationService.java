package com.czajkowski.operation.service;

import java.util.List;

import com.czajkowski.operation.model.Operation;


public interface OperationService {
	
	public List<Operation> listOperation();
	public List<String> listTitle();
	public List<Double> listValue();
}
