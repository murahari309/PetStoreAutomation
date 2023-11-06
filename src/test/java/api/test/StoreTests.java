package api.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndpoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	Faker faker;
	Store Payload;
	String minDateStr = "2023-01-30T00:00:00.000Z";
	String maxDateStr = "2023-10-30T00:00:00.000Z";
	public Logger log;
	
	@BeforeClass
	public void setData() throws ParseException {
		
		 faker = new Faker();
		 Payload = new Store();
		 Payload.setId(faker.number().numberBetween(2, 9));
		 Payload.setPetId(faker.number().numberBetween(1,100));
		 Payload.setQuantity(faker.number().numberBetween(2, 8));
		 SimpleDateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		 Date mindate = dateformat.parse(minDateStr);
		 Date maxdate = dateformat.parse(maxDateStr);
		 Date randomdate = faker.date().between(mindate, maxdate);
		 String dateandtime = dateformat.format(randomdate);
		 Payload.setShipDate(dateandtime);
		 Payload.setStatus("placed");
		 Payload.setComplete(true);
				
	}
	@Test(priority=0)
	public void POST_USER() {
		
		log=LogManager.getLogger(this.getClass());
		
		log.info("******* creating the new pet *******");
		Response response = StoreEndpoints.createuser(Payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		log.info("******* new pet is created *********");
	}
	
	@Test(priority=1)
	public void test_Get_user() {
		
		log.info("******** reading the created pet ******");
		
		Response response = StoreEndpoints.getuser(this.Payload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		log.info("********* displaying the created pet *******");
		
	}
	
	@Test(priority=2)
	public void test_Delete_user() {
		
		log.info("***** deleting the pet ********");
		
		Response response = StoreEndpoints.deleteuser(this.Payload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		log.info("******* deleted the pet ******");
		
	}

}
