package com.spotify.specBuilder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.spotify.Endpoints.SpotifyEndpoints;
import com.spotify.TokenManager.TokenManager;
import com.spotify.Utils.ConfigLoader;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	static String userId = "31ubp7xxtffe6txdm6msu4melkiq";
	static String accessToken = "BQApXo_rzJEcjRlYYlRHcI4p6RG5GnbBvIWbQR0SdIoDb4uUG2r524npV0zQcvlpbNxjGayikT6b3B1bEVr_21wX-yfG-CP_Z99KbHEdf9uoDd3f0vuX3uqpulrUHcb-1gd0eeSusNc2S7WYFRK1sdVTxu8xTtFeGnyiRuWc7SeT5VfAEs_Zg5QBQPXcc0oO6c9yLBDohyPDNzuYKa9kIYzuJjPwFrGeuq9A-Qhp72uR5soa5gt187p6P5lWGUZ8nEoZ8o6HfJR8bg33qf6s6CwzuqDQq3yORrPf1Ud-rZLfWA1ldkSy4g0r";
//	static String basePath = "/v1/users/" + userId + "/playlists";

	public static RequestSpecification getRequestSpec() {

		return new RequestSpecBuilder()
				.setBaseUri(ConfigLoader.getInstance().getBaseURI())
				.setBasePath(SpotifyEndpoints.basePath+SpotifyEndpoints.USERS+'/'+ConfigLoader.getInstance().getUserId()+SpotifyEndpoints.playlist)
				.addHeader("Authorization", "Bearer " + TokenManager.getToken()).setContentType(ContentType.JSON).log(LogDetail.ALL)
				.addFilter(new AllureRestAssured())
				.build();

	}

	public static RequestSpecification getRequestSpecBuilder(String playlistId) {
		return new RequestSpecBuilder().setBaseUri(ConfigLoader.getInstance().getBaseURI())
				.addHeader("Authorization", "Bearer " + TokenManager.getToken()).setContentType(ContentType.JSON)
				.setBasePath(SpotifyEndpoints.basePath+SpotifyEndpoints.playlist +'/'+playlistId)
				.addFilter(new AllureRestAssured())
				.log(LogDetail.ALL).build();
	}

	public static ResponseSpecification getResponseSpec() {
		return new ResponseSpecBuilder().log(LogDetail.ALL).build();
	}

	public static RequestSpecification getUpdateRequestSpec(String playlistId) {
		return new RequestSpecBuilder().setBaseUri(ConfigLoader.getInstance().getBaseURI())
				.addHeader("Authorization", "Bearer " + TokenManager.getToken()).setBasePath(SpotifyEndpoints.basePath+SpotifyEndpoints.playlist + '/'+playlistId)
                 .addFilter(new AllureRestAssured())
				.setContentType(ContentType.JSON).log(LogDetail.ALL).build();
	}

	public static RequestSpecification generateAccessToken() {
		String refreshToken = "AQDclehgcTSLU21pHCazSZO1XtM7UnGKuXrmKWH6RYbBPyA17NBwkIHSzB3V9E2mXcsZwWKPEqGn79s9xoLLh0aZVWBBIvBmgPFH9KKJanbvFvJDsInUCEq2FPQKZuxihEk";
		Map<String, String> formParam = new HashMap<String, String>();

		formParam.put("client_id", ConfigLoader.getInstance().getClientId());

		formParam.put("client_secret", ConfigLoader.getInstance().getClient_secret());

		formParam.put("refresh_token", ConfigLoader.getInstance().getRefresh_token());
		formParam.put("grant_type", ConfigLoader.getInstance().getGrant_type());

		return new RequestSpecBuilder().setBaseUri(ConfigLoader.getInstance().getRefreshTokenURI())
				.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8").addFormParams(formParam)
				.setBasePath(SpotifyEndpoints.api+SpotifyEndpoints.token)
				.addFilter(new AllureRestAssured()).log(LogDetail.ALL).build();
	}

}
