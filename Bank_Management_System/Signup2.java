package Bank_Management_System;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
public class Signup2 extends JFrame implements ActionListener {
    JButton next, prev;
    String formno;
    JTextField panText, aadharText;
    JRadioButton seniors, juniors,existing, Nonexisting;
    JComboBox combobox, combobox2, combobox3, combobox4, combobox5;
    Signup2(String first) {

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel ii4 = new JLabel(ii3);
        ii4.setBounds(0, 0, 200, 150);
        add(ii4);

        this.formno = first;

        JLabel fn = new JLabel("Form No:");
        fn.setFont(new Font("Raleway", Font.BOLD, 14));
        fn.setBounds(550, 20, 70, 30);
        add(fn);

        JLabel fnn = new JLabel(formno);
        fnn.setFont(new Font("Raleway", Font.BOLD, 14));
        fnn.setBounds(620, 20, 100, 30);
        add(fnn);

        JLabel details = new JLabel("Page 2 : Additional Details ");
        details.setFont(new Font("Raleway", Font.BOLD, 22));
        details.setForeground(Color.black);
        details.setBounds(250,95, 300, 30);
        add(details);

        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setForeground(Color.black);
        religion.setBounds(50, 150, 200, 30);
        add(religion);

        String religions[] = {"Hindu", "Muslim", "Sikh", "Christial", "Other"};
        combobox = new JComboBox(religions);
        combobox.setBackground(Color.white);
        combobox.setFont(new Font("Raleway", Font.BOLD, 14));
        combobox.setBounds(270, 150, 360, 30);
        add(combobox);
        
        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setForeground(Color.black);
        category.setBounds(50, 200, 200, 30);
        add(category);

        String categories[] = {"General", "OBC", "SC", "ST", "Other"};
        combobox2 = new JComboBox(categories);
        combobox2.setBackground(Color.white);
        combobox2.setFont(new Font("Raleway", Font.BOLD, 14));
        combobox2.setBounds(270, 200, 360, 30);
        add(combobox2);

        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setForeground(Color.black);
        income.setBounds(50, 250, 200, 30);
        add(income);

        String incomes[] = {"Null", "< 1,50,000", "< 2,50,000", " < 5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        combobox3 = new JComboBox(incomes);
        combobox3.setBackground(Color.white);
        combobox3.setFont(new Font("Raleway", Font.BOLD, 14));
        combobox3.setBounds(270, 250, 360, 30);
        add(combobox3);

        JLabel education = new JLabel("Education : ");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setForeground(Color.black);
        education.setBounds(50, 300, 200, 30);
        add(education);

        String educational[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        combobox4 = new JComboBox(educational);
        combobox4.setBackground(Color.white);
        combobox4.setFont(new Font("Raleway", Font.BOLD, 14));
        combobox4.setBounds(270, 300, 360, 30);
        add(combobox4);
        
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setForeground(Color.black);
        occupation.setBounds(50, 350, 200, 30);
        add(occupation);

        String occupations[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        combobox5 = new JComboBox(occupations);
        combobox5.setBackground(Color.white);
        combobox5.setFont(new Font("Raleway", Font.BOLD, 14));
        combobox5.setBounds(270, 350, 360, 30);
        add(combobox5);

        JLabel panno = new JLabel("PAN Number : ");
        panno.setFont(new Font("Raleway", Font.BOLD, 18));
        panno.setForeground(Color.black);
        panno.setBounds(50, 400, 200, 30);
        add(panno);

        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 16));
        panText.setBounds(270, 400, 360, 30);
        add(panText); 

        JLabel aadharNo = new JLabel("Aadhar Number : ");
        aadharNo.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharNo.setForeground(Color.black);
        aadharNo.setBounds(50, 450, 200, 30);
        add(aadharNo);

        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway", Font.BOLD, 16));
        aadharText.setBounds(270, 450, 360, 30);
        add(aadharText); 

        JLabel senior = new JLabel("Senior Citizen : ");
        senior.setFont(new Font("Raleway", Font.BOLD, 18));
        senior.setForeground(Color.black);
        senior.setBounds(50, 500, 200, 30);
        add(senior);

        seniors = new JRadioButton("Yes");
        seniors.setFont(new Font("Raleway", Font.BOLD, 15));
        seniors.setBounds(270, 500, 80, 30);
        add(seniors);

        juniors = new JRadioButton("No");
        juniors.setFont(new Font("Raleway", Font.BOLD, 15));
        juniors.setBounds(370, 500, 80, 30);
        add(juniors);
        
        ButtonGroup sj = new ButtonGroup();
        sj.add(seniors);
        sj.add(juniors);

        JLabel exAccount = new JLabel("Existing Account : ");
        exAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        exAccount.setForeground(Color.black);
        exAccount.setBounds(50, 550, 210, 30);
        add(exAccount);

        existing = new JRadioButton("Yes");
        existing.setFont(new Font("Raleway", Font.BOLD, 15));
        existing.setBounds(270, 550, 80, 30);
        add(existing);

        Nonexisting = new JRadioButton("No");
        Nonexisting.setFont(new Font("Raleway", Font.BOLD, 15));
        Nonexisting.setBounds(370, 550, 80, 30);
        add(Nonexisting);

        ButtonGroup ea = new ButtonGroup();
        ea.add(existing);
        ea.add(Nonexisting);

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
        getContentPane().setBackground(new Color(252, 208, 76));
        setSize(700, 750);
        setLocation(400, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String formn = formno;
        String relig = (String) combobox.getSelectedItem();
        String categ = (String) combobox2.getSelectedItem();
        String incom = (String) combobox3.getSelectedItem();
        String educat = (String) combobox4.getSelectedItem();
        String occup = (String) combobox5.getSelectedItem();

        String pan  = panText.getText();
        String aadhar = aadharText.getText();

        String scitizen = "";
        if (seniors.isSelected()) {
            scitizen = "Yes";
        } else if (juniors.isSelected()) {
            scitizen = "No";
        }

        String eaccount = "";
        if (existing.isSelected()) {
            eaccount = "Yes";
        } else if (Nonexisting.isSelected()) {
            eaccount = "No";
        }

        try {
            if(panText.getText().equals("") || aadharText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields!");
            } else {
                Connn c1 = new Connn();
                String q = "insert into signup2 values('"+formn+"', '"+relig+"', '"+categ+"', '"+incom+"', '"+educat+"', '"+occup+"', '"+pan+"', '"+aadhar+"', '"+scitizen+"', '"+eaccount+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        if (ae.getSource() == prev) {
            new Signup1();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Signup2("");
    }
}
