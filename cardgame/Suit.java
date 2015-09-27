package cardgame;

public enum Suit
{
	CLUBS("Clubs"),
	DIAMONDS("Diamonds"),
	HEARTS("Hearts"),
	SPADES("Spades");
	
	// Private fields
	private final String _suitText;
	
	// Constructor
	Suit(String suitText)
	{
		this._suitText = suitText;
	}
	
	/**
	 * Method getSuit
	 * @return suit value
	 */
	public String getSuit()
	{
		return this._suitText;
	}
}
