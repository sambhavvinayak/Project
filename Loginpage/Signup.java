

/*
* making this for signUp page in java
*/


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*; // this is for JFrame help to extends 

public class Signup extends JFrame{

    // public JPanel panel;
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JButton ButtonS,ButtonL;
    public JLabel heading,username,password;
    public String user,pass;


    public  Signup(){
        //panel
        // panel = new JPanel();
        // add(panel);
        // panel.setBounds(0,0,300,200);
        // panel.setBackground(Color.CYAN);

        setTitle("SignUp Page"); // title 
        Container c = getContentPane();
        c.setLayout(null);
          // it is compulsory becouse it set and align the all things
        
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        ButtonS = new JButton("SignUp");
        ButtonL = new JButton("Login");
        username = new JLabel("UserName : ");
        password = new JLabel("Password : ");
        heading = new JLabel("Welcome in signing page");
                
        c.add(heading);
        heading.setBounds(150,10,200, 20);
        c.add(username);
        username.setBounds(10,40,200, 20);
        c.add(usernameField);
        usernameField.setBounds(120,40,200, 20);
        c.add(password);
        password.setBounds(10,80,200, 20);
        c.add(passwordField);
        passwordField.setBounds(120,80,200, 20);
        c.add(ButtonS);
        ButtonS.setBounds(85,150,100, 30);
        add(ButtonL);
        ButtonL.setBounds(200,150,100, 30);
        
        ButtonL.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                LoginPage login = new LoginPage();
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
                login.setVisible(true);
            }
        });

        ButtonS.addActionListener(new ActionListener(){

            public Boolean isEmpty(){
                Object pass = new String(passwordField.getPassword());
                Object user = usernameField.getText();
                return user.equals("")&&  pass.equals("");
                
            }
            public void actionPerformed(ActionEvent e){

                ////////////////////////////////////////
               ///writer .. user namer...
                user = usernameField.getText();
                File lists = new File("username.txt");
                try{
                    //create a file ...
                    if (lists.exists()) {
                    lists.createNewFile();
                }
                FileWriter Write = new FileWriter(lists);
                BufferedWriter bf = new BufferedWriter(Write);

                    //write the text to file...
                    bf.write(user);

                    // close the file...
                    bf.close();
                }catch(IOException q){
                    q.printStackTrace();
                }
                /////////////////////////////
                pass = new String(passwordField.getPassword());
                File listl = new File("password.txt");
                try{
                    //create a file ...
                    if (listl.exists()) {
                    listl.createNewFile();
                }
                FileWriter Write = new FileWriter(listl);
                BufferedWriter bf = new BufferedWriter(Write);

                    //write the text to file...
                    bf.write(pass);

                    // close the file...
                    bf.close();
                }catch(IOException q){
                    q.printStackTrace();
                }
                ////////////////////////////
               ///writer for password..


                if (/*user.equals("") && pass.equals("")*/isEmpty()) {
                    return;
                }else{
                    System.out.println("Email : "+usernameField.getText());
                    System.out.println("Password : "+new String(passwordField.getPassword()));
                    usernameField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(null,"You SignUp Succesfully");
                    System.out.println("you succesfully uploaded your email and password");

                
                }
            }
        });
        setLocation(200,100);
        setSize(450,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        Signup signUp = new Signup();                                             
        signUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

