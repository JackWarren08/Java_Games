import java.util.Random;
import java.util.Scanner;
public class Game {
//  Variables used by the methods in main
  int numDice, trials;
  Random rand;
  Scanner scan;

//  When the 'Game' method is called dice number and attempt number is passed to main
  public Game(int numDice, int trials){
//    Setting number of dice and trials
    this.numDice = numDice;
    this.trials = trials;

//    Creating new random number method and new Scanner
    rand = new Random();
    scan = new Scanner(System.in);
  }

//  When the play method is called it plays a pre-determined amount of dice and attempts
  public int play(String who, int target){
//    Amount of dice is equal to the pre-determined amount in main
    int[] dice = new int[numDice];
//    Keeping track of each user's points
    int points = 0;


    for(int i=0; i < trials; i++)
    {
      for(int j = 0; j< numDice; j++){
        dice[j] = rand.nextInt(6) + 1;
      }
      System.out.println("Press Enter for Results");
      scan.nextLine();

      for(int j : dice){
        System.out.println(j + " ");
      }
      System.out.println();

      for(int j = 0; j< numDice; j++){
        if (dice[j] == target){
          points++;
        }
      }
      System.out.println(who + " got " + points + " points.");
    }
    return points;
  }

}
