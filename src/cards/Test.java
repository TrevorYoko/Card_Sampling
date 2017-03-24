package cards;



public class Test {

	public static void main(String[] args)
	{

		
		double[] percent1 = Odds.percentage_per_hand_category_exhaustive(7);
	
//		System.out.println("N \tTime");
//		for(int N = 1000; N < 10000000; N += 100000)
//		{
//			startTime = System.nanoTime();
//			double[] percents = Odds.percentage_per_hand_category_stochastic(7, N);
//			elapsed = System.nanoTime() - startTime;
//			
//			
//			System.out.println(N + " \t" + elapsed);
//		}

		
		System.out.println("Stochastic");
		System.out.println("N \tHigh Card \tPair \tTwo Pair "
						   + "\tThree of a Kind \tStraight \tFlush "
						   + "\tFull House \tFour of a Kind \tStaight Flsuh "
						   + "\tRoyal Flush");
		
		for(int N = 100; N <= 1000; N += 100)
		{
			double[] percent2 = Odds.percentage_per_hand_category_stochastic(7,N);
			
			System.out.print(N + "\t");
			for(int i = 0; i < percent2.length; i ++)
			{
				System.out.print(Math.abs(percent2[i] - percent1[i]) + "\t");
			}
			System.out.println();
		}
		for(int N = 1000; N <= 10000; N += 1000)
		{
			double[] percent2 = Odds.percentage_per_hand_category_stochastic(7,N);
			
			System.out.print(N + "\t");
			for(int i = 0; i < percent2.length; i ++)
			{
				System.out.print(Math.abs(percent2[i] - percent1[i]) + "\t");
			}
			System.out.println();
		}
		for(int N = 10000; N <= 100000; N += 10000)
		{
			double[] percent2 = Odds.percentage_per_hand_category_stochastic(7,N);
			
			System.out.print(N + "\t");
			for(int i = 0; i < percent2.length; i ++)
			{
				System.out.print(Math.abs(percent2[i] - percent1[i]) + "\t");
			}
			System.out.println();
		}
		
		for(int N = 100000; N <= 1000000; N += 100000)
		{
			double[] percent2 = Odds.percentage_per_hand_category_stochastic(7,N);
			
			System.out.print(N + "\t");
			for(int i = 0; i < percent2.length; i ++)
			{
				System.out.print(Math.abs(percent2[i] - percent1[i]) + "\t");
			}
			System.out.println();
		}
		for(int N = 100000; N <= 10000000; N += 1000000)
		{
			double[] percent2 = Odds.percentage_per_hand_category_stochastic(7,N);
			
			System.out.print(N + "\t");
			for(int i = 0; i < percent2.length; i ++)
			{
				System.out.print(Math.abs(percent2[i] - percent1[i]) + "\t");
			}
			System.out.println();
		}
		
	}
}
 