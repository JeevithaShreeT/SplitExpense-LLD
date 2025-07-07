
package com.mycompany.splitexpense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SplitPercent implements Split{
    
    public double round(double amt){
        return Math.round(amt*100.0)/100.0;
    }
     
    @Override
    public Map<User, Double> calculateshares(Expenses expense){
        
        List<Double> percents = expense.getamts();
        List<User> users = expense.getUserstopay();
        double totamt = expense.getamount();
        int totalusers = users.size();
        int totalval = percents.size();
        double tol = 0.0;
        
        for(double p : percents){
            tol+= p;
        }
        
        tol = Math.round(tol*100.0)/100.0;
        
        if(tol != 100.0 || totalusers != totalval){
            throw new IllegalArgumentException("The percentages does not add up to 100");
        }
        
        Map<User, Double> share = new HashMap<>();
        
        for(int i=0; i<totalusers; i++){
            User user = users.get(i);
            Double percent = percents.get(i);
            
            double amount = percent*totamt/100.0;
            
            share.put(user, round(amount));
            
        }
        
        return share;
    }
    
}
