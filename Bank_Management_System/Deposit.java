package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.CollationElementIterator;
import java.util.*;
public class Deposit extends JFrame implements ActionListener {
    String pinno;
    JTextField textField;
    JButton deposit, back;
    Deposit(String pinno) {
        this.pinno = pinno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1060,780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(250, 0, 1060, 780);
        add(i4);

        JLabel title = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        title.setFont(new Font("System", Font.BOLD, 17));
        title.setBounds(248, 200, 350, 30);
        title.setForeground(Color.white);
        i4.add(title);

        textField = new JTextField();
        textField.setBounds(238, 258, 362, 30);
        textField.setFont(new Font("Raleway", Font.BOLD, 18));
        textField.setBackground(new Color(12, 166, 6));
        textField.setForeground(Color.white);
        i4.add(textField);


        deposit = new JButton("Deposit");
        deposit.setBounds(450, 347, 150, 30);
        deposit.setFont(new Font("Raleway", Font.BOLD, 16));
        deposit.setBackground(new Color(12, 166, 6));
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        i4.add(deposit);

        back = new JButton("Back");
        back.setBounds(450, 391, 150, 30);
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
        String pinn = pinno;
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (ae.getSource() == deposit) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit!");
                } else {
                    Connn c = new Connn();
                    String q = "insert into bank values('"+pinn+"', '"+date+"', 'Deposit', '"+amount+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " deposited successfully!");
                    setVisible(false);
                    new Atm(pinn);
                }
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Atm(pinn);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}