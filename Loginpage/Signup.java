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

    public JTextField usernameField;
    public JPasswordField passwordField;
    public JButton ButtonS,ButtonL;
    public JLabel heading,username,password , lastM;
    public String user,pass;


    public  Signup(){

        super("SignUp Page"); // title 
        setLayout(new FlowLayout());  // it is compulsory becouse it set and align the all things


        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        ButtonS = new JButton("SignUp");
        ButtonL = new JButton("Login");
        username = new JLabel("UserName : ");
        password = new JLabel("Password : ");
        heading = new JLabel("Welcome in signing page .\nThat you cover it here only");
                
        add(heading);
        add(username);
        add(usernameField);
        add(password);
        add(passwordField);
        add(ButtonS);add(ButtonL);
        
        ButtonL.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                LoginPage login = new LoginPage();
                // setVisible(false);
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
                    usernameField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(null,"You SignUp Succesfully");
                    System.out.println("you succesfully uploaded your email and password");
                    System.out.println("Email : "+usernameField.getText());
                    System.out.println("Password : "+new String(passwordField.getPassword()));

                    lastM = new JLabel("Proceed for login");
                    add(lastM);
                }
            }
        });
        
        setSize(400,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        Signup signUp = new Signup();                                             
        signUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

