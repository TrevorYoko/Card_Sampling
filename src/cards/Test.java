package cards;

import static org.junit.Assert.*;


public class Test {

	public static void main(String[] args)
	{
		
		double[] percent1 = Odds.percentage_per_hand_category_exhaustive(5);
		double[] percent2 = Odds.percentage_per_hand_category_stochastic(5,100000000);
		
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
 