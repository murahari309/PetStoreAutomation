package api.endpoints;

/*
 Swagger URI --> https://petstore.swagger.io
 Create User(Post) :https://petstore.swagger.io/v2/user
 Get User (Get) : https://petstore.swagger.io/v2/user/{username}
 Update User(Put) : https://petstore.swagger.io/v2/user/{username}
 Delete User(Delete) :https://petstore.swagger.io/v2/user/{username}
 
 */

public class Routes {
	
	public static String Base_url ="https://petstore.swagger.io/v2";
	
	//user module 
	
	public static String Post_url =Base_url+"/user";
	public static String Get_url =Base_url+"/user/{username}";
	public static String Update_url =Base_url+"/user/{username}";
	public static String Delete_url=Base_url+"/user/{username}";
	
	// Store Module 
	    // here i will create Store module URL'S

}
