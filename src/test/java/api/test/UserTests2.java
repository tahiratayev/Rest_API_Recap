package api.test;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;


public class UserTests2 {
    Faker faker;
    User userPayload;
    public Logger logger;

    @BeforeClass
    public void setupData(){
        faker=new Faker();
        userPayload=new User();


        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        // logs
        logger= LogManager.getLogger(this.getClass());

    }

    @Test(priority = 1)
    public void testPostUser(){
        logger.info("*********** Creating user********************");
        Response response= UserEndPoints2.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("***********  User is Created ********************");
    }


    @Test(priority = 2)
    public void testGetUserByName(){

        logger.info("*********** Reading user info ********************");
        Response response= UserEndPoints2.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("***********  user info is displayed   ********************");
    }


    @Test(priority = 3)
    public void testUpdateUserByName(){

        logger.info("*********** Updating user info ********************");
        System.out.println(this.userPayload.getUsername());// update data using payload
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response= UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().body();
        System.out.println(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("***********  User info is updated ********************");

        // checking data after update
        Response responseAfterUpdate= UserEndPoints2.readUser(this.userPayload.getUsername());
        responseAfterUpdate.then().log().all();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);


    }




    @Test(priority =4)
    public void testDeleteUserByName(){

        logger.info("*********** Deleting user  ********************");
        Response response= UserEndPoints.deleteUser(this.userPayload.getUsername());
        //  response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("*********** User is deleted ********************");
    }

}