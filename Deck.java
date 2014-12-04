import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/*
   the Deck class creates a deck of 52 Cards.
*/
public class Deck
{
   public final static int CARDS_IN_DECK = 52;
   public final int FIRST = 0;
   private Card [] deck;
   private int ct;
   private ArrayList<Card> listDeck;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {
      freshDeck();
   }

   /*
      the freshDeck method creates an array of 52 cards exactly like a real deck
      and then calls the shuffle method and the toArrayList method.
   */  
   public void freshDeck()
   {
      deck = new Card[CARDS_IN_DECK];
      for (int r = Card.ACE; r <= Card.KING;r++)
      {
         for (int s = Card.SPADES; s <= Card.CLUBS; s++)
         {
            deck[ct]=new Card(r,s);
            ct = ct + 1;
         }
      }
      shuffle();
      toArrayList();
   }

   /*
      the dealCard method returns a Card from the end of the list and then removes it.
   */
   public Card dealCard()
   {
      ct--;
      Card temp = listDeck.get(ct);
      listDeck.remove(ct);
      return temp;  
   }
   
   /*
      the addCard method adds the specified card to the front of the list.
   */
   public void addCard(Card c)
   {
      ct++;
      listDeck.add(FIRST, c);
   }
 
   /*
      the total method returns the total amount of Cards in the listDeck.
   */
   public int total()
   {  
      return listDeck.size();
   }
   
   /*
      the shuffle method shuffles the Cards in the array deck.
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i] = deck[randNum];
         deck[randNum] = temp;
      }
   }
   
   /*
      the toArrayList method converts the deck array to an ArrayList called listDeck.
   */
   public void toArrayList()
   {
      listDeck = new ArrayList<Card>(Arrays.asList(deck));  
   }
}
