package RestApiAutomation.RestAp;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIGETTest
{		
		@Test
	public void getweatherDetails()
	{		
		//Specify BaseURI
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
				
		//Request Object created
		RequestSpecification httpreq=RestAssured.given();	
		
		//Response Object created
        Response res= httpreq.request(Method.GET,"Pune"); 
		
        //Print response on console
        
        String responseBody=res.getBody().asString();
		System.out.println("Response body is "+responseBody);
	
		//Status code Verification
		int statuscode=res.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		System.out.println(statuscode);
	
		String statusLine=res.getStatusLine();
		System.out.println(statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}	
}
