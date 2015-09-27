package cardgame;

import java.util.Scanner;

public final class GameActions
{
	// Private fields
	private static Scanner _scan = new Scanner(System.in);
	private static boolean _winnerExist = false;
	private static Player _gameWinner = null;
	
	/************************************
	 * PUBLIC METHODS
	 ************************************/

	/**
	 * Method creates amount of players based on user input
	 * @param players 
	 * @return nothing	
	 */
	public static Player[] createPlayers(Player[] players)
	{
		boolean a = true;
		byte amountPlayers = 0;

		while (a)
		{
			try
			{
				amountPlayers = _scan.nextByte();
					
				if (amountPlayers < 2 || amountPlayers > 4)
					System.out.println("Enter a number between 2 and 4:\n");
				else
					a = false;
			}
			catch (Exception InputMismatchException) 
			{
				System.out.println("Enter a number from 2 to 4:\n");
				_scan.next(); // needed to remove invalid token so user is asked again.
			}
		}

		// Initialize players array to user input
		players = new Player[amountPlayers];

		// Create players and add to Players array
		for(int i = 0; i < amountPlayers; i++)
		{
		    System.out.println("\nWhat is Player " + (i + 1) + " name?");
		    String name = _scan.next();
		    Player player = new Player();
		    player.setName(name);
		    players[i] = player;
		}

		return players;
	}
	
	/**
	 * Method asks user if playing again
	 * @return true or false boolean value
	 */
	public static boolean playAgain()
	{
		String choice = "";
		while (!choice.equals("yes") || !choice.equals("no"))
		{
			System.out.println("Would you like to play again? Enter: yes/no");
			choice = _scan.next();
			
			if (choice.equals("yes"))
				return true;
			else if (choice.equals("no"))
				break;
		}
		System.out.println("\nThank you for playing. Come back soon!");
		return false;
	}
	
	/**
	 * Method takes user input to draw topmost random card from shuffled deck
	 * @return nothing
	 */
	public static Card drawCardFromDeck(Deck deck)
	{
		String s = "";
		
		while(!s.equals("draw"))
		{
			s = _scan.next();

			if (!s.equals("draw"))
				System.out.println("Type \"draw\" to draw a card");
		}

		return deck.dealCard();
	}

	/**
	 * Method processes scores from one round.
	 * It penalizes players who drew a penalty card.
	 * It increases score of player with greatest card.
	 * It determines if there's a game winner at end of round.
	 * @param players
	 * @return boolean value determines if there's a winner
	 */
	public static void processScores(Player[] players)
	{
		int roundWinner = 0;
		int max = 0;
		int i = 0;
		for(i = 0; i < players.length; i++)
		{
			// Find player with greatest card and increase score
			if(players[i].getCardSelected().getValue() > max)
			{
				max = players[i].getCardSelected().getValue();
				roundWinner = i;
			}

			// Penalize players who drew a penalty card
			if(players[i].getCardSelected().getCardRank() == -1 && players[i].getScore() > 0)
			{
				players[i].decreaseScore();
				players[i].setRoundPoints(-1);
			}
			else
				players[i].setRoundPoints(0);
		}

		// Reward round winner and reset previous winner.
		for(i = 0; i < players.length; i++)
		{
			if (i == roundWinner)
			{
				players[i].increaseScore();
				players[i].setRoundPoints(2);
				players[i].setRoundWinner(true);
			}
			else
				players[i].setRoundWinner(false);
		}
		
		// Check if round winner is the game winner.
		// If a player has 21 or more points leading by at least 2 points
		// set boolean variable _winnerExist to true;
		int count = 0;
		if(players[roundWinner].getScore() >= 21)
		{
			for(i = 0; i < players.length; i++)
			{
				if (i != roundWinner)
				{
					if((players[roundWinner].getScore() - players[i].getScore()) >= 2)
						count++;
				}
			}
			
			if(count == players.length - 1)
			{
				_winnerExist = true;
				_gameWinner = players[roundWinner];
			}
		}
		
	}// end processScores()
	
	/**
	 * Method returns value of private winner variable to caller
	 * @return true if there's a winner, false if no winner yet
	 */
	public static boolean winnerExist()
	{
		return _winnerExist;
	}
	
	/**
	 * Method returns private variable _gameWinner to caller
	 * @return Player object
	 */
	public static Player getGameWinner()
	{
		return _gameWinner;
	}
	
	/**
	 * Method resets private variables to default values
	 * @return nothing
	 */
	public static void resetAll()
	{
		_winnerExist = false;
		_gameWinner = null;
	}

}// end GameActions class
