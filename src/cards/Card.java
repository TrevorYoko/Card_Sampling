package cards;

/**
 * Card Class
 * 
 * This class represents a playing card and holds a face value
 * and a suite
 * 
 * @author Jacob
 *
 */
public class Card{
	private CardValue value;
	private Suite suite; //4 = spades  3 = hearts
	//2 = diamonds   1 = clubs

	/**
	 * Constructor Methods
	 * 
	 * Creates a card object with given parameters
	 * 
	 * @param value
	 * @param suite
	 */
	public Card(int position)
	{

		switch (position / 13) {
    	case 0:  
    		this.suite = Suite.Clubs;
    		break;
    	case 1:
    		this.suite = Suite.Diamonds;
    		break;
    	case 2:
    		this.suite = Suite.Hearts;
    		break;
    	case 3: 
    		this.suite = Suite.Spades;
    		break;
    }

		switch(position % 13){
		case 0:
			this.value = CardValue.Two;
			break;
		case 1:
			this.value = CardValue.Three;
			break;
		case 2:
			this.value = CardValue.Four;
			break;
		case 3:
			this.value = CardValue.Five;
			break;
		case 4:
			this.value = CardValue.Six;
			break;
		case 5:
			this.value = CardValue.Seven;
			break;
		case 6:
			this.value = CardValue.Eight;
			break;
		case 7:
			this.value = CardValue.Nine;
			break;
		case 8:
			this.value = CardValue.Ten;
			break;
		case 9:
			this.value = CardValue.Jack;
			break;
		case 10:
			this.value = CardValue.Queen;
			break;
		case 11:
			this.value = CardValue.King;
			break;
		case 12:
			this.value = CardValue.Ace;
			break;
			
		}
          		
	}

	/**
	 * Gets the value of the card
	 * 
	 * @return value
	 */
	public CardValue getValue()
	{
		return this.value;
	}

	/**
	 * Gets the suite of the card
	 * 
	 * @return suite
	 */
	public Suite getSuite()
	{
		return this.suite;
	}
	

	public String toString()
	{
		String str = "";
		
		str += value + " of " + suite;
		
		return str;
	}

	
	public enum Suite
	{
		Hearts, Spades, Clubs, Diamonds
	}
	public enum CardValue{
		Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
	}
	

}
