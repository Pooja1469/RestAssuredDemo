package com.RestAssuredDemo.RestAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class Test02_Post {
	
	@Test
	void test_03_Post() {
		
		//option 1 
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("name","morpheus");
		map.put("job", "leader");
		
		System.out.println(map);
		
		JSONObject obs = new JSONObject(map);  //  imported from simple.JSONObject lib
		System.out.println(obs);
		System.out.println(obs.toJSONString());
		
		// option 2
		
		JSONObject req = new JSONObject();
		
		req.put("name","Pooja");
		req.put("job", "QA");
		
		System.out.println(req);
		
		given()
		.header("Content-Type", "application/json")
		.body(req.toJSONString())
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201);
					
	}
	
	@Test
	void test_04_Put() {
			
		JSONObject req = new JSONObject();
		
		req.put("name","Neha");
		req.put("job", "Designer");
		
		System.out.println(req);
		
		given()
		.header("Content-Type", "application/json")
		.body(req.toJSONString())
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
					
	}
	
	@Test
	void test_05_Patch() {
			
		JSONObject req = new JSONObject();
		
		req.put("name","Neha");
		req.put("job", "Designer");
		
		System.out.println(req);
		
		given()
		.header("Content-Type", "application/json")
		.body(req.toJSONString())
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
					
	}

	@Test
	void test_06_Delete() {
	
		 when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204);
						
	}

}
