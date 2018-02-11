package com.klindziuk.ws.test.srt;


import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeTest;

public class SrtBaseTest {

   protected RestTemplate restTemplate;

    @BeforeTest
    public void initTest() {
         restTemplate = new RestTemplate();
    }

}
