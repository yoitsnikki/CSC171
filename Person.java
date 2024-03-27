/*
 * Niharika Agrawal
 * CSC 171
 * Design HW Assignment - Person Class
 * nagrawa5@u.rochester.edu
 * Last Edited March 4, 2024
 */

public class Person {
	// define variables
	String name;
	int year;
	String occupation;
	boolean alive;
	
	// set variables
	public Person(String name, int year) {
		this.name = name;
		this.year = year;
		this.alive = true; // default is they are alive
	}
	
	// define all getters
	public String getName() {
		return name;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	// setters
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	// toString method
	public String toString() {
		if (alive = true) {
			return name + " is a " + occupation + " born in " + year + ".";
		}
		
		else {
			return name + " was a " + occupation + " born in " + year + ".";
		}
	}

}
