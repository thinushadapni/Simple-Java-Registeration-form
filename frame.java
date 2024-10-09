import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

class frame implements ActionListener {
    JFrame f = new JFrame("Employee Registration Form");
    JPanel p = new JPanel();

    JLabel l;
    JLabel na, g, pass, d, m, e, ar, st, n;
    JButton b;

    ButtonGroup bg = new ButtonGroup();
    JRadioButton ch1, ch2;
    JComboBox<String> day, month, year;
    JComboBox<String> state;

    JTextField t1, t3, t4, t5, t6;
    JPasswordField t2;
    Container c;

    frame() {
        Container c = new Container();
        l = new JLabel("Register Form");
        l.setBounds(170, 10, 100, 20);
        c.add(l);

        na = new JLabel("Name");
        na.setBounds(20, 50, 100, 20);
        c.add(na);

        t1 = new JTextField();
        t1.setBounds(140, 50, 200, 20);
        c.add(t1);

        g = new JLabel("Gender");
        g.setBounds(20, 100, 100, 20);
        c.add(g);

        ch1 = new JRadioButton("Male", true);
        ch1.setBounds(140, 100, 90, 20);
        c.add(ch1);

        ch2 = new JRadioButton("Female", false);
        ch2.setBounds(230, 100, 90, 20);
        c.add(ch2);

        bg.add(ch1);
        bg.add(ch2);

        pass = new JLabel("Password");
        pass.setBounds(20, 150, 100, 20);
        c.add(pass);

        t2 = new JPasswordField();
        t2.setBounds(140, 150, 200, 20);
        c.add(t2);

        d = new JLabel("Date of Birth");
        d.setBounds(20, 200, 100, 20);
        c.add(d);

        String days[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String years[] = { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011",
                "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023",
                "2024", "2025" };
        day = new JComboBox<>(days);
        month = new JComboBox<>(months);
        year = new JComboBox<>(years);

        day.setBounds(140, 200, 50, 20);
        month.setBounds(200, 200, 90, 20);
        year.setBounds(300, 200, 70, 20);
        c.add(day);
        c.add(month);
        c.add(year);

        m = new JLabel("Mobile Number");
        m.setBounds(20, 250, 100, 20);
        c.add(m);

        t3 = new JTextField();
        t3.setBounds(140, 250, 200, 20);
        c.add(t3);

        e = new JLabel("E-Mail");
        e.setBounds(20, 300, 100, 20);
        c.add(e);

        t4 = new JTextField();
        t4.setBounds(140, 300, 200, 20);
        c.add(t4);

        ar = new JLabel("Area");
        ar.setBounds(20, 350, 100, 20);
        c.add(ar);

        t5 = new JTextField();
        t5.setBounds(140, 350, 200, 20);
        c.add(t5);

        st = new JLabel("State");
        st.setBounds(20, 400, 100, 20);
        c.add(st);

        String states[] = { "Tamil Nadu", "Kerala", "Karnataka", "Andhra Pradesh", "Madhya Pradesh" };
        state = new JComboBox<>(states);
        state.setBounds(140, 400, 100, 20);
        c.add(state);

        n = new JLabel("Nationality");
        n.setBounds(20, 450, 100, 20);
        c.add(n);

        t6 = new JTextField();
        t6.setBounds(140, 450, 200, 20);
        c.add(t6);

        f.add(c);
        f.setSize(500, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        b = new JButton("Register");
        b.setBounds(100, 500, 100, 40);
        c.add(b);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b)
        {
            FileWriter w=null;
            try
            {
                w=new FileWriter("D:/Java/New folder/sample.txt",true);
                w.write("Name: " + t1.getText() + "\n");
                w.write("Gender: " + (ch1.isSelected() ? "Male" : "Female") + "\n");
                w.write("Password: " + new String(t2.getPassword()) + "\n");
                w.write("Date of Birth: " + day.getSelectedItem() + " " + month.getSelectedItem() + " " + year.getSelectedItem() + "\n");
                w.write("Mobile Number: " + t3.getText() + "\n");
                w.write("E-Mail: " + t4.getText() + "\n");
                w.write("Area: " + t5.getText() + "\n");
                w.write("State: " + state.getSelectedItem() + "\n");
                w.write("Nationality: " + t6.getText() + "\n\n");
                JOptionPane.showMessageDialog(f, "Registration Successful!");
            }
            catch(IOException l)
            {
                System.out.println(l.getMessage());
            }
            finally {
                try {
                    if (w != null) {
                        w.close();
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        frame fr = new frame();
    }
}
