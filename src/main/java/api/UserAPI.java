package api;

import java.util.Map;

public class UserAPI extends BaseAPI {

    private final String USERS_ENDPOINT = "/users";

    public io.restassured.response.Response getUser(int id) {
        return get(USERS_ENDPOINT + "/" + id);
    }

    public io.restassured.response.Response createUser(Map<String, Object> body) {
        return post(USERS_ENDPOINT, body);
    }

    public io.restassured.response.Response updateUser(int id, Map<String, Object> body) {
        return put(USERS_ENDPOINT + "/" + id, body);
    }

    public io.restassured.response.Response deleteUser(int id) {
        return delete(USERS_ENDPOINT + "/" + id);
    }
}