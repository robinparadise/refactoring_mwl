package intervals;

public abstract class Interval {

	private double minimum;
	private double maximum;
	private Opening opening;
	
	
	public Opening getOpening() {
		return opening;
	}
	
	public double getMinimum() {
		return minimum;
	}
	
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	
	public double getMaximum() {
		return maximum;
	}
	
	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

	public Interval(double minimum, double maximum, Opening opening) {
		setMinimum(minimum);
		setMaximum(maximum);
		this.opening = opening;
	}

	public double midPoint() {
		return (getMaximum() + getMinimum()) / 2;
	}

	public abstract boolean includes(double value);
	
	public abstract boolean includes(Interval interval);

	public boolean intersectsWith(Interval interval) {
		if (getMinimum() == interval.getMaximum()) {
			switch (getOpening()) {
			case BOTH_OPENED:
			case LEFT_OPENED:
				return false;
			case RIGHT_OPENED:
			case UNOPENED:
				return interval.opening == Opening.LEFT_OPENED ||
						interval.opening == Opening.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		if (getMaximum() == interval.getMinimum()) {
			switch (getOpening()) {
			case BOTH_OPENED:
			case RIGHT_OPENED:
				return false;
			case LEFT_OPENED:
			case UNOPENED:
				return interval.opening == Opening.RIGHT_OPENED ||
						interval.opening == Opening.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

	@Override
	public String toString() {
		// TODO
		return null;
	}

	@Override
	public boolean equals(Object object) {
		// TODO
		return false;
	}

}
