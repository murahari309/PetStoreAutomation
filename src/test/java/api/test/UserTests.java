package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User Payload;
	
	public Logger logger ;  // for logs
	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		Payload = new User();
		Payload.setId(faker.idNumber().hashCode());
		Payload.setUsername(faker.name().username());
		Payload.setFirstName(faker.name().firstName());
		Payload.setLastName(faker.name().lastName());
		Payload.setEmail(faker.internet().emailAddress());
		Payload.setPassword(faker.internet().password());
		Payload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=0)
	public void testPostUser() {
		
		logger.info("********** Creating User ************");
		
		Response response=UserEndpoints.createuser(Payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("********** User is Created **********");
		
	}
	@Test(priority=1)
	public void testGetUserByName() {
		
		logger.info("******* Reading User Info ***********");
		Response response = UserEndpoints.readUser(this.Payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("******** User Info Displayed ******** ");
		
	}
	@Test(priority=2)
	public void testUpdateByName() {
		
		logger.info("***** updating user ************"); 
		
		
		//update the user data 
		Payload.setFirstName(faker.name().firstName());
		Payload.setLastName(faker.name().lastName());
		Payload.setEmail(faker.internet().emailAddress());
		
		Response response = UserEndpoints.UpdateUser(this.Payload.getUsername(), Payload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******** UserData Updated ********");
		
		//checking the data after update 
		Response responseAfterUpdate = UserEndpoints.readUser(this.Payload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
			
	}
	@Test(priority=3)
	public void testDeleteUser() {
		
		logger.info("******** User Deleted ***********");
		
		Response response = UserEndpoints.DeleteUser(this.Payload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
	}

}
