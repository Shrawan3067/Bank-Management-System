package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener{
    JButton signin, clear, signup;
    String pinn;
    JTextField cardField;
    JPasswordField pinnoField;
    
    Login(String pinn) {
        this.pinn = pinn;
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel ii4 = new JLabel(ii3);
        ii4.setBounds(0, 0, 200, 150);
        add(ii4);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Raleway", Font.BOLD, 38));
        text.setForeground(Color.white);
        text.setBounds(250, 50, 400, 50);
        add(text);
        
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setForeground(Color.white);
        cardno.setBounds(80, 180, 200, 30);
        add(cardno);

        cardField = new JTextField();
        cardField.setFont(new Font("Raleway", Font.BOLD, 20));
        cardField.setBounds(250, 180, 360, 30);
        add(cardField);

        JLabel pinno = new JLabel("Pin No: ");
        pinno.setFont(new Font("Raleway", Font.BOLD, 22));
        pinno.setForeground(Color.white);
        pinno.setBounds(80, 230, 200, 30);
        add(pinno);

        pinnoField = new JPasswordField();
        pinnoField.setFont(new Font("Raleway", Font.BOLD, 20));
        pinnoField.setBounds(250, 230, 360, 30);
        add(pinnoField);

        signin = new JButton("SIGN IN");
        signin.setFont(new Font("Raleway", Font.BOLD, 16));
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.setBounds(250, 280, 150, 30);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setFont(new Font("Raleway", Font.BOLD, 16));
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setBounds(460, 280, 150, 30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setFont(new Font("Raleway", Font.BOLD, 16));
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.setBounds(250, 320, 360, 30);
        signup.addActionListener(this);
        add(signup);

        ImageIcon card = new ImageIcon(ClassLoader.getSystemResource("Icons/visa.png"));
        Image card1 = card.getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT);
        ImageIcon card2 = new ImageIcon(card1);
        JLabel card3 = new JLabel(card2);
        card3.setBounds(40, 390, 50, 30);
        add(card3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/mainbg.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0, 0, 800, 480);
        add(i4);

        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800, 480);
        setLocation(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == signup) {
                new Signup1();
                setVisible(false);
            } else if (ae.getSource() == signin) {
                Connn c = new Connn();
                String cardn = cardField.getText();
                String pinn = pinnoField.getText();
                String q = "select * from login where CARD_NO = '"+cardn+"' and PIN = '"+pinn+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()) {
                    setVisible(false);
                    new Atm(pinn);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN!");
                }
            } else if (ae.getSource() == clear) {
                cardField.setText("");
                pinnoField.setText("");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login("");
    }
}


