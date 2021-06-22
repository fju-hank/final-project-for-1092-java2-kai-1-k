package com.fju;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class App extends JFrame {
    private JPanel App;
    private JButton hotelButton;
    private JButton trainButton;
    private JButton shipButton;
    private JButton airplaneButton;
    private JButton noButton;
    private JButton yesButtom;
    private JPanel Choice;
    private JPanel YN;
    private JTextArea textArea1;
    private JButton exitButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public App(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(App);
        this.pack();
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("https://ods.railway.gov.tw/tra-ods-web/ods/download/dataResource/a5839b4e6bef4964946d56535bfaabc9");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();;
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = in.readLine();
            while(line != null) {
//                System.out.println(line);
                sb.append(line);
                line = in.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int total = 0 ;
        int discount = 0 ;
        Train Train = new Train();
        Ship Ship = new Ship();
        Airplane Airplane = new Airplane();
        Hotel Hotel = new Hotel();
        JFrame jFrame = new App("My order app");
        jFrame.setVisible(true);
        JTextArea order = new JTextArea();
        order.setVisible(true);
        JButton yes = new JButton();
        JButton no = new JButton();
        JButton airplane = new JButton();
        JButton train = new JButton();
        JButton ship = new JButton();
        JButton hotel = new JButton();
        JButton exit = new JButton();
        exit.setVisible(true);
        yes.setVisible(true);
        no.setVisible(true);
        airplane.setVisible(true);
        train.setVisible(true);
        ship.setVisible(true);
        hotel.setVisible(true);


        while (true) {
            order.append(Hotel.type + " : " + Hotel.price
                   + "\n" + Airplane.type + " : " + Airplane.price
                   + "\n" + Ship.type + " : " + Ship.price
                    + "\n" + Train.type + " : " + Train.price );
            if (hotel.getModel().isPressed()){
                order.append(" Are u sure for the " + Hotel.type + " ? ");
                if (yes.getModel().isPressed()){
                    order.append("Do u want to buy other ticket for 10% discount ?" );
                    if (yes.getModel().isPressed()){
                      order.append(" Which do u want to buy ?");
                        order.append(Hotel.type + " : " + Hotel.price
                                + "\n" + Airplane.type + " : " + Airplane.price
                                + "\n" + Ship.type + " : " + Ship.price
                                + "\n" + Train.type + " : " + Train.price);
                        if (train.getModel().isPressed()){
                            Hotel.count += 1;
                            Train.count += 1;
                            discount += (int) ((Hotel.price + Train.price) * 0.1);
                            total += Train.price + Hotel.price;
                            order.append(Train.type + " : " + Train.count + "\n"
                                        + Hotel.type + " : " + Hotel.count + "\n"
                                        + "Discount : " + discount
                                        + "Total : " + total);
                        } else if (ship.getModel().isPressed()){
                            Hotel.count += 1;
                            Ship.count += 1;
                            discount += (int) ((Hotel.price + Ship.price) * 0.1);
                            total += Ship.price + Hotel.price;
                            order.append(Ship.type + " : " + Ship.count + "\n"
                                    + Hotel.type + " : " + Hotel.count + "\n"
                                    + "Discount : " + discount
                                    + "Total : " + total);
                        } else if (airplane.getModel().isPressed()){
                            Hotel.count += 1;
                            Airplane.count += 1;
                            discount += (int) ((Hotel.price + Airplane.price) * 0.1);
                            total += Airplane.price + Hotel.price;
                            order.append(Airplane.type + " : " + Airplane.count + "\n"
                                    + Hotel.type + " : " + Hotel.count + "\n"
                                    + "Discount : " + discount
                                    + "Total : " + total);
                        }
                    } else if (no.getModel().isPressed()){
                        order.append(Hotel.type + " : " + Hotel.count + "\n"
                                + "Discount : " + discount
                                + "Total : " + total);
                    }
                }
            }  if (train.getModel().isPressed()){
                order.append(" Are u sure for the " + Train.type + " ? ");
                if (yes.getModel().isPressed()){
                    order.append("Do u want to buy  " + Hotel.type + " for 10% discount ?" );
                    if (yes.getModel().isPressed()){
                        Hotel.count += 1;
                        Train.count += 1;
                        discount += (int) ((Hotel.price + Train.price) * 0.1);
                        total += Train.price + Hotel.price;
                        order.append(Train.type + " : " + Train.count + "\n"
                                + Hotel.type + " : " + Hotel.count + "\n"
                                + "Discount : " + discount
                                + "Total : " + total);
                    } else if (no.getModel().isPressed()){
                        order.append(Train.type + " : " + Train.count + "\n"
                                + "Discount : " + discount
                                + "Total : " + total);
                    }
                }
            }  if (ship.getModel().isPressed()){
                order.append(" Are u sure for the " + Ship.type + " ? ");
                if (yes.getModel().isPressed()){
                    order.append("Do u want to buy  " + Train.type + " for 10% discount ?" );
                    if (yes.getModel().isPressed()){
                        Hotel.count += 1;
                        Ship.count += 1;
                        discount += (int) ((Hotel.price + Ship.price) * 0.1);
                        total += Ship.price + Hotel.price;
                        order.append(Ship.type + " : " + Ship.count + "\n"
                                + Hotel.type + " : " + Hotel.count + "\n"
                                + "Discount : " + discount
                                + "Total : " + total);
                    } else if (no.getModel().isPressed()){
                        order.append(Ship.type + " : " + Ship.count + "\n"
                                + "Discount : " + discount
                                + "Total : " + total);
                    }
                }
            } if (airplane.getModel().isPressed()){
                order.append(" Are u sure for the " + Airplane.type + " ? ");
                if (yes.getModel().isPressed()){
                    order.append("Do u want to buy  " + Hotel.type + " for 10% discount ?" );
                    if (yes.getModel().isPressed()){
                        Hotel.count += 1;
                        Airplane.count += 1;
                        discount += (int) ((Hotel.price + Airplane.price) * 0.1);
                        total += Airplane.price + Hotel.price;
                        order.append(Airplane.type + " : " + Airplane.count + "\n"
                                + Hotel.type + " : " + Hotel.count + "\n"
                                + "Discount : " + discount );
                    } else if (no.getModel().isPressed()){
                        order.append(Airplane.type + " : " + Airplane.count + "\n"
                                + "Discount : " + discount
                                + "Total : " + total);
                    }
                }
            }if (exit.getModel().isPressed()){
                order.append(" Thank u bye ! ");
                break;
            }
        }
    }
}