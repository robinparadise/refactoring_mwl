package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
	    
    	switch (opening) {
            case BOTH_OPENED:
                return new BothOpenedInterval(new Point(minimum), new Point(maximum));
            case LEFT_OPENED:
                return new LeftOpenedInterval(new Point(minimum), new Point(maximum));
            case RIGHT_OPENED:
                return new RightOpenedInterval(new Point(minimum), new Point(maximum));
            case UNOPENED:
                return new UnopenedInterval(new Point(minimum), new Point(maximum));
            default:
                throw new IllegalArgumentException("Incorrect type code");
        }
		
	}
}