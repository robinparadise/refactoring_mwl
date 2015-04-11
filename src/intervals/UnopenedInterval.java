package intervals;

public class UnopenedInterval extends Interval {

	public UnopenedInterval(double minimum, double maximum) {
		super(minimum, maximum);
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
			return interval.intersectedMinimum(this);
		}
		if (getMaximum() == interval.getMinimum()) {
			return interval.intersectedMaximum(this);
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}
	
	public boolean intersected(LeftOpenedInterval interval) {
		return true;
	}
	
	public boolean intersected(RightOpenedInterval interval) {
		return true;
	}
	
	@Override
	public boolean intersectedMinimum(UnopenedInterval interval){
		return true;
	}
	
	@Override
	public boolean intersectedMaximum(UnopenedInterval interval){
		return true;
	}

}
