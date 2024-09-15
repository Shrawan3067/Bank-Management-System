package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
public class FastCast extends JFrame implements ActionListener{
    JButton b1, b2, b3, b4, b5, b6, back;
    String pin;
    FastCast(String pin) {
        
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1060,780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(250, 0, 1060, 780);
        add(i4);

        JLabel title = new JLabel("SELECT WITHDRAWL AMOUNT");
        title.setFont(new Font("System", Font.BOLD, 22));
        title.setBounds(250, 180, 355, 30);
        title.setForeground(Color.white);
        i4.add(title);

        b1 = new JButton("Rs. 100");
        b1.setBounds(230, 257, 150, 35);
        b1.setFont(new Font("Raleway", Font.BOLD, 16));
        b1.setBackground(new Color(12, 166, 6));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        i4.add(b1);
        
        b2 = new JButton("Rs. 500");
        b2.setBounds(450, 257, 150, 35);
        b2.setFont(new Font("Raleway", Font.BOLD, 16));
        b2.setBackground(new Color(12, 166, 6));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        i4.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setBounds(230, 301, 150, 35);
        b3.setFont(new Font("Raleway", Font.BOLD, 16));
        b3.setBackground(new Color(12, 166, 6));
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        i4.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setBounds(450, 301, 150, 35);
        b4.setFont(new Font("Raleway", Font.BOLD, 16));
        b4.setBackground(new Color(12, 166, 6));
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        i4.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setBounds(230, 347, 150, 35);
        b5.setFont(new Font("Raleway", Font.BOLD, 16));
        b5.setBackground(new Color(12, 166, 6));
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        i4.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setBounds(450, 347, 150, 35);
        b6.setFont(new Font("Raleway", Font.BOLD, 16));
        b6.setBackground(new Color(12, 166, 6));
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        i4.add(b6);
        
        back = new JButton("Back");
        back.setBounds(450, 392, 150, 35);
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
        if (ae.getSource() == back) {
            setVisible(false);
            new Atm(pin);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            Connn c = new Connn();
            Date date = new Date();
            try {
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                } 

                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                 }
                 c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                 JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

            } catch(Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
            new Atm(pin);
        }
    }
    public static void main(String[] args) {
        new FastCast("");
    }
}
