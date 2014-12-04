/*William Kniffin
CS110
Homework#10 */

/*
   The PlayingField class creates the "field of play" for the war game.  
   It creates the deck of cards for the user, the computer, and for the 
   "war deck" which holds the cards during a war.  
*/

public class PlayingField
{
   public Deck userDeck;
   public Deck compDeck;
   public WarDeck warDeck;
   private final int START = 0;
   private final int COMP_WIN = 0;
   private final int USER_WIN = 1;
   private final int WAR = 3;
   
   /*
      The PlayingField contructor is a no argument constructor 
      which creates decks for each player and the war deck.
   */
   public PlayingField()
   {
      userDeck = new Deck();
      compDeck = new Deck();
      warDeck = new WarDeck();
   }
   
   /*
      the findWinner method checks if either deck is empty.
      If one of the decks is empty it returns the int which represents a user or a comp win.
   */
   public int findWinner()
   {
      if(userDeck.total() == START)
      {
         return COMP_WIN;
      }
      else if(compDeck.total() == START)
      {
         return USER_WIN;
      }
      else
      {
         return WAR;
      }
   }
   
   /*
      the getCardsLeft method returns the number of cards left in a deck based
      on what int representing the player is given.
   */
   public int getCardsLeft(int player)
   {
      if(player == COMP_WIN)
      {
         return compDeck.total();
      }
      else if(player == USER_WIN)
      {
         return userDeck.total();
      }
      else
      {
         return warDeck.total();
      }
   }
   
   /*
      the getUserPlay method returns the top Card of the user deck.
   */
   public Card getUserPlay()
   {
      return userDeck.dealCard();
   }
   /*
      the getCompPlay method returns the top Card of the comp deck.
   */
   public Card getCompPlay()
   {
      return compDeck.dealCard();
   }
   /*
      the getWarCard method returns the top Card of the war deck.
   */
   public Card getWarCard()
   {
      return warDeck.dealCard();
   }
   /*
      the addCardToUserDeck method adds a Card to the user deck at the beginning.
   */
   public void addCardToUserDeck(Card c)
   {
      userDeck.addCard(c);
   }
   /*
      the addCardToCompDeck method adds a Card to the comp deck at the beginning.
   */
   public void addCardToCompDeck(Card c)
   {
      compDeck.addCard(c);
   }
   /*
      the addCardToWarDeck method adds a Card to the war deck at the end.
   */
   public void addCardToWarDeck(Card c)
   {
      warDeck.addCard(c);
   }
}