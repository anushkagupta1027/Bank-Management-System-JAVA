package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    SignupThree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);
    
        r1=new JRadioButton("Saving Accounts");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBounds(100,180,200,30);
        add(r1);
        
        r2=new JRadioButton("Fixed Accounts");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBounds(350,180,200,30);
        add(r2);
        
        r3=new JRadioButton("Current Accounts");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBounds(100,220,200,30);
        add(r3);
        
        r4=new JRadioButton("Recurring Accounts");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBounds(350,220,200,30);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number = new JLabel("xxxx-xxxx-xxxx-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel carddeatil = new JLabel("Your 16 digit card number");
        carddeatil.setFont(new Font("Raleway", Font.BOLD, 12));
        carddeatil.setBounds(100,330,300,20);
        add(carddeatil);
        
        JLabel pin = new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
    
        JLabel pindeatil = new JLabel("Your 4 digit Password");
        pindeatil.setFont(new Font("Raleway", Font.BOLD, 12));
        pindeatil.setBounds(100,400,300,20);
        add(pindeatil);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,450,200,20);
        add(services);
        
        c1=new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,480,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,480,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,510,200,30);
        add(c3);
        
        c4=new JCheckBox("EMAIL and SMS Allerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,510,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,540,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,540,200,30);
        add(c6);
        
        c7=new JCheckBox("I hearby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,580,600,30);
        add(c7);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,620,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,620,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
    setSize(850,820);
    setLocation(350,0);
    setVisible(true);
    
    
    
    
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accounttype=null;
            if(r1.isSelected())
            {
                accounttype="Savings Account";
            }else if(r2.isSelected())
            {
                accounttype="Fixed Deposit Account";
                
            }else if (r3.isSelected())
            {
                accounttype="Curent Account";
                
            }else if (r4.isSelected())
            {
                accounttype="Recuring Deposit Account";
            }
            
            Random random=new Random();
            long cardno = (random.nextLong() % 90000000L + 5040936000000000L);
            String cardnumber = "" + Math.abs(cardno);
            
            
            long pinno = (random.nextLong() % 9000L + 1000L);
            String pinnumber = "" + Math.abs(pinno);
            
            
            
        String facility="";
        if(c1.isSelected())
            {
                facility = facility + " ATM Card";
            }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL & SMS Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
             
        try
        {
            if(accounttype.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Fill all the required fields");
                    }
            else
            {
                Conn conn = new Conn();
                    String query = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";  
                    String query2= "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin:"+ pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
            }
    
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
            
        }else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[])
            
    {
        new SignupThree("");
    }
}