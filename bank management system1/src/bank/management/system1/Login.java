 
package bank.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        
        setTitle("AUTOMATIC TELLER MACHINE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Osward", Font.BOLD, 38));
        cardno.setBounds(120, 150, 400, 40);
        add(cardno);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 40);
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("raleway", Font.BOLD, 38));
        pin.setBounds(120, 220, 250, 40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 40);
        add(pinTextField);
        
        login = new JButton("Sign in");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
         signup = new JButton("Sign up");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
         getContentPane().setBackground(Color.WHITE);
        
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"'and pin ='"+pinnumber+"'";
            try{
                 ResultSet rs = conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
                 }
                 else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } else if(ae.getSource() == signup){
            setVisible(false);
            new Signup().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
