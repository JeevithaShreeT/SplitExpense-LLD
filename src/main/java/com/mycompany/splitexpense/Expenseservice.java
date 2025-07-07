
package com.mycompany.splitexpense;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Expenseservice {

     Map<String, User> usermap;
     Balance balances;
     
     public Expenseservice(Map<String, User> usermap, Balance balances){
         this.usermap = usermap;
         this. balances = balances;
     }
     
     
     public void addExpense(String userid, double amt, List<String> users, Splittype type, List<Double> values){
         
         User paidby = usermap.get(userid);
         List<User> userlist = new ArrayList<>();
         
         for(String id : users){
             User people = usermap.get(id);
             userlist.add(people);
         }
         
         Expenses expense = new Expenses(paidby, amt, userlist, type, values);
         
         Split calculation;
         
         switch(type){
             case EQUAL :
                 calculation = new SplitEqual();
                 break;
                 
             case EXACT :
                 calculation = new SplitExact();
                 break;
                 
             case PERCENT :
                 calculation = new SplitPercent();
                 break;
                 
             default: 
                 throw new IllegalArgumentException("Invalid Splittytpe");
                 
         }
         
         Map<User, Double> calc = calculation.calculateshares(expense);
         
         for(Map.Entry<User, Double> entry : calc.entrySet()){
             User owned = entry.getKey();
             double amts = entry.getValue();
             
             balances.addBalance(userid, owned.getUserid(), amts);
         }
     }
}
