package cardgame;

public final class Notifications
{

	/************************************
	 * PUBLIC METHODS
	 ************************************/

	// round number
	public static void displayRoundNumber(int roundNumber)
	{
		System.out.println();
		System.out.println("|******************************************************************");
		System.out.println("| Round Number: " + roundNumber);
		System.out.println("|******************************************************************");
		System.out.println();
	}

	// player turn
	public static void displayPlayerTurn(Player[] players, byte playerTurn)
	{		
		System.out.println();
		System.out.println("|---------------------------------");
		System.out.println("| Player turn: " + players[playerTurn].getName());
		System.out.println("| Type \"draw\" to draw a card");
		System.out.println("|---------------------------------");
		System.out.println();
	}
	
	// card drawn
	public static void displayCardDrawn(Card card)
	{
		System.out.println();
		System.out.println("|---------------------------------");
		System.out.println("| Your card:"); 
		System.out.println("|"); 
		System.out.println("| ***** " + card.toString() + " ****");
		System.out.println("|---------------------------------");
		System.out.println();
	}
	
}// end Notifications class
