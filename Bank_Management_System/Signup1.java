package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;
import java.sql.*;
public class Signup1 extends JFrame implements ActionListener{
    JButton next, prev;
    JTextField nameField, fnameField, emailField, addressField, cityField, stateField, pincodeField;
    JDateChooser dobChooser;
    JRadioButton male, female, other, married, unmarried, others;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);
    Signup1() {
        
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel ii4 = new JLabel(ii3);
        ii4.setBounds(0, 0, 200, 150);
        add(ii4);

        JLabel text = new JLabel("APPLICATION FORM NO :" + first);
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        text.setForeground(Color.black);
        text.setBounds(180, 35, 480, 50);
        add(text);
        
        JLabel details = new JLabel("Page 1 : Personal Details ");
        details.setFont(new Font("Raleway", Font.BOLD, 22));
        details.setForeground(Color.black);
        details.setBounds(250,95, 300, 30);
        add(details);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setForeground(Color.black);
        name.setBounds(50, 150, 200, 30);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.PLAIN, 16));
        nameField.setBounds(250, 150, 360, 30);
        add(nameField);
        
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setForeground(Color.black);
        fname.setBounds(50, 200, 200, 30);
        add(fname);

        fnameField = new JTextField();
        fnameField.setFont(new Font("Raleway", Font.PLAIN, 16));
        fnameField.setBounds(250, 200, 360, 30);
        add(fnameField);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setForeground(Color.black);
        gender.setBounds(50, 250, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        male.setBounds(250, 250, 100, 30);
        male.setBackground(new Color(255, 150, 255));
        male.setForeground(Color.black);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        female.setBounds(380, 250, 100, 30);
        female.setBackground(new Color(255, 150, 255));
        female.setForeground(Color.black);
        add(female);

        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.BOLD, 15));
        other.setBounds(510, 250, 100, 30);
        other.setBackground(new Color(255, 150, 255));
        other.setForeground(Color.black);
        add(other);

        ButtonGroup gbutton = new ButtonGroup();
        gbutton.add(male);
        gbutton.add(female);
        gbutton.add(other);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setForeground(Color.black);
        dob.setBounds(50, 300, 200, 30);
        add(dob);

        dobChooser = new JDateChooser();
        dobChooser.setFont(new Font("Raleway", Font.PLAIN, 16));
        dobChooser.setBounds(250, 300, 360, 30);
        add(dobChooser);

        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setForeground(Color.black);
        email.setBounds(50, 350, 200, 30);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.PLAIN, 16));
        emailField.setBounds(250, 350, 360, 30);
        add(emailField);

        JLabel marrital = new JLabel("Marrital Status : ");
        marrital.setFont(new Font("Raleway", Font.BOLD, 18));
        marrital.setForeground(Color.black);
        marrital.setBounds(50, 400, 200, 30);
        add(marrital);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 15));
        married.setBounds(250, 400, 100, 30);
        married.setBackground(new Color(255, 150, 255));
        married.setForeground(Color.black);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 15));
        unmarried.setBounds(370, 400, 120, 30);
        unmarried.setBackground(new Color(255, 150, 255));
        unmarried.setForeground(Color.black);
        add(unmarried);

        others = new JRadioButton("Other");
        others.setFont(new Font("Raleway", Font.BOLD, 15));
        others.setBounds(510, 400, 100, 30);
        others.setBackground(new Color(255, 150, 255));
        others.setForeground(Color.black);
        add(others);

        ButtonGroup mbutton = new ButtonGroup();
        mbutton.add(married);
        mbutton.add(unmarried);
        mbutton.add(others);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setForeground(Color.black);
        address.setBounds(50, 450, 200, 30);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addressField.setBounds(250, 450, 360, 30);
        add(addressField);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setForeground(Color.black);
        city.setBounds(50, 500, 200, 30);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.PLAIN, 16));
        cityField.setBounds(250, 500, 360, 30);
        add(cityField);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setForeground(Color.black);
        state.setBounds(50, 550, 200, 30);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.PLAIN, 16));
        stateField.setBounds(250, 550, 360, 30);
        add(stateField);

        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setForeground(Color.black);
        pincode.setBounds(50, 600, 200, 30);
        add(pincode);

        pincodeField = new JTextField();
        pincodeField.setFont(new Font("Raleway", Font.PLAIN, 16));
        pincodeField.setBounds(250, 600, 360, 30);
        add(pincodeField);

        prev = new JButton("PREV");
        prev.setFont(new Font("Raleway", Font.BOLD, 16));
        prev.setBackground(Color.black);
        prev.setForeground(Color.white);
        prev.setBounds(50, 660, 100, 30);
        prev.addActionListener(this);
        add(prev);

        next = new JButton("NEXT");
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(510, 660, 100, 30);
        next.addActionListener(this);
        add(next);

        setTitle("SIGN UP");
        setLayout(null);
        getContentPane().setBackground(new Color(255, 150, 255));
        setSize(700, 750);
        setLocation(400, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            String formno = first;
            String nameText = nameField.getText();
            String fnameText = fnameField.getText();
            String dobText = ((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();
            String genderText = null;

            if (male.isSelected()) {
                genderText = "Male";
            } else if (female.isSelected()) {
                genderText = "Female";
            } else if (other.isSelected()) {
                genderText = "Other";
            }

            String emailText = emailField.getText();
            String marritalText = null;

            if (married.isSelected()) {
                marritalText = "Married";
            } else if (unmarried.isSelected()) {
                marritalText = "Unmarried";
            } else if (others.isSelected()) {
                marritalText = "Other";
            }

            String addressText = addressField.getText();
            String cityText = cityField.getText();
            String stateText = stateField.getText();
            String pincodeText = pincodeField.getText();

            try {
                if (nameText.equals("") || fnameText.equals("") || (male.isSelected() == false && female.isSelected() == false && other.isSelected() == false) || dobText.equals("") || emailText.equals("") || (married.isSelected() == false && unmarried.isSelected() == false && others.isSelected() == false) || addressText.equals("") || cityText.equals("")  || stateText.equals("") || pincodeText.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                } else {
                    Connn con1 = new Connn();
                    String q = "insert into signup1 values('"+formno+"', '"+nameText+"', '"+fnameText+"', '"+genderText+"', '"+dobText+"', '"+emailText+"', '"+marritalText+"', '"+addressText+"', '"+cityText+"', '"+stateText+"', '"+pincodeText+"')";
                    con1.statement.executeUpdate(q);
                    new Signup2(first);
                    setVisible(false);
                }
            } catch(Exception E) {
                E.printStackTrace();
            }
        if (ae.getSource() == prev) {
            new Login("");
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Signup1();
    }
}
