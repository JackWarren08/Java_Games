import java.util.Scanner;

public class TheGame {

  public static void main(String[] args) {
//    init
    Scanner sc = new Scanner(System.in);
    Deck theDeck = new Deck(1,true);

//    inti the player objects
    Player me = new Player("Jack");
    Player dealer = new Player("Dealer");

//    Player first card to both players
    me.addCard(theDeck.dealNextCard());
    dealer.addCard(theDeck.dealNextCard());

//    Playing second card to both players
    me.addCard(theDeck.dealNextCard());
    dealer.addCard(theDeck.dealNextCard());

//    print initial hands
    System.out.println("Cards are dealt\n");
    me.printHand(true);
    dealer.printHand(false);
    System.out.println("\n");

//    Flags for when each player is finished hitting
    boolean meDone = false;
    boolean dealerDone = false;
    String ans;

    while(!meDone || !dealerDone) {

//      Player's turns
      if (!meDone) {
        System.out.print("Hit or Stay? (Enter H or S): ");
        ans = sc.next();
        System.out.println();

//        If the player hits
        if (ans.compareToIgnoreCase("H") == 0) {

//          add next card in the deck and store whether play is bust
          meDone = !me.addCard(theDeck.dealNextCard());
          me.printHand(true);
        } else {
          meDone = true;
        }
      }

//      Dealer's turn
      if (!dealerDone) {
//        Dealer always hits if its below 17 count
        if (dealer.getHandSum() < 17) {
          System.out.println("\nThe dealer hits");
//        Add next card in the deck and store whether dealer is bust
          dealerDone = !dealer.addCard(theDeck.dealNextCard());
          dealer.printHand(false);
        } else {
          System.out.println("\nThe dealer stays");
          dealerDone = true;
        }
        System.out.println();
      }

    }
//      Close Scanner
      sc.close();

//      Print final hands
      me.printHand(true);
      dealer.printHand(true);

      int mySum = me.getHandSum();
      int dealerSum = dealer.getHandSum();

      if(mySum > dealerSum && mySum <= 21){
        System.out.println("\nYou Win with a card sum of : " + mySum +
            "\tWhile House had a sum of : " + dealerSum);
      }
      else if (dealerSum > 21){
        System.out.println("\nYou Win with a card sum of : " + mySum +
            "\tWhile House went bust with : " + dealerSum);
    }
      else {
        System.out.println("\nHouse Wins with card sum of : " + dealerSum +
            "\tWhile you had a sum of : " + mySum);
      }

  }
}
