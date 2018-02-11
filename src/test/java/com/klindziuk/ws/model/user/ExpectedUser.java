package com.klindziuk.ws.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExpectedUser {

    @JsonProperty("expected")
    private List<User> expected;

    public ExpectedUser() {
    }

    public List<User> getExpected() {
        return expected;
    }

    public void setExpected(List<User> expected) {
        this.expected = expected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ExpectedUser that = (ExpectedUser) o;

        return expected != null ? expected.equals(that.expected) : that.expected == null;
    }

    @Override
    public int hashCode() {
        return expected != null ? expected.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ExpectedPost{" + "expected=" + expected + '}';
    }

}
