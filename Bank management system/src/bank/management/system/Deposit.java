package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount,t2;
    JButton deposit,back,b3;
    JLabel text,image,l2,l3;
    String pinnumber;
    
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,20);
        image.add(amount);
        
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(355,485,150,30);
        image.add(deposit);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        image.add(back);
        
        setLayout(null);
        
        deposit.addActionListener(this);
        back.addActionListener(this);
        
        setSize(850,820);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
            String number = amount.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                }else{
                    try{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'deposit', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    }catch(Exception e){
                     System.out.println(e);
        }
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
