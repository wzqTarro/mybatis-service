package com.report.common.constant;

import java.io.Serializable;
import java.util.List;

public class PageRecord<T> implements Serializable{
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 8600527982543905998L;
	private int pageNum;
	private int pageSize;
	private long pageTotal;
	private List<T> list;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(long pageTotal) {
		this.pageTotal = pageTotal;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
