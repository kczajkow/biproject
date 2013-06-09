package net.javeabet.spring.webflow.assetmgmt;

import java.io.Serializable;

public class AssetManagementModel implements Serializable{

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
