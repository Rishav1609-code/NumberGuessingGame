import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxTries = 7;
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Challenge!\n");
        boolean continuePlaying = true;
        
        while (continuePlaying) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.printf("New Round - Guess a number between %d and %d\n", lowerBound, upperBound);
            System.out.println("You have " + maxTries + " tries.\n");
            
            int currentTries = 0;
            boolean hasGuessedCorrectly = false;
            
            while (currentTries < maxTries) {
                System.out.print("Make your guess: ");
                int userGuess = scanner.nextInt();
                
                currentTries++;
                
                if (userGuess == secretNumber) {
                    System.out.printf("Congratulations! You found the number in %d attempts.\n", currentTries);
                    totalScore += currentTries;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low! Try again.\n");
                } else {
                    System.out.println("Your guess is too high! Try again.\n");
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Unfortunately, you've used up all your attempts. The correct number was " + secretNumber);
            }
            
            System.out.println("Your total score so far: " + totalScore + "\n");
            
            System.out.print("Would you like to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                continuePlaying = false;
            }
        }
        
        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        
        scanner.close();
    }
}
