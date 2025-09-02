package com.spotify.playlist.pojo;
public class Owner{
	private String href;
	private String id;
	private String displayName;
	private String type;
	private ExternalUrls externalUrls;
	private String uri;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setExternalUrls(ExternalUrls externalUrls){
		this.externalUrls = externalUrls;
	}

	public ExternalUrls getExternalUrls(){
		return externalUrls;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}
}
