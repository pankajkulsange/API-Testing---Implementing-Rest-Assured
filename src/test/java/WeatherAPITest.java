import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class WeatherAPITest {
	@Test
	public void getRequest() {
		Response res = get("https://api.openweathermap.org/data/2.5/weather?lat=18.520430&lon=73.856743&appid=f726e265a1cb9faade2059b74aa5259b");
		System.out.println("Response Code: " + res.getStatusCode());
		System.out.println("Response Time: " + res.getTime());
		System.out.println("Response Body: " + res.getBody().asString());
		System.out.println("Status Line: " + res.getStatusLine());
		
		int actualRes = res.statusCode();
		Assert.assertEquals(actualRes, 200);
	}
	
	@Test
	public void Test2() {
		baseURI="https://api.openweathermap.org/data/2.5";
		given().get("/weather?lat=18.520430&lon=73.856743&appid=f726e265a1cb9faade2059b74aa5259b").
		then().
		statusCode(200).
		body("name", equalTo("Pune")).
		log().all();
	}
}
