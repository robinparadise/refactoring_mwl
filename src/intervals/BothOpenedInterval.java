package intervals;

public class BothOpenedInterval extends Interval {
	
	public BothOpenedInterval(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}
	
	public boolean includes(double value) {
		return getMinimum() < value && value < getMaximum();
	}

}
