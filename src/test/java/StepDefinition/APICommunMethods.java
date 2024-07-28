package StepDefinition;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APICommunMethods {
	
	  public Response getApiResponse(String endpoint) {
		    return RestAssured.get(endpoint);
		  }

		  public Response postApiResponse(String endpoint, Object body) {
		    return RestAssured.given().body(body).post(endpoint);
		  }
		  
}
