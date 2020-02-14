package alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class View {
	
	static NumberFormat nf = NumberFormat.getCurrencyInstance();
	
	public static Chad inputHandler(String input) {
		
		switch(input) {
		case "0": return Chad.DISPLAYALL;
		case "1": return Chad.LOCATIONNAMES;
		case "2": return Chad.NAME;
		case "4": return Chad.ZIPCODE;
		case "5": return Chad.ADDVEHICLE;
		case "6": return Chad.REMOVEVEHICLE;
		case "sub.0": return Chad.OUTPUTALL;
		case "sub.1": return Chad.OUTPUTDAILYRATE;
		case "sub.2": return Chad.DAILYREVENUE;
		case "sub.3": return Chad.AVAILABLEVEHICLES;
		case "sub.4": return Chad.ADDVEHICLE;
		case "sub.5": return Chad.REMOVEVEHICLE;
		case "sub.r": return Chad.RETURNTOMAIN;
		default:  
			if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("sub.q")) {
				return Chad.QUIT;
			} else {
				return Chad.ERROR;
			}
			
		}

		
	}
	
	public static String displayMenu() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("-------Welcome to TravelWithChad.com BackOffice-------\n");
		System.out.println("Display all rentals:        Enter 0");
		System.out.println("See all locations:          Enter 1");
		System.out.println("Search rentals by location: Enter 2");
		System.out.println("Search rentals by zipcode:  Enter 3");
		System.out.println("Add Vehicle:                Enter 4");
		System.out.println("Remove Vehicle:             Enter 5");
		System.out.println("Quit:                       Enter Q");
		System.out.println();
		
		String input = "";
		try {
			input = in.readLine().toLowerCase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return input;
	}
	
	public static String displaySubMenu(String locationName) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("-------TravelWithChad.com BackOffice-------");
		System.out.println("Showing results for : " + locationName);
		System.out.println();
		System.out.println("Display all rentals:                   Enter 0");
		System.out.println("Display Daily Rates:                   Enter 1");
		System.out.println("Display Daily Revenue:                 Enter 2");
		System.out.println("Display Number of Available Vehicles:  Enter 3");
		System.out.println("Add Vehicle:                           Enter 4");
		System.out.println("Remove Vehicle:                        Enter 5");
		System.out.println("Return to Main Menu:                   Enter R");
		System.out.println("Quit:                                  Enter Q");
		System.out.println();
		
		String input = "";
		try {
			input = in.readLine().toLowerCase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "sub." + input;
	}
	
	public static void displayLocationNames(HashSet<String> hashSet) {
		
		//for(Vehicle vehicle : vehicles) {
		//if(Chad.LOCATIONNAMES != null) {
			System.out.println("------------Locations------------\n");
			System.out.println(FunctionHandler.getLocations() + "\n ");
			System.out.println("-------------------------------\n");
		//}
		}
	
	public static String displaySubMenu(int zip) {
		return displaySubMenu( "" + zip );
	}

	public static void displayError() {
		
		System.out.println(Chad.ERROR.toString());
	}
	
	public static String getZip() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter a zip code to search");
		String input = "";
		try {
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static String getName() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter a Location Name to search");
		String input = "";
		try {
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static String getInput() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static void displayOutput(Vehicle[] vehicles) {
		
		List<String> locs = new ArrayList<String>();
		List<Integer> zips = new ArrayList<Integer>();
		List<Vehicle[]> vZip = new ArrayList<Vehicle[]>();
		String lineBreak = "-------------------------------------------------------";
		
		for (Vehicle v : vehicles) {
			if (!zips.contains(v.getZipCode())) {
				zips.add(v.getZipCode());
				vZip.add(FunctionHandler.filterByZip(vehicles, v.getZipCode()));
			}
		}
		
		for (Vehicle[] vz : vZip) {
			System.out.println(lineBreak);
			System.out.println("ZipCode: " + vz[0].getZipCode() + "\n");
			for (Vehicle v : vz) {
				if (!locs.contains(v.getLocationName().toLowerCase())) {
					locs.add(v.getLocationName().toLowerCase());
					System.out.println("\t-----------------------------------------------");
					System.out.println("\tLocation: " + v.getLocationName() + "\n");
				}
				
				System.out.println("\t" + v.getMake() + "" + v.getModel()
						+ "\t" + v.getRentalRate() + "\t"
						+ (v.getVehicleCount() - v.getVehicleRentCount()) + " Available\t"
						+ v.getVehicleRentCount() + " Rented");
				
			}
			System.out.println("\t-----------------------------------------------");
			System.out.println("\n" + lineBreak);
		}
		getInput();
	}
	
public static void displayLocationNames(Vehicle[] vehicles) {
		
		//for(Vehicle vehicle : vehicles) {
		//if(Chad.LOCATIONNAMES != null) {
			System.out.println("------------Locations------------\n");
			System.out.println(FunctionHandler.getLocations() + "\n ");
			System.out.println("-------------------------------\n");
		//}
		}
	
	//hello
	public static void displayOutput(int noVehicles) {
			
			System.out.println("---NUMBER AVAILABLE RENTALS---\n");
			System.out.println("Number rentals Available: " + noVehicles);
			System.out.println("------------------------------\\n");
	}
	
	public static void displayOutput(Double output, Chad rateOrRevenue) {
		if (rateOrRevenue == Chad.DAILYREVENUE) {
			System.out.println("----------TOTAL REVENUE-------\n");
			System.out.println("Total Revenue: " + nf.format(output));
			System.out.println("------------------------------\n");
		}
		if (rateOrRevenue == Chad.OUTPUTDAILYRATE) {
			System.out.println("----------RENTAL RATE-------\n");
			System.out.println("Rental Rate: " + nf.format(output));
			System.out.println("------------------------------\n");
		}
	}
	
	public static void displayOutput(String message) {
		
		System.out.println("\n" + message + "\n");
		
	}
	
	public static void displayExit() {
		System.out.println("BRAH... I'M OUT!");
		System.exit(0);
	}
}
