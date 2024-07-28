package StepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

public class ApiStepDefinitions {

    private String endpoint;
    private String requestbody;
    private String expresponsebody;
    private String actresponsebody;


    private Response response;

    @Given("^I have the endpoint from the Excel file with coordinate \"([^\"]*)\",\"([^\"]*)\", and \"([^\"]*)\"$")
	public void iHaveTheEndpointFromTheExcelFileWithCoordinateSheetRowAndCell(int sheet, int row, int cell) throws IOException
	 {
    	
        
        endpoint = ExcelUtils.getData(sheet, row,cell);
        System.out.println(endpoint);
    }
    @When("I send a GET request to the endpoint")
    public void i_send_a_GET_request_to_the_endpoint() {
        APICommunMethods api = new APICommunMethods();
        response = api.getApiResponse(endpoint);
    }

    @Then("I should receive a status code {int}")
    public void i_should_receive_a_status_code(int statusCode) {
    	System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }
    @When("I send a POST request to the endpoint")
    public void i_send_a_Post_request_to_the_endpoint() {
        APICommunMethods api = new APICommunMethods();
        response = api.postApiResponse(endpoint, requestbody);
		System.out.println(response.getBody().asPrettyString());

    }


	@And("^I have the body from the Excel file with coordinate \"([^\"]*)\",\"([^\"]*)\", and \"([^\"]*)\"$")
	public void iHaveTheBodyFromTheExcelFileWithCoordinateBsheetBrowAndBcell(int sheet, int row, int cell) throws Throwable {
		requestbody = ExcelUtils.getData(sheet, row, cell);
		System.out.println(requestbody);
	}
	@And("^verify response body with data from excel file with \"([^\"]*)\",\"([^\"]*)\", and \"([^\"]*)\"$")
	public void verifyResponseBodyWithDataFromExcelFileWithAnd(int sheet, int row, int cell) throws Throwable {
		expresponsebody = ExcelUtils.getData(sheet, row, cell);
		System.out.println(expresponsebody);
		System.out.println(response.asPrettyString());

		Assert.assertTrue(expresponsebody.equalsIgnoreCase(response.asPrettyString()), "Response is not correct");
	}
	
	
	

	

	 
	
}
