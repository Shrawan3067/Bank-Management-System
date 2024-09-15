package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Signup3 extends JFrame implements ActionListener {
    JButton prev, submit;
    String formno;
    JRadioButton saving, fd, current, recurring;
    JCheckBox atmCard, IBanking, MBanking, eAlerts, ChequeBook, EStatement;
    Signup3(String formno) {
        
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel ii4 = new JLabel(ii3);
        ii4.setBounds(0, -10, 200, 150);
        add(ii4);
        
        JLabel details = new JLabel("Page 3 : Account Details ");
        details.setFont(new Font("Raleway", Font.BOLD, 22));
        details.setBounds(250,85, 300, 30);
        add(details);

        this.formno = formno;

        JLabel form = new JLabel("Form No :");
        form.setFont(new Font("Raleway", Font.BOLD, 14));
        form.setBounds(550,20, 70, 30);
        add(form);

        JLabel forms = new JLabel(formno);
        forms.setFont(new Font("Raleway", Font.BOLD, 14));
        forms.setBounds(620,20, 50, 30);
        add(forms);

        JLabel accountType = new JLabel("Account Type : ");
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        accountType.setBounds(50, 140, 200, 30);
        add(accountType);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 15));
        saving.setBounds(50, 180, 200, 22);
        saving.setBackground(new Color(200, 255, 252));
        add(saving);

        fd = new JRadioButton("Fixed Deposit Account");
        fd.setFont(new Font("Raleway", Font.BOLD, 15));
        fd.setBounds(300, 180, 200, 22);
        fd.setBackground(new Color(200, 255, 252));
        add(fd);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 15));
        current.setBounds(50, 220, 200, 22);
        current.setBackground(new Color(200, 255, 252));
        add(current);

        recurring = new JRadioButton("Recurring Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 15));
        recurring.setBounds(300, 220, 200, 22);
        recurring.setBackground(new Color(200, 255, 252));
        add(recurring);

        ButtonGroup accountButton = new ButtonGroup();
        accountButton.add(saving);
        accountButton.add(fd);
        accountButton.add(current);
        accountButton.add(recurring);

        JLabel cardNumber = new JLabel("Card Number : ");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        cardNumber.setBounds(50, 270, 200, 30);
        add(cardNumber);

        JLabel cardNumberField = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNumberField.setFont(new Font("Raleway", Font.BOLD, 16));
        cardNumberField.setBounds(300, 270, 300, 30);
        add(cardNumberField);

        JLabel cardDes = new JLabel("(Your 16-digit Card number)");
        cardDes.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardDes.setBounds(50, 295, 200, 30);
        add(cardDes);

        JLabel cardFieldDes = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        cardFieldDes.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardFieldDes.setBounds(300, 295, 400, 30);
        add(cardFieldDes);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(50, 345, 200, 30);
        add(pin);

        JLabel pinNumberField = new JLabel("XXXX");
        pinNumberField.setFont(new Font("Raleway", Font.BOLD, 16));
        pinNumberField.setBounds(300, 345, 300, 30);
        add(pinNumberField);

        JLabel pinDes = new JLabel("(4-digit password)");
        pinDes.setFont(new Font("Raleway", Font.PLAIN, 12));
        pinDes.setBounds(50, 370, 200, 30);
        add(pinDes);

        JLabel service = new JLabel("Serivices Required :");
        service.setFont(new Font("Raleway", Font.BOLD, 18));
        service.setBounds(50, 410, 200, 30);
        add(service);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setFont(new Font("Raleway", Font.BOLD, 15));
        atmCard.setBounds(50, 460, 200, 22);
        atmCard.setBackground(new Color(200, 255, 252));
        add(atmCard);

        IBanking = new JCheckBox("Internet Banking");
        IBanking.setFont(new Font("Raleway", Font.BOLD, 15));
        IBanking.setBounds(300, 460, 200, 22);
        IBanking.setBackground(new Color(200, 255, 252));
        add(IBanking);

        MBanking = new JCheckBox("Mobile Banking");
        MBanking.setFont(new Font("Raleway", Font.BOLD, 15));
        MBanking.setBounds(50, 500, 200, 22);
        MBanking.setBackground(new Color(200, 255, 252));
        add(MBanking);

        eAlerts = new JCheckBox("EMAIL Alerts");
        eAlerts.setFont(new Font("Raleway", Font.BOLD, 15));
        eAlerts.setBounds(300, 500, 200, 22);
        eAlerts.setBackground(new Color(200, 255, 252));
        add(eAlerts);

        ChequeBook = new JCheckBox("Cheque Book");
        ChequeBook.setFont(new Font("Raleway", Font.BOLD, 15));
        ChequeBook.setBounds(50, 540, 200, 22);
        ChequeBook.setBackground(new Color(200, 255, 252));
        add(ChequeBook);

        EStatement = new JCheckBox("E-Statement");
        EStatement.setFont(new Font("Raleway", Font.BOLD, 15));
        EStatement.setBounds(300, 540, 200, 22);
        EStatement.setBackground(new Color(200, 255, 252));
        add(EStatement);

        JCheckBox confirm = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        confirm.setFont(new Font("Raleway", Font.BOLD, 12));
        confirm.setBounds(50, 600, 600, 18);
        confirm.setBackground(new Color(200, 255, 252));
        add(confirm);

        prev = new JButton("Cancel");
        prev.setFont(new Font("Raleway", Font.BOLD, 16));
        prev.setBackground(Color.black);
        prev.setForeground(Color.white);
        prev.setBounds(50, 660, 100, 30);
        prev.addActionListener(this);
        add(prev);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(510, 660, 100, 30);
        submit.addActionListener(this);
        add(submit);

        setLayout(null);
        getContentPane().setBackground(new Color(200, 255, 252));
        setTitle("SIGN UP");
        setSize(700, 750);
        setLocation(400, 45);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formn = formno;

        String acctype = "";
        if(saving.isSelected()) {
            acctype = "Saving Account";
        } else if (fd.isSelected()) {
            acctype = "Fixed Deposit Account";
        } else if (current.isSelected()) {
            acctype = "Current Account";
        } else if (recurring.isSelected()) {
            acctype = "Recurring Deposit Account";
        }

        Random ranCard = new Random();
        long first7 = (ranCard.nextLong() % 90000000L) + 1409963000000000L;
        String cardNo = "" + Math.abs(first7);
        
        long first3 = (ranCard.nextLong() % 9000L) + 1000L;
        String pinNo = "" + Math.abs(first3);

        String servReq = "";
        if (atmCard.isSelected()) {
            servReq += "Atm Card";
        }
        if (IBanking.isSelected()) {
            servReq += " Internet Banking";
        }
        if (MBanking.isSelected()) {
            servReq += " Mobile Banking";
        }
        if (eAlerts.isSelected()) {
            servReq += " Email Alerts";
        }
        if (ChequeBook.isSelected()) {
            servReq += " Cheque Book";
        }
        if (EStatement.isSelected()) {
            servReq += " E-Statement";
        }

        try {
            if (ae.getSource() == submit) {
                if (acctype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields!");
                } else {
                    Connn c1 = new Connn();
                    String q1 = "insert into signup3 values('"+formn+"', '"+acctype+"', '"+cardNo+"', '"+pinNo+"', '"+servReq+"')";
                    String q2 = "insert into login values('"+formn+"', '"+cardNo+"', '"+pinNo+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number : " + cardNo + " \nPin : " + pinNo);
                    new Login(pinNo);
                    // new Atm(pinNo);
                    setVisible(false);
                }
            } else if (ae.getSource() == prev) {
                System.exit(0);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Signup3("");
    }
}