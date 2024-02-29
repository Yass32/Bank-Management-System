package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

//This class represents the Mini Statement window in the ATM system.
//It displays the user's card number (partially masked), recent transactions, and current balance.

public class MiniStatement extends JFrame {
    String pinNo;
    MiniStatement(String pinNo) {
        this.pinNo = pinNo;

        // Set window title
        setTitle("Mini Statement");

        // Set layout manager to null for complete control over component positioning
        setLayout(null);

        // Add text label for bank name
        JLabel text = new JLabel("African Bank");
        text.setBounds(190, 20, 700, 35);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 20));
        add(text);

        // Add text label for card number (partially masked)
        JLabel card = new JLabel();
        card.setBounds(20, 70, 700, 35);
        card.setBackground(Color.BLACK);
        card.setFont(new Font("System", Font.BOLD, 14));
        add(card);

        // Add text label for displaying recent transactions
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        mini.setBackground(Color.BLACK);
        mini.setFont(new Font("System", Font.BOLD, 14));
        add(mini);

        // Add text label for current balance
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        balance.setBackground(Color.BLACK);
        balance.setFont(new Font("System", Font.BOLD, 14));
        add(balance);



        //Connect to database and retrieve card number (partially masked)
        try {
            Connect c = new Connect();
            String query = "SELECT * FROM login WHERE pinNumber = '"+pinNo+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                String fullCardNumber = rs.getString("cardNumber");
                // Mask the middle digits while displaying first and last 4 digits
                card.setText("Card Number: " + fullCardNumber.substring(0, 4) + "XXXXXXXX" + fullCardNumber.substring(12));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        // Connect to database and retrieve transactions and calculate balance
        try {
            Connect c = new Connect();
            int bal = 0;
            String query = "SELECT * FROM bank WHERE pinNumber = '"+pinNo+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                // Build the transaction details string in HTML format for better formatting
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                // The user's current balance is calculated by iterating through the results and summing up deposits and subtracting withdrawals
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is $ " + bal);
        }
        catch (Exception e) {
            System.out.println(e);
        }


        getContentPane().setBackground(new Color(243,241,241));
        setSize(500, 700);
        setLocation(200, 10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
