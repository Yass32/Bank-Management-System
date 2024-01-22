package BankManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


//Add ActionListener for handling action events "nextBtn" button click
public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fatherNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton nextBtn;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    SignupOne() {
        //Set window title
        setTitle("Personal Information");


        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        //Generates a random long value that is between 1000 and 9999 (inclusive) and ensure that the result is non-negative
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

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
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        //Create a label for father name field
        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Rale way", Font.BOLD, 20));
        fatherName.setBounds(100, 190, 200, 30);
        add(fatherName);

        //Create father name input text field
        fatherNameTextField = new JTextField();
        fatherNameTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        fatherNameTextField.setBounds(300, 190, 400, 30);
        add(fatherNameTextField);

        //Create a label for the date of birth field
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Rale way", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        //This third-party library creates component to allow users to pick a date
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);

        //Create a label for gender field
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Rale way", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        //Create radio button component for gender
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(new Color(243,241,241));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(new Color(243,241,241));
        add(female);

        //Group the radio buttons together using a ButtonGroup so that only one can be selected at a time
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        //Create a label for email field
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Rale way", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        //Create email input text field
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        //Create a label for marital status field
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Rale way", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        //Create radio button components for marital status
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(new Color(243,241,241));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(new Color(243,241,241));
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(new Color(243,241,241));
        add(other);

        //Group the radio buttons together using a ButtonGroup so that only one can be selected at a time
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        //Create a label for address field
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Rale way", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        //Create address input text field
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        //Create a label for city field
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Rale way", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        //Create city input text field
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        //Create a label for state field
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Rale way", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        //Create state input text field
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        //Create a label for Pin code field
        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Rale way", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        //Create pin input text field
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        //Create next button
        nextBtn = new JButton("Next");
        nextBtn.setBackground(Color.BLACK);
        nextBtn.setForeground(Color.WHITE);
        nextBtn.setFont(new Font("Rale way", Font.BOLD, 14));
        nextBtn.setBounds(620, 660, 80, 30);
        nextBtn.addActionListener(this);
        add(nextBtn);

        getContentPane().setBackground(new Color(243,241,241));
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fatherNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "male";
        }
        else if (female.isSelected()) {
            gender = "female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "married";
        }
        else if (unmarried.isSelected()) {
            marital = "unmarried";
        }
        else if (other.isSelected()) {
            marital = "other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required!");

            }
            else {
                Connect c = new Connect();
                String query = "INSERT INTO signup (formno, name, father_name, dob, gender, marital_status, address, city, state, pincode)" +
                                "VALUES ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);


            }
        } catch ( Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
