package intervals;

public class BothOpenedInterval extends Interval {

	public BothOpenedInterval(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	public boolean includes(double value) {
		return getMinimum() < value && value < getMaximum();
	}
	
	public boolean includes(Interval interval) {
		return interval.isIncluded(this);
	}
	
	@Override
	public boolean isIncluded(BothOpenedInterval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.getMaximum());
		return (minimumIncluded || getMinimum() == interval.getMinimum())
				&& (maximumIncluded || getMaximum() == interval
						.getMaximum());
	}

	@Override
	public boolean isIncluded(LeftOpenedInterval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.getMaximum());
		return (minimumIncluded || getMinimum() == interval.getMinimum())
				&& (maximumIncluded);
	}

	@Override
	public boolean isIncluded(RightOpenedInterval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.getMaximum());
		return (minimumIncluded)
				&& (maximumIncluded || getMaximum() == interval
						.getMaximum());
	}

	@Override
	public boolean isIncluded(UnopenedInterval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.getMaximum());
		return (minimumIncluded) && (maximumIncluded);
	}

	public boolean intersectsWith(Interval interval) {
		if (getMinimum() == interval.getMaximum()) {
			return false;
		}
		if (getMaximum() == interval.getMinimum()) {
			return false;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

}
