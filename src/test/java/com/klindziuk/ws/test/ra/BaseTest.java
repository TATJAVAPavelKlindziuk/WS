package com.klindziuk.ws.test.ra;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

import static com.klindziuk.ws.constants.PathConstants.BASE_URI;

public class BaseTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = BASE_URI;
    }

}
