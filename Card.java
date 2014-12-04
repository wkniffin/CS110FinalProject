/*William Kniffin
CS110
Homework#10 */

import javax.swing.ImageIcon;

/*
   the Card class creates a card which holds the rank and the suit of the card and an ImageIcon for the card.
*/
public class Card
{
   public int rank;
   public char suit;
   public static final int ACE = 1;
   public static final int KING = 13;
   public static final int SPADES = 1, HEARTS = 2, DIAMONDS = 3, CLUBS = 4;
   public ImageIcon cardFront;
   
   /*
      the Card contructor takes the rank and the suit and creates a card.
      It converts the integer which represents the suit into a character.
      It also gets an image to represent the Card from the cardPics folder.
   */
   public Card(int rank, int suit)
   {
      this.rank = rank;
      if(suit == SPADES)
      {
         this.suit = 's';
      }
      else if(suit == HEARTS)
      {
         this.suit = 'h';
      }
      else if(suit == DIAMONDS)
      {
         this.suit = 'd';
      }
      else
      {
         this.suit = 'c';
      }
      cardFront = new ImageIcon("cardPics/" + rank + this.suit + ".jpg");
   }
   
   /*
      the getRank method returns the rank of the card.
   */
   public int getRank()
   {
      return rank;
   }
   
   /*
      the getSuit method returns the suit of the card.
   */
   public char getSuit()
   {
      return suit;
   }
   
   /*
      the setImage method sets the image of the card.
   */
   public void setImage()
   {
      cardFront = new ImageIcon("cardPics/" + rank + suit + ".jpg");
      System.out.println(suit);
   }
   
   /*
      the getImage method returns the ImageIcon associated with the card.
   */
   public ImageIcon getImage()
   {
      return cardFront;
   }
}