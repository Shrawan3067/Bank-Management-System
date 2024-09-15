package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class balanceEnquiry extends JFrame implements ActionListener{
    JLabel title2;
    JButton back;
    String pinno;
    balanceEnquiry(String pinno) {
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1060,780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(250, 0, 1060, 780);
        add(i4);

        JLabel title = new JLabel("Your Current Balance is Rs. ");
        title.setFont(new Font("Raleway", Font.BOLD, 20));
        title.setBounds(250, 180, 350, 30);
        title.setForeground(Color.white);
        i4.add(title);

        title2 = new JLabel();
        title2.setFont(new Font("Raleway", Font.BOLD, 16));
        title2.setBounds(285, 230, 350, 30);
        title2.setForeground(Color.white);
        i4.add(title2);

        back = new JButton("Back");
        back.setBounds(455, 390, 150, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBackground(new Color(12, 166, 6));
        back.setForeground(Color.white);
        back.addActionListener(this);
        i4.add(back);

        int balance = 0;
        try {
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where PIN = '"+pinno+"'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        title2.setText(""+balance);

        setLayout(null);
        setSize(1560, 820);
        setLocation(-10, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Atm(pinno);
    }
    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
