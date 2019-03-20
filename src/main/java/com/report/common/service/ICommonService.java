package com.report.common.service;

import java.util.List;

import com.report.common.constant.PageRecord;

public interface ICommonService {

	Object queryObjectByParameter(String statement, Object parameter);
	
	<T> List<T> queryListByObject(String statement, Object parameter);
	
	<T> PageRecord<T> queryPageByObject(String countStatement, String listStatement, Object parameter, Integer pageNum, Integer pageSize) throws Exception;
	
	int queryCountByObject(String statement, Object parameter);

	int insert(String statement, Object parameter);
	
	int update(String statement, Object parameter);
	
	int delete(String statement, Object parameter);
}
