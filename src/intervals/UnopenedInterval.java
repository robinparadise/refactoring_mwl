package intervals;

public class UnopenedInterval extends Interval {
	
	public UnopenedInterval(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}
	
	public boolean includes(double value) {
		return getMinimum() <= value && value <= getMaximum();
	}

}
