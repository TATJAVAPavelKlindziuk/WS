package com.klindziuk.ws.test.ra;

import com.klindziuk.ws.constants.PathConstants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StatusCodeTest extends BaseTest {

    @Test
    public void checkPostsStatusCode() {
        checkStatusCode(PathConstants.POSTS);
    }

    @Test
    public void checkUsersStatusCode() {
        checkStatusCode(PathConstants.USERS);
    }

    private void checkStatusCode(String path) {
        Response rp = given().get(path).andReturn();
        Assert.assertEquals(rp.getStatusCode(), 200);
    }

}
