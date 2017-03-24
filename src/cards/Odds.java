<<<<<<< Updated upstream
package cards;

import java.lang.reflect.Array;

public class Odds {

	public static void buildHistogram(){
		Deck deck = new Deck();
		
	}
	static double odds_to_win(int h1c1, int h1c2, int h2c1, int h2c2, int samples){
		return -1.0;
	}
	
	static double[] percentage_per_hand_category_exhaustive(int hand_size){
		return null;
	}
	
	static double[] percentage_per_hand_category_stochastic(int hand_size, int random_samples){
		return null;
	}
	
}
=======
package cards;

import java.lang.reflect.Array;
import java.util.HashMap;

import cards.Hand.Rank;

public class Odds {

	//private static Deck deck = new Deck();
	private static int[] histogram = new int[10];
	
	public static void buildHistogram()
	{	
		//histogram = new int[10];
	}
	static double odds_to_win(int h1c1, int h1c2, int h2c1, int h2c2, int samples)
	{
		return -1.0;
	}
	
	static double[] percentage_per_hand_category_exhaustive(int hand_size)
	{
		Hand hand = new Hand();
		if(hand_size == 5)
		{	
			for(int card1 = 0; card1 < 48; card1 ++)
			{
				for(int card2 = card1+1; card2 < 49; card2 ++)
				{
					for(int card3 = card2+1; card3 < 50; card3 ++)
					{
						for(int card4 = card3+1; card4 < 51; card4 ++)
						{
							for(int card5 = card4+1; card5 < 52; card5 ++)
							{
								hand.add(Deck.deck[card1]);
								hand.add(Deck.deck[card2]);
								hand.add(Deck.deck[card3]);
								hand.add(Deck.deck[card4]);
								hand.add(Deck.deck[card5]);
								
								Rank rank = hand.getRank();	
								
								histogram[rank.ordinal()] ++;	
							}
						}
					}
				}
			}
		}
		else
		{
			for(int card1 = 0; card1 < 46; card1 ++)
			{
				for(int card2 = card1+1; card2 < 47; card2 ++)
				{
					for(int card3 = card2+1; card3 < 48; card3 ++)
					{
						for(int card4 = card3+1; card4 < 49; card4 ++)
						{
							for(int card5 = card4+1; card5 < 50; card5 ++)
							{
								for(int card6 = card5+1; card5 < 51; card6 ++)
								{
									for(int card7 = card6+1; card5 < 52; card7 ++)
									{
										hand.add(Deck.deck[card1]);
										hand.add(Deck.deck[card2]);
										hand.add(Deck.deck[card3]);
										hand.add(Deck.deck[card4]);
										hand.add(Deck.deck[card5]);
										hand.add(Deck.deck[card6]);
										hand.add(Deck.deck[card7]);
										
										Rank rank = hand.getRank();	
										
										histogram[rank.ordinal()] ++;
									}
								}
							}
						}
					}
				}
			}
		}
		
		double[] percents = new double[10];
		int total = 0;

		for(int index = 0; index < percents.length; index ++)
		{
			total += histogram[index];
		}
		
		for(int index = 0; index < percents.length; index ++)
		{
			percents[index] = (histogram[index] / total) * 100;
		}
		
		return percents;
	}
	
	static double[] percentage_per_hand_category_stochastic(int hand_size, int random_samples)
	{  
		final int N = random_samples;
		Hand hand = new Hand();
		
		for(int index = 1; index < N; index ++)
		{
			hand.getRandomHand(false);
			Rank rank = hand.getRank();
			
			histogram[rank.ordinal()] ++;
		}
		
		double[] percents = new double[10];
		int total = 0;

		for(int index = 0; index < percents.length; index ++)
		{
			total += histogram[index];
		}
		
		for(int index = 0; index < percents.length; index ++)
		{
			percents[index] = (histogram[index] / total) * 100;
		}
		return percents;
	}
	
}
>>>>>>> Stashed changes
