/*William Kniffin
CS110
Homework#10 */

import java.util.ArrayList;

/*
   the WarDeck class is a Deck which has a simplified contructor, and addCard method.
   It also overrides the total and dealCard method to add and remove cards from the 
   correct arraylist.
*/
public class WarDeck extends Deck
{
   public final int FIRST = 0;
   private ArrayList<Card> warDeck;
   private int ct;
   
   /*
      the WarDeck contructor creates a new ArrayList to hold the Card objects added during a war.
   */
   public WarDeck()
   {
      warDeck = new ArrayList<Card>();
   }
   
   /*
      the addCard method adds a card to the warDeck at the end of the list.
   */
   public void addCard(Card c)
   {
      warDeck.add(c);
      ct++;
   }
   
   /*
      the total method returns the size of the ArrayList.
   */
   public int total()
   {  
      return warDeck.size();
   }
   
   /*
      the dealCard method returns a card from the end of the list.
   */
   public Card dealCard()
   {
      ct--;
      return warDeck.remove(ct); 
   }
}