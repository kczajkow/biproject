package net.javeabet.spring.webflow.assetmgmt;

public class AssetManagementService {

    public boolean isCredentialValid(String username, String password){

        return (username.equals("admin") && password.equals("admin"));
    }
}
