

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton Back;
    public String user , pass;

    public LoginPage() {
        setTitle/*we ca write here super also*/("Login Page");
        setLayout(new FlowLayout());

        usernameLabel = new JLabel("Username: ");
        add(usernameLabel);

        usernameField = new JTextField(20/*this is for a size defining */);
        add(usernameField);

        passwordLabel = new JLabel("Password: ");
        add(passwordLabel);

        passwordField = new JPasswordField(20);
        add(passwordField);

        loginButton = new JButton("Login");
        Back = new JButton("Back");
        add(loginButton);
        add(Back);

        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Signup sgn = new Signup();
                setVisible(false);
                sgn.setVisible(true);
                dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                ////////////////////////////////////////////////////
                // here is the file locator which locate the file ..
                String userlist = "username.txt";
                File file = new File(userlist);
                try (Scanner input = new Scanner(file)) {
                    user = input.nextLine();
                } catch (FileNotFoundException t) {
                     // TODO Auto-generated catch block
                     t.printStackTrace();
                }
                String passlist = "password.txt";
                    File list1 = new File(passlist);
                try (Scanner inpScanner = new Scanner(list1)) {
                    pass = inpScanner.nextLine();
                } catch (FileNotFoundException p) {
                    // TODO Auto-generated catch block
                    p.printStackTrace();
                }  
                System.out.println("Email : "+usernameField.getText());
                System.out.println("Password : "+new String(passwordField.getPassword()));
                ///////////////////////////////////////////////////////////

                String Username = usernameField.getText();
                String password = new String(passwordField.getPassword()); /// this is for create object 
                // check if the entered username and password are correct
                if(Username.equals(user) && password.equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Welcome " + Username);
                    usernameField.setText("");
                    passwordField.setText("");
                    dispose();
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });
        setSize(350, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
