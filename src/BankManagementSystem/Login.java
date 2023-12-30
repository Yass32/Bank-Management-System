package BankManagementSystem;

import javax.swing.*;
import java.awt.*;


public class Login extends JFrame{

    Login() {
        //Set window title
        setTitle("Automated Teller Machine");
        //Set window size
        setSize(800, 480);
        //Set window visibly to true
        setVisible(true);
        //Set window position to middle of the screen
        setLocation(350, 200);


        ImageIcon i1 = new ImageIcon(String.valueOf(ClassLoader.getSystemResource("icons/logo.jpg")));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(i1);
        add(label);


    }

    public static void main(String[] args) {
        new Login();
    }
}