package intervals;

public class RightOpenedInterval extends Interval {

	public RightOpenedInterval(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	public boolean includes(double value) {
		return getMinimum() <= value && value < getMaximum();
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
		return (minimumIncluded || getMinimum() == interval.getMinimum())
				&& (maximumIncluded || getMaximum() == interval
						.getMaximum());
	}

	@Override
	public boolean isIncluded(UnopenedInterval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.getMaximum());
		return (minimumIncluded || getMinimum() == interval.getMinimum())
				&& (maximumIncluded);
	}

	public boolean intersectsWith(Interval interval) {
		if (getMinimum() == interval.getMaximum()) {
			return interval.getOpening() == Opening.LEFT_OPENED
					|| interval.getOpening() == Opening.UNOPENED;
		}
		if (getMaximum() == interval.getMinimum()) {
			return false;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

}
