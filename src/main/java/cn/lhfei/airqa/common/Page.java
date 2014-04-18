package cn.lhfei.airqa.common;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private int pageSize;
	
	private int curPage;
	
	private int pageCount = 10;
	
	private int totalCount;
	
	private List<T> result = new ArrayList<T>();

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageCount() {
		pageCount = this.totalCount/this.pageCount;
		if(pageCount%this.getPageSize() != 0){
			pageCount+=1;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
