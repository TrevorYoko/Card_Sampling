package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand 
{
	private ArrayList<Card> hand;
	private Rank rank;
	private Random_Generator rand;


	public Hand()
	{
		hand = new ArrayList<>();
		rand = new Javas_Random_Generator();
		
	}
	
	public void makeThree(){
		Card card = new Card(0);
		Card card2 = new Card(13);
		Card card3= new Card(26);
		Card card4 = new Card(3);
		Card card5= new Card(16);
		//Card draw = Deck.deck[rand.next_int(52)];
		//Card draw2 = Deck.deck[rand.next_int(52)];
		hand.add(card);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
		
	}

	public void getRandomHand(boolean seven)
	{
		//Set the number of cards to be drawn to be five or seven based
		//on the boolean parameter seven
		int numCards;
		if(seven)
		{
			numCards = 7;
		}
		else
		{
			numCards = 5;
		}

		Card draw = Deck.deck[rand.next_int(52)];
		hand.add(draw);

		//Loop until the number of cards is reached
		while(hand.size() < numCards)
		{
			draw = Deck.deck[rand.next_int(52)];
			if(!hand.contains(draw)) //If the hand does not already contain this card add it
			{
				hand.add(draw);
			}
		}
	}

	public void getTwoRandomHands(Hand hand1, Hand hand2)
	{
		//Fill the first two slots of hand1 and hand2 with null
		/*hand1.hand.add(null);
		hand1.hand.add(null);   //This allows us to add the shared cards
		hand2.hand.add(null);   //to the back of the hand
		hand2.hand.add(null);
	*/

		Card draw = Deck.deck[rand.next_int(52)];
		hand1.hand.add(draw);
		hand2.hand.add(draw);

		while(hand1.hand.size() < 5)
		{
			draw = Deck.deck[rand.next_int(52)];
			if(!hand1.hand.contains(draw)) //If the hand does not already contain this card add it
			{
				hand1.hand.add(draw);
				hand2.hand.add(draw);
			}
		}

		//Add two more cards to the front hand1
		for(int index = 0; index < 2; index ++)
		{
			draw = Deck.deck[rand.next_int(52)];
			if(!hand1.hand.contains(draw)) //If the hand does not already contain this card add it
			{
				hand1.hand.add(index,draw);
			}
			else
			{
				index --; // dont allow the index to increment
			}
		}

		//Add two more cards to the front hand2
		for(int index = 0; index < 2; index ++)
		{
			draw = Deck.deck[rand.next_int(52)];
			//If the hand does not already contain this card add it
			if(!hand1.hand.contains(draw) && !hand2.hand.contains(draw)) 
			{
				hand2.hand.add(index,draw);
			}
			else
			{
				index --; // dont allow the index to increment
			}
		}

	}
	public String toString()
	{
		String str = "";
		for(int index = 0; index < hand.size(); index ++)
		{
			str += hand.get(index) + ", ";
		}
		return str.substring(0, str.length()-2);
	}
	public void sortHand(){
		Collections.sort(hand, new Comparator<Card>(){
		    @Override
		    public int compare(Card card1, Card card2) {
		    	return card1.getValue().ordinal() - (card2.getValue().ordinal());
		    }});
	}

	public Rank getRank(){
		boolean isFlush = true;
		boolean isStraight = false;
		boolean fullHouse = false;
		int pair = getPairs();
		boolean threeOfAKind = isThreeOfAKind();
		boolean fourOfAKind = isFourOfAKind();
		rank = Rank.HighCard;
		sortHand();
		//Two Pair
		if(pair == 1){
			rank = Rank.Pair;
		}
		//Three Pair
		if(pair == 2){
			rank = Rank.TwoPair;
		}
		

		//Three of a Kind
		else if(threeOfAKind)
		{
			rank = Rank.ThreeOfKind;
			System.out.println("////////////////" + rank.toString());
		}
		//FullHouse
		if(threeOfAKind && pair == 1){
			fullHouse = true;
		}
		if(fullHouse){
			rank = Rank.FullHouse;
		}
		//Four of A Kind
		if(fourOfAKind){
			rank = Rank.FourOfKind;
		}
		//Flush
		for(int flushPosition = 0; flushPosition < hand.size() - 1; flushPosition++){
			if(!hand.get(flushPosition).getSuite().equals(hand.get(flushPosition + 1).getSuite())){
				isFlush = false;
			}
		}
		for(int straight = 0; straight < hand.size() - 1; straight++){
			if((hand.get(straight).getValue().ordinal() + 1) == (hand.get(straight).getValue().ordinal())){
				isStraight = true;
			}
		}
		if(isStraight && isFlush)
			rank = Rank.StraightFlush;
		else if(isFlush && !isStraight){
			rank = Rank.Flush;
		}
		else if(isStraight && !isFlush)
			rank = Rank.Straight;

		
		return rank;
	}

	private int getPairs() {
		int numPairs = 0; 
		for (int i = 0; i < hand.size(); i++) {
			Card first = hand.get(i);
			for (int j = i + 1; j < hand.size(); j++) {
				Card second = hand.get(j);
				if (first.getValue() == second.getValue()) {
					numPairs++;
				}
			}
		}
		return numPairs;
	}
	private boolean isThreeOfAKind() {
		int counter = 0;
	    for(int x = 2; x < hand.size(); x++){
	         for(int y = 0; y < x; y++){
	             if(hand.get(x).getValue().equals(hand.get(y).getValue()))
	                 counter++;
	         }
	         if(counter == 2) 
	        	 return true;
	         counter = 0;
	    }

	    return false;
	}
	private boolean isFourOfAKind() {
		int counter = 0;
	    for(int x = 2; x < hand.size(); x++){
	         for(int y = 0; y < x; y++){
	             if(hand.get(x).getValue().equals(hand.get(y).getValue()))
	                 counter++;
	         }
	         if(counter == 3) 
	        	 return true;
	         counter = 0;
	    }

	    return false;
	}

	
	
	
	public enum Rank
	{
		HighCard, Pair, TwoPair, ThreeOfKind, Straight, Flush, 
		FullHouse, FourOfKind, StraightFlush, RoyalFlush
	}
	
}
