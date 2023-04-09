package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, back, b8;
    JTextField t1;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(210, 300, 700, 35);
        l3.add(l1);

        b1 = new JButton("Rs 100");
        b1.setBounds(170, 415, 150, 30);
        l3.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(355, 415, 150, 30);
        l3.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(170, 450, 150, 30);
        l3.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(355, 450, 150, 30);
        l3.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(170, 485, 150, 30);
        l3.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(355, 485, 150, 30);
        l3.add(b6);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        l3.add(back);

        setLayout(null);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        back.addActionListener(this);

        setSize(850, 820);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } else {
                String amount = ((JButton) ae.getSource()).getText().substring(3);
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                } else if (ae.getSource() == back) {
                    this.setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    Date date = new Date();
                    c.s.executeUpdate("insert into bank values('" +pinnumber+ "', '" +date+ "', 'Withdrawl', '" +amount+ "')");
                    JOptionPane.showMessageDialog(null, "Rs. " +amount+ " Debited Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
