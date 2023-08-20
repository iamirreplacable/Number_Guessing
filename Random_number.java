package com.aman;
import java.util.*;

public class Random_number {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxRange = getUserInput("Enter the maximum range of numbers: ", scanner);
        int secretNumber = generateRandomNumber(maxRange);

        System.out.println("Welcome to the Number Guessing Game!");
        int attempts = 15;

        while (attempts > 0) {
            int userGuess = getUserInput("Make a guess: ", scanner);

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You've won!");
                int playAgain = getUserInput("Enter 1 to stop or 5 to play again: ", scanner);

                if (playAgain == 5) {
                    maxRange = getUserInput("Enter the new maximum range of numbers: ", scanner);
                    secretNumber = generateRandomNumber(maxRange);
                    System.out.println("New game started. You can guess up to 15 times.");
                } else {
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                }
            } else {
                String hint = userGuess < secretNumber ? "Increase your guess" : "Decrease your guess";
                if (Math.abs(userGuess - secretNumber) == 1) {
                    hint += ", you're very close";
                }
                System.out.println(hint);
            }
            attempts--;
        }

        System.out.println("Sorry! Better luck next time. The secret number was " + secretNumber);
    }

    private static int getUserInput(String message, Scanner scanner) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private static int generateRandomNumber(int maxRange) {
        Random random = new Random();
        return random.nextInt(maxRange + 1);
    }
}
