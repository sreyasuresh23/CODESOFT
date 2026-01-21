import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continueGame = true;
        int totalScore = 0;

        while (continueGame) {

            int secretNumber = (int)(Math.random() * 100) + 1;
            int attemptCount = 0;
            int maxTries = 7;
            int guess;

            System.out.println("\nI have selected a number between 1 and 100.");

            do {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attemptCount++;

                if (guess > secretNumber) {
                    System.out.println("Your guess is higher than the number.");
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is lower than the number.");
                } else {
                    System.out.println("Correct! You found the number in " + attemptCount + " attempts.");
                }

            } while (guess != secretNumber && attemptCount < maxTries);

            if (guess == secretNumber) {
                int roundScore = (maxTries - attemptCount + 1) * 10;
                totalScore += roundScore;
                System.out.println("You earned " + roundScore + " points this round.");
            } else {
                System.out.println("Attempts over! The correct number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            continueGame = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Your final score: " + totalScore);
        sc.close();
    }
}
