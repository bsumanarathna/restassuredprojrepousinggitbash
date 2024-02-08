package api.tests;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDtestCases{

    @Test(priority = 1,dataProvider = "Dataset",dataProviderClass = api.utilities.DataProviders.class)
    public void createUserTest(String userID,String Username, String fname,String lname,String email,String pwd,String ph)

    {
        User user = new User();

        //String ID="3020857508";
        //Integer IDint = Integer.parseInt(ID.trim());
        //user.setId(parseInt(ID));
        //user.setId(IDint);

        user.setId(Integer.parseInt(userID));
        user.setUsername(Username);
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setEmail(email);
        user.setPassword(pwd);
        user.setPhone(ph);

        Response response = UserEndPoints.createUser(user);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
