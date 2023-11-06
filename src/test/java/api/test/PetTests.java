package api.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.endpoints.PetEndpoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tags;
import io.restassured.response.Response;

public class PetTests {
	
	Pet Payload;
	Category cate;
	Tags t;
	 String jPayload;
	 ObjectMapper map;

	@BeforeClass
	public void setdata() throws JsonProcessingException  {
		
		Payload = new Pet();
		Payload.setId(1);
		cate= new Category();
		cate.setId(20);
		cate.setName("pitbull");
		Payload.setCategory(cate);
		Payload.setName("doggie");
		ArrayList<String> photo = new ArrayList<>();
		photo.add("https:dummy.com");
		Payload.setPhotoUrls(photo);
		ArrayList<Tags> list = new ArrayList<>();
		Tags t = new Tags();
		t.setId(8);
		t.setName("chintu");
		list.add(t);
		Payload.setTags(list);
		Payload.setStatus("available");
		
		
		
		
		
		
	
		 map = new ObjectMapper();
	  jPayload = map.writerWithDefaultPrettyPrinter().writeValueAsString(Payload);
		 
	

	}
	
	@Test(priority=0)
	public void POST() throws JsonMappingException, JsonProcessingException {
		
		Response response = PetEndpoints.createuser(jPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);

		
	}
	@Test(priority=1)
	public void GET() {
		Response response = PetEndpoints.getuser(this.Payload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
			
	}
	@Test(priority=2)
	public void UPDATE() throws JsonProcessingException {
		
		
		Payload.setStatus("sold");
		
		 jPayload = map.writerWithDefaultPrettyPrinter().writeValueAsString(Payload);
		
		Response response = PetEndpoints.updateuser( jPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	@Test(priority=3)
	public void DELETE() {
		
		Response response = PetEndpoints.deleteuser(this.Payload.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}

}
