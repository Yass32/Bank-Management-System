package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    JTextField amount;
    String pinNo;
    Deposit(String pinNo) {
        this.pinNo = pinNo;
        //Set window title
        setTitle("Deposit");

        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel backgroundImage = new JLabel(image3);
        backgroundImage.setBounds(0, 0, 900, 900);
        add(backgroundImage);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(text);

        amount = new JTextField();
        amount.setBounds(250, 360, 170, 30);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(amount);

        back = new JButton("<-- Back");
        back.setBounds(160, 485, 150, 30);
        back.addActionListener(this);
        backgroundImage.add(back);

        deposit = new JButton("Deposit");
        deposit.setBounds(362, 485, 150, 30);
        deposit.addActionListener(this);
        backgroundImage.add(deposit);



        //Set window size
        setSize(900, 900);
        //Set window visibly to true
        setVisible(true);
        //Set window position to middle of the screen
        setLocation(300, 0);
        //setUndecorated(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else {
                try {
                    Connect c = new Connect();
                    String query = "INSERT INTO bank (pinNumber, date, type, amount)" +
                            "VALUES ('"+pinNo+"', '"+date+"', 'Deposit', '"+number+"')";
                    // Execute the query
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$ " + number + " was Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
        else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
