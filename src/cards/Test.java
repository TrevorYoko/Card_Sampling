package cards;

import static org.junit.Assert.*;


public class Test {

	public static void main(String[] args)
	{
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		hand.makeThree();
		//hand.getRandomHand(false);
		hand2.getRandomHand(true);
		hand.sortHand();
		hand2.sortHand();
		System.out.println(hand.toString());
		System.out.println(hand2.toString());
		System.out.println(hand.getRank());
		System.out.println(hand2.getRank());
		System.out.println(hand.Winner(hand2));
		
		System.out.println();
	
	}
	

}
 