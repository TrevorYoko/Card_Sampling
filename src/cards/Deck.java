package cards;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cards.Card.Suite;

/**
 * This class will represent a deck of cards
 * 
 * The array  list deck will be accessible to all classes
 * 
 * @author jacob
 *
 */
public class Deck 
{
	//public ArrayList<Card> deck;  //The actual deck that will accessible publicly
	public static final Card[] deck = new Card[52];
	/**
	 * Constructor Method
	 * 
	 * The deck will be created and filled with all 52 cards
	 */

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
