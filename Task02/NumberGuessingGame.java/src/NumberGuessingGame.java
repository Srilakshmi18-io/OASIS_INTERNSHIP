import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        int numtoguess = ran.nextInt(100)+1;
        int userguess = 0;
        int attempts = 0;
        int maxattempts = 5;
        int score = 100;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have "+maxattempts+"attempts");



        while(userguess != numtoguess && attempts<maxattempts){
            System.out.println("Enter your choice : ");
            userguess = sc.nextInt();
            attempts++;

            if(userguess>numtoguess){
                System.out.println("Too High");
                score -= 20;
            }
            else if(userguess<numtoguess){
                System.out.println("Too Low");
                score -= 20;
            }
            else{
                System.out.println("You guessed it right");
                System.out.println("Attempts: "+attempts);
                System.out.println("Your scores : "+score);
            }
            System.out.println();
        }
        if(userguess != numtoguess){
            System.out.println("Game over");
            System.out.println("The correct number was : "+numtoguess);
            System.out.println("Your score :"+score);
        }
        sc.close();
    }
}
