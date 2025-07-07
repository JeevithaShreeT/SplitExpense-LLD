
package com.mycompany.splitexpense;

import java.util.*;
import java.util.Map;


public class Balance {

     private Map<String, Map<String, Double>> balances;
     
     public Balance(){
         this.balances = new HashMap<>();
     }
    
     public double round(double amt){
         return Math.round(amt*100.0)/100.0;
     }
     
     public void addBalance(String paidby, String ownedby, double amt){
         
         if(paidby.equals(ownedby)) return;
         
         balances.putIfAbsent(ownedby, new HashMap<>());
         
         Map<String, Double> own = balances.get(ownedby);
        
         double currentamt = own.getOrDefault(paidby, 0.0);
         
         own.put(paidby, round(currentamt + amt));
         
     }
     
     public void showallBalnce(){
        boolean found = false;
        
        for(String owned : balances.keySet()){
            for (Map.Entry<String, Double> entry : balances.get(owned).entrySet()) {
             String paidby = entry.getKey();
             double amttopay = entry.getValue();
             
             if(amttopay > 0.0){
                 System.out.println(owned +" owns "+ paidby + " : "+amttopay);
                 found = true;
             }
        }
        }
        
        if(!found){
            System.out.println("No balances");
        }
     }
     
     public void showUserbalnce(String userid){
         
         boolean found = false;
         
         if(balances.containsKey(userid)){
             for(Map.Entry<String, Double> entry : balances.get(userid).entrySet()){
                System.out.println(userid + " owns "+ entry.getKey()+ " : "+ entry.getValue());
                found = true;
         }
         }
         
         for(String other : balances.keySet()){
             Map<String, Double> map = balances.get(other);
             
             if(map.containsKey(userid)){
                 
                 System.out.println(other+" owns "+userid+ " : "+ round(map.get(userid)));
                 found = true;
             }
         }
         
         if(!found){
             System.out.println("No balances");
         }
     }
     
}
