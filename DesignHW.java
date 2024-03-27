/*
 * Niharika Agrawal
 * CSC 171
 * Design HW Assignment - Main Method
 * nagrawa5@u.rochester.edu
 * Last Edited March 4, 2024
 */

public class DesignHW {
	
	public static void main(String[] args) {		
		// Class: Person
		Person person1 = new Person("Albert Einstein", 1879); // show how it works
		person1.setOccupation("physicist");
		person1.setAlive(false);
		System.out.println(person1);
		
		Person person2 = new Person("Barack Obama", 1961); // print one, then alter it
		person2.setOccupation("politician");
		System.out.println(person2);
		person2.setOccupation("retired");
		System.out.println(person2);
		
		// Class: Animal
		 Animal dog = new Animal("Dog", 3, true); // show how it works
		 System.out.println(dog.isAsleep());
		 
		 Animal cow = new Animal("Cow", 7, false); // print one, then alter it
		 System.out.println(cow.isAsleep());
		 cow.awake = true;
		 System.out.println(cow.isAsleep());
		 
		 // Class 3: Phone
		 Phone phone = new Phone(2200);
		 System.out.println("battery life, features off: " + phone.computeBattery());
		 
		 // change features
		 phone.setWifi(true);
		 phone.setbluetooth(true);
		 System.out.println("battery life, features on: " + phone.computeBattery());
		 
		 
		 
		 
		 
	}

}
