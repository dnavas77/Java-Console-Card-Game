package cardgame;

public final class StartScreen
{
	/**
	 * Method start()
	 * @return outputs start screen for the game
	 */
	public static void startInfo()
	{
		System.out.println("Welcome to\nMAXETA's Card Game -Multiplayer\n");

		System.out.println("From 2 to 4 players!\n");

		System.out.println("Rules:\n> Every player draws a card once per round.\n"
							+ "> Cards are compared for value.\n"
							+ "> Deck is shuffled at beginning of every round.\n"
							+ "> Player with greatest card gets 2 points added to score.\n"
							+ "> Penalty cards will decrease your score by 1.\n"
							+ "> First player with 21 points (leading by 2 points) wins the game.\n"
							+ "> If a player gets 21 points leading only by 1, game continues.\n"
							+ "> If 2 or more players draw a card with the same rank, greates card\n"
							+ "  will be determined by the suit of the card. Precedence is as\n"
							+ "  follows: Spades > Hearts > Diamonds > Clubs\n");
	}
}
