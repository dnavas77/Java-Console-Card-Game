package cardgame;

public class Deck
{
	// Private fields
	private final int NUM_CARDS = 56;
	private final int SHUFFLE_AMT = 100;
	private Card[] _deck;
	private int _currentCard;

	// Constructor
	public Deck()
	{
		_deck = new Card[NUM_CARDS];
		_currentCard = 0;
		
		// Populate deck
		int index = 0;
		for (Rank r: Rank.values())
		{
			for(Suit s: Suit.values())
			{
				/* if index is greater than 51, it means
				 * we are creating penalty cards which
				 * should have a value less than 0
				 * because 0 values is for 2 of spades
				 */
				if (index > 51)
					_deck[index] = new Card(r, s, -1);
				else
					_deck[index] = new Card(r, s, index);
				
				// increment index
				index++;
			}
		}
	}
	

	/************************************
	 * PUBLIC METHODS
	 ************************************/

	/**
	 * This method shuffles the deck randomly.
	 * @return nothing 
	 */
	public void shuffle()
	{
		int i, j, k;

		for (k = 0; k < SHUFFLE_AMT; k++)
		{
		    i = (int) (NUM_CARDS * Math.random());
		    j = (int) (NUM_CARDS * Math.random());
	
		    // swap randomly selected cards
		    Card tmp = _deck[i];
		    _deck[i] = _deck[j];
		    _deck[j] = tmp;
		}
		 _currentCard = 0;   // Reset current card to deal
	}

	/**
	 * Method draws a card from top of deck for player
	 * @return a Card object
	 */
	public Card dealCard()
	{
		if (_currentCard < NUM_CARDS)
		    return (_deck[_currentCard++]);
		else
		{
		    System.out.println("Out of cards error");
		    return (null);
		}
	}

	/**
	 * Method toString()
	 * @return a string representation of all cards in deck
	 */
	public String toString()
	{
		String tmp = "";
		for (Card c: _deck)
		{
			tmp += c.getCardRank() + " of " + c.getCardSuit() + " \n";
		}
		return tmp;
	}
	
} // end Deck
