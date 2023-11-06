package api.endpoints;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndpoints {
	
	
	
	
	
	public static Response createuser(String jPayload) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		Pet pet = mapper.readValue(jPayload, Pet.class);
		
		
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(pet)
		
		.when()
		.post(Routes.pet_Post_Url);
		return response;
			
	}
	
	public static Response getuser(int petId) {
		
		Response response = given()
		.pathParam("petId",petId)
		
		.when()
		.get(Routes.pet_Get_Url);
		return response;
		
	}
	
	public static Response updateuser(String jPayload) {
		
		
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jPayload)
		
		.when()
		.put(Routes.pet_Update_url);
		return response;
		
	}
	
	public static Response deleteuser(int petId) {
		
		Response response = given()
		.pathParam("petId",petId)
		
		.when()
		.delete(Routes.pet_Delete_Url);
		return response;
	}

}
