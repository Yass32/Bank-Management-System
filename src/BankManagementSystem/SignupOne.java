package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
//import com.toedter.calendar.JCalender;



public class SignupOne  extends JFrame {

    SignupOne() {
        //Set window title
        //setTitle("Automated Teller Machine");


        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        //Generates a random long value that is between 1000 and 9999 (inclusive) and ensure that the result is non-negative
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        //Create a label for the form title
        JLabel formNum = new JLabel("APPLICATION FORM NO." + random);
        formNum.setFont(new Font("Rale way", Font.BOLD, 38));
        formNum.setBounds(140, 20, 600, 40);
        add(formNum);

        //Create a label for the form subtitle
        JLabel personalDetails = new JLabel("Personal Details");
        personalDetails.setFont(new Font("Rale way", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        //Create a label for the name field
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Rale way", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        //Create name input text field
        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        //Create a label for father name field
        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Rale way", Font.BOLD, 20));
        fatherName.setBounds(100, 190, 200, 30);
        add(fatherName);

        //Create father name input text field
        JTextField fatherNameTextField = new JTextField();
        fatherNameTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        fatherNameTextField.setBounds(300, 190, 400, 30);
        add(fatherNameTextField);

        //Create a label for the date of birth field
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Rale way", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        //Create a label for gender field
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Rale way", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        //Create a label for email field
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Rale way", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        //Create email input text field
        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        //Create a label for marital status field
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Rale way", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        //Create a label for address field
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Rale way", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        //Create address input text field
        JTextField addressTextField = new JTextField();
        addressTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        //Create a label for city field
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Rale way", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        //Create city input text field
        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        //Create a label for state field
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Rale way", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        //Create state input text field
        JTextField stateTextField = new JTextField();
        stateTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        //Create a label for Pin code field
        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Rale way", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        //Create pin input text field
        JTextField pinTextField = new JTextField();
        pinTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);



        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
