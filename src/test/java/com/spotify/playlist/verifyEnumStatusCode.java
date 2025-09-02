package com.spotify.playlist;

import org.testng.annotations.Test;

import com.spotify.statusCode.StatusCode;

public class verifyEnumStatusCode {
	@Test
	public static void main() {
		System.out.println(StatusCode.CREATED.code);
		System.out.println(StatusCode.BAD_REQUEST.code);
		System.out.println(StatusCode.FORBIDDEN.code);
		System.out.println(StatusCode.INTERNAL_SERVER_ERROR.code);
	}

}
