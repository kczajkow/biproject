package net.javeabet.spring.webflow.assetmgmt.savings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SavingsAssetService {

    private static Map<SavingsAssetModel, Set<SavingsDetail>> userSavingsDetailMap;

    public boolean isCredentialValid(String username, String password){

        Iterator<Map.Entry<SavingsAssetModel, Set<SavingsDetail>>> iterator = userSavingsDetailMap.entrySet().iterator();
        while (iterator.hasNext()){

            SavingsAssetModel model = iterator.next().getKey();
            System.out.println("Model is " + model + ", " + model.getUsername() + ", " + model.getPassword());
            if (model != null && model.getUsername().equals(username) && model.getPassword().equals(password)){
                return true;
            }else{
                continue;
            }
        }
      return false;
    }

    public Set<SavingsDetail> getSavingsDetails(String username, String password){

        Iterator<Map.Entry<SavingsAssetModel, Set<SavingsDetail>>> iterator = userSavingsDetailMap.entrySet().iterator();
        while (iterator.hasNext()){

            Map.Entry<SavingsAssetModel, Set<SavingsDetail>> entry = iterator.next();
            SavingsAssetModel model = entry.getKey();
            if (model != null && model.getUsername().equals(username) && model.getPassword().equals(password)){
                return entry.getValue();
            }else{
                continue;
            }
        }
        return new HashSet<SavingsDetail>();
    }

    static{
        
        userSavingsDetailMap = new HashMap<SavingsAssetModel, Set<SavingsDetail>>();

        populateData("admin-savings", "admin-savings",
            savingsDetail("Fixed Deposit in HDFC", "HDFC", "FD", 20130),
            savingsDetail("Recurring Deposit in ICICI", "ICICI", "FD", 40320),
            savingsDetail("Insurance in MNYL", "Max New York Life", "Insurance", 220000));

        populateData("guest", "guest",
            savingsDetail("Fixed Deposit in Citibank", "Citibank", "FD", 12040),
            savingsDetail("Insurance in SBI", "SBI", "Insurance", 330000));
        
    }

    private static void populateData(String username, String password, SavingsDetail ... savingsDetails){

        SavingsAssetModel model = new SavingsAssetModel();
        model.setUsername(username);
        model.setPassword(password);

        Set<SavingsDetail> savingsDetailSet = new HashSet<SavingsDetail>();
        for (SavingsDetail savingsDetail : savingsDetails){
            savingsDetailSet.add(savingsDetail);
        }
        userSavingsDetailMap.put(model, savingsDetailSet);
    }
    
    private static SavingsDetail savingsDetail(String name, String organization,
        String category, double amount){

        SavingsDetail savingsDetail = new SavingsDetail();
        savingsDetail.setName(name);
        savingsDetail.setOrganization(organization);
        savingsDetail.setCategory(category);
        savingsDetail.setAmount(amount);
        return savingsDetail;
    }
}
