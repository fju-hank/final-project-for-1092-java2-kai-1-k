package com.fju;

public class Ticket {
    String type;
    int price;
    int number;
    int count ;
    public Ticket(String type , int price , int number , int count){
        this.price = price;
        this.type = type;
        this.number = number;
        this.count = count;
    }
}
