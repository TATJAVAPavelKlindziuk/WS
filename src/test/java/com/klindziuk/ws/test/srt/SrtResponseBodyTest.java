package com.klindziuk.ws.test.srt;

import com.klindziuk.ws.comparator.PostComparator;
import com.klindziuk.ws.comparator.UserComparator;
import com.klindziuk.ws.constants.PathConstants;
import com.klindziuk.ws.model.post.Post;
import com.klindziuk.ws.model.user.User;
import org.springframework.http.ResponseEntity;

import org.testng.annotations.Test;

public class SrtResponseBodyTest extends SrtBaseTest {

    @Test
    public void checkPostResponseBody() {
        PostComparator postComparator = new PostComparator();

        ResponseEntity<Post[]> response = restTemplate
                .getForEntity(PathConstants.BASE_URI + PathConstants.POSTS, Post[].class);

        postComparator.comparePost(response.getBody());
        postComparator.compareSize(response.getBody());
    }

    @Test
    public void checkUserResponseBody() {
        UserComparator userComparator = new UserComparator();

        ResponseEntity<User[]> response = restTemplate
                .getForEntity(PathConstants.BASE_URI + PathConstants.USERS, User[].class);

        userComparator.compareUser(response.getBody());
        userComparator.compareSize(response.getBody());
    }
}
