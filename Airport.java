/** These import the java.io and java.util
 * built in functions so that the class can
 * call data structures and catch exceptions.
 * 
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/** This class is a generic Airport class that 
 * extends Airplane. This class holds three 
 * queues and will add planes to their respecive
 * queue, remove it, and print the contents of
 * each queue. It will also randomly generate issues 
 * that might cause a plan to need to land early.
 * It keeps track of the runway and list all the
 * planes in the area and their distances away
 * from the runway.
 * 
 * @author morganhardin
 *
 * @param <T>
 */
public class Airport<T> extends Airplane
{
	/** These three queues (2 regular and 1 priority)
	 * are the for the incoming planes (approaching),
	 * the planes ready to land (landQueue), and the
	 * planes that have already landed.
	 * 
	 */
	PriorityQueue<T> landQueue = new PriorityQueue<T>();
	Queue<T> approachQueue = new LinkedList<T>();
	Queue<T> landed = new LinkedList<T>();
	
	/** These instantiate timeSeconds, land, minutes, index,
	 * and index2 as integers equal to 0. It also instantiates
	 * name and name2 as null strings. These will be used in
	 * this class to keep track of the planes names and time.
	 * 
	 */
	int timeSeconds = 0, land = 0, minutes = 0, index = 0, index2 = 0;
	String name, name2;
	
