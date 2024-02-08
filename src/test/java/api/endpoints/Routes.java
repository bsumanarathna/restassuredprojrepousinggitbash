package api.endpoints;

// Swagger: https://petstore.swagger.io/v2
//Create URL: https://petstore.swagger.io/v2/user
//Read URL:https://petstore.swagger.io/v2/user/{username}
// Update URL:https://petstore.swagger.io/v2/user/{username}
// Delete URL:https://petstore.swagger.io/v2/user/{username}

public class Routes {
    public static String base_URL= "https://petstore.swagger.io/v2";

    //This is User module Urls
public static String post_URL=base_URL+"/user";
public static String get_URL=base_URL+"/user/{username}";
public static String put_URL=base_URL+"/user/{username}";
public static String delete_URL=base_URL+"/user/{username}";

}
