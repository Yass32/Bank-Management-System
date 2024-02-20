package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton exit;
    String pinNo, balance;
    BalanceEnquiry(String pinNo){
        this.pinNo = pinNo;

        // Set window title
        setTitle("Balance Enquiry");

        // Set layout manager to null for complete control over component positioning
        setLayout(null);

        //Load and set background image
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel backgroundImage = new JLabel(image3);
        backgroundImage.setBounds(0, 0, 900, 900);
        add(backgroundImage);



        // Add text label for user prompt
        JLabel text = new JLabel("Your current balance is $ " + balance);
        text.setBounds(240, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(text);

        exit = new JButton("<- Back");
        exit.setBounds(362, 520, 150, 30);
        //exit.addActionListener(this);
        backgroundImage.add(exit);

        // Set window size, visibility, and position
        setSize(900, 900);
        setVisible(true);
        setLocation(300, 0);



    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
        else {
            // Create a database connection
            Connect c = new Connect();

            try {
                // Retrieve the user's transaction history from the database
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinNumber = '"+pinNo+"' ");
                int balance = 0;

                // The user's current balance is calculated by iterating through the results and summing up deposits and subtracting withdrawals
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch (Exception e) {
                // Handle any exceptions that occur during the database operations
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
