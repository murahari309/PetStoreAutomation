package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	
	@Test(priority=0,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostuser(String userID,String UserName,String fname,String lname,String useremail,String pwd,String ph) {
		
		User Payload = new User();
		
		Payload.setId(Integer.parseInt(userID));
		//Payload.setId(userID);
		Payload.setUsername(UserName);
		Payload.setFirstName(fname);
		Payload.setLastName(lname);
		Payload.setEmail(useremail);
		Payload.setPassword(pwd);
		Payload.setPhone(ph);
		
		Response response = UserEndpoints.createuser(Payload);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=1,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testUserByname(String UserName) {
		
		Response response = UserEndpoints.DeleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(),200);
		
	}

}
