package com.mscharhag.sparkdemo;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonUtil {

	public static String toJson(Object object) {
		return new Gson().toJson(object);
	}

	public static ResponseTransformer json() {
		return JsonUtil::toJson;
	}
}
