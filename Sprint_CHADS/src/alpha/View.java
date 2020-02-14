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
		case "2": return Chad.ZIPCODE;
		case "3": return Chad.ADDVEHICLE;
		case "4": return Chad.REMOVEVEHICLE;
		case "sub.0": return Chad.OUTPUTALL;
		case "sub.1": return Chad.DAILYREVENUE;
		case "sub.2": return Chad.ADDVEHICLE;
		case "sub.3": return Chad.REMOVEVEHICLE;
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
		System.out.println("Display all rentals: Enter 0");
		System.out.println("Search by location:  Enter 1");
		System.out.println("Search by zipcode:   Enter 2");
		System.out.println("Add Vehicle:         Enter 3");
		System.out.println("Remove Vehicle:      Enter 4");
		System.out.println("Quit:                Enter Q");
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
		clear();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("-------TravelWithChad.com BackOffice-------");
		System.out.println("Showing results for : " + locationName);
		System.out.println();
		System.out.println("Display all rentals:                   Enter 0");
		System.out.println("Display Daily Revenue:                 Enter 1");
		System.out.println("Add Vehicle:                           Enter 2");
		System.out.println("Remove Vehicle:                        Enter 3");
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
		
			clear();
			System.out.println("------------Locations------------\n");
			System.out.println(FunctionHandler.getLocations() + "\n ");
			System.out.println("-------------------------------\n");
			

		}
	
	public static String displaySubMenu(int zip) {
		return displaySubMenu( "" + zip );
	}

	public static void displayError() {
		clear();
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
		clear();
		List<String> locs = new ArrayList<String>();
		List<Integer> zips = new ArrayList<Integer>();
		List<Vehicle[]> vZip = new ArrayList<Vehicle[]>();
		List<Vehicle[]> vLoc = null;
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
			vLoc = new ArrayList<Vehicle[]>();
			for (Vehicle v : vz) {
				if (!locs.contains(v.getLocationName().toLowerCase())) {
					locs.add(v.getLocationName().toLowerCase());
					vLoc.add(FunctionHandler.filterByName(vehicles, v.getLocationName()));
				}
			}
			
			for (Vehicle[] vl : vLoc) {
				System.out.println("\t-----------------------------------------------");
				System.out.println("\tLocation: " + vl[0].getLocationName() + "\n");
				for (Vehicle v : vl) {
					System.out.println("\t" + v.getMake() + " " + v.getModel()
					+ "\t" + v.getRentalRate() + "\t"
					+ (v.getVehicleCount() - v.getVehicleRentCount()) + " Available\t"
					+ v.getVehicleRentCount() + " Rented");
				}
			}
			System.out.println("\t-----------------------------------------------");
			System.out.println("\n" + lineBreak);
		}
		System.out.println("Press Enter To Continue");
		getInput();
		
	}
	
	public static void displayLocationNames(Vehicle[] vehicles) {
		clear();

		System.out.println("------------Locations------------\n");
		System.out.println(FunctionHandler.getLocations() + "\n ");
		System.out.println("-------------------------------\n");
		
		System.out.println("Press Enter To Continue");
		getInput();
		

		}
	

	public static void displayOutput(int noVehicles) {
		clear();
		System.out.println("---NUMBER AVAILABLE RENTALS---\n");
		System.out.println("Number rentals Available: " + noVehicles);
		System.out.println("-------------------------------\n");
		
		System.out.println("Press Enter To Continue");
		getInput();
		
	}
	
	public static void displayOutput(Double output, Chad rateOrRevenue) {
		clear();
		if (rateOrRevenue == Chad.DAILYREVENUE) {
			System.out.println("----------TOTAL REVENUE-------\n");
			System.out.println("Total Revenue: " + nf.format(output));
			System.out.println("------------------------------\n");
			
			System.out.println("Press Enter To Continue");
			getInput();
		}
		if (rateOrRevenue == Chad.OUTPUTDAILYRATE) {
			System.out.println("----------RENTAL RATE-------\n");
			System.out.println("Rental Rate: " + nf.format(output));
			System.out.println("------------------------------\n");
			
			System.out.println("Press Enter To Continue");
			getInput();
		}
		
	}
	
	public static void displayOutput(String message) {
		clear();
		System.out.println("\n" + message + "\n");
		
	}
	
	public static void displayExit() {
		clear();
		System.out.println("BRAH... I'M OUT!");
		System.exit(0);
	}
	
	public static void clear(){

		for (int i = 0; i < 50; ++i) System.out.println();
		
	}
}