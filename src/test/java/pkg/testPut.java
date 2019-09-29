package pkg;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testPut {
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPutRequest() {
		
		
		RequestSpecification request =RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("name", "morpheus");
		json.put("job", "zion resident");
		
		request.body(json.toJSONString());
		
		Response response = request.put("https://reqres.in/api/users/2");
		System.out.println(response.getStatusCode());
		
		String name =response.jsonPath().getString("name");
		String job =response.jsonPath().getString("job");
		String statusCode = Integer.toString(response.getStatusCode());
		
		try {
			Assert.assertTrue(statusCode.equals("200"));
			Assert.assertTrue(name.equals("morpheus"));
			Assert.assertTrue(job.equals("zion resident"));
	
		}catch (Exception e) {

			Assert.assertTrue(false);
			
		}finally {
			System.out.println("Received data from API is--->"
					+". Status Code: "+response.getStatusCode()
					+". Name: "+name+" Job: "+job
					+". Time: "+response.getTime()+"ms");
		}
		
	}

}
