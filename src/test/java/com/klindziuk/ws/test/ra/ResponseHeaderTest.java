package com.klindziuk.ws.test.ra;

import com.klindziuk.ws.constants.PathConstants;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.klindziuk.ws.constants.HeaderConstants;

import static io.restassured.RestAssured.given;

public class ResponseHeaderTest extends BaseTest {

    @Test
    public void checkPostsResponseHeader() {
        checkResponseHeader(PathConstants.POSTS);
    }

    @Test
    public void checkUsersResponseHeader() {
        checkResponseHeader(PathConstants.USERS);
    }

    private void checkResponseHeader(String path) {
        SoftAssert softAssert = new SoftAssert();
        Response response = given().get(path).andReturn();

        softAssert.assertEquals(response.getHeader(HeaderConstants.CONTENT_TYPE), "application/json; charset=utf-8");
        softAssert.assertEquals(response.getHeader(HeaderConstants.ACCESS_CONTROL_ALLOW_CREDENTIALS), "true");
        softAssert.assertEquals(response.getHeader(HeaderConstants.CONTENT_ENCODING), "gzip");
        softAssert.assertEquals(response.getHeader(HeaderConstants.PRAGMA), "no-cache");
        softAssert.assertEquals(response.getHeader(HeaderConstants.TRANSFER_ENCODING), "chunked");
        softAssert.assertEquals(response.getHeader(HeaderConstants.VARY), "Origin, Accept-Encoding");
        softAssert.assertEquals(response.getHeader(HeaderConstants.X_CONTENT_TYPE_OPTIONS), "nosniff");
        softAssert.assertEquals(response.getHeader(HeaderConstants.SERVER), "cloudflare");

        softAssert.assertAll();
    }
}
