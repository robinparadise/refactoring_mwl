package intervals;

public class LeftOpenedInterval extends Interval {
	
	public LeftOpenedInterval(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}
	
	public boolean includes(double value) {
		return getMinimum() < value && value <= getMaximum();
	}

}
