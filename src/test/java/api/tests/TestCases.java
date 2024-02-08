package api.tests;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases {

    Faker faker;
    User payloads;
   Logger logger;

    @BeforeClass
    public void setData()
    {
        faker= new Faker();
        payloads=new User();

        payloads.setId(faker.idNumber().hashCode());
        payloads.setUsername(faker.name().username());
        payloads.setFirstName(faker.name().firstName());
        payloads.setLastName(faker.name().lastName());
        payloads.setEmail(faker.internet().emailAddress());
        payloads.setPassword(faker.internet().password(5,10));
        payloads.setPhone(faker.phoneNumber().phoneNumber());
       logger = (Logger) LogManager.getLogger(this.getClass());
    }
    @Test(priority = 1)
    public void createUserTest()
    {
  logger.info(" ****before user created***");
        Response response = UserEndPoints2.createUser(payloads);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info(" ******User created****");
    }

    @Test(priority = 2)
    public void readUserTest()
    {
        Response response= UserEndPoints.readUser(payloads.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 3)
    public void updateUserTest()
    {
        payloads.setFirstName(faker.name().firstName());
        payloads.setLastName(faker.name().lastName());
        payloads.setEmail(faker.internet().emailAddress());
        Response response= UserEndPoints.updateUser(payloads.getUsername(),payloads);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 4)
    public void deleteUserTest()
    {
        Response response = UserEndPoints.deleteUser(payloads.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        Response response1=UserEndPoints.readUser((payloads.getUsername()));
        response1.then().log().all();
        Assert.assertEquals(response1.getStatusCode(),404);
    }
}
