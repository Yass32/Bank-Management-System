package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener {

    String formno;
    JComboBox<String> religionDropDown, categoryDropDown, incomeDropDown, educationDropDown, occupationDropDown;
    JTextField sSecurityTextField;
    JRadioButton yes, no, yes1, no1;
    JButton nextBtn;


    SignupTwo(String formno) {
        //Set window title
        setTitle("Personal Information 2");

        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        this.formno = formno;

        /*

        //Create a label for the form title
        JLabel formNum = new JLabel("APPLICATION FORM NO." + this.formno);
        formNum.setFont(new Font("Rale way", Font.BOLD, 38));
        formNum.setBounds(140, 20, 600, 40);
        add(formNum);

         */

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Rale way", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Rale way", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        //Create name input text field
        String[] religionOptions = {"Islam", "Christianity", "Judaism"};
        religionDropDown = new JComboBox<>(religionOptions);
        religionDropDown.setFont(new Font("Rale way", Font.BOLD, 14));
        religionDropDown.setBackground(Color.WHITE);
        religionDropDown.setBounds(300, 140, 400, 30);
        add(religionDropDown);

        //Create a label for father name field
        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Rale way", Font.BOLD, 20));
        Category.setBounds(100, 190, 200, 30);
        add(Category);

        //Create father name input text field
        String[] categoryOptions = {"Savings Account", "Checking Account", "Business Account"};
        categoryDropDown = new JComboBox<>(categoryOptions);
        categoryDropDown.setFont(new Font("Rale way", Font.BOLD, 14));
        categoryDropDown.setBackground(Color.WHITE);
        categoryDropDown.setBounds(300, 190, 400, 30);
        add(categoryDropDown);

        //Create a label for the date of birth field
        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Rale way", Font.BOLD, 20));
        Income.setBounds(100, 240, 200, 30);
        add(Income);

        //This third-party library creates component to allow users to pick a date
        String[] incomeOptions = {"Null", "<50,000", "<100,000"};
        incomeDropDown = new JComboBox<>(incomeOptions);
        incomeDropDown.setFont(new Font("Rale way", Font.BOLD, 14));
        incomeDropDown.setBackground(Color.WHITE);
        incomeDropDown.setBounds(300, 240, 400, 30);
        add(incomeDropDown);

        //Create a label for gender field
        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Rale way", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        //Create radio button component for gender
        String[] educationOptions = {"High School", "Undergraduate", "Graduate"};
        educationDropDown = new JComboBox<>(educationOptions);
        educationDropDown.setFont(new Font("Rale way", Font.BOLD, 14));
        educationDropDown.setBackground(Color.WHITE);
        educationDropDown.setBounds(300, 290, 400, 30);
        add(educationDropDown);

        //Create a label for email field
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Rale way", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);

        //Create email input text field
        String[] occupationOptions = {"Student", "Employed", "Unemployed"};
        occupationDropDown = new JComboBox<>(occupationOptions);
        occupationDropDown.setFont(new Font("Rale way", Font.BOLD, 14));
        occupationDropDown.setBackground(Color.WHITE);
        occupationDropDown.setBounds(300, 340, 400, 30);
        add(occupationDropDown);

        //Create a label for marital status field
        JLabel socialSecurity = new JLabel("Social Number:");
        socialSecurity.setFont(new Font("Rale way", Font.BOLD, 20));
        socialSecurity.setBounds(100, 390, 200, 30);
        add(socialSecurity);

        sSecurityTextField = new JTextField();
        sSecurityTextField.setFont(new Font("Rale way", Font.BOLD, 14));
        sSecurityTextField.setBackground(Color.WHITE);
        sSecurityTextField.setBounds(300, 390, 400, 30);
        add(sSecurityTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Rale way", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 440, 200, 30);
        add(seniorCitizen);

        yes = new JRadioButton("Yes");
        yes.setFont(new Font("Rale way", Font.BOLD, 14));
        yes.setBounds(300, 440, 60, 30);
        yes.setBackground(new Color(243,241,241));
        add(yes);

        no = new JRadioButton("No");
        no.setFont(new Font("Rale way", Font.BOLD, 14));
        no.setBounds(450, 440, 120, 30);
        no.setBackground(new Color(243,241,241));
        add(no);

        //Group the radio buttons together using a ButtonGroup so that only one can be selected at a time
        ButtonGroup sCitizenGroup = new ButtonGroup();
        sCitizenGroup.add(yes);
        sCitizenGroup.add(no);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Rale way", Font.BOLD, 20));
        existingAccount.setBounds(100, 490, 200, 30);
        add(existingAccount);

        yes1 = new JRadioButton("Yes");
        yes1.setFont(new Font("Rale way", Font.BOLD, 14));
        yes1.setBounds(300, 490, 60, 30);
        yes1.setBackground(new Color(243,241,241));
        add(yes1);

        no1 = new JRadioButton("No");
        no1.setFont(new Font("Rale way", Font.BOLD, 14));
        no1.setBounds(450, 490, 120, 30);
        no1.setBackground(new Color(243,241,241));
        add(no1);

        ButtonGroup eAGroup = new ButtonGroup();
        eAGroup.add(yes1);
        eAGroup.add(no1);

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
        String religion = (String) religionDropDown.getSelectedItem();
        String category =  (String) categoryDropDown.getSelectedItem();
        String income =  (String) incomeDropDown.getSelectedItem();
        String education =  (String) educationDropDown.getSelectedItem();
        String occupation =  (String) occupationDropDown.getSelectedItem();
        String socialNum =  sSecurityTextField.getText();
        String seniorCitizen = null;
        if (yes.isSelected()) {
            seniorCitizen = "yes";
        }
        else if (no.isSelected()) {
            seniorCitizen = "no";
        }
        String existAccount = null;
        if (yes1.isSelected()) {
            existAccount = "yes";
        }
        else if (no1.isSelected()) {
            existAccount = "no";
        }

        try {
            // Establish a database connection
            Connect c = new Connect();
            // Construct and execute the SQL query to insert data into the 'signuptwo' table
            String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, socialNum, seniorCitizen, existAccount)" +
                    "VALUES ('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+socialNum+"', '"+seniorCitizen+"', '"+existAccount+"')";
            // Execute the query
            c.s.executeUpdate(query);

            //Sign up 3 object Go to next page
            setVisible(false);
            new SignupThree(formno).setVisible(true);


        }
        catch (Exception e) {
            System.out.println(e);
        }
    }



    public static void main(String[] args) {
        new SignupTwo("").setVisible(true);
    }

    /*
    * CREATE TABLE signuptwo (
    formno TEXT PRIMARY,
    religion TEXT,
    category TEXT,
    income TEXT,
    education TEXT,
    occupation TEXT,
    socialNum TEXT,
    seniorCitizen TEXT,
    existAccount TEXT
)*/
}
