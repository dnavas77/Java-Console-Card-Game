package cardgame;

public final class ScoreBoard
{

	/************************************
	 * PUBLIC METHODS
	 ************************************/
	
	/**
	 * Method outputs overall scores for all player
	 * as well as round points and round winner
	 * @param players
	 */
	public static void displayRoundScores(Player[] players, int roundNumber)
	{
		System.out.println("###########################################");
		System.out.println("|              SCORE BOARD                |");
		System.out.println("|               Round: " + roundNumber + "                  |");
		System.out.println("|-----------------------------------------|");
		
		for(Player p: players)
		{
			String roundWinner = p.getRoundWinner() ? "(round winner!)" : "";

			System.out.println("| Player: " + p.getName() + " " + roundWinner);
			System.out.println("| Score: " + p.getScore());
			System.out.println("| Round Points: " + p.getRoundPoints());
			System.out.println("|=========================================|");
		}
		System.out.println();
	}
	
	/**
	 * 
	 */
	public static void displayGameWinner()
	{
		System.out.println();
		System.out.println("|***************************************************|");
		System.out.println("|*************** CONGRATULATIONS!!! ****************|");
		System.out.println("|****************** GAME WINNER ********************|");
		System.out.println("|                                                   |");
		System.out.println("| Player: " + GameActions.getGameWinner().getName());
		System.out.println("| Final Score: " + GameActions.getGameWinner().getScore());
		System.out.println("|                                                   |");
		System.out.println("|****************************************************");
		System.out.println();
	}
	
}// end ScoreBoard class
