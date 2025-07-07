
package com.mycompany.splitexpense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SplitExpense {

    public static void main(String[] args) {
        
        Map<String, User> userMap = new HashMap<>();
        userMap.put("u1", new User("u1", "User1", "user1@email.com", "1234567890"));
        userMap.put("u2", new User("u2", "User2", "user2@email.com", "1234567891"));
        userMap.put("u3", new User("u3", "User3", "user3@email.com", "1234567892"));
        userMap.put("u4", new User("u4", "User4", "user4@email.com", "1234567893"));
        
        Balance bal = new Balance();
        Expenseservice service = new Expenseservice(userMap, bal);
        
        Scanner sc = new Scanner(System.in);
        
        while(true){
            String input = sc.nextLine().trim();
            
            if(input.equalsIgnoreCase("exit")) break;
            
            String[] ipts = input.split(" ");
            
            if(ipts[0].equalsIgnoreCase("show")){
                if(ipts.length == 1){
                    bal.showallBalnce();
                }
                else{
                    String id = ipts[1];
                    bal.showUserbalnce(id);
                }
            }
            else if(ipts[0].equalsIgnoreCase("expense")){
                String payer = ipts[1];
                double amount = Double.parseDouble(ipts[2]);
                int usersnum = Integer.parseInt(ipts[3]);
                
                List<String> usersid = new ArrayList<>();
                
                for(int i=0; i<usersnum; i++){
                    usersid.add(ipts[i+4]);
                }
                        
                Splittype type = Splittype.valueOf(ipts[4+usersnum]);
                
                List<Double> values = new ArrayList<>();
                
                for(int i=5+usersnum; i<ipts.length; i++){
                    double val = Double.parseDouble(ipts[i]);
                    values.add(val);
                }
                
                service.addExpense(payer, amount, usersid, type, values);
            }
            
            else{
                System.out.println("Invalid comment");
            }
        }
        
        sc.close();
    }
}
