/**
 * Niharika Agrawal
 * CSC 171
 * nagrawa5@u.rochester.edu
 * HW 4: SupplyChainHW
 */

import java.util.Scanner;
import java.util.ArrayList;

/**
 * class SupplyChainHW
 */

public class SupplyChainHW {
	
	// name all variables
	String name;
	double max_cargo;
	double max_range;
	double top_speed;
	double hourly_cost;
	double cost_per_mile;
	
	/**
	 * Set the variables for the main vehicle being created from inputs.
	 * @param name
	 * @param max_cargo
	 * @param max_range
	 * @param top_speed
	 * @param hourly_cost
	 * @param cost_per_mile
	 * @return null
	 */
	public SupplyChainHW (String name, double max_cargo, double max_range, double top_speed, double hourly_cost, double cost_per_mile) {
		this.name = name;
		this.max_cargo = max_cargo;
		this.max_range = max_range;
		this.top_speed = top_speed;
		this.hourly_cost = hourly_cost;
		this.cost_per_mile = cost_per_mile;
	}
	
	/**
	 * method to calculate total cost of contract
	 * @param distance
	 * @return total_cost
	 */
	public double calculate_cost(double distance) {
		double travel_time = distance / top_speed;
        double total_cost = (travel_time * hourly_cost) + (distance * cost_per_mile);
        
        // System.out.printf("vehicle: %s total cost: %.2f\n", name, total_cost);
        return total_cost;
    }
	
	/**
	 * main function that calls other methods.
	 * where program enters scanner input.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// read fleet description and parse into ArrayList
		 int fleetSize = Integer.parseInt(s.nextLine()); // pick fleet size from first line
	        
		 ArrayList<SupplyChainHW> fleet = new ArrayList<>(); // create array list named fleet
	        for (int i = 0; i < fleetSize; i++) {
	            String[] vehicleInfo = s.nextLine().split(" "); // create list of vehicle info as i parse
	            
	            SupplyChainHW vehicle = new SupplyChainHW(vehicleInfo[0], Double.parseDouble(vehicleInfo[1]),
	                    Double.parseDouble(vehicleInfo[2]), Double.parseDouble(vehicleInfo[3]),
	                    Double.parseDouble(vehicleInfo[4]), Double.parseDouble(vehicleInfo[5]));
	            fleet.add(vehicle); //add the created vehicle with class supplychainhw to the fleet list
	        }
	        

	        // contract creation 
	    	double total_profit = 0;
	    	
	        while (true) {
	        	String[] contract = s.nextLine().split(" ");
	        	
	        	// how to break the while loop reading contracts
	        	if (contract[0].equals("quit")) {
	                break;
	            }
	        	
	        	// give my contract variables values based on the contract list being read
	        	double mass = Double.parseDouble(contract[0]);
	            double distance = Double.parseDouble(contract[1]);
	            double payment = Double.parseDouble(contract[2]);
	            
	            // System.out.printf("mass: %.2f distance: %.2f payment %.2f\n", mass, distance, payment);
	            
	            double best_profit = -1;
	            String best_vehicle = null;
	            boolean profitable = false;
	        	
	            for (SupplyChainHW vehicle : fleet) {
	                // System.out.printf("vehicle: %s max_cargo: %.2f max_range: %.2f top_speed: %.2f hourly_cost: %.2f cost_per_mile: %.2f\n", vehicle.name, vehicle.max_cargo, vehicle.max_range, vehicle.top_speed, vehicle.hourly_cost, vehicle.cost_per_mile);
	                if (mass < vehicle.max_cargo && distance < vehicle.max_range) {
	                    double cost = vehicle.calculate_cost(distance);
	                    double profit = payment - cost;
	                    // System.out.printf("vehicle: %s cost: %.2f payment: %.2f profit: %.2f\n", vehicle.name, cost, payment, profit);
	                    if (profit > 0 && profit > best_profit) {
	                        profitable = true;
	                        best_profit = profit;
	                        best_vehicle = vehicle.name;
	                        // System.out.printf("best vehicle: %s best profit: %.2f\n", best_vehicle, best_profit);

	                    }
	                }
	                else {
	                	//System.out.printf("vehicle: %s not used\n", vehicle.name);
	                }
	            }
	            
	            // print statements 
	            if (profitable) {
	                System.out.printf("%s %.2f\n", best_vehicle, best_profit);
	                total_profit += best_profit;
	            } 
	            
	            else {
	                System.out.println("decline");
	            }
	        }
	        
	        System.out.printf("TotalProfit: %.2f\n", total_profit);
	}
	

}
