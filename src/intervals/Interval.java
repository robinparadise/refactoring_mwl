package intervals;

public abstract class Interval {

	private Point minimum;
	private Point maximum;
	
	public double getMinimum() {
		return minimum.get();
	}
	
	public void setMinimum(Point minimum) {
		this.minimum = minimum;
	}
	
	public double getMaximum() {
		return maximum.get();
	}
	
	public void setMaximum(Point maximum) {
		this.maximum = maximum;
	}

	public Interval(Point minimum, Point maximum) {
		setMinimum(minimum);
		setMaximum(maximum);
	}

	public double midPoint() {
		return (getMaximum() + getMinimum()) / 2;
	}

	public abstract boolean includes(double value);
	
	public abstract boolean includes(Interval interval);
	
	public abstract boolean isIncluded(BothOpenedInterval interval);
	
	public abstract boolean isIncluded(LeftOpenedInterval interval);
	
	public abstract boolean isIncluded(RightOpenedInterval interval);
	
	public abstract boolean isIncluded(UnopenedInterval interval);
	
	public abstract boolean intersectsWith(Interval interval);
	
	public boolean intersected(LeftOpenedInterval interval){
		return false;
	}
	
	public boolean intersected(RightOpenedInterval interval){
		return false;
	}

	public boolean intersectedMinimum(UnopenedInterval interval) {
		return false;
	}
	
	public boolean intersectedMaximum(UnopenedInterval interval) {
		return false;
	}
	
	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(Object object) {
		return false;
	}


}
