/*
 * Niharika Agrawal
 * CSC 171
 * Design HW Assignment - Phone Class
 * nagrawa5@u.rochester.edu
 * Last Edited March 4, 2024
 */

public class Phone {
	// make variables
	int batteryCapacity;
	boolean screen;
	boolean voiceCalling;
	boolean wifi;
	boolean bluetooth;
	
	// set variables
	public Phone (int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	// define all getters
	public int batteryCapacity() {
		return batteryCapacity;
	}
	
	public boolean screen() {
		return screen;
	}
	
	public boolean voiceCalling() {
		return voiceCalling;
	}
	
	public boolean wifi() {
		return wifi;
	}
	
	public boolean bluetooth() {
		return bluetooth;
	}
	
	// define all setters
	public void setScreen(boolean screen) {
		this.screen = screen;
	}
	
	public void setVoiceCalling(boolean voiceCalling) {
		this.voiceCalling = voiceCalling;
	}
	
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	
	public void setbluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}
	
	// compute batteryPower
	public double computeBattery() {
		double totalPower = 0;
		
		if (screen) totalPower += 500;
        if (voiceCalling) totalPower += 300;
        if (wifi) totalPower += 200;
        if (bluetooth) totalPower += 100;
        
        // standby power
        totalPower += 5;
        
        return batteryCapacity / totalPower;
	}

}
