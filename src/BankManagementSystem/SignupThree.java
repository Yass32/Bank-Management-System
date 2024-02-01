package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAccount, fixedAccount, currentAccount, recurringAccount;
    JCheckBox atmCard, internetBank, mobileBank, alerts, checkBook, eStatement, confirmation;
    JButton submitBtn, cancelBtn;
    SignupThree() {
        //Set window title
        setTitle("Account Information");

        //method sets the layout manager of a container to null, you have complete control over the size and position of each component within the container
        setLayout(null);

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Rale way", Font.BOLD, 22));
        accountDetails.setBounds(290, 80, 400, 30);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Rale way", Font.BOLD, 20));
        accountType.setBounds(100, 140, 150, 30);
        add(accountType);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Rale way", Font.BOLD, 14));
        savingAccount.setBounds(100, 180, 170, 30);
        savingAccount.setBackground(new Color(243,241,241));
        add(savingAccount);

        fixedAccount = new JRadioButton("Fixed Deposit Account");
        fixedAccount.setFont(new Font("Rale way", Font.BOLD, 14));
        fixedAccount.setBounds(300, 180, 200, 30);
        fixedAccount.setBackground(new Color(243,241,241));
        add(fixedAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Rale way", Font.BOLD, 14));
        currentAccount.setBounds(100, 220, 170, 30);
        currentAccount.setBackground(new Color(243,241,241));
        add(currentAccount);

        recurringAccount = new JRadioButton("Recurring Deposit Account");
        recurringAccount.setFont(new Font("Rale way", Font.BOLD, 14));
        recurringAccount.setBounds(300, 220, 220, 30);
        recurringAccount.setBackground(new Color(243,241,241));
        add(recurringAccount);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(savingAccount);
        accountGroup.add(fixedAccount);
        accountGroup.add(currentAccount);
        accountGroup.add(recurringAccount);

        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Rale way", Font.BOLD, 20));
        cardNumber.setBounds(100, 270, 150, 30);
        add(cardNumber);

        JLabel cardNo = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNo.setFont(new Font("Rale way", Font.BOLD, 20));
        cardNo.setBounds(300, 270, 300, 30);
        add(cardNo);

        JLabel cardSub = new JLabel("Your 16 Digit Card Number");
        cardSub.setFont(new Font("Rale way", Font.ITALIC, 12));
        cardSub.setBounds(100, 290, 170, 30);
        add(cardSub);

        JLabel pinNumber = new JLabel("PIN:");
        pinNumber.setFont(new Font("Rale way", Font.BOLD, 20));
        pinNumber.setBounds(100, 340, 150, 30);
        add(pinNumber);

        JLabel pinNo = new JLabel("XXXX");
        pinNo.setFont(new Font("Rale way", Font.BOLD, 20));
        pinNo.setBounds(300, 340, 150, 30);
        add(pinNo);

        JLabel pinSub = new JLabel("Your 4 Digit Password");
        pinSub.setFont(new Font("Rale way", Font.ITALIC, 12));
        pinSub.setBounds(100, 360, 170, 30);
        add(pinSub);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Rale way", Font.BOLD, 20));
        services.setBounds(100, 410, 220, 30);
        add(services);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setFont(new Font("Rale way", Font.BOLD, 14));
        atmCard.setBounds(100, 450, 170, 30);
        atmCard.setBackground(new Color(243,241,241));
        add(atmCard);

        internetBank = new JCheckBox("Internet Banking");
        internetBank.setFont(new Font("Rale way", Font.BOLD, 14));
        internetBank.setBounds(300, 450, 170, 30);
        internetBank.setBackground(new Color(243,241,241));
        add(internetBank);

        mobileBank = new JCheckBox("Mobile Banking");
        mobileBank.setFont(new Font("Rale way", Font.BOLD, 14));
        mobileBank.setBounds(100, 490, 200, 30);
        mobileBank.setBackground(new Color(243,241,241));
        add(mobileBank);

        alerts = new JCheckBox("Email & SMS Alerts");
        alerts.setFont(new Font("Rale way", Font.BOLD, 14));
        alerts.setBounds(300, 490, 200, 30);
        alerts.setBackground(new Color(243,241,241));
        add(alerts);

        checkBook = new JCheckBox("Check Book");
        checkBook.setFont(new Font("Rale way", Font.BOLD, 14));
        checkBook.setBounds(100, 530, 200, 30);
        checkBook.setBackground(new Color(243,241,241));
        add(checkBook);

        eStatement = new JCheckBox("E - Statement");
        eStatement.setFont(new Font("Rale way", Font.BOLD, 14));
        eStatement.setBounds(300, 530, 200, 30);
        eStatement.setBackground(new Color(243,241,241));
        add(eStatement);

        confirmation = new JCheckBox("I hereby declare that the information entered above are correct to the best of my knowledge");
        confirmation.setFont(new Font("Rale way", Font.ITALIC, 14));
        confirmation.setBounds(100, 620, 700, 30);
        confirmation.setBackground(new Color(243,241,241));
        add(confirmation);

        submitBtn = new JButton("Submit");
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFont(new Font("Rale way", Font.BOLD, 14));
        submitBtn.setBounds(250, 660, 100, 30);
        submitBtn.addActionListener(this);
        add(submitBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFont(new Font("Rale way", Font.BOLD, 14));
        cancelBtn.setBounds(450, 660, 100, 30);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        getContentPane().setBackground(new Color(243,241,241));
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitBtn) {

        }
        else if (ae.getSource() == cancelBtn) {

        }

    }

    public static void main(String[] args) {
        new SignupThree();
    }
}
