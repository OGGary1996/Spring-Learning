package com.springMVCRequestResponse.pojo;

public class QueryParam {
    private String username;
    private String password;
    private String alias;

    @Override
    public String toString() {
        return "QueryParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
