import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class PostRequestTest {
	@Test
	public void postRequestTest() {
		JSONObject request = new JSONObject();
		request.put("name", "Dr. Strange");
		request.put("job", "Doctor");
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in/api";
		given().
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
	}
}
