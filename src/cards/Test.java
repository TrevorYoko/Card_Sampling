package cards;

import static org.junit.Assert.*;


public class Test {

	public static void main(String[] args)
	{
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		hand.makeThree();
		//hand.getRandomHand(false);
		hand2.getRandomHand(false);
		hand.sortHand();
		hand2.sortHand();
		System.out.println(hand.toString());
		System.out.println(hand2.toString());
		System.out.println(hand.getRank());
		System.out.println(hand2.getRank());
		System.out.println(hand.getRank().ordinal() > hand2.getRank().ordinal());
		
		System.out.println();
	
	}
	

}
 