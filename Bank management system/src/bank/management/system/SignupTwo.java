package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {
    
    
    JTextField nameTextField,fnameTextField,aadhar,pan,emailTextField,dobTextfield,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton eno,eyes,syes,sno;
    JDateChooser datechooser;
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    
    
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW APLICATION FORM -PAGE2");
        
        JLabel additionalDetails= new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 80,400,30);
        add(additionalDetails);
       
        
        JLabel name= new JLabel("Religion:");       
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140,100,30);
        add(name);
        
        
        String valreligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        add(religion); 
        
        JLabel fname= new JLabel("Category:");       
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 190,200,30);
        add(fname);
         
        String valcategory[] ={"General","OBC","SC","ST","other"};
        category=new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        add(category);
        
        JLabel dob= new JLabel("Income:");       
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 240,200,30);
        add(dob);
        
        String valincome[] ={"Null","<1,50,00","<2,50,000","<5,00,000","upto 10,00,000"};
        income=new JComboBox(valincome);
        income.setBounds(300,240,400,30);
        add(income);
        
        JLabel gender= new JLabel("Educational");       
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 290,200,30);
        add(gender);
        
        
        
        JLabel email= new JLabel("Qualification:");       
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 315,200,30);
        add(email);
        
        String educationvalues[] ={"Non-Graduation","Graduate","Post-Graduate","Doctrate","others"};
        education=new JComboBox(educationvalues);
        education.setBounds(300,315,400,30);
        add(education);
        
        
        
        JLabel martial= new JLabel("Occupation:");       
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(100, 390,200,30);
        add(martial);
        
        String occupationvalues[] ={"Salaried","Self Employed","Bussiness","Student","Retired","others"};
        occupation=new JComboBox(occupationvalues);
        occupation.setBounds(300,390,400,30);
        add(occupation);
       
        
        JLabel address= new JLabel("PAN number:");       
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 440,200,30);
        add(address);
        
        pan= new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city= new JLabel("Aadhar number:");       
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 490,200,30);
        add(city);
      
        
        aadhar= new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state= new JLabel("Senior citizen:");       
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 540,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        

        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
      
        
        JLabel pincode= new JLabel("Existing Account:");       
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 590,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        

        ButtonGroup existinggroup=new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,630,80,15);
        next.addActionListener(this);
        add(next);
        
      
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(300,5);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected()){ 
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){ 
            seniorcitizen = "No";
        }
            
        
        String existing = null;
        if(eyes.isSelected()){ 
            existing = "Yes";
        }else if(eno.isSelected()){ 
            existing = "No";
        }
           
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
           
            
                Conn c = new Conn();
                String query2 = "insert into Signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+span+"','"+saadhar+"','"+existing+"','"+seniorcitizen+"')";
                c.s.executeUpdate(query2);
                
               
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
            
        }catch(Exception e){
             System.out.println(e);
        }
        
    }
    
    
    public static void main(String args[])
    {

        new SignupTwo("");
    }
}

