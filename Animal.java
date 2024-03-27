/*
 * Niharika Agrawal
 * CSC 171
 * Design HW Assignment - Animal Class
 * nagrawa5@u.rochester.edu
 * Last Edited March 4, 2024
 */

public class Animal {
	// make variables
	String species;
	int age;
	boolean awake;
	
	// set variables
	public Animal(String species, int age, boolean awake) {
		this.species = species;
		this.age = age;
		this.awake = true; // default to the animal being awake
	}
	
	// define getters for all variables
	public String getSpecies() {
		return species;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean isAwake() {
		return awake;
	}
	
	public String isAsleep() {
		if (awake = true) {
			return "Animal Noises! ";
		}
		else {
			return "Snoring Noises!";
		}
	}

}
