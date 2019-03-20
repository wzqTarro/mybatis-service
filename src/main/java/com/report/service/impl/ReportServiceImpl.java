package com.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.bean.Report;
import com.report.common.service.ICommonService;
import com.report.dbSql.Query;
import com.report.service.IReportService;

@Service
public class ReportServiceImpl implements IReportService{
	
	@Autowired
	private ICommonService commonService;
	
	@Override
	public List<Report> getReport() {
		
		return commonService.queryListByObject(Query.QUERY_REPORT, null);
	}
}
