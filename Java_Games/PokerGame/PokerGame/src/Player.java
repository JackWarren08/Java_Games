//An implementation of a blackjack Player
public class Player {
//  The players Name
  private String name;

//  The cards in the player's current hand
  private Card[] hand = new Card[10];

//  The number of cards in the player's current hand
  private int numCards;

//  Player constructor
  public Player(String aName){
    this.name = aName;

//    set a player's hand to empty
    this.emptyHand();
  }

//  Reset the player's hand to have no cards
  public void emptyHand(){
    for(int c= 0; c < 10; c++){
      this.hand[c] = null;
    }
    this.numCards = 0;
  }

//  Add a card to the player's hand
  public boolean addCard(Card aCard){

//    Print error if we already have the max number of cards
    if(this.numCards == 10){
      System.err.printf("%s's hand already has 10 cards: " + "cannot add another\n",
          this.name);
      System.exit(1);
    }

//    Add new card in the next slot and increment number of cards counter
    this.hand[this.numCards] = aCard;
    this.numCards++;

    return (this.getHandSum() <= 21);
  }

//  Get the sum of the cards in the player's hand
  public int getHandSum(){
    int handSum = 0;
    int cardNum;
    int numAces = 0;

//    Calc each card's contribution to the hand sum
    for(int c = 0; c < this.numCards; c++){
//      get the number for the current card
      cardNum = this.hand[c].getNumber();

      if(cardNum == 1){
        numAces++;
        handSum += 11;
      } else if (cardNum > 10) {
        handSum += 10;
      }
      else {
        handSum += cardNum;
      }
    }

//    if we have aces and our sum is > 21, set some/all of them to the
//    value 1 instead

    while(handSum > 21 && numAces > 0){
      handSum -=10;
      numAces--;
    }
    return handSum;

  }

//  Print the cards in the player's hand.
  public void printHand(boolean showFirstCard){
    System.out.printf("\n%s's cards: \n", this.name);
    for(int c = 0; c < this.numCards; c++){
      if(c == 0 && !showFirstCard){
        System.out.println("  [hidden]");
      }
      else{
        System.out.printf("  %s\n", this.hand[c].toString());
      }
    }
  }
}
