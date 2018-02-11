package com.klindziuk.ws.test.srt;

import com.klindziuk.ws.constants.PathConstants;
import com.klindziuk.ws.model.post.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SrtStatusCodeTest {

    @Test
    public void checkPostsStatusCode() {
        checkStatusCode(PathConstants.BASE_URI + PathConstants.POSTS);
    }

    @Test
    public void checkUsersStatusCode() {
        checkStatusCode(PathConstants.BASE_URI + PathConstants.USERS);
    }

    private void checkStatusCode(String path) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> response = restTemplate.getForEntity(path, Post[].class);
        Assert.assertEquals(response.getStatusCodeValue(), 200);
    }

}
