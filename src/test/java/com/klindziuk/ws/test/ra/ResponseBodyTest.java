package com.klindziuk.ws.test.ra;

import com.klindziuk.ws.comparator.PostComparator;
import com.klindziuk.ws.comparator.UserComparator;
import com.klindziuk.ws.constants.PathConstants;
import com.klindziuk.ws.model.user.User;
import io.restassured.response.Response;
import com.klindziuk.ws.model.post.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseBodyTest extends BaseTest {

    @Test
    public void checkPostResponseBody() {
        PostComparator postComparator = new PostComparator();
        Response rp = given().get(PathConstants.POSTS).andReturn();
        Post[] posts = rp.as(Post[].class);
        postComparator.comparePost(posts);
        postComparator.compareSize(posts);
    }

    @Test
    public void checkUserResponseBody() {
        UserComparator userComparator = new UserComparator();
        Response rp = given().get(PathConstants.USERS).andReturn();
        User[] users = rp.as(User[].class);
        userComparator.compareUser(users);
        userComparator.compareSize(users);
    }
}
