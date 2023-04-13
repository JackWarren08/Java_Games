import java.util.Random;

//An  implementation of a desk cars
public class Deck {
//  Array if cards in the deck
  private Card[] myCards;

//  Number of cards currently in the desk
  private int numCards;

//
  public Deck(){
//    Call the other constructor, defining the one deck without shuffling
    this(1, false);
  }

//  Constructor defines the number of deck and whether it should be shuffled

  public Deck (int numDeck, boolean shuffle) {

    this.numCards = numDeck * 52;
    this.myCards = new Card[this.numCards];

//    int card index
    int c = 0;

//    For each Deck
    for (int d = 0; d < numDeck; d++) {
//      For each Suit
      for (int s =0; s < 4; s++) {
//        For each Number
        for (int n = 1; n <= 13; n++) {
//          Add a new card to the deck
          this.myCards[c] = new Card(Suit.values()[s], n);
          c++;

        }
      }
    }

//    Shuffle if necessary
      if (shuffle) {
        this.shuffle();
      }
  }

//  Shuffle deck by randomly swapping pairs of cards.
  public void shuffle(){
//    init random number Generator
    Random rng = new Random();
//    Temp card
    Card temp;
//      Get a random card j to swap i's value with
    int j;
    for (int i = 0; i < this.numCards; i++)
    {
//      Swapping
      j = rng.nextInt(this.numCards);

      temp = this.myCards[i];
      this.myCards[i] = this.myCards[j];
      this.myCards[j] = temp;
    }
  }

//  Deal the next card from the top of the deck.
  public Card dealNextCard(){
//    Get top card
    Card top = this.myCards[0];

//    Shift all the subsequent cards to the left by one
    for (int c = 1; c < this.numCards; c++)
    {
      this.myCards[c-1] = this.myCards[c];
    }

    this.myCards[this.numCards-1] = null;

//    Decrement the number of cards in our deck
    this.numCards--;

    return top;
  }

//  Print the top cards in the deck
  public void printDeck(int numToPrint){

    for(int c = 0; c < numToPrint; c++){
      System.out.printf("% 3d/%d %s\n", c+1, this.numCards,
          this.myCards[c].toString());
    }

    System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
  }
}
