import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredAPITest {

	@Test
	public void getRequest() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code: " + res.getStatusCode());
		System.out.println("Response Time: " + res.getTime());
		System.out.println("Response Body: " + res.getBody().asString());
		System.out.println("Status Line: " + res.getStatusLine());
	}
}
