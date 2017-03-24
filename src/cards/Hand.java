package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import cards.Card.Suite;

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
	public void add(Card card){
		hand.add(card);
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
		hand1.hand.add(null);
		hand1.hand.add(null);   //This allows us to add the shared cards
		hand2.hand.add(null);   //to the back of the hand
		hand2.hand.add(null);
	
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
		boolean threeOfAKind = isThreeOfAKind();
		boolean fourOfAKind = isFourOfAKind();
		boolean isStraight = isStraight();
		boolean isFlush = isFlush();
		boolean isFullHouse = isFullHouse();
		rank = Rank.HighCard;
		sortHand();
		//Pair
		if(isPair()){
			rank = Rank.Pair;
		}
		//Two Pair
		if(isTwoPair()){
			rank = Rank.TwoPair;
		}
		//Three of a Kind
		if(threeOfAKind)
		{
			rank = Rank.ThreeOfKind;
		}
		//Straight
		if(isStraight)
			rank = Rank.Straight;
		//Flush
		if(isFlush){
			rank = Rank.Flush;
		}
		//FullHouse
		if(isFullHouse){
			rank = Rank.FullHouse;
		}
		//Four of A Kind
		if(fourOfAKind){
			rank = Rank.FourOfKind;
		}

		//StraightFlush
		if(isStraight && isFlush)
			rank = Rank.StraightFlush;

		//RoyalFlush
		if(isRoyalFlush() && isFlush && isStraight){
			rank = Rank.RoyalFlush;
		}

		return rank;
	}

	private boolean isFlush() {
		int countHeart = 0;
		int countSpade = 0;
		int countClub = 0;
		int countDiamond = 0;

		for (int index = 0; index < hand.size(); index++) {
			if (hand.get(index).getSuite() == Suite.Hearts) {
				countHeart++;
			}
			if (hand.get(index).getSuite() == Suite.Spades) {
				countSpade++;
			}
			if (hand.get(index).getSuite() == Suite.Clubs) {
				countClub++;
			}
			if (hand.get(index).getSuite() == Suite.Diamonds) {
				countDiamond++;
			}
		}

		if ((countHeart == 5 || countSpade == 5 || countClub == 5 || countDiamond == 5) || (countHeart == 7 || countSpade == 7 || countClub == 7 || countDiamond == 7)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isStraight() {
		int count = 0;

		for (int index = 0; index < hand.size() - 1; index++) {
			if (hand.get(index).getValue().ordinal() + 1 == (hand.get(index + 1).getValue().ordinal())) {
				count++;
			} 
		}
		if (count == 4 || count == 6) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isPair() {
		int[] cardValues = new int[13];
		for (int i = 0; i < hand.size(); i++) {
			cardValues[hand.get(i).getValue().ordinal()]++;
		}
		for (int i = 0; i < cardValues.length; i++) {
			if (cardValues[i] == 2) {
				if (!isTwoPair() || !isFullHouse()) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Returns true if PokerHand is two pair (not full house)
	// false otherwise.
	private boolean isTwoPair() {
		int[] cardValues = new int[13];
		int numberOfPairs = 0;
		for (int i = 0; i < hand.size(); i++) {
			cardValues[hand.get(i).getValue().ordinal()]++;
		}
		for (int i = 0; i < cardValues.length; i++) {
			if (cardValues[i] == 2) {
				numberOfPairs++;
			}
		}
		if (numberOfPairs == 2) {
			return true;
		}
		return false;
	}

	// Returns true if PokerHand is a Full House
	// false otherwise
	private boolean isFullHouse(){
		boolean hasAPair = false;
		int[] cardValues = new int[13];
		for(int i = 0; i < hand.size(); i++){
			cardValues[hand.get(i).getValue().ordinal()]++;
		}
		for(int i = 0; i < cardValues.length; i++){
			if(cardValues[i] == 2){
				hasAPair = true;
		    }
		}
		if(hasAPair && isThreeOfAKind()){			
			return true;
		}
		return false;
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
	private boolean isRoyalFlush(){
		int numberCounter = 0;
		for(int index = 0; index < hand.size(); index++){
			numberCounter += (hand.get(index).getValue().ordinal());
		}
		if(numberCounter == 50 || numberCounter == 63)
			return true;
		return false;
	}

	
	public enum Rank
	{
		HighCard, Pair, TwoPair, ThreeOfKind, Straight, Flush, 
		FullHouse, FourOfKind, StraightFlush, RoyalFlush
	}
	
}