	/** This empty constructor sets index and index2 equal 
	 * to 1, timeSeconds and land equal to 0, minutes equal to
	 * 7, and name and name2 equal to an empty string. These
	 * will be used within the various methods in this class
	 * and within the time class.
	 * 
	 */
	public Airport()
	{
		index = 1;
		index2 = 1;
		timeSeconds = 0;
		land = 0;
		name = "";
		name2 = "";
		minutes = 7;
	}
	/** This void method randomly generates a number 
	 * between 0 and 1. If it is less than 0.15, a
	 * plane will be added the the approach queue and
	 * to the list of planes. If not, the time will 
	 * continue to run and a plane is not generated.
	 * 
	 */
	public void generatePlane()
	{
		if (Math.random() < 0.15)
		{
			name = "Plane " + index;
			planesApproaching(name);
			addPlane(name);
			index++;
		}
		else
		{
			return;
		}
	}
	/** This void method loops through the hashmap
	 * list from the Airplane class and prints out
	 * the list of planes and their distance from
	 * the runway. It also changes the distance 
	 * based on where they are in a particular 
	 * queue and what the current distance is.
	 * 
	 */
	public void listPlanes()
	{
		System.out.println("List of Planes and their Distance: ");
		
		for (String i : list.keySet())
		{
			System.out.println("\t" + i + ": " + list.get(i) + " miles");
			if (list.get(i) > 100)
			{
				list.computeIfPresent(i, (key, oldValue) -> oldValue - 10);
			}
			else if (list.get(i) == 100 && i != landQueue.peek())
			{
				list.computeIfPresent(i, (key, oldValue) -> oldValue = 100);
			}
			else if (list.get(i) == 100 && i == landQueue.peek() && timeSeconds == 1)
			{
				list.computeIfPresent(i, (key, oldValue) -> oldValue = 100);
			}
			else if (list.get(i) == 100 && i == landQueue.peek() && timeSeconds != 1)
			{
				list.computeIfPresent((String) landQueue.peek(), (key, oldValue) -> oldValue - 10);
			}
			else if (list.get(i) < 100 && list.get(i) > 0)
			{
				list.computeIfPresent((String) landQueue.peek(), (key, oldValue) -> oldValue - 10);
			}
		}
		System.out.println();
	}
	/** This void method adds element to the approachQueue.
	 * 
	 * @param element
	 */
	@SuppressWarnings("unchecked")
	public void planesApproaching(String element)
	{
		approachQueue.add((T) element);
	}
	/** This void method loops through the approachQueue
	 * using an iterator and prints out the contents
	 * of the queue while keeping track of the time.
	 * 
	 */
	public void planesApproaching()
	{
		System.out.println("Planes Approaching: ");
		if (approachQueue.isEmpty() == true)
		{
			System.out.println();
		}
		else
		{
			Iterator<T> planeApproach = approachQueue.iterator();
			timeSeconds++;
			while (planeApproach.hasNext())
			{
				System.out.println("\t" + planeApproach.next());
			}
		}
	}
	/** This void method adds the front element 
	 * of the approachQueue to the landQueue.
	 * After this, it will remove that element 
	 * from the approachQueue to simulate the plane
	 * getting ready to land.
	 * 
	 */
	public void readyToLandQueue()
	{
		landQueue.add(approachQueue.peek());
		approachQueue.poll();
	}
	/** This void method will print out the contents
	 * of the landQueue using an iterator while also
	 * keeping track of the time.
	 * 
	 */
	public void readyToLand()
	{
		System.out.println("Ready to Land: ");
		if (landQueue.isEmpty() == true)
		{
			System.out.println();
		}
		else
		{
			Iterator<T> planeNext = landQueue.iterator();
			land++;
			while (planeNext.hasNext())
			{
				System.out.println("\t" + planeNext.next());
			}
		}
		System.out.println();
	}
	/** This void method simulates a plane landing by
	 * adding it to the landed queue and removing it
	 * from the landQueue (ready to land queue).
	 * 
	 */
	public void landed()
	{
		System.out.println("Just Landed: ");
		landed.add(landQueue.poll());
		String word = (String) landed.peek();
		System.out.println(word);
	}
	/** This void method calls the time class 
	 * from Airplane in order to track and 
	 * print the time.
	 * 
	 */
	public void simulate()
	{
		time();
	}
	/** This void method will print if the runway is clear
	 * or if it is occupied. If it's occupied, then it will
	 * also print the minutes left for the runway to clear.
	 * This is based on how long the plane has been in the
	 * landQueue and if a plane has just landed or not. It 
	 * will also be based on if either queue is empty. If
	 * a plane landed, it will also remove that element
	 * from landed (landed queue) so that it is now null.
	 * 
	 */
	public void runway()
	{
		if (landQueue.isEmpty() == true && landed.peek() != null && minutes != 1)
		{
			System.out.println("Runway: Occupied --> Minutes to Clear: " + minutes);
			minutes--;
		}
		else if (landQueue.isEmpty() == true && landed.peek() != null && minutes == 1)
		{
			System.out.println("Runway: Occupied --> Minutes to Clear: " + minutes);
			landed.poll();
			minutes = 7;
		}
		else if (landQueue.isEmpty() == false && landed.peek() != null && minutes != 1)
		{
			System.out.println("Runway: Occupied --> Minutes to Clear: " + minutes);
			minutes--;
		}
		else if (landQueue.isEmpty() == false && landed.peek() != null && minutes == 1)
		{
			System.out.println("Runway: Occupied --> Minutes to Clear: " + minutes);
			landed.poll();
			minutes = 7;
		}
		else if (landQueue.isEmpty() == true && landed.peek() == null && minutes == 1)
		{
			System.out.println("Runway: Clear");
			minutes = 7;
		}
		else if (landQueue.isEmpty() == false && landed.peek() == null && minutes != 1)
		{
			System.out.println("Runway: Clear");
		}
		else if (land == 10)
		{
			System.out.println("Runway: Occupied --> Minutes to Clear: " + minutes);
			minutes--;
		}
		else if (land < 10)
		{
			System.out.println("Runway: Clear");
		}
	}
	/** This void method will scan an emergency landing
	 * file and will randomly generate a number 1 through
	 * 10 that will read that line of the file. It will 
	 * ask for user input to allow the plane to land early.
	 * If the input is yes, the plane will immediately be
	 * added to the landQueue and will have a smaller
	 * distance than the rest of the planes. It will move
	 * the other planes back in the queue if it is not
	 * empty. If the input is no, the plane will go to 
	 * another airport. This is surrounded by a try catch
	 * block that will catch an error if the file is 
	 * not found.
	 * 
	 */
	@SuppressWarnings({ "resource", "unchecked" })
	public void issues()
	{
		Scanner input = new Scanner(System.in);
		ArrayList<String> emergency = new ArrayList<String>();
		try
		{
			FileReader fr = new FileReader("Emergency_Landing.txt");
			Scanner scan = new Scanner(fr);
			
			while (scan.hasNextLine())
			{
				emergency.add(scan.nextLine());
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File Not Found.");
		}
		int i = (int) (Math.random()*(10-1))+1;
		System.out.println(emergency.get(i));
		System.out.print("Do you let the plane land early?\n--> ");
		String answer = input.nextLine().toUpperCase();
		if (answer.contains("Y"))
		{
			distance = 80;
			name2 = "Emergency Plane " + index2;
			addPlane(name2);
			landQueue.add((T) name2);
			while (landQueue.peek() != (T) name2)
			{
				T plane = landQueue.poll();
				landQueue.add(plane);
				list.computeIfPresent((String) landQueue.peek(), (key, oldValue) -> oldValue = 100);
			}
			index2++;
			System.out.println("---------------------------------------------------------");
			distance = 200;
		}
		else if (answer.contains("N"))
		{
			System.out.println("The plane decided to go to another airport.");
			System.out.println("---------------------------------------------------------");
		}
	}
}
