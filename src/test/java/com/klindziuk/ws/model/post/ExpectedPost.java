package com.klindziuk.ws.model.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExpectedPost {

    @JsonProperty("expected")
    private List<Post> expected;

    public ExpectedPost() {
    }

    public List<Post> getExpected() {
        return expected;
    }

    public void setExpected(List<Post> expected) {
        this.expected = expected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ExpectedPost that = (ExpectedPost) o;

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
