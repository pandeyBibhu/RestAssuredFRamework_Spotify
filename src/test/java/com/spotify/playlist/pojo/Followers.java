package com.spotify.playlist.pojo;
public class Followers{
	private int total;
	private Object href;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setHref(Object href){
		this.href = href;
	}

	public Object getHref(){
		return href;
	}
}
