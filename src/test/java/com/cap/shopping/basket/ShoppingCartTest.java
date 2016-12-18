/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cap.shopping.basket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author SRAMGOLA
 */
public class ShoppingCartTest {

ShoppingCart cart;

@Before
public void setUp(){
    cart = new ShoppingCart();
}

/*Positive scenarios -- Step 1*/

/*To  test doesContain()  and getTotalItems()*/

/*
1.	Add 1 Apple to shopping cart and check if shopping cart contains the item using 
        the doesContain() is True and check total number of items in shopping cart using getTotalItems() is 1
*/

@Test
public void positiveaddOneItemToCart() {
    cart.add("Apple");
    assertThat(cart.getTotalItems(), is(1));
    assertTrue(cart.doesContain("Apple"));
    
}

/*
2.	Add 1 Apple and 1 orange to shopping cart and check if shopping cart contains the item using 
        the doesContain() is True and check total number of items in shopping cart using getTotalItems() is 2
*/
@Test
public void positiveaddTwoItemsToCart(){
    cart.add("Apple");
    cart.add("Orange");
    assertTrue(cart.doesContain("Apple"));
    assertTrue(cart.doesContain("Orange"));
    assertThat(cart.getTotalItems(), is(2));

}

/*
3.	Add 1 Apple and 2 oranges to shopping cart and check if shopping cart contains the item using the doesContain()
        is True and check total number of items in shopping cart using getTotalItems() is 3
*/
@Test
public void positiveaddThreeItemsToCart(){
    cart.add("Apple");
    cart.add("Orange");
    cart.add("Orange");
    assertTrue(cart.doesContain("Apple"));
    assertTrue(cart.doesContain("Orange"));
    assertThat(cart.getTotalItems(), is(3));
}

/*
4.	Add 2 Oranges to shopping cart and check  total number of items in shopping cart using getTotalItems() is 2 
*/
@Test
public void positiveaddAnItemTwice(){
    cart.add("Orange");
    cart.add("Orange");
    assertThat(cart.getTotalItems(), is(2));
}
/*
5.	Add 1 Apple to shopping cart and check if total is correct amount of 0.6
*/
@Test
public void positivecheckOutOneItem(){
    cart.add("Apple");
    assertThat(cart.checkout(), is(0.6));
}

/*
6.	Add 1 Apple and 1 orange to shopping cart and check if total is correct amount of 0.85
*/
@Test
public void positivecheckoutTwoSeparateItems(){
    cart.add("Orange");
    cart.add("Apple");
    assertThat(cart.checkout(), is(0.85));
}

/*
7.	Add 2 Apples to shopping cart and check if total is correct amount of 1.20
*/

@Test
public void positivecheckoutTwoSameItems(){
    cart.add("Apple");
    cart.add("Apple");
    assertThat(cart.checkout(), is(1.20));
}


/*
8.	Add 3 Apples and 1 orange to shopping cart and check if total is correct amount of 2.05
*/
@Test
public void positivecheckoutThreeItems(){
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Orange");
    cart.add("Apple");
    assertTrue(cart.doesContain("Apple"));
    assertTrue(cart.doesContain("Orange"));
    assertThat(cart.checkout(), is(2.05));
}

/*
8.	Add invalid item (Banana) to shopping cart and check if total is correct amount of 0
*/

@Test 
public void positivecheckOutAnInvalidItem(){
    cart.add("Banana");
    assertThat(cart.doesContain("Orange"), is (false));
    assertThat(cart.doesContain("Apple"), is (false));
    assertThat(cart.checkout(),is(0.0));
}


/*Negative scenarios -- Step 1*/

/*
1.	Add 1 Apple to shopping cart and check if shopping cart contains the item using 
        the doesContain() is false and check total number of items in shopping cart using getTotalItems() is 1
*/

@Test
public void negativeaddOneItemToCart() {
    cart.add("Apple");
    assertThat(cart.doesContain("Apple"), is (false));
  
    
    
}


/*
2.	Add 1 Apple to shopping cart and check if 
        and check total number of items in shopping cart using getTotalItems() is 3 which should fail
*/
@Test
public void negativetotalnumberofitems() {
    cart.add("Apple");
    assertThat(cart.getTotalItems(), is(3));
    
    
}

/*
3.	Add 1 Apple to shopping cart and check if 
        and check Orange exists in shopping cart is true which should fail
*/

public void negativenoitemfound() {
cart.add("Apple");
    assertTrue(cart.doesContain("Orange"));

}


/*
4.	Add 3 Apples and 1 orange to shopping cart and check if total is of wrong  amount of 2.50 which should fail
*/
@Test
public void negativecheckoutThreeItems(){
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Orange");
    cart.add("Apple");
    assertTrue(cart.doesContain("Apple"));
    assertTrue(cart.doesContain("Orange"));
    assertThat(cart.checkout(), is(2.50));
}

/*
5.	Add invalid item (Banana) to shopping cart and check if total is correct amount of 0.25
*/

@Test 
public void negativecheckOutAnInvalidItem(){
    cart.add("Banana");
    assertThat(cart.checkout(),is(0.25));
}


/*Positive scenarios -- Step 2*/

@Test 
public void Step2positivetest1(){
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    assertThat(cart.checkout(),is(3.05));
}


@Test 
public void Step2positivetest2(){
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    assertThat(cart.checkout(),is(2.7));
}



@Test 
public void Step2positivetest3(){
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    assertThat(cart.checkout(),is(2.2));
}

/*Negative scenarios -- Step 2*/

@Test 
public void Step2postitivetest4(){
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Banana");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    assertThat(cart.checkout(),is(2.2));
}

@Test
public void Step2negativetest2(){
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Apple");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    cart.add("Orange");
    assertThat(cart.checkout(),is(2.7));
}    

@Test 
public void Step2negativetest3(){
    cart.add("Banana");
    assertThat(cart.checkout(),is(0.25));
}
    
}