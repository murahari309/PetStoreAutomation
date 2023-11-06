package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndpoints {
	
	
	
	public static Response createuser(Store Payload) {
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Payload)
		
		.when()
		.post(Routes.store_Post_Url);
		
		return response;
	
	}
	
	public static Response getuser(int orderId) {
		
		Response response = given()
		.pathParam("orderId",orderId)
		
		.when()
		.get(Routes.store_Get_Url);
		
		return response;
		
	}
	public static Response deleteuser(int orderId) {
		
		Response response = given()
		.pathParam("orderId",orderId)
		
		.when()
		.delete(Routes.store_Delete_Url);
		return response;
		
	}

}
