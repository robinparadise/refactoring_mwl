package intervals;

public class RightOpenedInterval extends Interval {

	public RightOpenedInterval(double minimum, double maximum) {
		super(minimum, maximum);
	}

	public boolean includes(double value) {
		return getMinimum() <= value && value < getMaximum();
	}

	public boolean includes(Interval interval) {
		return interval.isIncluded(this);
	}

	@Override
	public boolean isIncluded(BothOpenedInterval interval) {
		return (interval.includes(getMinimum()))
				&& (interval.includes(getMaximum()) || getMaximum() == interval
						.getMaximum());
	}

	@Override
	public boolean isIncluded(LeftOpenedInterval interval) {
		return (interval.includes(getMinimum()))
				&& (interval.includes(getMaximum()) || getMaximum() == interval
						.getMaximum());
	}

	@Override
	public boolean isIncluded(RightOpenedInterval interval) {
		return (interval.includes(getMinimum()) || getMinimum() == interval
				.getMinimum())
				&& (interval.includes(getMaximum()) || getMaximum() == interval
						.getMaximum());
	}

	@Override
	public boolean isIncluded(UnopenedInterval interval) {
		return (interval.includes(getMinimum()) || getMinimum() == interval
				.getMinimum())
				&& (interval.includes(getMaximum()) || getMaximum() == interval
						.getMaximum());
	}

	public boolean intersectsWith(Interval interval) {
		if (getMinimum() == interval.getMaximum()) {
			return interval.intersected(this);
		}
		if (getMaximum() == interval.getMinimum()) {
			return false;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}
	
	public boolean intersected(LeftOpenedInterval interval) {
		return true;
	}
	
	public boolean intersected(UnopenedInterval interval) {
		return true;
	}
	
	@Override
	public boolean intersectedMaximum(UnopenedInterval interval){
		return true;
	}

}
