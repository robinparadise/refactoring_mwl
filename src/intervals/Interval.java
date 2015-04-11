package intervals;

public abstract class Interval {

	private double minimum;
	private double maximum;
	
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

	public Interval(double minimum, double maximum) {
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
