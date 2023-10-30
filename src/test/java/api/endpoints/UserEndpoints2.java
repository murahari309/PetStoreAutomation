package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// created for perform Create,Read,Update ,Delete requests the user API

public class UserEndpoints2 {
	
	
	// Method created for getting url's from property file 
	
	static ResourceBundle getURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
		
	}
	
	
	public static Response createuser(User payload) {
		
		 
		 String post_url =getURL().getString("post_url");
		
		Response res = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
		return res;
			
	}
	
	public static Response readUser(String username) {
		 
		String get_url = getURL().getString("get_url");
		
		
		Response res = given()
		.pathParam("username", username)
		
		.when()
		.get(get_url);
		
		return res;
	}
	
	public static Response  UpdateUser(String username, User payload) {
		String update_url = getURL().getString("update_url");
		
		Response res = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username",username)
		.body(payload)
		
		
		.when()
		.put(update_url);
		return res;
		
	}
	
	public static Response DeleteUser(String username) {
		
		String delete_url = getURL().getString("delete_url");
		
		Response res = given()
		.pathParam("username", username)
		
		.when()
		.delete(delete_url);
		return res;
		
	}

}
