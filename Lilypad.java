/*
 * Niharika Agrawal
 * CSC 171
 * Lilypad Assignment
 * Last Edited February 23, 2024
 * 
 * start the program by just entering the coordinates
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Lilypad {
	String name;
	double x;
	double y;
	
	// represent each lilypad
	public Lilypad(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	// calculate the distance between two lilypads
	public double distanceTo(Lilypad other) {
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}
	
	// program to find a lilypad by the name assigned to it, otherwise it returns null if they don't match up
		public static Lilypad findLilypadByName(ArrayList<Lilypad> lilypads, String name) {
			for (Lilypad lilypad : lilypads) {
				if (lilypad.name.equals(name)) {
					return lilypad;
				}
			}
			
			return null;
		}
	
		
	// find shortest path from one lilypad to another lilypad
	public static List<Lilypad> findPath(ArrayList<Lilypad> lilypads, String start, String destination) {
		List<Lilypad> path = new ArrayList<>(); // make path list
		Set<Lilypad> visited = new HashSet<>(); // hashset to keep track of which lilypads i already visited
		
		Lilypad current = findLilypadByName(lilypads, start); // mark the current lilypad, which is the start
        Lilypad dest = findLilypadByName(lilypads, destination); // mark the destination lilypad
        
        // add both to the path and the visited
        path.add(current);
        visited.add(current);
        
        // until the lilypad we are on = the destination lilypad, run this while loop
        while (current != dest) {
        	double minDistance = Double.MAX_VALUE;
        	Lilypad next = null;
        	
        	for (Lilypad neighbor : lilypads) {
        		if (!visited.contains(neighbor) && !neighbor.equals(current)) {
        			double distance = current.distanceTo(neighbor);
        			
        			if (distance < minDistance) {
        				minDistance = distance;
        				next = neighbor; // if the distance is the smallest, hop the lilypad so the next lilypad = neighbor
        			}
        			
        			// break the tie if the distance is equal and the pick the one higher in the list
        			else if (distance == minDistance && lilypads.indexOf(neighbor) < lilypads.indexOf(next)) {
        				next = neighbor;
        			} 
        		}
        	}
        	
        	if (next != null) {
        		path.add(next);
                visited.add(next);
                current = next;
        	}
        	
        	else {
        		break;
        	}	
        }
        
        return path; // return the path list when the method is called
	}
	
	// calculate total distance travelled
	public static double calculateTotalDistance(List<Lilypad> path) {
		double totalDistance = 0;
		
		// loop through the path list with the overall path taken
		for (int i = 0; i < path.size() - 1; i++) {
			totalDistance += path.get(i).distanceTo(path.get(i + 1));
		}
		return totalDistance;
	}
	
	// main method for frog hopping
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numLilypads = s.nextInt(); // number of lily pads
		s.nextLine();
		
		// read lilypad coordinates from input and organize in an array
		ArrayList<Lilypad> lilypads = new ArrayList<>(); // arraylist to hold inputs
        for (int i = 0; i < numLilypads; i++) {
            String[] parts = s.nextLine().split(" "); // split input into multiple parts
           
            // create a new lilypad object with the associated coordinates in the line
            lilypads.add(new Lilypad(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
        }
        
        // read start and end destinations for lilypad
        String start = s.next();
        String destination = s.next();
        
        s.close(); // close scanner bc the error messages are annoying me
        
        List<Lilypad> path = findPath(lilypads, start, destination); // simulate frog path
        
        //output results
        System.out.println(path.size()); // number of lilpads including start pad
        for (Lilypad lp : path) {
            System.out.println(lp.name); // Print the name of each lilypad in the path (for loop through the path list)
        }
        System.out.println(calculateTotalDistance(path)); // distance travelled
	}
}
