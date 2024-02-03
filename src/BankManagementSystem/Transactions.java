package BankManagementSystem;

import javax.swing.*;
import java.awt.*;

public class Transactions extends JFrame{
    Transactions() {
        //Set window title
        setTitle("Main Transaction");

        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel backgroundImage = new JLabel(image3);
        backgroundImage.setBounds(0, 0, 900, 900);
        add(backgroundImage);

        JLabel text = new JLabel("Please select your Transaction");


        //Get content pane for this frame and set background color
        //getContentPane().setBackground(new Color(243,241,241));
        //Set window size
        setSize(900, 900);
        //Set window visibly to true
        setVisible(true);
        //Set window position to middle of the screen
        setLocation(300, 0);
    }

    public static void main(String[] args) {
        new Transactions();
    }
}
