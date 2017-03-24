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

		double[] percent1 = Odds.percentage_per_hand_category_exhaustive(5);
		double[] percent2 = Odds.percentage_per_hand_category_stochastic(5,150000);
		
		System.out.println("Exhaustive");
		for(int i = 0; i < percent1.length; i ++)
		{
			System.out.print(percent1[i] + ", ");
		}
		System.out.println();
		System.out.println("Stochastic");
		for(int i = 0; i < percent2.length; i ++)
		{
			System.out.print(percent2[i] + ", ");
		}
	}
}
 