package org.example;

import java.math.BigDecimal;

//Don't use float or double in calculations that require exact answer
//Use BidDecimal if you are okay with slower performance
public class Main {
  public static void main(String[] args) {
    //0.6100000000000001
    System.out.println(1.03 - 0.42);
//    0.09999999999999998
    System.out.println(1.00 - 9 * 0.10);

    candies();
    candiesBigDecimal();
    candiesInCents();
  }

  private static void candies() {
    double funds = 1.00;
    int itemBought = 0;

    for (double price = 0.10; funds >= price; price += 0.1) {
      itemBought++;
      funds -= price;
    }
//funds: 0.3999999999999999
    System.out.println("funds: " + funds);
    //item bought: 3
    System.out.println("item bought: " + itemBought);
  }

  private static void candiesBigDecimal() {
    //use string to create bigdecimal
    final BigDecimal TEN_CENTS = new BigDecimal(".10");
    BigDecimal funds = BigDecimal.ONE;
    int itemBought = 0;

    for (BigDecimal price = new BigDecimal("0.1"); funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
      funds = funds.subtract(price);
      itemBought++;
    }

    //funds: 0.00
    System.out.println("funds: " + funds);
    //item bought: 4
    System.out.println("item bought: " + itemBought);
  }

  //as an alternative solution make all math operations with int or long
  private static void candiesInCents() {
    int tenCents = 10;
    int funds = 100;
    int itemBought = 0;

    for (int price = tenCents; funds >= price; price += tenCents) {
      funds -= price;
      itemBought++;
    }
//funds: 0
    System.out.println("funds: " + funds);
    //item bought: 4
    System.out.println("item bought: " + itemBought);
  }
}