package cards;

public class BetterRandomNumberGenerator implements Random_Generator {
	
	private long multiplier = 22695477;
	private long increment = 1;
	private long seed;
	
	private static final long mask = (1L << 48) - 1;

	@Override
	public int next_int(int max) 
	{
		
		return (int)Math.abs(System.nanoTime() % max);
	}

	@Override
	public void set_seed(long seed) {
		this.seed = seed;
	}

	@Override
	public void set_constants(long multiplier, long increment) {
		this.multiplier = multiplier;
		this.increment = increment;
	}
}
