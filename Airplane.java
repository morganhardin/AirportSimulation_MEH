/** This imports java.util into this class so
 * that the built in data structures can be used
 * in this class and called in the classes that
 * extend this one.
 * 
 */
import java.util.*;

/** This class is abstract and contains getters and
 * setters, an add method to add a plane and its
 * distance to the list, and time that accurately
 * tracks the time in the simulation.
 * 
 * @author morganhardin
 *
 */
public abstract class Airplane
{
	/** This instantiates a hashmap list with string and
	 * integer elements, name as a null string, id and
	 * distance as integers, seconds equal to 00 and
	 * hours equal to 12, am equal to true and pm
	 * equal to false, and finally the string AM_PM
	 * equal to the string " AM".
	 * 
	 */
	protected HashMap<String, Integer> list = new HashMap<String, Integer>();
	protected String name;
	protected int id, distance;
	protected static int seconds = 00, hours = 12;
	protected boolean am = true, pm = false;
	protected String AM_PM = " AM";
	
	/** This empty constructor instantiates id as 0
	 * and distance as 200.
	 * 
	 */
	public Airplane()
	{
		id = 0;
		distance = 200;
	}
	/** This preferred constructor takes three
	 * parameters, String name, int id, and int
	 * distance and sets them equal to this name,
	 * id, and distance.
	 * 
	 * @param name
	 * @param id
	 * @param distance
	 */
	public Airplane(String name, int id, int distance)
	{
		this.name = name;
		this.id = id;
		this.distance = distance;
	}
	/** This setter method takes the integer parameter
	 * distance and sets it equal to this distance.
	 * 
	 * @param distance
	 */
	public void setDistance(int distance)
	{
		this.distance = distance;
	}
	/** This getter method returns the integer distance.
	 * 
	 * @return
	 */
	public int getDistance()
	{
		return distance;
	}
	/** This takes the string parameter name and adds
	 * it to the hashmap list. It also adds distance 
	 * as the value element of the plane key.
	 * 
	 * @param name
	 */
	public void addPlane(String name)
	{
		list.put(name, distance);
	}
	/** This void method uses an if else statement to
	 * keep track of the correct hours and seconds
	 * during the simulation. It prints these values out
	 * and also the corresponding time of day (am or pm).
	 * 
	 */
	public void time()
	{
		if (hours == 12 && seconds > 59)
		{
			hours = 1;
			seconds = 00;
			if (am == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " AM");
				System.out.println("---------------------------------------------------------");
			}
			else if (pm == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " PM");
				System.out.println("---------------------------------------------------------");
			}
			seconds++;
		}
		else if (hours == 12 && seconds < 10)
		{
			if (am == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " AM");
				System.out.println("---------------------------------------------------------");
			}
			else if (pm == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " PM");
				System.out.println("---------------------------------------------------------");
			}
			seconds++;
		}
		else if (hours == 12 && seconds > 10 && seconds < 59)
		{
			if (am == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":" + seconds + " AM");
				System.out.println("---------------------------------------------------------");
			}
			else if (pm == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":" + seconds + " PM");
				System.out.println("---------------------------------------------------------");
			}
			seconds++;
		}
		else if (hours != 12 && hours != 11 && seconds > 59)
		{
			hours++;
			seconds = 00;
			if (am == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " AM");
				System.out.println("---------------------------------------------------------");
			}
			else if (pm == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " PM");
				System.out.println("---------------------------------------------------------");
			}
			seconds++;
		}
		else if (hours == 11 && seconds > 59)
		{
			hours++;
			seconds = 00;
			if (am == true)
			{
				am = false;
				pm = true;
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " PM");
				System.out.println("---------------------------------------------------------");
			}
			else if (pm == true)
			{
				pm = false;
				am = true;
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " AM");
				System.out.println("---------------------------------------------------------");
			}
			seconds++;
		}
		else if (hours != 12 && seconds < 10)
		{
			if (am == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " AM");
				System.out.println("---------------------------------------------------------");
			}
			else if (pm == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":0" + seconds + " PM");
				System.out.println("---------------------------------------------------------");
			}
			seconds++;
		}
		else
		{
			if (am == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":" + seconds++ + " AM");
				System.out.println("---------------------------------------------------------");
			}
			else if (pm == true)
			{
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t   Time: " + hours + ":" + seconds++ + " PM");
				System.out.println("---------------------------------------------------------");
			}
		}
	}
}
