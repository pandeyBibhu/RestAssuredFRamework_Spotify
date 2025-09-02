package com.spotify.playlist;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

public class BaseTest {
	@BeforeMethod
	public void beforeMethod(Method m) {
    System.out.println("Starting Test"+m.getName());
    System.out.println("Thread is:"+Thread.currentThread().threadId());
	}
}
