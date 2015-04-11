package intervals;


public class IntervalFactory {

	public static Interval getInterval(Point minimum, Point maximum, Opening opening) {
	    
    	switch (opening) {
            case BOTH_OPENED:
                return new BothOpenedInterval(minimum, maximum);
            case LEFT_OPENED:
                return new LeftOpenedInterval(minimum, maximum);
            case RIGHT_OPENED:
                return new RightOpenedInterval(minimum, maximum);
            case UNOPENED:
                return new UnopenedInterval(minimum, maximum);
            default:
                throw new IllegalArgumentException("Incorrect type code");
        }
		
	}
}