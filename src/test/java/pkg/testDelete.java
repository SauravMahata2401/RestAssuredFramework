package pkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testDelete {
	
	
	@Test
	public void testDeleteRequest() {
		
		
		RequestSpecification request =RestAssured.given();
		
		Response response = request.delete("https://reqres.in/api/users/2");
		System.out.println(response.getStatusCode());
		
		String statusCode = Integer.toString(response.getStatusCode());
		
		try {
			Assert.assertTrue(statusCode.equals("204"));
	
		}catch (Exception e) {

			Assert.assertTrue(false);
			
		}finally {
			System.out.println("Received data from API is--->"
					+". Status Code: "+response.getStatusCode());
		}
		
	}

}
