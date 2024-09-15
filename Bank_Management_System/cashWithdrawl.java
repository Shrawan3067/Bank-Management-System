package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class cashWithdrawl extends JFrame implements ActionListener {
    String pinno;
    JTextField textField;
    JButton deposit, back;
    cashWithdrawl(String pinno) {
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1060,780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(250, 0, 1060, 780);
        add(i4);

        JLabel title = new JLabel("Maximum withdrawal is RS. 25,000");
        title.setFont(new Font("Raleway", Font.BOLD, 20));
        title.setBounds(250, 180, 350, 30);
        title.setForeground(Color.white);
        i4.add(title);

        JLabel title2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        title2.setFont(new Font("Raleway", Font.BOLD, 16));
        title2.setBounds(285, 230, 350, 30);
        title2.setForeground(Color.white);
        i4.add(title2);

        textField = new JTextField();
        textField.setBounds(250, 280, 322, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 18));
        textField.setBackground(new Color(12, 166, 6));
        textField.setForeground(Color.white);
        i4.add(textField);


        deposit = new JButton("Withdraw");
        deposit.setBounds(455, 347, 150, 30);
        deposit.setFont(new Font("Raleway", Font.BOLD, 16));
        deposit.setBackground(new Color(12, 166, 6));
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        i4.add(deposit);

        back = new JButton("Back");
        back.setBounds(455, 390, 150, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBackground(new Color(12, 166, 6));
        back.setForeground(Color.white);
        back.addActionListener(this);
        i4.add(back);

        setLayout(null);
        setSize(1560, 820);
        setLocation(-10, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override 
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (textField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                Connn c = new Connn();
                ResultSet resultSet = c.statement.executeQuery("select * from bank where PIN = '"+pinno+"'");
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+pinno+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully!");
                setVisible(false);
                new Atm(pinno);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new cashWithdrawl("");
    }
}
