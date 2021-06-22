package com.fju;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
        yes.setVisible(true);
        no.setVisible(true);
        airplane.setVisible(true);
        train.setVisible(true);
        ship.setVisible(true);
        hotel.setVisible(true);


        while (true) {
            order.setText(Hotel.type + " : " + Hotel.price
                   + "\n" + Airplane.type + " : " + Airplane.price
                   + "\n" + Ship.type + " : " + Ship.price
                    + "\n" + Train.type + " : " + Train.price);
            if (hotel.getModel().isPressed()){
                order.append(" Are u sure for the " + Hotel.type + " ? ");
                if (yes.getModel().isPressed()){
                    order.append("Do u want to buy  " + Train.type + " for 10% discount ?" );
                    if (yes.getModel().isPressed()){
                        Hotel.count += 1;
                        Train.count += 1;
                        discount += (int) ((Hotel.price + Train.price) * 0.1);
                        total += Train.price + Hotel.price;
                    } else if (no.getModel().isPressed()){
                        break;
                    }
                }
            }
        }
    }
}