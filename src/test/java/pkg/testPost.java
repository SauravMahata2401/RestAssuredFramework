package pkg;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testPost {
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPostRequest() {
		
		
		RequestSpecification request =RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("name", "morpheus");
		json.put("job", "leader");
		
		request.body(json.toJSONString());
		
		Response response = request.post("https://reqres.in/api/users");
		System.out.println(response.getStatusCode());
		
		String name =response.jsonPath().getString("name");
		String job =response.jsonPath().getString("job");
		String id =response.jsonPath().getString("id");
		String statusCode = Integer.toString(response.getStatusCode());
		
		try {
			Assert.assertTrue(statusCode.equals("201"));
			Assert.assertTrue(name.equals("morpheus"));
			Assert.assertTrue(job.equals("leader"));
	
		}catch (Exception e) {

			Assert.assertTrue(false);
			
		}finally {
			System.out.println("Received data from API is--->"+" Id: "+id
					+". Status Code: "+response.getStatusCode()
					+". Name: "+name+" Job: "+job
					+". Time: "+response.getTime()+"ms");
		}
		
	}

}
