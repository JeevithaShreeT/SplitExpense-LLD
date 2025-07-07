
package com.mycompany.splitexpense;

import java.util.Map;


public interface Split {

     Map<User, Double> calculateshares(Expenses expense);
         
         
}
