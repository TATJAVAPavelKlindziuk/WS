package com.klindziuk.ws.service;

import com.klindziuk.ws.model.post.Post;
import com.klindziuk.ws.model.user.User;

import java.util.Collections;
import java.util.Map;

public class PostDataStorage {

    private static volatile PostDataStorage instance;
    private static Map<Integer, Post> postMap;
    private static Map<Integer, User> userMap;

    private PostDataStorage() {

    }

    public static PostDataStorage getInstance() {
        PostDataStorage localInstance = instance;
        if (localInstance == null) {
            synchronized (PostDataStorage.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PostDataStorage();
                }
            }
        }
        return localInstance;
    }

    public Map<Integer, Post> getPostMap() {
        initPostMap();
        return postMap;
    }

    public Map<Integer, User> getUserMap() {
        initUserMap();
        return userMap;
    }

    private void initUserMap() {
        if (null == userMap) {
            userMap = Collections.synchronizedMap(ExtractService.getUserMap());
        }
    }

    private void initPostMap() {
        if (null == postMap) {
            postMap = Collections.synchronizedMap(ExtractService.getPostMap());
        }
    }

}
