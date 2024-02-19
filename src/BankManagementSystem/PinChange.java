package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton change, back;
    JPasswordField pin1, pin2;
    String pinNo;
    PinChange(String pinNo){
        this.pinNo = pinNo;

        // Set window title
        setTitle("Pin Change");

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
        JLabel text = new JLabel("Enter your new 4 digit PIN");
        text.setBounds(240, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(text);

        JLabel newPin1 = new JLabel("New PIN:");
        newPin1.setBounds(160, 360, 700, 35);
        newPin1.setForeground(Color.WHITE);
        newPin1.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(newPin1);

        // Add text field for amount input
        pin1 = new JPasswordField();
        pin1.setBounds(320, 410, 170, 30);
        pin1.setForeground(Color.BLACK);
        pin1.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(pin1);

        // Add text label for user prompt
        JLabel newPin2 = new JLabel("Re-enter new PIN:");
        newPin2.setBounds(160, 410, 700, 35);
        newPin2.setForeground(Color.WHITE);
        newPin2.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(newPin2);

        // Add text field for amount input
        pin2 = new JPasswordField();
        pin2.setBounds(320, 360, 170, 30);
        pin2.setForeground(Color.BLACK);
        pin2.setFont(new Font("System", Font.BOLD, 16));
        backgroundImage.add(pin2);

        // Add back button
        back = new JButton("<-- Back");
        back.setBounds(160, 485, 150, 30);
        back.addActionListener(this);
        backgroundImage.add(back);

        // Add deposit button
        change = new JButton("Change");
        change.setBounds(362, 485, 150, 30);
        change.addActionListener(this);
        backgroundImage.add(change);



        // Set window size, visibility, and position
        setSize(900, 900);
        setVisible(true);
        setLocation(300, 0);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
        else {
            String newPin = pin1.getText();
            String reNewPin = pin2.getText();

            if (newPin.equals(reNewPin)) {

                Connect c = new Connect();
                try {
                    String query1 = "UPDATE login SET pinNumber = '"+newPin+"' WHERE pinNumber = '"+pinNo+"'  ";
                    String query2 = "UPDATE bank SET pinNumber = '"+newPin+"' WHERE pinNumber = '"+pinNo+"'  ";
                    String query3 = "UPDATE signupthree SET pinNumber = '"+newPin+"' WHERE pinNumber = '"+pinNo+"'  ";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);

                    pinNo = newPin;
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");

                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                }
                catch (Exception e) {
                    // Handle any exceptions that occur during the database operations
                    System.out.println(e);
                }



            }
            else {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
            }
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}


