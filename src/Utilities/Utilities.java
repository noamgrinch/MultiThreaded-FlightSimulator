package Utilities;

import java.util.ArrayList;
import java.util.List;

import DataObjects.Airport;
import DataObjects.FlightTower;
import DataObjects.FlightTowerImpl;
import DataObjects.Lane;

public class Utilities {
	
	public static List<FlightTower> generateFlightTowers(int prefix, int lanes, int amount){
		List<FlightTower> flightTowers = new ArrayList<FlightTower>();
		for(int i=1;i<=amount;i++) {
			flightTowers.add(new FlightTowerImpl(generateLanes(prefix ^ i, lanes)));
		}
		return flightTowers;
	}
	
	private static List<Lane> generateLanes(int prefix, int amount){
		List<Lane> lanes = new ArrayList<Lane>();
		for(int i=0;i<amount;i++) {
			lanes.add(new Lane(prefix + i));
		}
		return lanes;
	}
	
	public static List<Airport> generateAirports(List<FlightTower> flightTowers){
		List<Airport> airports = new ArrayList<Airport>();
		for(int i=0;i<flightTowers.size();i++) {
			airports.add(new Airport(flightTowers.get(i)));
		}
		return airports;
	}
	

}
