//An implementation of a card type
public class Card {
//  Variables
    private Suit mySuit;

//    The number of hits cars, where Ace: 1, Jack-King : 11 - 13
    private int myNumber;

    public Card (Suit aSuit, int aNumber){

//      Card Constructor, aSuit = suit of the card,
//      aNumber = The number of the card.
      this.mySuit = aSuit;

      if (aNumber >= 1 && aNumber <= 13){
        this.myNumber = aNumber;
      }
      else{
        System.err.println(aNumber + " is not a valid card Number");
        System.exit(1);
      }

    }

//    Return the number of the card
    public int getNumber(){
      return myNumber;
    }

    public String toString(){

      String numStr = "Error";

      switch(this.myNumber){
        case 2 :
          numStr = "Two";
          break;

        case 3 :
          numStr = "Three";
          break;

        case 4 :
          numStr = "Four";
          break;

        case 5 :
          numStr = "Five";
          break;

        case 6 :
          numStr = "Six";
          break;

        case 7 :
          numStr = "Seven";
          break;

        case 8 :
          numStr = "Eight";
          break;

        case 9 :
          numStr = "Nine";
          break;

        case 10 :
          numStr = "Ten";
          break;

        case 11 :
          numStr = "Jack";
          break;

        case 12 :
          numStr = "Queen";
          break;

        case 13 :
          numStr = "King";
          break;

        case 1 :
          numStr = "Ace";
          break;

      }

      return numStr + " of " + mySuit.toString();
    }
}
