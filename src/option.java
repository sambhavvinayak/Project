  package project.src;

import java.util.Scanner;

public class option {
    Scanner input = new Scanner(System.in);
    int TRue = 1;
    public void swh(){
        while (TRue==1) {
            
            System.out.println();
            System.out.println("For exit Type 0 And Continue 1 :");
            TRue = input.nextInt();

            System.out.println("For SignUP click (1) and for login click (0) :");
            int option = input.nextInt();
            switch (option) {
           
            case 1:
            // signUp 
            signUp sp = new signUp();
            
            sp.banner();
            
            //
            System.out.print("Enter your Email (example@gmail.com): ");
            String email = input.next();
            
            //
            System.out.print("Enter your password (more then 7 latter): ");
            String pass = input.next();
            //
            sp.SPage(email, pass);
            
            break;
            
            case 0:
            
            //login
            Login lp = new Login();
            // login Banner
            lp.loginBanner();
            //
            System.out.print("Enter your Email (example@gmail.com): ");
            String emailL = input.next();

            System.out.print("Enter your password (more then 7 latter): ");
            String passL = input.next();
            lp.Loginx(emailL,passL);
        
            break;
            default:
            System.out.println("you Enter wrong choice.");

           
        }
        }
    }
}
