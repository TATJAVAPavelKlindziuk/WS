package com.klindziuk.ws.comparator;

import com.klindziuk.ws.model.post.Post;
import com.klindziuk.ws.service.PostDataStorage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class PostComparator {
    private Map<Integer, Post> postMap;

    public PostComparator() {
        postMap = PostDataStorage.getInstance().getPostMap();
    }

    public void comparePost(Post[] posts) {
        SoftAssert softAssert = new SoftAssert();
        for (Post post : posts) {
            Post expectedPost = postMap.get(post.getId());
            softAssert.assertEquals(expectedPost.getBody(), post.getBody());
            softAssert.assertEquals(expectedPost.getTitle(), post.getTitle());
            softAssert.assertEquals(expectedPost.getUserId(), post.getUserId());
        }
        softAssert.assertAll();
    }

    public void compareSize(Post[] posts) {
        Assert.assertEquals(posts.length, postMap.size());
    }
}
