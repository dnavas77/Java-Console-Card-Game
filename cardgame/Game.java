/**
 * Card Game Project for MAXETATECH
 * 
 * Completed: Sunday September 27, 2015
 * @author Danilo Navas (danilo.navas@outlook.com)
 * @version 1.0.0
 */

package cardgame;


public class Game
{
	// Main
	public static void main(String[] args)
	{
		StartScreen.startInfo();
		boolean playAgain = true;
				
		while(playAgain)
		{
			// Default game state on initialization
			Deck deck = new Deck();
			Card cardDrawn;
			byte playerTurn = 0;
			int roundNumber= 1;
			Player[] players = null;
			boolean winner = false;
			GameActions.resetAll();

			System.out.println("Enter amount of players:");
			players = GameActions.createPlayers(players);

			deck.shuffle();
			
			while(winner == false)
			{
				Notifications.displayRoundNumber(roundNumber);
				pressEnterToContinue();

				while(playerTurn < players.length)
				{
					Notifications.displayPlayerTurn(players, playerTurn);

					cardDrawn = GameActions.drawCardFromDeck(deck);
					players[playerTurn].setCardSelected(cardDrawn);

					Notifications.displayCardDrawn(cardDrawn);
					pressEnterToContinue();
					
					playerTurn++;
				}

				GameActions.processScores(players);
				ScoreBoard.displayRoundScores(players, roundNumber);
				pressEnterToContinue();
				
				roundNumber++;
				playerTurn = 0;

				winner = GameActions.winnerExist();
			}

			ScoreBoard.displayGameWinner();
			playAgain = GameActions.playAgain();
		}
	}
	
	// Helper method
	public static void pressEnterToContinue()
	{ 
		System.out.println("Press <enter> to continue...");
	    try
	    {
	    	System.in.read();
	    }  
	    catch(Exception e)
	    {}  
	 }
	
}// end Game class
