import java.util.Random;

public class Rando_m {
    public static void main(String[] args) {
        // int n = 0;
        // while (n<100) {
            
        //     Random random = new Random();
        //     int randomNumber = random.nextInt(100); /// this is use for  a class in java 
        //     // int secretNumber = (int)(Math.random() *100); // but it is a double   use  of Math.random();
        //     System.out.println("Random number: " + randomNumber+"  "/*+secretNumber*/);
        //     n++;
        // }
        int num = 0;
        while (num<100){
            Random random = new Random();
            int randomNumber = random.nextInt(100);
            int secret = (int)(Math.random() *100);
            System.out.println("Random number: " + randomNumber+"  "+secret);
            if (randomNumber == secret) {
                System.out.println("you will win");
                return;
            }
            num++;
        }
    }
}
