package com.spotify.playlist;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotify.TokenManager.TokenManager;
import com.spotify.common.apiUtils.ApiUtils;
import com.spotify.playlist.pojo.GetPlaylist_Pojo;
import com.spotify.specBuilder.SpecBuilder;

import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;
import java.util.Map;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
@Epic("PlayList epic")
public class CreatePlaylist extends BaseTest {
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	String accessToken;
	String playlistId;
	@Test(description="Able to Create playlist")
	@Story("12345:CreatePlaylist")
	@Link("https://www.google.com")
	@TmsLink("12345")
	@Description("This is Description")
//	@Test(description="Able to Create playlist")
	public void createPlaylist() {
		GetPlaylist_Pojo requestPlaylist=new GetPlaylist_Pojo();
		requestPlaylist.setName("BibhuPlayList");
		requestPlaylist.setDescription("Bibhu AutomationPLaylist");
		requestPlaylist.setPublic(false);
		
		
		
		String userId="31ubp7xxtffe6txdm6msu4melkiq";
		String requestPayload="{\r\n"
				+ "    \"name\": \"New Playlist1\",\r\n"
				+ "    \"description\": \"New playlist description1\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}";
		
		Response response=ApiUtils.post(requestPlaylist);
		int statucCode=response.getStatusCode();
		Assert.assertEquals(statucCode, 201);
				
		
		
		
		JsonPath path=new JsonPath(response.getBody().asString());
		playlistId=path.getString("id");
		Assert.assertEquals(path.getString("name"), requestPlaylist.getName());
		Assert.assertEquals(path.getString("description"), requestPlaylist.getDescription());
		Assert.assertEquals(path.getBoolean("public"), requestPlaylist.isPublic());
		
	}
	@Story("12345:getPlaylist")
	@TmsLink("12345")
	@Description("This is get playlist Description")
	@Test(dependsOnMethods = "createPlaylist",description="Extract list of playlist")
	public void getPlaylist() {
		
		Response response=ApiUtils.get(playlistId);
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
				
		
	}
	@Story("12345:UpdatePlaylist")
	@Issue("12345")
	@Description("This is update playlist Description")
	@Test(dependsOnMethods = "getPlaylist",description="update the playlist and return the response")
	public void updatePlaylist() {
		String updatePayload="{\r\n"
				+ "    \"name\": \"BibhuPlaylist Name\",\r\n"
				+ "    \"description\": \"Updated playlist description\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}";
		
		Response response=ApiUtils.update(updatePayload,playlistId);
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
				
				
	}
	

}
