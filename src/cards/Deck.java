package cards;

/**
 * This class will represent a deck of cards
 * 
 * The array  list deck will be accessible to all classes
 * 
 * @author jacob and Trevor
 *
 */
public class Deck 
{
	public static final Card[] deck = new Card[52];

	
	static
	{
	    for (int i=0; i < 52; i++)
	      {
	    	deck[i] = new Card(i);
	      }
	}
	public Card getCard(int position){
		return deck[position];
	}

}
