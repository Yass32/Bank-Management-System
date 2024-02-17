package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

// The Deposit class allows users to deposit money into their bank account.
public class Deposit extends JFrame implements ActionListener {
    JButton deposit, back;
    JTextField amount;
    String pinNo;
    Deposit(String pinNo) {
        this.pinNo = pinNo;
        // Set window title
        setTitle("Deposit");

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
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(text);

        // Add text field for amount input
        amount = new JTextField();
        amount.setBounds(250, 360, 170, 30);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(amount);

        // Add back button
        back = new JButton("<-- Back");
        back.setBounds(160, 485, 150, 30);
        back.addActionListener(this);
        backgroundImage.add(back);

        // Add deposit button
        deposit = new JButton("Deposit");
        deposit.setBounds(362, 485, 150, 30);
        deposit.addActionListener(this);
        backgroundImage.add(deposit);



        // Set window size, visibility, and position
        setSize(900, 900);
        setVisible(true);
        setLocation(300, 0);

    }

    // @param ae The ActionEvent object containing information about the button click.
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            // Get deposit amount and current date
            String number = amount.getText();
            Date date = new Date();

            // Check if amount is empty, show error if so
            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else {
                try {
                    // Connect to database and insert transaction record
                    Connect c = new Connect();
                    String query = "INSERT INTO bank (pinNumber, date, type, amount)" +
                            "VALUES ('"+pinNo+"', '"+date+"', 'Deposit', '"+number+"')";
                    c.s.executeUpdate(query);

                    // Show success message and switch to Transaction Window
                    JOptionPane.showMessageDialog(null, "$ " + number + " was Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                }
                catch (Exception e) {
                    // Log exception to console
                    System.out.println(e);
                }
            }
        }
        else if (ae.getSource() == back) {
            // Switch to Transactions window
            setVisible(false);
            new Transactions(pinNo).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }

    /*
    CREATE TABLE bank (
    pinNumber TEXT,
    date TEXT,
    type TEXT,
    amount TEXT
    );
    */
}
