package cards;

import static org.junit.Assert.*;


public class Test {

	public static void main(String[] args)
	{
		Hand hand = new Hand();
		Hand hand2 = new Hand();
		hand.getRandomHand(false);
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
		/*double[] percents = Odds.percentage_per_hand_category_stochastic(5, 1000);
		
		for(int i = 0; i < percents.length; i ++)
		{
			System.out.print(percents[i] + ", ");
		}
		*/
	}
	

}
 