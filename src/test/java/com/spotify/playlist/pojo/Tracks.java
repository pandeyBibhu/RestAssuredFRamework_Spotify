package com.spotify.playlist.pojo;

import java.util.List;

public class Tracks{
	private Object next;
	private int total;
	private int offset;
	private Object previous;
	private int limit;
	private String href;
	private List<Object> items;

	public void setNext(Object next){
		this.next = next;
	}

	public Object getNext(){
		return next;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setPrevious(Object previous){
		this.previous = previous;
	}

	public Object getPrevious(){
		return previous;
	}

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	public void setItems(List<Object> items){
		this.items = items;
	}

	public List<Object> getItems(){
		return items;
	}
}
