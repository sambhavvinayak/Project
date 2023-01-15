import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int secretNumber = (int)(Math.random() * 100+1);
    Scanner input = new Scanner(System.in);
    int guess;
    do {
      System.out.print("Enter your guess: ");
      System.out.println(secretNumber);
      guess = input.nextInt();
      if (guess < secretNumber) {
        System.out.println("Too low! Try again.");
      } else if (guess > secretNumber) {
        System.out.println("Too high! Try again.");
      }
    } while (guess != secretNumber);
    System.out.println("Congratulations! You guessed the secret number!");
  }
}
