package project.src;

public class signUp {
        public char[] password = new char[]{};
        public void banner(){
            System.out.println("||||||||SignUp|||||||");
            System.out.println("---------------------");
            System.out.println();
        }
        public void bannerSucc(){
            System.out.println();
            System.out.println("||||||||SignUp SuccesFully|||||||");
            System.out.println("---------------------------------");
            System.out.println();
        }
        public String email;
        public void Email(String email){
            this.email = email;
        }
        
        public void password(String pass){
            // for (int i = 1; i <= 7; i++) {
            //     char[i]                                                                             = pass;
            // }
        }
        public void SPage(String email, String pass){
    
            // email
            Email(email);
            
            
            // password
            password(pass);
            
            
            // banner
            bannerSucc();
        }
}



// oxzps6341j