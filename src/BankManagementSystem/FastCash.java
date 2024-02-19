package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton amount1, amount2, amount3, amount4, amount5, amount6, exit;
    String pinNo;
    FastCash( String pinNo) {
        this.pinNo = pinNo;
        //Set window title
        setTitle("Fast Cash");

        // Set layout manager to null for complete control over component positioning
        setLayout(null);

        // Load and set background image
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel backgroundImage = new JLabel(image3);
        backgroundImage.setBounds(0, 0, 900, 900);
        add(backgroundImage);

        // Add text label for user prompt
        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(230, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(text);

        // Add buttons for preset withdrawal amounts
        amount1 = new JButton("$20");
        amount1.setBounds(160, 415, 150, 30);
        amount1.addActionListener(this);
        backgroundImage.add(amount1);

        amount2 = new JButton("$50");
        amount2.setBounds(160, 450, 150, 30);
        amount2.addActionListener(this);
        backgroundImage.add(amount2);

        amount3 = new JButton("$100");
        amount3.setBounds(160, 485, 150, 30);
        amount3.addActionListener(this);
        backgroundImage.add(amount3);

        amount4 = new JButton("$150");
        amount4.setBounds(362, 415, 150, 30);
        amount4.addActionListener(this);
        backgroundImage.add(amount4);

        amount5 = new JButton("$200");
        amount5.setBounds(362, 450, 150, 30);
        amount5.addActionListener(this);
        backgroundImage.add(amount5);

        amount6 = new JButton("$250");
        amount6.setBounds(362, 485, 150, 30);
        amount6.addActionListener(this);
        backgroundImage.add(amount6);

        exit = new JButton("<- Back");
        exit.setBounds(362, 520, 150, 30);
        exit.addActionListener(this);
        backgroundImage.add(exit);

        //Set window size, visibility and size
        setSize(900, 900);
        setVisible(true);
        setLocation(300, 0);
    }

    // Handles button clicks and performs fast withdrawal operations.
    public void actionPerformed(ActionEvent ae) {
        // If the user clicked the exit button Hide the FastCash window and show the Transactions window
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }

        // If the source is not the exit button, it assumes it's one of the fast cash buttons
        else {
            // The withdrawal amount is extracted from the button text by removing the first character ("$").
            String amount = ((JButton)ae.getSource()).getText().substring(1);

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

                // If the available balance is less than the requested withdrawal amount, an error message is shown, and the method exits
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Get the current date and time
                Date date = new Date();

                // Construct the SQL query to insert the withdrawal transaction into the database
                String query = "INSERT INTO bank (pinNumber, date, type, amount)" +
                        "VALUES ('"+pinNo+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "$" + amount + " was successfully debited.");

                // Hide the FastCash window and show the Transactions window
                setVisible(false);
                new Transactions(pinNo).setVisible(true);
            }
            catch (Exception e) {
                // Handle any exceptions that occur during the database operations
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

