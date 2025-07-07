
package com.mycompany.splitexpense;

import java.util.List;


public class Expenses {
 
    private User user;
    private Double amount;
    private List<User> users;
    private Splittype type;
    private List<Double> amt;
    
    Expenses(User user, Double amount, List<User> users, Splittype type, List<Double> amt){
        this.user = user;
        this.amount = amount;
        this.users = users;
        this.type = type;
        this.amt = amt;
    }
    
    public User getPaiduser(){
        return this.user;
    }
    
    public Double getamount(){
        return this.amount;
    }
    
    public List<User> getUserstopay(){
        return this.users;
    }
    
    public Splittype gettype(){
        return this.type;
    }
    
    public List<Double> getamts(){
        return this.amt;
    }
}
