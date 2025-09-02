package com.spotify.TokenManager;

import static io.restassured.RestAssured.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.testng.annotations.Test;

import com.spotify.common.apiUtils.ApiUtils;
import com.spotify.specBuilder.SpecBuilder;

import groovy.transform.Synchronized;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenManager {
	private static String accessToken;
	private static Instant expiryTime;

	public synchronized static  String getToken() {
		try {
			if (accessToken == null || Instant.now().isAfter(expiryTime)) {
				System.out.println("==========================Renewing token=====================================");

				Response response = extractAccessToken();

				accessToken = response.path("access_token");
				int expiryDurationInSeconds = response.path("expires_in");
				expiryTime = Instant.now().plusSeconds(expiryDurationInSeconds);
				
				System.out.println("CurrentTime::"+Instant.now()+ "Token will expire at:"+expiryTime);
			} else {
				System.out.println("*********************Token is good to use!!********************************");
			}

		} catch (Exception e) {
			throw new RuntimeException("############### Abort! Failed to extract token#########################");
		}

		return accessToken;
	}

	private static Response extractAccessToken() {

		Response response = ApiUtils.getAccessToken();
		if (response.statusCode() != 200) {
			throw new RuntimeException("Abort!! Renew Token Failed");
		}

		return response;
	}
}
