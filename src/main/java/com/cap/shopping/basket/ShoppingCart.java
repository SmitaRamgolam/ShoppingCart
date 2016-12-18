/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cap.shopping.basket;

/**
 *
 * @author SRAMGOLA
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* SR: Create shopping cart class*/
public class ShoppingCart { 

List<String> items;

/* SR: Create shopping cart with a list of items*/
public ShoppingCart(){
    items = new ArrayList<String>();
}

/* SR: Add items to shopping cart*/
public void add(String item) {
    items.add(item);
}

/* SR: Return total number of items in shopping cart*/
public int getTotalItems() {
    return items.size();
}

/* SR: Check if item exists in shopping cart*/
public Boolean doesContain(String itemName) {
    return items.contains(itemName);
}


public int countitem(String itemName) {
    return Collections.frequency(items, itemName);
}


// SR: Return total amount of shopping cart -- Step 1
public double checkout() {
    /* SR: Set initial shopping cart total to 0*/
    double total = 0; 
    int appletotalitems = countitem("Apple");
    double appletotal = 0;
    double applediv = 0;
    
    int orangetotalitems = countitem("Orange");
    double orangetotal = 0;
    double orangediv = 0;
    
    //Start of Step 1 Derivation
     for(String item: items){
        if(item.equals("Apple")){
            appletotal += 0.6;
        }else if(item.equals("Orange")){
            orangetotal += 0.25;
        
        }
        
    }
    //End of Step 1 Derivation
    
    ///////////////////////////////////////////////////////////////////////////
    // Start of Step 2 Derivation
    
    //Apple cost derivation
 /*   applediv = appletotalitems / 2; 
    appletotal = (appletotalitems - applediv)*0.6; 
    
    
    //Orange cost derivation
    orangediv = orangetotalitems / 3; 
    orangetotal = (orangetotalitems - orangediv)*0.25; 
    
   // End of Step 2 Derivation*/
    total = appletotal + orangetotal;
    
    return total;
}   

}
