package com.klindziuk.ws.test.srt;

import com.klindziuk.ws.constants.PathConstants;
import com.klindziuk.ws.model.post.Post;
import com.klindziuk.ws.test.ra.BaseTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class SrtResponseHeaderTest extends BaseTest {

    @Test
    public void checkPostsResponseHeader() {
        checkResponseHeader(PathConstants.BASE_URI + PathConstants.POSTS);
    }

    @Test
    public void checkUsersResponseHeader() {
        checkResponseHeader(PathConstants.BASE_URI + PathConstants.USERS);
    }

    private void checkResponseHeader(String path) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> response = restTemplate.getForEntity(path, Post[].class);
        List<String> valueOfContentTypeHeader = response.getHeaders().get("content-type");
        Assert.assertEquals(valueOfContentTypeHeader.get(0), "application/json; charset=utf-8");
    }

}
