package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Atm extends JFrame implements ActionListener{
    JButton deposit, fastcash, pinchange, cashWithdrawl, miniStatement, balanceEnquiry, exit;
    String pinno;
    Atm(String pinno) {

        this.pinno = pinno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1060,780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(250, 0, 1060, 780);
        add(i4);


        JLabel title = new JLabel("Please Select Your Transaction");
        title.setFont(new Font("System", Font.BOLD, 20));
        title.setBounds(260, 180, 350, 30);
        title.setForeground(Color.white);
        i4.add(title);

        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Arial", Font.BOLD, 11));
        deposit.setBounds(230, 260, 150, 30);
        deposit.setBackground(new Color(12, 166, 6));
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        i4.add(deposit);

        fastcash = new JButton("FAST CASH");
        fastcash.setFont(new Font("Arial", Font.BOLD, 11));
        fastcash.setBounds(230, 305, 150, 30);
        fastcash.setBackground(new Color(12, 166, 6));
        fastcash.setForeground(Color.white);
        fastcash.addActionListener(this);
        i4.add(fastcash);

        pinchange = new JButton("PIN CHANGE");
        pinchange.setFont(new Font("Arial", Font.BOLD, 11));
        pinchange.setBounds(230, 350, 150, 30);
        pinchange.setBackground(new Color(12, 166, 6));
        pinchange.setForeground(Color.white);
        pinchange.addActionListener(this);
        i4.add(pinchange);

        cashWithdrawl = new JButton("CASH WITHDRAWL");
        cashWithdrawl.setFont(new Font("Arial", Font.BOLD, 11));
        cashWithdrawl.setBounds(450, 260, 150, 30);
        cashWithdrawl.setBackground(new Color(12, 166, 6));
        cashWithdrawl.setForeground(Color.white);
        cashWithdrawl.addActionListener(this);
        i4.add(cashWithdrawl);

        miniStatement = new JButton("MINI STATEMENT");
        miniStatement.setFont(new Font("Arial", Font.BOLD, 11));
        miniStatement.setBounds(450, 305, 150, 30);
        miniStatement.setBackground(new Color(12, 166, 6));
        miniStatement.setForeground(Color.white);
        miniStatement.addActionListener(this);
        i4.add(miniStatement);

        balanceEnquiry = new JButton("BALANCE ENQUIRY");
        balanceEnquiry.setFont(new Font("Arial", Font.BOLD, 11));
        balanceEnquiry.setBounds(450, 350, 150, 30);
        balanceEnquiry.setBackground(new Color(12, 166, 6));
        balanceEnquiry.setForeground(Color.white);
        balanceEnquiry.addActionListener(this);
        i4.add(balanceEnquiry);

        exit = new JButton("EXIT");
        exit.setFont(new Font("Arial", Font.BOLD, 11));
        exit.setBounds(450, 395, 150, 30);
        exit.setBackground(new Color(12, 166, 6));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        i4.add(exit);


        setLayout(null);
        setSize(1560, 820);
        setLocation(-10, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            new Deposit(pinno);
            setVisible(false);
        } else if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == fastcash) {
            new FastCast(pinno);
            setVisible(false);
        } else if (e.getSource() == pinchange) {
            new PinChange(pinno);
            setVisible(false);
        } else if (e.getSource() == cashWithdrawl) {
            new cashWithdrawl(pinno);
            setVisible(false);
        } else if (e.getSource() == miniStatement) {
            new miniStatement(pinno);
            setVisible(false);
        } else if (e.getSource() == balanceEnquiry) {
             new balanceEnquiry(pinno);
             setVisible(false);
        } 
    }
    public static void main(String[] args) {
        new Atm("");
    }
}
