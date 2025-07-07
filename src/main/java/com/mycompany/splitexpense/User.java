
package com.mycompany.splitexpense;


public class User {
     
    private String userid;
    private String name;
    private String email;
    private String mobileno;
     
     User(String userid, String name, String email, String mobileno){
         this.userid = userid;
         this.name = name;
         this.email = email;
         this.mobileno = mobileno;
     }
     
     public String getUserid(){
         return this.userid;
     }
     
     public String getUsername(){
         return this.name;
     }
     
     public String getUseremail(){
         return this.email;
     }
     
     public String getUsermobile(){
         return this.mobileno;
     }
     
    
}
