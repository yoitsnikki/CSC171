/*
 * Niharika Agrawal
 * CSC 171
 * nagrawa5@u.rochester.edu
 * HW 2: CalculatorHW
 */

// a conversion calculator. insert input in format "value" "source" to "dest", eg 64 ft to m
// it accepts ft, m, c, f, lb, kg, h, and min
// c/f = celcius/fahrenheit

// import classes
import java.util.Objects;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculatorHW {
	public static void main(String[] args) {
		Scanner s0 = new Scanner(System.in);
				
		//main while loop the entire program is in 
		while(s0.hasNextLine()) {
			String line = s0.nextLine();
			
			// to break the loop
			if (line.length() == 0)
				break;
			
			Scanner s = new Scanner(line);
			
			while (s.hasNext()) {
				
				// assign variables based on input
				double value = s.nextDouble();
				String source = s.next();
				String to = s.next();
				String dest = s.next();
				
				
				double f = 5.0 / 9.0; // for temp conversions
				double c = 9.0 / 5.0; // for temp conversions
				
				DecimalFormat df = new DecimalFormat("0.000"); // for rounding the decimal places
				
				// if the source and destination are equal
				if (Objects.equals(source, dest)) {
					double result = value;
					System.out.println(result);
					System.out.println("source = dest");
				}
				
				// f to c 
				else if ((source.equalsIgnoreCase("f")) & (dest.equalsIgnoreCase("c"))) {
					double result = ((value - 32.0)*f);
					System.out.println(df.format(result));
				}
				
				// c to f
				else if ((source.equalsIgnoreCase("c")) & (dest.equalsIgnoreCase("f"))) {
					double result = ((c*value) + 32.0);
					System.out.println(df.format(result));
				}
				
				// kg to lb
				else if ((source.equalsIgnoreCase("kg")) & (dest.equalsIgnoreCase("lb"))) {
					double result = (value * 2.20462);
					System.out.println(df.format(result));
				}
				
				// lb to kg
				else if ((source.equalsIgnoreCase("lb")) & (dest.equalsIgnoreCase("kg"))) {
					double result = (value * 0.453592);
					System.out.println(df.format(result));
				}
				
				// m to ft
				else if ((source.equalsIgnoreCase("m")) & (dest.equalsIgnoreCase("ft"))) {
					double result = (value * 3.28084);
					System.out.println(df.format(result));
				}
				
				// ft to m
				else if ((source.equalsIgnoreCase("ft")) & (dest.equalsIgnoreCase("m"))) {
					double result = (value * 0.3048);
					System.out.println(df.format(result));
				}
				
				// h to min
				else if ((source.equalsIgnoreCase("h")) & (dest.equalsIgnoreCase("min"))) {
					double result = (value * 60);
					System.out.println(df.format(result));
				}
				
				// min to h
				else if ((source.equalsIgnoreCase("min")) & (dest.equalsIgnoreCase("h"))) {
					double result = (value * 0.0166667);
					System.out.println(df.format(result));
				}
						
				// if input is invalid
				else {
					System.out.println("***Unable to convert from " + source.toLowerCase() + " to " + dest.toLowerCase() + "***");
				}
				
			}
			
		}
		
	}

}
