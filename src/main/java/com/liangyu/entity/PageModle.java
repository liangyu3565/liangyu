package com.liangyu.entity;

import java.io.Serializable;
import java.util.List;

public class PageModle<T> implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 5662866989779542349L;
private List<T> data;
 private int totalPage;
public List<T> getData() {
	return data;
}
public void setData(List<T> data) {
	this.data = data;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
@Override
public String toString() {
	return "PageModle [data=" + data + ", totalPage=" + totalPage + "]";
}

 
  
 
 
}
