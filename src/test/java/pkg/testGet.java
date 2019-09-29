package pkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testGet {
	
	
	@Test
	public void testGetRequest() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		String first_email = response.jsonPath().getString("data.email[0]");
		String statusCode = Integer.toString(response.getStatusCode());
		
		try {
			Assert.assertTrue(first_email.equals("michael.lawson@reqres.in"));
			Assert.assertTrue(statusCode.equals("200"));
	
		}catch (Exception e) {

			Assert.assertTrue(false);
			
		}finally {
			System.out.println("Received data from API is: "+first_email
					+" Status Code: "+statusCode+" Time: "+response.getTime()+"ms");
		}
	}

}
