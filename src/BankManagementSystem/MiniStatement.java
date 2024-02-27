package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinNo, card;
    MiniStatement(String pinNo) {
        this.pinNo = pinNo;

        // Set window title
        setTitle("Mini Statement");

        // Set layout manager to null for complete control over component positioning
        setLayout(null);

        // Add text label for user prompt
        JLabel text = new JLabel("African Bank");
        text.setBounds(200, 20, 700, 35);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 20));
        add(text);

        // Add text label for user prompt
        JLabel card = new JLabel();
        card.setBounds(150, 50, 700, 35);
        card.setBackground(Color.BLACK);
        card.setFont(new Font("System", Font.BOLD, 14));
        add(card);

        // Add text label for user prompt
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        //mini.setBackground(Color.BLACK);
        //mini.setFont(new Font("System", Font.BOLD, 14));
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);





        try {
            Connect c = new Connect();
            //int balance = 0;
            String query = "SELECT * FROM login WHERE pinNumber = '"+pinNo+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            Connect c = new Connect();
            int bal = 0;
            String query = "SELECT * FROM bank WHERE pinNumber = '"+pinNo+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br></html>");
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

        mini.setBounds(20, 140, 400, 200);


        getContentPane().setBackground(new Color(243,241,241));
        setSize(500, 700);
        setLocation(200, 10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
