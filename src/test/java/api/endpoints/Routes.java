package api.endpoints;
/*
Swaggeer URI --> https://petstore.swagger.io

POST:https://petstore.swagger.io/v2/user
GET:https://petstore.swagger.io/v2/user/{username}
PUT:https://petstore.swagger.io/v2/user/{username}
DELETE:https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {

    public static String base_url="https://petstore.swagger.io/v2";

    // User module
    public  static String post_url=base_url+"/user";
    public  static String get_url=base_url+"/user/{username}";
    public  static String update_url=base_url+"/user/{username}";
    public  static String delete_url=base_url+"/user/{username}";


    // Store module
         // here will define Store module URL's

    // Pet Module
         // here will define Pet module URL's

}
