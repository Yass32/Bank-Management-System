package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//JFrame is a class that represents a window in a graphical user interface.
//Login class inherits the properties of a JFrame, allowing you to create and customize a window for your application
//ActionListener is an interface used for handling action events, such as button clicks
public class Login extends JFrame implements ActionListener {
    //Global variables
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        //Set window title
        setTitle("Automated Teller Machine");

        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        //Image icon class loads an image file named "logo.jpg" from a directory named "icons." The ClassLoader is a mechanism in Java for dynamically loading classes and resources
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));

        //Get the Image object from the previously created ImageIcon(i1) then scaling the image to a size of 100x100 pixels using getScaledInstance
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        //Creating a new ImageIcon from the scaled Image object (i2)
        ImageIcon i3 = new ImageIcon(i2);

        //label will display the scaled image(i3)
        JLabel label = new JLabel(i3);

        //Setting the position(x, y) and size(width, height)of the JLabel
        label.setBounds(150, 10, 100, 100);

        //method used to add JLabel component to the JFrame container
        add(label);

        //Create welcome text label
        JLabel text = new JLabel("Welcome to ATM");

        //Change text font
        text.setFont((new Font("Onward", Font.BOLD, 38)));

        //Set the position of text close to the logo(label)
        text.setBounds(270, 40, 400, 40);

        //display text
        add(text);

        //Card Number Label
        JLabel cardNum = new JLabel("Card No:");
        cardNum.setFont((new Font("Rale way", Font.BOLD, 28)));
        cardNum.setBounds(120, 150, 150, 30);
        add(cardNum);

        //Create Card Number Input Text Field
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        //Pin number Label
        JLabel pinNum = new JLabel("PIN:");
        pinNum.setFont((new Font("Rale way", Font.BOLD, 28)));
        pinNum.setBounds(120, 220, 250, 30);
        add(pinNum);

        //Create PIN Input Text Field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        //Create log in button
        login = new JButton("LOG IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //Create button to clear text
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        //Create sign up button
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        //Get content pane for this frame and set background color
        getContentPane().setBackground(new Color(243,241,241));
        //Set window size
        setSize(800, 480);
        //Set window visibly to true
        setVisible(true);
        //Set window position to middle of the screen
        setLocation(350, 200);


    }

    //When login class implements ActionListener, it must provide an implementation for the actionPerformed method,
    // which is called when an action event occurs.
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == login) {
            Connect c = new Connect();
            String cardNo = cardTextField.getText();
            String pinNo = pinTextField.getText();
            String query = "SELECT * FROM login WHERE cardNumber = '"+cardNo+"' AND pinNumber = '"+pinNo+"'";

            try {
                // It checks if the ResultSet (rs) contains any rows using the next() method.
                // If there is at least one row, it means the login credentials are valid.
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Number");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}