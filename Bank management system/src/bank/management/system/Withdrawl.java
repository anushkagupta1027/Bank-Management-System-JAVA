package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount,t2;
    JButton Withdrawl,back,b3;
    JLabel text,image,l2,l3;
    String pinnumber;
    
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRWAL");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,20);
        image.add(amount);
        
        
        Withdrawl = new JButton("WITHDRAWL");
        Withdrawl.setBounds(355,485,150,30);
        image.add(Withdrawl);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        image.add(back);
        
        setLayout(null);
        
        Withdrawl.addActionListener(this);
        back.addActionListener(this);
        
        setSize(850,820);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String number = amount.getText();
            Date date = new Date();
            if(ae.getSource()==Withdrawl){
                
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdrawl");
                }else{
                    try{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Withdrawl Successfully");
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
        new Withdrawl("").setVisible(true);
    }
}
