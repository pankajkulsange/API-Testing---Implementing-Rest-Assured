import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredAPITest {

	@Test
	public void getRequest() {
		Response res = get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code: " + res.getStatusCode());
		System.out.println("Response Time: " + res.getTime());
		System.out.println("Response Body: " + res.getBody().asString());
		System.out.println("Status Line: " + res.getStatusLine());
		
		int actualRes = res.statusCode();
		Assert.assertEquals(actualRes, 200);
	}
	
	@Test
	public void Test2() {
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).
		body("data[2].id", equalTo(9)).
		log().all();
	}
}
