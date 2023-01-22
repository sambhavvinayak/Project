
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class LoginPage extends JFrame {
    private Cursor curT= new Cursor(Cursor.TEXT_CURSOR);
    private Cursor curP = new Cursor(Cursor.HAND_CURSOR);
    private Font font = new Font("Arial",Font.BOLD,15);
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton Back , Show;
    public String user , pass;

    public LoginPage() {
        setTitle/*we ca write here super also*/("Login Page");
        Container c = getContentPane();
        c.setLayout(null);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.MAGENTA);
        usernameLabel.setBounds(10,40,100, 20);
        usernameLabel.setFont(font);
        usernameLabel.setCursor(curT);
        c.add(usernameLabel);

        usernameField = new JTextField(20/*this is for a size defining */);
        usernameField.setBounds(120,40,200, 20);
        usernameField.setFont(font);
        usernameField.setForeground(Color.RED);
        c.add(usernameField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10,80,100, 20);
        passwordLabel.setForeground(Color.MAGENTA);
        passwordLabel.setCursor(curT);
        passwordLabel.setFont(font);
        c.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(120,80,200, 20);
        passwordField.setForeground(Color.RED);
        c.add(passwordField);
        passwordField.setFont(font);

        loginButton = new JButton("Login");
        loginButton.setBounds(85,150,100, 30);
        loginButton.setFont(font);
        loginButton.setCursor(curP);
        c.add(loginButton);

        Back = new JButton("Back");
        Back.setBounds(200,150,100, 30);
        Back.setCursor(curP);
        Back.setFont(font);
        c.add(Back);

        Show = new JButton("^");
        Show.setBounds(190,100,50, 20);
        c.add(Show);
        Show.setCursor(curP);


        Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                passwordField.setEchoChar((char)0);
                Show.setEnabled(false);
            }
        });

        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Signup sgn = new Signup();
                sgn.setVisible(true);
                dispose();
                sgn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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


        setLocation(500, 100);
        setSize(350, 500);
        setVisible(true);

    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
