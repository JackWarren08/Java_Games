import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {

//    Creating Variables
    int numDice = 3, trials = 5;
    int playerPoints, computerPoints;

//    Creating a random number
    Random choice = new Random();

//    Creating a scanner so the program knows what your target number is
    Scanner scan = new Scanner(System.in);

//  Getting the user to select their target number
    System.out.println("Choose your target Number: ");
    int playerTarget = scan.nextInt();

//  Program is running the users attempt at the game
    Game player = new Game(numDice, trials);

//  Program is allocating the users points
    playerPoints = player.play("Player", playerTarget);

//  This creates a random number target for the computer between 1 and 6
    int computerTarget = choice.nextInt(6) + 1;
    System.out.println("Computer's target is " + computerTarget);

//  Program is running the computers attempt at the game
    Game computer = new Game(numDice, trials);

//  Program is allocating points to the computer
    computerPoints = computer.play("Computer", computerTarget);

//    Displaying who the winner is as well as the points they had.
//    Player Wins
    if(playerPoints > computerPoints)
    {
      System.out.println("The player has won with " + playerPoints + " points");
    }
//    Computer Wins
    else if(playerPoints < computerPoints){
      System.out.println("The computer wins with " + computerPoints + " points");
    }
//    Game is a draw
    else
    {
      System.out.println("The game has ended in a draw as Player has: " + playerPoints
       + "\n and the Computer has: " + computerPoints);
    }

//    Closing the scanner off
    scan.close();
  }

}