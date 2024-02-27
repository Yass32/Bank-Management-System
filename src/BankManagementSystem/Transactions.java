package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, fastCash, pinChange, cashWithdrawal, miniStatement, balanceEnquiry, exit;
    String pinNo;
    Transactions( String pinNo) {
        this.pinNo = pinNo;
        //Set window title
        setTitle("Main Transactions");

        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel backgroundImage = new JLabel(image3);
        backgroundImage.setBounds(0, 0, 900, 900);
        add(backgroundImage);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(160, 415, 150, 30);
        deposit.addActionListener(this);
        backgroundImage.add(deposit);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(160, 450, 150, 30);
        fastCash.addActionListener(this);
        backgroundImage.add(fastCash);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(160, 485, 150, 30);
        pinChange.addActionListener(this);
        backgroundImage.add(pinChange);

        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(362, 415, 150, 30);
        cashWithdrawal.addActionListener(this);
        backgroundImage.add(cashWithdrawal);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(362, 450, 150, 30);
        miniStatement.addActionListener(this);
        backgroundImage.add(miniStatement);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(362, 485, 150, 30);
        balanceEnquiry.addActionListener(this);
        backgroundImage.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(362, 520, 150, 30);
        exit.addActionListener(this);
        backgroundImage.add(exit);


        //Set window size
        setSize(900, 900);
        //Set window visibly to true
        setVisible(true);
        //Set window position to middle of the screen
        setLocation(300, 0);
        //setUndecorated(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        }
        else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNo).setVisible(true);
        }
        else if (ae.getSource() == cashWithdrawal) {
            setVisible(false);
            new Withdrawal(pinNo).setVisible(true);
        }
        else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNo).setVisible(true);
        }
        else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNo).setVisible(true);
        }
        else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNo).setVisible(true);
        }
        else if (ae.getSource() == miniStatement) {
            setVisible(false);
            new MiniStatement(pinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
