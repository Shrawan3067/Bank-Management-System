package Bank_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;
import com.mysql.cj.protocol.Resultset;

public class miniStatement extends JFrame implements ActionListener {
    String pin;
    JButton button;
    miniStatement(String pin) {
        this.pin = pin;
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(550, 130);
        setLayout(null);


        JLabel l1 = new JLabel();
        l1.setBounds(20, 140, 400, 250);
        add(l1);

        JLabel l2 = new JLabel("Shrawan Kumar Sah");
        l2.setFont(new Font("System", Font.BOLD, 15));
        l2.setBounds(120, 20, 200, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 450, 300, 20);
        add(l4);

        try {
            Connn c = new Connn();
            ResultSet rs = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()) {
                l3.setText("Card Number: " + rs.getString("CARD_NO").substring(0,4)+"XXXXXXXX" + rs.getString("CARD_NO").substring(12));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Connn c = new Connn();
            ResultSet rs = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");

            JLabel dateLabel = new JLabel("DATE");
            dateLabel.setBounds(80, 110, 50, 25);
            add(dateLabel);

            JLabel typeLabel = new JLabel("TYPE");
            typeLabel.setBounds(200, 110, 50, 25);
            add(typeLabel);

            JLabel amountLabel = new JLabel("AMOUNT");
            amountLabel.setBounds(260, 110, 100, 25);
            add(amountLabel);

            while (rs.next()) {

                if (rs.getString("type").equals("Deposit")) {
                    l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                } else {
                    l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                }

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 

            l4.setText("Your Total Balance is Rs " + balance);


        } catch(Exception e) {
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        add(button);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Atm(pin);
    }

    public static void main(String[] args) {
        new miniStatement("");
    }
}