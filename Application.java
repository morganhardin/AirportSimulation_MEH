/** These import java.io and java.util so
 * that the Timer can be used and the tasks
 * can be returned.
 * 
 */
import java.util.*;

/** This application class will print the contents
 * of the Time class in the console after the
 * specified amount of seconds.
 * 
 * @author morganhardin
 *
 */
public class Application
{
	/** This main method instantiates Timer and
	 * calls TimerTask in terms of the Time class.
	 * It then schedules the Time class to be run
	 * after the specified seconds.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Timer time = new Timer();
		TimerTask task = new Time();
		time.schedule(task, 100, 1000);
	}
}
