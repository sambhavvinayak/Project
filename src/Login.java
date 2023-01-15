package project.src;

public class Login {
        signUp sign = new signUp();
        public void loginBanner(){
            System.out.println();
            System.out.println("|||||||||LOGIN||||||||");
            System.out.println();
        } 
        public void loginSuccBn(){
            System.out.println();
            System.out.println("|||||||||Login Succefully||||||");
            System.out.println("-------------------------------");
            System.out.println();
        }
        public void emailLogin(String EmailL){

        }
        public void passLogin(String PassL){

        }
        public void Loginx(String EmailL,String PassL){

            if (EmailL==sign.email) {
                
                // succ Banner
                loginSuccBn();
                return;
            }
            
            // login write it.
            emailLogin(EmailL);
            //
            passLogin(PassL);

        }

}
