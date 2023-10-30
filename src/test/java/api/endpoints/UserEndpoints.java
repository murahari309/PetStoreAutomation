package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// created for perform Create,Read,Update ,Delete requests the user API

public class UserEndpoints {
	
	
	public static Response createuser(User payload) {
		
		
		Response res = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.Post_url);
		return res;
			
	}
	
	public static Response readUser(String username) {
		
		
		Response res = given()
		.pathParam("username", username)
		
		.when()
		.get(Routes.Get_url);
		
		return res;
	}
	
	public static Response  UpdateUser(String username, User payload) {
		
		Response res = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username",username)
		.body(payload)
		
		
		.when()
		.put(Routes.Update_url);
		return res;
		
	}
	
	public static Response DeleteUser(String username) {
		
		Response res = given()
		.pathParam("username", username)
		
		.when()
		.delete(Routes.Delete_url);
		return res;
		
	}

}
