package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton amount1, amount2, amount3, amount4, amount5, amount6, exit;
    String pinNo;
    FastCash( String pinNo) {
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

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(text);

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
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Connect c = new Connect();
            try {
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinNo+"' ");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
            setVisible(false);
            new Deposit(pinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

