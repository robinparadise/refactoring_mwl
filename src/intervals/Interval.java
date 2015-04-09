package intervals;

public class Interval {

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

	public Interval(double minimum, double maximum, Opening opening) {
		setMinimum(minimum);
		this.maximum = maximum;
		this.opening = opening;
	}

	public double midPoint() {
		return (maximum + getMinimum()) / 2;
	}

	public boolean includes(double value) {
		switch (getOpening()) {
		case BOTH_OPENED:
			return getMinimum() < value && value < maximum;
		case LEFT_OPENED:
			return getMinimum() < value && value <= maximum;
		case RIGHT_OPENED:
			return getMinimum() <= value && value < maximum;
		case UNOPENED:
			return getMinimum() <= value && value <= maximum;
		default:
			assert false;
			return false;
		}
	}

	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.maximum);
		switch (getOpening()) {
		case BOTH_OPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded);
			case RIGHT_OPENED:
				return (minimumIncluded)
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded) && (maximumIncluded);
			default:
				assert false;
				return false;
			}
		case LEFT_OPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			case RIGHT_OPENED:
				return (minimumIncluded)
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded)
						&& (maximumIncluded || maximum == interval.maximum);
			default:
				assert false;
				return false;
			}
		case RIGHT_OPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded);
			case RIGHT_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded);
			default:
				assert false;
				return false;
			}
		case UNOPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			case RIGHT_OPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded || getMinimum() == interval.getMinimum())
						&& (maximumIncluded || maximum == interval.maximum);
			default:
				assert false;
				return false;
			}
		default:
			assert false;
			return false;
		}
	}

	public boolean intersectsWith(Interval interval) {
		if (getMinimum() == interval.maximum) {
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
		if (maximum == interval.getMinimum()) {
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
				|| this.includes(interval.maximum);
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
