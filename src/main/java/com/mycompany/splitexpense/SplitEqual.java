
package com.mycompany.splitexpense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SplitEqual implements Split {
 
    
    private double round(double amt){
          return Math.round(amt * 100.0)/100.0;
}
   
   @Override
   public Map<User, Double> calculateshares(Expenses expense){
       
       List<User> users = expense.getUserstopay();
       double totalamt = expense.getamount();
       int totalusers = users.size();
       
       Map<User, Double> share = new HashMap<>();
       
       double splitamt = Math.floor((totalamt/totalusers)*100.0)/100.0;
       double totalassign = splitamt * totalusers;
       double remaining = Math.floor((totalamt - totalusers)* 100.0)/100.0;
       
       for(int i=0; i<totalusers; i++){
           User user = users.get(i);
           
           if(user.equals(expense.getPaiduser())){
               continue;
           }
           
           double finalshare = splitamt;
           
           if(remaining > 0.0){
               finalshare+=0.01;
               remaining -= 0.01;
           }
           
           share.put(user, round(finalshare));
       }
       
       return share;
   
  }
   
}
    
