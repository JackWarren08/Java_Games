import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TikTacToe {
  static ArrayList<Integer> playerLoc = new ArrayList<Integer>();
  static ArrayList<Integer> cpuLoc = new ArrayList<Integer>();

  public static void main(String[] args) {
//Creating the game board style
    char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                          {'-', '+', '-', '+', '-'},
                          {' ', '|', ' ', '|', ' '},
                          {'-', '+', '-', '+', '-'},
                          {' ', '|', ' ', '|', ' '}};
//Printing this game board to the users terminal
    printGameBoard(gameBoard);

//Getting the user to enter their chosen position
    while(true){
      Scanner scan = new Scanner(System.in);
      System.out.print("please select a box from between 1 through 9: ");
      int playerLocation = scan.nextInt();

//Checking to see if that position has already been taken in this game
      while(playerLoc.contains(playerLocation) || cpuLoc.contains((playerLocation)))
      {
        System.out.println("This position is already taken try again:");
        playerLocation = scan.nextInt();
      }
//Placing the board piece on the game board and showing the user
      placePiece(gameBoard, playerLocation, "player");
//Checking to see if there are any winners yer
      String result = checkWinner();
      if(result.length() > 0)
      {
//If there is a winner displaying who won to the user
        System.out.println(result);
        break;
      }

//    Generating random number between 1-9 for the bot to place its piece
      Random random = new Random();
      int cpuLocation = random.nextInt(9);
      while(playerLoc.contains(cpuLocation) || cpuLoc.contains((cpuLocation)))
      {
        System.out.println("Cpu chose a box already in use");
        //Setting the bots location to the random number
        cpuLocation = random.nextInt(9) + 1;
      }

//    Placing the bots piece
      placePiece(gameBoard, cpuLocation, "cpu");

      printGameBoard(gameBoard);

//    Checking if anyone has won this game
      result = checkWinner();

      if(result.length() > 0)
      {
        System.out.println(result);
        break;
      }
    }
  }

  public static void printGameBoard(char[][] gameBoard){
    for(char[] row: gameBoard){
      for(char c : row){
        System.out.print(c);
      }
      System.out.println();
    }
  }

//  Method to see who is playing the piece, changing the char of the piece
//  And inputting that char into the game bored
  public static void placePiece(char[][] gameBoard, int location, String user){

    char symbol = ' ';

    if(user.equals("player")){
      symbol = 'X';
      playerLoc.add(location);
    } else if (user.equals("cpu")){
      symbol = 'O';
      cpuLoc.add(location);
    }

    switch (location){
      case 1:
        gameBoard[0][0] = symbol;
        break;
      case 2:
        gameBoard[0][2] = symbol;
        break;
      case 3:
        gameBoard[0][4] = symbol;
        break;
      case 4:
        gameBoard[2][0] = symbol;
        break;
      case 5:
        gameBoard[2][2] = symbol;
        break;
      case 6:
        gameBoard[2][4] = symbol;
        break;
      case 7:
        gameBoard[4][0] = symbol;
        break;
      case 8:
        gameBoard[4][2] = symbol;
        break;
      case 9:
        gameBoard[4][4] = symbol;
        break;
      default:
    }
  }
//Creating an array list of all positions on the game board
  public static String checkWinner(){

    List topRow = Arrays.asList(1, 2, 3);
    List midRow = Arrays.asList(4, 5, 6);
    List bottomRow = Arrays.asList(7, 8, 9);

    List leftColumn = Arrays.asList(1, 4, 7);
    List midColumn = Arrays.asList(2, 5, 8);
    List rightColumn = Arrays.asList(3, 6, 9);

    List crossing = Arrays.asList(1, 5, 9);
    List secondCrossing = Arrays.asList(7, 5, 3);

    //Adding all these positions to a new List
    List<List> winningConditions = new ArrayList<List>();
    winningConditions.add(topRow);
    winningConditions.add(midRow);
    winningConditions.add(bottomRow);

    winningConditions.add(leftColumn);
    winningConditions.add(midColumn);
    winningConditions.add(rightColumn);

    winningConditions.add(crossing);
    winningConditions.add(secondCrossing);

//    Checking to see if the player or the cpu has won.
//    Or if a tie has occured.
    for(List l : winningConditions){
      if(playerLoc.containsAll(l)){
        return "Congratulations you are the winner";
      }
      else if (cpuLoc.containsAll(l)){
        return "Cpu is the winner, try again";
      }
      else if(playerLoc.size() + cpuLoc.size() == 9){
        return "Game Try, good job both sides.";
      }
    }
    return "";
  }
}
