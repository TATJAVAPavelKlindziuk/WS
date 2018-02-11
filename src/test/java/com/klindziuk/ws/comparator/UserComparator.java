package com.klindziuk.ws.comparator;

import com.klindziuk.ws.model.user.User;
import com.klindziuk.ws.service.PostDataStorage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class UserComparator {
    private Map<Integer, User> userMap;

    public UserComparator() {
        userMap = PostDataStorage.getInstance().getUserMap();
    }

    public void compareUser(User[] users) {
        SoftAssert softAssert = new SoftAssert();
        for (User user : users) {
            User expectedUser = userMap.get(user.getId());

            softAssert.assertEquals(user.getName(), expectedUser.getName(),
                    String.format("User name '%s' should be equal to '%s'", user.getName(), expectedUser.getName()));
            softAssert.assertEquals(expectedUser.getUsername(), user.getUsername(),
                    String.format("User userName '%s' should be equal to '%s'", user.getUsername(),
                            expectedUser.getUsername()));
            softAssert.assertEquals(expectedUser.getEmail(), user.getEmail(),
                    String.format("email '%s' should be equal to '%s'", user.getEmail(), expectedUser.getEmail()));
            softAssert.assertEquals(expectedUser.getAddress(), user.getAddress(),
                    String.format("Address '%s' should be equal to '%s'", user.getAddress(),
                            expectedUser.getAddress()));
            softAssert.assertEquals(expectedUser.getPhone(), user.getPhone(),
                    String.format("email '%s' should be equal to '%s'", user.getPhone(), expectedUser.getPhone()));
            softAssert.assertEquals(expectedUser.getWebsite(), user.getWebsite(),
                    String.format("email '%s' should be equal to '%s'", user.getWebsite(), expectedUser.getWebsite()));
            softAssert.assertEquals(expectedUser.getCompany(), user.getCompany(),
                    String.format("email '%s' should be equal to '%s'", user.getCompany(), expectedUser.getCompany()));
        }
        softAssert.assertAll();
    }

    public void compareSize(User[] users) {
        Assert.assertEquals(users.length, userMap.size());
    }
}
