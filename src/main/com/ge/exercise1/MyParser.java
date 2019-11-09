package com.ge.exercise1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyParser implements Parser {

	@Override
	public Application parseApplicationData(String data) {
		data = data
				.replaceAll("(Application\\(|User\\(|Group\\()", "{\"")
				.replaceAll("\\(", "{\"")
				.replaceAll("\\)", "\"}")
				.replaceAll("[:][\\s]*", "\":\"")
				.replaceAll("[,][\\s]*", "\",\"")
				.replaceAll("\"\\[", "[")
				.replaceAll("\"\\]", "]")
				.replaceAll("\\]\"", "]");
		System.out.println(data);
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(data, MyApplication.class);
	}

}
