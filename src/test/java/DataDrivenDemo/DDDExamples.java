package DataDrivenDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DDDExamples {
	
	@Test
	public void Test1_post() {
		
		 JSONObject req = new JSONObject();
		
		 req.put("", "");
		
		 given().
		 header("Content-Type", "application/json").
		 body(req.toJSONString()).
		 when().
		 post("http://localhost:3000/users").
		 then().
		 statusCode(200);		
	}
}
