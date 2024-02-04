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
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(text);

        JButton deposit = new JButton("Deposit");
        deposit.setBounds(160, 415, 150, 30);
        backgroundImage.add(deposit);

        JButton fastCash = new JButton("Fast Cash");
        fastCash.setBounds(160, 450, 150, 30);
        backgroundImage.add(fastCash);

        JButton pinChange = new JButton("Pin Change");
        pinChange.setBounds(160, 485, 150, 30);
        backgroundImage.add(pinChange);

        JButton cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(362, 415, 150, 30);
        backgroundImage.add(cashWithdrawal);

        JButton miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(362, 450, 150, 30);
        backgroundImage.add(miniStatement);

        JButton balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(362, 485, 150, 30);
        backgroundImage.add(balanceEnquiry);

        JButton exit = new JButton("Exit");
        exit.setBounds(362, 520, 150, 30);
        backgroundImage.add(exit);


        //Get content pane for this frame and set background color
        //getContentPane().setBackground(new Color(243,241,241));
        //Set window size
        setSize(900, 900);
        //Set window visibly to true
        setVisible(true);
        //Set window position to middle of the screen
        setLocation(300, 0);
        //setUndecorated(true);
    }

    public static void main(String[] args) {
        new Transactions();
    }
}
