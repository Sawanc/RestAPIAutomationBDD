package RestApiAutomation.RestAp;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostApiTest 
{
	@Test
	public void PostRequest()
	{		
		 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("FirstName", "Virert"); // Cast
		 requestParams.put("LastName", "Sehw");
		 requestParams.put("UserName", "vi7897");
		 requestParams.put("Password", "passwo123");		 
		 requestParams.put("Email","vi78@gmail.com");
		 
		 request.header("Content-Type","application/json");
		 
		 request.body(requestParams.toJSONString());//Attach Data/payload to request
		 
		 Response response = request.post("/register");/*/register is path parameter*/
		 
		 int statusCode = response.getStatusCode();		 
		 Assert.assertEquals(statusCode, 201);		 
			 		 
		 String successCode = response.jsonPath().get("SuccessCode");
		 Assert.assertEquals(successCode, "OPERATION_SUCCESS");	
		 
		 String contentType=response.contentType();	
		 System.out.println(contentType);
		 
		 String Serverheader=response.header("Server");
		 System.out.println(Serverheader);
			 
		 String ExpiresServer= response.header("Expires");
         System.out.println(ExpiresServer);
         
         long timeLimits=response.timeIn(TimeUnit.MILLISECONDS);
	     System.out.println(timeLimits);
	      	
	}
	
}
