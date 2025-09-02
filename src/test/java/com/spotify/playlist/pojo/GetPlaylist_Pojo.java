package com.spotify.playlist.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetPlaylist_Pojo {
	private Owner owner;
	private Object images;
	private String snapshotId;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private boolean collaborative;
	private String description;
	private Object primaryColor;
	private String type;
	private String uri;
	private Tracks tracks;
	private Followers followers;
	private boolean Public;
	private String name;
	private String href;
	private String id;
	private ExternalUrls externalUrls;

}
