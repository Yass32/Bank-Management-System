package BankManagementSystem;

import javax.swing.*;
import java.awt.*;

public class MiniStatement extends JFrame {
    String pinNo, card;
    MiniStatement(String pinNo) {
        this.pinNo = pinNo;

        // Set window title
        setTitle("Mini Statement");

        // Set layout manager to null for complete control over component positioning
        setLayout(null);

        // Add text label for user prompt
        JLabel text = new JLabel("Yazak Bank");
        text.setBounds(220, 150, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        add(text);

        Connect c = new Connect();

        try {
            card = "SELECT cardNumber FROM login WHERE pinNumber = '"+pinNo+"' ";
            c.s.executeQuery(card);

            // Add text label for user prompt
            JLabel text1 = new JLabel("Card Number: " + card.substring(0,4) + "XXXXXXXX" + card.substring(card.length()-4));
            text1.setBounds(220, 320, 700, 35);
            text1.setForeground(Color.WHITE);
            text1.setFont(new Font("System", Font.BOLD, 16));
            add(text1);

            // Retrieve the user's transaction history from the database
            String query = "SELECT * FROM bank WHERE pinNumber = '"+pinNo+"' ORDER BY date DESC LIMIT 3 ";
            c.s.executeQuery(query);

            JLabel text2 = new JLabel(query);
            text2.setBounds(220, 350, 700, 35);
            text2.setForeground(Color.WHITE);
            text2.setFont(new Font("System", Font.BOLD, 16));
            add(text2);



        }
        catch (Exception e) {
            System.out.println(e);
        }

        // Add text label for user prompt
        JLabel text1 = new JLabel("Yazak Bank");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        add(text);


        getContentPane().setBackground(new Color(243,241,241));
        setSize(500, 700);
        setLocation(350, 10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
