package cards;

import cards.Hand.Rank;

/**
 * This class contains methods to calulate odds and percentages  for different poker hands
 * 
 * @author jacob and trevor
 *
 */
public class Odds {
	
	/**
	 * UNIMPLEMENTED
	 * 
	 * @param h1c1
	 * @param h1c2
	 * @param h2c1
	 * @param h2c2
	 * @param samples
	 * @return
	 */
	static double odds_to_win(int h1c1, int h1c2, int h2c1, int h2c2, int samples)
	{
		return -1.0;
	}
	
	/**
	 * This method will calculate all the possible hands and retrun all the percentafes of each
	 * hand rank via an array of doubles
	 * 
	 * @param hand_size -- 5 or 7
	 * @return array of percentages
	 */
	static double[] percentage_per_hand_category_exhaustive(int hand_size)
	{
		int[] histogram = new int[10];
		
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
								Hand hand = new Hand();
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
								for(int card6 = card5+1; card6 < 51; card6 ++)
								{
									for(int card7 = card6+1; card7 < 52; card7 ++)
									{
										Hand hand = new Hand();
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

		double total = 0;

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
	
	/**
	 * This method will sample random hand N number of times to create a histogram
	 * of hand ranks
	 * Then it will calculate the percentage of each hand 
	 * 
	 * @param hand_size -- 5 or 7
	 * @param random_samples -- number of samples
	 * @return array of percentages
	 */
	static double[] percentage_per_hand_category_stochastic(int hand_size, int random_samples)
	{
		final int N = random_samples;
		int[] histogram = new int[10];
		
		
		for(int index = 1; index < N; index ++)
		{
			Hand hand = new Hand();
			if(hand_size == 5)
				hand.getRandomHand(false);
			else
				hand.getRandomHand(true);
			Rank rank = hand.getRank();
			histogram[rank.ordinal()] ++;
		}
		
		double[] percents = new double[10];
		double total = 0;

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
