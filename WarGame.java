/*William Kniffin
CS110
Homework#10 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
   the WarGame class is the GUI for the PlayWar class.
*/
public class WarGame extends JFrame
{
   public final int USER = 1;
   public final int COMP = 0;
   public final int WAR = 3;
   private PlayWar game;
   private PlayingField playField;
   private JPanel topPanel, gamePanel, userPanel, compPanel, warPanel;
   private JButton play;
   private JLabel userCards, compCards, warCards, compTitle, userTitle;
   private JLabel userCardBack, compCardBack;
   private JLabel title, whoWins;
   private JLabel me;
   private JLabel back, back2, back3;
   private ImageIcon backImage;
   private JLabel win;
   private JLabel userPlay, compPlay;
   private int playIt;
   private int ct;
   
   /*
      the WarGame constructor creates the panels, button, and labels for the GUI window.  
      There is a topPanel which holds the title, and gamePanel which holds the game actions,
      a user and a computer panel which holds the card totals for each player, and a warPanel
      which holds the amount of cards in the war pile.
   */
   public WarGame()
   {
      backImage = new ImageIcon("cardPics/back.jpg");
      back = new JLabel(backImage);
      back2 = new JLabel(backImage);
      back3 = new JLabel(backImage);
      
      game = new PlayWar();
      playField = game.getPlayField();
      
      topPanel = new JPanel();
      add(topPanel, BorderLayout.PAGE_START);
      topPanel.setBackground(new Color(255, 255, 226));
      title = new JLabel("WAR!");
      title.setFont(new Font("Courier", Font.BOLD, 36));
      topPanel.add(title);
      me = new JLabel("By William D. Kniffin");
      me.setFont(new Font("Courier", Font.ITALIC, 12));
      topPanel.add(me);
      
      gamePanel = new JPanel(new BorderLayout());
      add(gamePanel, BorderLayout.CENTER);
      gamePanel.setBackground(new Color(246, 246, 246));
      play = new JButton("Deal Cards");
      play.setFont(new Font("Courier", Font.BOLD, 25));
      play.addActionListener(new ButtonListener());
      gamePanel.add(play, BorderLayout.PAGE_START);
      compPlay = new JLabel();
      userPlay = new JLabel();
      gamePanel.add(compPlay, BorderLayout.LINE_END);
      gamePanel.add(userPlay, BorderLayout.LINE_START);
      whoWins = new JLabel();
      gamePanel.add(whoWins, BorderLayout.CENTER);
      whoWins.setHorizontalAlignment(JLabel.CENTER);
      whoWins.setFont(new Font("Courier", Font.BOLD, 36));
      
      
      userPanel = new JPanel();
      userPanel.setLayout(new GridLayout(3, 1));
      userTitle = new JLabel("Player");
      userPanel.add(userTitle);
      userTitle.setHorizontalAlignment(JLabel.CENTER);
      add(userPanel, BorderLayout.LINE_START);
      userPanel.setBackground(new Color(230, 232, 255));
      userPanel.add(back);
      userCards = new JLabel("Cards left: " + playField.getCardsLeft(USER));
      userPanel.add(userCards);
      userCards.setHorizontalAlignment(JLabel.CENTER);
      
      
      compPanel = new JPanel();
      compPanel.setLayout(new GridLayout(3, 1));
      add(compPanel, BorderLayout.LINE_END);
      compTitle = new JLabel("Computer");
      compPanel.add(compTitle);
      compTitle.setHorizontalAlignment(JLabel.CENTER);
      compPanel.setBackground(new Color(255, 230, 230));
      compPanel.add(back2);
      compCards = new JLabel("Cards left: " + playField.getCardsLeft(COMP));
      compPanel.add(compCards);
      compCards.setHorizontalAlignment(JLabel.CENTER);
      
      warPanel = new JPanel();
      add(warPanel, BorderLayout.PAGE_END);
      warPanel.setBackground(new Color(255, 232, 212));
      warCards = new JLabel("War Cards: " + playField.getCardsLeft(WAR));
      warPanel.add(warCards);
      warCards.setHorizontalAlignment(JLabel.CENTER);
   }
   
   /*
      the ButtonListener class executes all the actions when the play button is pressed.
   */
   private class ButtonListener implements ActionListener
   {
      /*
         the actionPerformed method takes in the button press and executes a number of actions
         based on what is happening in the game. The user clicks the button each time trading cards
         with the computer until there is a war, when each player adds 3 cards to the pile and then 
         a deciding card is dealt from each. The player who wins gets all the cards from the war pile.
      */
      public void actionPerformed(ActionEvent ae)
      {
         if(ct == 5)
         {
            game = new PlayWar();
            playField = game.getPlayField();
            compCards.setText("Cards left: " + playField.getCardsLeft(COMP));
            userCards.setText("Cards left: " + playField.getCardsLeft(USER));
            warCards.setText("War Cards: " + playField.getCardsLeft(WAR));
            play.setText("Deal Cards");
         }
         if(playField.findWinner() == USER)
         {
            whoWins.setText("PLAYER WINS!");
            whoWins.setFont(new Font("Courier", Font.BOLD, 36));
            play.setText("Play again?");
            ct = 5;
         }
         else if(playField.findWinner() == COMP)
         {
            whoWins.setText("Computer wins :(");
            whoWins.setFont(new Font("Courier", Font.BOLD, 36));
            play.setText("Play again?");
            ct = 5;
         }
            
         playIt = game.play();
         compPlay.setIcon(game.getPlay(COMP));
         userPlay.setIcon(game.getPlay(USER));
         compCards.setText("Cards left: " + playField.getCardsLeft(COMP));
         userCards.setText("Cards left: " + playField.getCardsLeft(USER));
         warCards.setText("War Cards: " + playField.getCardsLeft(WAR));
         
         if(playIt == COMP)
         {
            whoWins.setText("Computer wins the cards");
            play.setText("Deal Cards");
            ct = 0;
         }
         else if(playIt == USER)
         {
            whoWins.setText("Player wins the cards!");
            play.setText("Deal Cards");
            ct = 0;
         }
         else
         {
            whoWins.setText("WAR!");
            ct = 2;
            game.war();
            compCards.setText("Cards left: " + playField.getCardsLeft(COMP));
            userCards.setText("Cards left: " + playField.getCardsLeft(USER));
            warCards.setText("War Cards: " + playField.getCardsLeft(WAR));
            play.setText("Deal war play!");
         }
      }
   }        
   
   /*
      the main method creates the window.
   */
   public static void main(String [] args)
   {
      JFrame frame = new WarGame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1280,800);
      frame.validate();
      frame.setVisible(true);
   }
}