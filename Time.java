/** This import java.util so that the
 * built in Timer and TimerTask can be used.
 * 
 */
import java.util.*;

/** This class will instantiate a new variation
 * of the airport class and will call those methods
 * in the run method to print out the contents of
 * the methods at each time interval. It also extends
 * TimerTask so that these tasks will run hand in hand
 * with the timer.
 * 
 * @author morganhardin
 *
 */
public class Time extends TimerTask
{
	/** This instantiates a new variation of the
	 * airport class.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public Airport airport = new Airport();
	
	/** This run method calls the methods in the
	 * airport class to generate planes, list
	 * all the planes, print the contents of each
	 * queue, print the state of the runway, and 
	 * print the time after each loop of this method.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void run()
	{
		System.out.println("\n\n\n\n\n\n\n\n\n---------------------------------------------------------");
		
		if (airport.timeSeconds%2 == 0 || airport.approachQueue.isEmpty() == true || airport.landQueue.isEmpty() == true)
		{
			airport.generatePlane();
		}
		airport.listPlanes();
		
		if (airport.timeSeconds == 10 && airport.land != 10)
		{
			if (Math.random() < 0.5 && airport.landQueue.peek() != airport.name2)
			{
				airport.issues();
			}
			airport.readyToLandQueue();
			airport.planesApproaching();
			airport.readyToLand();
			airport.runway();
			airport.timeSeconds = 0;
		}
		else if (airport.land == 10 && airport.timeSeconds != 10)
		{
			if (Math.random() < 0.05 && airport.landQueue.peek() != airport.name2)
			{
				airport.issues();
			}
			airport.planesApproaching();
			airport.landed();
			airport.readyToLand();
			airport.runway();
			airport.land = 0;
		}
		else if (airport.timeSeconds == 10 && airport.land == 10)
		{
			if (Math.random() < 0.05 && airport.landQueue.peek() != airport.name2)
			{
				airport.issues();
			}
			airport.readyToLandQueue();
			airport.planesApproaching();
			airport.landed();
			airport.readyToLand();
			airport.runway();
			airport.timeSeconds = 0;
			airport.land = 0;
		}
		else
		{
			if (Math.random() < 0.01 && airport.landQueue.peek() != airport.name2)
			{
				airport.issues();
			}
			airport.planesApproaching();
			airport.readyToLand();
			airport.runway();
		}
		airport.simulate();
	}
}
