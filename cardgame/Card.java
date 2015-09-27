package cardgame;

public class Card
{
	// Private fields
	private Suit _suit;
	private Rank _rank;
	private int _value;


	public boolean isFlipped;
	
	// Constructor
	public Card(Rank rank, Suit suit, int value)
	{
		_rank = rank;
		_suit = suit;
		_value = value;
		this.isFlipped = false;
	}

	/************************************
	 * PUBLIC METHODS
	 ************************************/
	
	/**
	 * Method getCardSuit()
	 * @return suit of card
	 */
	public String getCardSuit()
	{
		return _suit.getSuit();
	}
	
	/**
	 * Method getCardRank()
	 * @return rank of card
	 */
	public int getCardRank()
	{
		return _rank.getRank();
	}
	
	/**
	 * Method getValue()
	 * @return integer holding value for instance variable _value
	 */
	public int getValue()
	{
		return _value;
	}

	/**
	 * Method setValue() sets instance variable _value to passed value parameter
	 * @param int value
	 */
	public void setValue(int value)
	{
		_value = value;
	}
	
	/**
	 * Method toString()
	 * @return suit and rank of card as a string
	 */
	public String toString()
	{
		// If rank is Ace don't output 1 but "Ace".
		if (_rank.getRank() == 1 || _rank.getRank() == 11 ||
			_rank.getRank() == 12 || _rank.getRank() == 13)
		{
			return _rank + " of " + _suit.getSuit();
		}

		return _rank.getRank() + " of " + _suit.getSuit();
	}

}// end Card
