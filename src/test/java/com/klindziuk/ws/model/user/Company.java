package com.klindziuk.ws.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Company {

    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Company company = (Company) o;

        if (name != null ? !name.equals(company.name) : company.name != null)
            return false;
        if (catchPhrase != null ? !catchPhrase.equals(company.catchPhrase) : company.catchPhrase != null)
            return false;
        if (bs != null ? !bs.equals(company.bs) : company.bs != null)
            return false;
        return additionalProperties != null ?
                additionalProperties.equals(company.additionalProperties) :
                company.additionalProperties == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (catchPhrase != null ? catchPhrase.hashCode() : 0);
        result = 31 * result + (bs != null ? bs.hashCode() : 0);
        result = 31 * result + (additionalProperties != null ? additionalProperties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" + "name='" + name + '\'' + ", catchPhrase='" + catchPhrase + '\'' + ", bs='" + bs + '\''
                + ", additionalProperties=" + additionalProperties + '}';
    }
}
