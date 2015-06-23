package com.mscharhag.sparkdemo;

import com.google.gson.Gson;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UserControllerIntegrationTest {

	@BeforeClass
	public static void beforeClass() {
		Main.main(null);
	}

	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}

	@Test
	public void aNewUserShouldBeCreated() {
		TestResponse res = request("POST", "/users?name=john&email=john@foobar.com");
		Map<String, String> json = res.json();
		assertEquals(200, res.status);
		assertEquals("john", json.get("name"));
		assertEquals("john@foobar.com", json.get("email"));
		assertNotNull(json.get("id"));
	}

	private TestResponse request(String method, String path) {
		HttpURLConnection connection;
		try {
			URL url = new URL("http://localhost:4567" + path);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			//connection.connect();
			if(connection.getResponseCode()>=200 && connection.getResponseCode()<300) {
				String body = IOUtils.toString(connection.getInputStream());
				return new TestResponse(connection.getResponseCode(), body);
			} else {
				String body = IOUtils.toString(connection.getErrorStream());
				return new TestResponse(connection.getResponseCode(), body);
			}
		} catch (IOException e) {		
			e.printStackTrace();
			org.junit.Assert.fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}


	private static class TestResponse {

		public final String body;
		public final int status;

		public TestResponse(int status, String body) {
			this.status = status;
			this.body = body;
		}

		public Map<String,String> json() {
			return new Gson().fromJson(body, HashMap.class);
		}
	}
}
