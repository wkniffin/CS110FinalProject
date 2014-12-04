/*William Kniffin
CS110
Homework#10 */


import javax.swing.*;

/*
   the PlayWar class executes the game of war.  
   It creates a playing field and holds the play for the user and the computer.
*/
public class PlayWar
{
   public Card userPlay;
   public Card compPlay;
   private final int START = 0;
   private final int COMP_WIN = 0;
   private final int USER_WIN = 1;
   private final int WAR = 3;
   private int ct;
   public PlayingField playField;
   private int warCards;
   
   /*
      the PlayWar constructor creates a playing field for the PlayWar class to play war on.
   */
   public PlayWar()
   {
      playField = new PlayingField();
   }
   
   /*
      the play method sees which card played is of higher value (based on rank of the card)
      and returns an integer to represent who won. If the two cards match in rank, a value to
      represent a war is returned. If the play method is called after the war method has been called,
      it will initiate the collectWar method for whoever has won the next play.
   */
   public int play()
   {
      userPlay = playField.getUserPlay();
      compPlay = playField.getCompPlay();
      if(userPlay.getRank() < compPlay.getRank())
      {
         playField.addCardToCompDeck(userPlay);
         playField.addCardToCompDeck(compPlay);
         if(ct > START)
         {
            collectWar(COMP_WIN);
            ct = START;
         }
         return COMP_WIN;
      }
      else if(userPlay.getRank() > compPlay.getRank())
      {
         playField.addCardToUserDeck(compPlay);
         playField.addCardToUserDeck(userPlay);
         if(ct > START)
         {
            collectWar(USER_WIN);
            ct = START;
         }
         return USER_WIN;
      }
      else
      {
         return WAR;
      }
   }
   
   /*
      the war method adds the current cards played to the war deck
      and then two more cards from each player to the war deck. 
      it also sets the count to 3 which sets up the play method to call
      the collectWar method.
   */
   public void war()
   {
      playField.addCardToWarDeck(userPlay);
      playField.addCardToWarDeck(compPlay);
      playField.addCardToWarDeck(playField.getUserPlay());
      playField.addCardToWarDeck(playField.getCompPlay());
      playField.addCardToWarDeck(playField.getUserPlay());
      playField.addCardToWarDeck(playField.getCompPlay());
      ct = WAR;
   }
   
   /*
      the collectWar method takes the cards from the war deck and adds them to the
      deck of the player who won. 
   */
   public void collectWar(int win)
   {
      warCards = playField.getCardsLeft(WAR);
      if(win == COMP_WIN)
      {
         for(int i = 0; i < warCards; i++)
         {
            Card won = playField.getWarCard();
            playField.addCardToCompDeck(won);
         }
      }
      else
      {
         for(int i = 0; i < warCards; i++)
         {
            Card won = playField.getWarCard();
            playField.addCardToUserDeck(won);
         }
      }
   }
   
   /*
      the getPlay method returns the ImageIcon of the Card for each player based on
      the integer given to represend said player. Calls getImage from the Card class.
   */
   public ImageIcon getPlay(int player)
   {
      if(player == COMP_WIN)
      {
         return compPlay.getImage();
      }
      else
      {
         return userPlay.getImage();
      }
   }
   
   /*
      the getPlayField method returns the reference to the PlayingField object created
      in the PlayWar class. This method is for the GUI.
   */
   public PlayingField getPlayField()
   {
      return playField;
   }
}