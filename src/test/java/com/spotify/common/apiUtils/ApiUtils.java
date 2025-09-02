package com.spotify.common.apiUtils;

import com.spotify.specBuilder.SpecBuilder;
import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;
import java.util.Map;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ApiUtils {
@Step
	public static Response post(Object requestPayload) {

		return given().spec(SpecBuilder.getRequestSpec()).body(requestPayload).post().then()
				.spec(SpecBuilder.getResponseSpec()).extract().response();
	}
	
	public static Response post(String requestPayload) {

		return given().spec(SpecBuilder.getRequestSpec()).body(requestPayload).post().then()
				.spec(SpecBuilder.getResponseSpec()).extract().response();
	}
	@Step
	public static Response get(String playlistId) {
		return given().spec(SpecBuilder.getRequestSpecBuilder(playlistId)).get().then()
				                 .spec(SpecBuilder.getResponseSpec()).extract().response();
	}
	@Step
	public static Response update(String requestPayload,String playlistId) {
		return given().spec(SpecBuilder.getUpdateRequestSpec(playlistId)).body(requestPayload).put().
				then().spec(SpecBuilder.getResponseSpec()).extract().response();
	}
	public static Response getAccessToken() {
		return given().spec(SpecBuilder.generateAccessToken()).post().then().spec(SpecBuilder.getResponseSpec()).extract().response();
	}
	
	
}
