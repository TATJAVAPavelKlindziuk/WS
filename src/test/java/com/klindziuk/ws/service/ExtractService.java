package com.klindziuk.ws.service;

import com.klindziuk.ws.model.post.ExpectedPost;
import com.klindziuk.ws.model.post.Post;
import com.klindziuk.ws.model.user.ExpectedUser;
import com.klindziuk.ws.model.user.User;
import com.klindziuk.ws.util.FileUtil;
import com.klindziuk.ws.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

public final class ExtractService {
    private static final String HOST_JSON_PATH = "/Users/pavel_klindziuk/IdeaProjects/ws/src/test/java/resources/";
    private static final String POST_JSON_PATH = HOST_JSON_PATH + "post.json";
    private static final String USER_JSON_PATH = HOST_JSON_PATH + "user.json";

    public static Map<Integer, Post> getPostMap() {
        Map<Integer, Post> result = new HashMap<>();
        for (Post post : getExpectedData(POST_JSON_PATH, ExpectedPost.class).getExpected()) {
            result.put(post.getId(), post);
        }
        return result;
    }

    public static Map<Integer, User> getUserMap() {
        Map<Integer, User> result = new HashMap<>();
        for (User user : getExpectedData(USER_JSON_PATH, ExpectedUser.class).getExpected()) {
            result.put(user.getId(), user);
        }
        return result;
    }

    private static <T> T getExpectedData(String path, Class<T> classOfT) {
        String json = FileUtil.getFileSource(path);
        return JsonUtil.fromJson(json, classOfT);
    }
}
