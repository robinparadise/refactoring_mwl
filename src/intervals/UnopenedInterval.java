package intervals;

public class UnopenedInterval extends Interval {

	public UnopenedInterval(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	public boolean includes(double value) {
		return getMinimum() <= value && value <= getMaximum();
	}
	
	public boolean includes(Interval interval) {
		return interval.isIncluded(this);
	}

	@Override
	public boolean isIncluded(BothOpenedInterval interval) {
		return (interval.includes(getMinimum())) && (interval.includes(getMaximum()));
	}

	@Override
	public boolean isIncluded(LeftOpenedInterval interval) {
		return (interval.includes(getMinimum()))
				&& (interval.includes(getMaximum()) || getMaximum() == interval.getMaximum());
	}

	@Override
	public boolean isIncluded(RightOpenedInterval interval) {
		return (interval.includes(getMinimum()) || getMinimum() == interval.getMinimum())
				&& (interval.includes(getMaximum()));
	}

	@Override
	public boolean isIncluded(UnopenedInterval interval) {
		return (interval.includes(getMinimum()) || getMinimum() == interval.getMinimum())
				&& (interval.includes(getMaximum()) || getMaximum() == interval.getMaximum());
	}

	public boolean intersectsWith(Interval interval) {
		if (getMinimum() == interval.getMaximum()) {
			return interval.getOpening() == Opening.LEFT_OPENED
					|| interval.getOpening() == Opening.UNOPENED;
		}
		if (getMaximum() == interval.getMinimum()) {
			return interval.getOpening() == Opening.RIGHT_OPENED
					|| interval.getOpening() == Opening.UNOPENED;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

}
