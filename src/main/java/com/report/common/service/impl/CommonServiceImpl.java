package com.report.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.report.common.dao.CommonDao;
import com.report.common.service.ICommonService;
import com.report.common.constant.CommonValue;
import com.report.common.constant.PageRecord;

@Service
public class CommonServiceImpl implements ICommonService{

	@Autowired
	private CommonDao dao;

	@Override
	public <T> List<T> queryListByObject(String statement, Object parameter) {
		return dao.queryListByObject(statement, parameter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> PageRecord<T> queryPageByObject(String countStatement, String listStatement, Object parameter,
			Integer pageNum, Integer pageSize) throws Exception {
		Map<String, Object> params = new HashMap<>(2);
		if (parameter != null) {
			params = JSON.parseObject(JSON.toJSONString(parameter), Map.class);		
		}
		if (null == pageNum || 0 == pageNum) {
			pageNum = CommonValue.PAGE;
		}
		if (null == pageSize || 0 == pageSize) {
			pageSize = CommonValue.SIZE;
		}
		int num = (pageNum - 1) * pageSize;
		int size = pageSize;
		params.put("pageNum", num);
		params.put("pageSize", size);
		PageRecord<T> page = new PageRecord<>();
		page.setList(dao.queryListByObject(listStatement, params));
		page.setPageTotal(dao.queryCountByObject(countStatement, params));
		page.setPageNum(num);
		page.setPageSize(size);
		return page;
	}

	@Override
	public int queryCountByObject(String statement, Object parameter) {
		return dao.queryCountByObject(statement, parameter);
	}

	@Override
	public int insert(String statement, Object parameter) {
		return dao.insert(statement, parameter);
	}

	@Override
	public int update(String statement, Object parameter) {
		return dao.update(statement, parameter);
	}

	@Override
	public int delete(String statement, Object parameter) {
		return dao.delete(statement, parameter);
	}

	@Override
	public Object queryObjectByParameter(String statement, Object parameter) {
		return dao.queryObjectByParameter(statement, parameter);
	}

}
