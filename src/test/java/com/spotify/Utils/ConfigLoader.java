package com.spotify.Utils;

import java.io.File;
import java.util.Properties;

public class ConfigLoader {
	private final Properties properties;
	private static ConfigLoader configLoader;

	private ConfigLoader() {
		properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getClientId() {
		String prop = properties.getProperty("client_id");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("properties client_id not available in config.properties file");
		}
	}
	public String getGrant_type() {
		String prop = properties.getProperty("grant_type");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("properties grant_type not available in config.properties file");
		}
	}
	public String getRefresh_token() {
		String prop = properties.getProperty("refresh_token");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("properties refresh_token not available in config.properties file");
		}
	}
	public String getClient_secret() {
		String prop = properties.getProperty("client_secret");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("properties client_secret not available in config.properties file");
		}
	}
	public String getUserId() {
		String prop = properties.getProperty("userId");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("properties userId not available in config.properties file");
		}
	}
	public String getCode() {
		String prop = properties.getProperty("code");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("properties code not available in config.properties file");
		}
	}
	public String getBaseURI() {
		String prop = properties.getProperty("baseURI");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("properties baseURI not available in config.properties file");
		}
	}
	public String getRefreshTokenURI() {
		String prop = properties.getProperty("refreshTokenURI");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("properties refreshTokenURI not available in config.properties file");
		}
	}
}
