/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.splitexpense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SplitExact implements Split {
    
    public double round(double amt){
        return Math.round(amt*100.0)/100.0;
    }
   
    @Override
    public Map<User, Double> calculateshares(Expenses expense){
        
        List<User> users = expense.getUserstopay();
        int totalusers = users.size();
        List<Double> values = expense.getamts();
        int totalvalues = values.size();
        
        if(totalusers != totalvalues){
         
        throw new IllegalArgumentException("The given values doesnt match the users");
        
    }
        
        Map<User, Double> share = new HashMap<>();
        
        for(int i=0; i<totalusers; i++){
            User user = users.get(i);
            double value = values.get(i);
            share.put(user, round(value));
        }
        
        return share;
    }
    
}
