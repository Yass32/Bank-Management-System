package BankManagementSystem;

import javax.swing.*;
import java.awt.*;


public class Login extends JFrame{

    Login() {
        //Set window title
        setTitle("Automated Teller Machine");

        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        //Image icon class loads an image file named "logo.jpg" from a directory named "icons." The ClassLoader is a mechanism in Java for dynamically loading classes and resources
        ImageIcon i1 = new ImageIcon(String.valueOf(ClassLoader.getSystemResource("icons/logo.jpg")));
        //Get the Image object from the previously created ImageIcon(i1) then scaling the image to a size of 100x100 pixels using getScaledInstance
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //Creating a new ImageIcon from the scaled Image object (i2)
        ImageIcon i3 = new ImageIcon(i2);
        //label will display the scaled image(i3)
        JLabel label = new JLabel(i3);
        //Setting the position(x, y) and size(width, height)of the JLabel
        label.setBounds(70, 10, 100, 100);
        //method used to add JLabel component to the JFrame container
        add(label);

        //Set window size
        setSize(800, 480);
        //Set window visibly to true
        setVisible(true);
        //Set window position to middle of the screen
        setLocation(350, 200);


    }

    public static void main(String[] args) {
        new Login();
    }
}