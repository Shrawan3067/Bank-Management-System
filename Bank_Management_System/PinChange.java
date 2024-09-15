package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PinChange extends JFrame implements ActionListener{
    JButton change, back;
    JPasswordField p1, p2;
    String pin;
    PinChange(String pin) {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1060,780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(250, 0, 1060, 780);
        add(i4);

        this.pin = pin;

        JLabel title = new JLabel("CHANGE YOUR PIN");
        title.setFont(new Font("System", Font.BOLD, 17));
        title.setBounds(340, 180, 350, 30);
        title.setForeground(Color.white);
        i4.add(title);

        JLabel title2 = new JLabel("New PIN:");
        title2.setFont(new Font("System", Font.BOLD, 17));
        title2.setBounds(250, 230, 150, 25);
        title2.setForeground(Color.white);
        i4.add(title2);

        p1 = new JPasswordField();
        p1.setBounds(410, 230, 160, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 18));
        p1.setBackground(new Color(12, 166, 6));
        p1.setForeground(Color.white);
        i4.add(p1);

        JLabel title3 = new JLabel("Confirm New PIN:");
        title3.setFont(new Font("System", Font.BOLD, 17));
        title3.setBounds(250, 265, 150, 25);
        title3.setForeground(Color.white);
        i4.add(title3);

        p2 = new JPasswordField();
        p2.setBounds(410, 265, 160, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 18));
        p2.setBackground(new Color(12, 166, 6));
        p2.setForeground(Color.white);
        i4.add(p2);

        change = new JButton("CHANGE");
        change.setBounds(455, 345, 150, 30);
        change.setFont(new Font("Raleway", Font.BOLD, 15));
        change.setBackground(new Color(12, 166, 6));
        change.setForeground(Color.white);
        change.addActionListener(this);
        i4.add(change);

        back = new JButton("BACK");
        back.setBounds(455, 385, 150, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
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
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match!");
                return;
            }
            if (ae.getSource() == change) {
                if (p1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (p2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Confirm New PIN");
                }

                Connn c = new Connn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signup3 set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully!");
                setVisible(false);
                new Login(pin);

            } else if(ae.getSource() == back) {
                new Atm(pin);
                setVisible(false);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
