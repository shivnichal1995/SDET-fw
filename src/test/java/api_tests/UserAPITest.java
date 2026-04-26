package api_tests;

import api.UserAPI;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UserAPITest extends BaseTest {

    UserAPI userAPI = new UserAPI();

    @Test
    public void getUserTest() {
        Response response = userAPI.getUser(1);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
    }

    @Test
    public void createUserTest() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "John Doe");
        user.put("email", "john@example.com");
        user.put("role", "admin");

        Response response = userAPI.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), "John Doe");
    }

    @Test
    public void updateUserTest() {
        Map<String, Object> update = new HashMap<>();
        update.put("name", "John Updated");

        Response response = userAPI.updateUser(1, update);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "John Updated");
    }

    @Test
    public void deleteUserTest() {
        Response response = userAPI.deleteUser(1);
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}