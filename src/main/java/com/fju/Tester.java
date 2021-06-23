package com.fju;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Train train = new Train();
        Ship ship = new Ship();
        Airplane airplane = new Airplane();
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int discount = 0;
        while (true) {
            String type[] = {train.type, ship.type, airplane.type, hotel.type};
            int TicketCount[] = {train.count, ship.count, airplane.count, hotel.count};
            int number[] = {train.number, ship.number, airplane.number, hotel.number};
            int price[] = {train.price, ship.price, airplane.price, hotel.price};
            System.out.println("Please select the ticket :");
            for (int i = 0; i < 30; i++) {
                System.out.print("*");
            }
            System.out.println();
            for (int i = 0; i < 4; i++) {
                System.out.println(i + 1 + " ." + type[i] + " :" + price[i]);
            }
            System.out.println("Pause 0 to exit");
            for (int i = 0; i < 30; i++) {
                System.out.print("*");
            }
            System.out.println();
            for (int i = 0; i < 4; i++) {
                System.out.println(type[i] + " : " + TicketCount[i]);
            }
            System.out.println("discount" + " : " + discount);
            System.out.println("total" + " : " + (total - discount));
            for (int i = 0; i < 30; i++) {
                System.out.print("*");
            }
            System.out.println();
            int ticket = scanner.nextInt();
            if (ticket == 0) {
                System.out.println("Thank u ! bye !");
                break;
            } else {
                if (ticket == train.number) {
                    System.out.println("Sure for " + train.type + " ?");
                    System.out.println("Pause 1 for sure ");
                    System.out.println("Pause 0 to exit ");
                    int answer1 = scanner.nextInt();
                    if (answer1 == 1) {
                        System.out.println("Do u want to buy the hotel ticket for 10% discount ? ");
                        System.out.println("Pause 1 for sure ");
                        System.out.println("Pause 0 to exit ");
                        int answer2 = scanner.nextInt();
                        if (answer2 == 1) {
                            hotel.count += 1;
                            train.count += 1;
                            discount += (int) ((hotel.price + train.price) * 0.1);
                            total += train.price * train.count + hotel.price * hotel.count ;
                        } if (answer2 == 0){
                            train.count += 1 ;
                            total = train.price * train.count;
                        }
                    } else if (answer1 == 0) {
                        System.out.println();
                    }
                } else if (ticket == ship.number) {
                    System.out.println("Sure for " + ship.type + " ?");
                    System.out.println("Pause 1 for sure ");
                    System.out.println("Pause 0 to exit ");
                    int answer1 = scanner.nextInt();
                    if (answer1 == 1) {
                        if (answer1 == 1) {
                            System.out.println("Do u want to buy the hotel ticket for 10% discount ? ");
                            System.out.println("Pause 1 for sure ");
                            System.out.println("Pause 0 to exit ");
                            int answer2 = scanner.nextInt();
                            if (answer2 == 1) {
                                hotel.count += 1;
                                ship.count += 1;
                                discount += (int) ((hotel.price + ship.price) * 0.1);
                                total += ship.price*ship.count + hotel.price* hotel.count;
                            }if (answer2 == 0){
                                ship.count += 1 ;
                                total += ship.price* ship.count;
                            }
                        } else if (answer1 == 0) {
                            System.out.println();
                        }
                    }
                    } else if (ticket == airplane.number) {
                        System.out.println("Sure for " + airplane.type + " ?");
                        System.out.println("Pause 1 for sure ");
                        System.out.println("Pause 0 to exit ");
                        int answer1 = scanner.nextInt();

                        if (answer1 == 1) {
                            System.out.println("Do u want to buy the hotel ticket for 10% discount ? ");
                            System.out.println("Pause 1 for sure ");
                            System.out.println("Pause 0 to exit ");
                            int answer2 = scanner.nextInt();
                                if (answer2 == 1) {
                                    hotel.count += 1;
                                    airplane.count += 1;
                                    discount += (int) ((hotel.price + airplane.price) * 0.1);
                                    total += airplane.price * airplane.count + hotel.price * hotel.count ;
                                }if (answer2 == 0){
                                    airplane.count += 1 ;
                                    total += airplane.price * airplane.count;
                                }
                            } else if (answer1 == 0) {
                                System.out.println("Thank u ! bye !");
                            }
                }else if ( ticket == hotel.number) {
                            System.out.println("Sure for " + hotel.type + " ?");
                            System.out.println("Pause 1 for sure ");
                            System.out.println("Pause 0 to exit ");
                            int answer1 = scanner.nextInt();

                            if (answer1 == 1) {
                                System.out.println("Do u want add the other tickets for 10% discount?");
                                int answer2 = scanner.nextInt();
                                for (int i = 0; i < 3; i++) {
                                    System.out.println(i + 1 + " ." + type[i] + " + " + hotel.type +
                                            " = " + (price[i] * 0.9 + hotel.price ));
                                } if (answer2 == train.number){
                                    hotel.count += 1;
                                    train.count += 1;
                                    discount += (int) ((hotel.price + train.price) * 0.1);
                                    total += train.price * train.count + hotel.price * hotel.count;
                                } else if (answer2 == ship.number){
                                    hotel.count += 1;
                                    ship.count += 1;
                                    discount += (int) ((hotel.price + ship.price) * 0.1);
                                    total += ship.price * ship.count + hotel.price * hotel.count ;
                                } else if (answer2 == ship.number){
                                    hotel.count += 1;
                                    airplane.count += 1;
                                    discount += (int) ((hotel.price + airplane.price ) * 0.1);
                                    total += airplane.price * airplane.count + hotel.price * hotel.count;
                                }if (answer2 == 0){
                                    hotel.count += 1 ;
                                    total += hotel.price * hotel.count;
                                }
                            } else if (answer1 == 0) {

                            }
                        } else {
                            System.out.println("!!!!error!!!!");
                            System.out.println("Please enter again :");
                        }


            }
        }
    }
}
