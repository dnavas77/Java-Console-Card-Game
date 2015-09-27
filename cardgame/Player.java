package cardgame;

public class Player
{
	// Private fields
	private int _score;
	private int _decreaseValue;
	private int _increaseValue;
	private Card _cardSelected;
	private String _name;
	private int _roundPoints;
	private boolean _isRoundWinner;			
	
	// Constructor
	public Player()
	{
		_score = 0;
		_cardSelected = null;
		_decreaseValue = 1;
		_increaseValue = 2;
		_roundPoints = 0;
		_isRoundWinner = false;
		_name = "";
	}

	/************************************
	 * GETTERS AND SETTERS 
	 ************************************/

	public int getScore()
	{
		return _score;
	}

	public boolean getRoundWinner()
	{
		return _isRoundWinner;
	}

	public void setRoundWinner(boolean isRoundWinner)
	{
		_isRoundWinner = isRoundWinner;
	}

	public void decreaseScore()
	{
		_score = _score - _decreaseValue;
	}
	
	public void increaseScore()
	{
		_score = _score + _increaseValue;
	}

	public Card getCardSelected()
	{
		return _cardSelected;
	}

	public void setCardSelected(Card cardSelected)
	{
		_cardSelected = cardSelected;
	}

	public String getName()
	{
		return _name;
	}

	public void setName(String name)
	{
		_name = name;
	}

	public int getRoundPoints()
	{
		return _roundPoints;
	}

	public void setRoundPoints(int roundPoints)
	{
		_roundPoints = roundPoints;
	}

}// end Player
