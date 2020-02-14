package alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
//brah
public class FunctionHandler {
	
	static Vehicle[] filterByZip(Vehicle[] v, int zipCode) {
		int size = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getZipCode() == zipCode) {
				size++;
			}
		}
		Vehicle[] output = new Vehicle[size];
		int count = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getZipCode() == zipCode) {
				output[count] = v[i];
				count++;
			}
		}
		return output;
	}
	

	static Vehicle[] filterByName(Vehicle[] v, String locationName) {
		int size = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getLocationName().equalsIgnoreCase(locationName)) {
				size++;
			}
		}
		Vehicle[] output = new Vehicle[size];
		int count = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getLocationName().equalsIgnoreCase(locationName)) {
				output[count] = v[i];
				count++;
			}
		}
		return output;
	}

	static int getAvailableVehicles(int zipCode) {
		Vehicle[] output = filterByZip(new DatabaseHandler().output(), zipCode);
		int count = 0;
		for (Vehicle v : output) {
			count += (v.getVehicleCount() - v.getVehicleRentCount());
		}
		return count;
	}

	static int getAvailableVehicles(String locationName) {
		Vehicle[] output = filterByName(new DatabaseHandler().output(), locationName);
		int count = 0;
		for (Vehicle v : output) {
			count += (v.getVehicleCount() - v.getVehicleRentCount());
		}
		return count;
	}

	static double getDailyRate(int zipCode) {
		Vehicle[] output = filterByZip(new DatabaseHandler().output(), zipCode);
		double rate = 0;
		for (Vehicle v : output) {
			rate += v.getRentalRate();
		}
		rate = (rate / output.length);
		return rate;
	}

	static double getDailyRate(String locationName) {
		Vehicle[] output = filterByName(new DatabaseHandler().output(), locationName);
		double rate = 0;
		for (Vehicle v : output) {
			rate += v.getRentalRate();
		}
		rate = (rate / output.length);
		return rate;
	}

	static double getDailyRevenue(int zipCode) {
		Vehicle[] output = filterByZip(new DatabaseHandler().output(), zipCode);
		double dailyRevenue = 0;
		for (Vehicle v : output) {
			dailyRevenue += (v.getRentalRate() * v.getVehicleRentCount());
		}
		return dailyRevenue;
	}

	static double getDailyRevenue(String locationName) {
		Vehicle[] output = filterByName(new DatabaseHandler().output(), locationName);
		double dailyRevenue = 0;
		for (Vehicle v : output) {
			dailyRevenue += (v.getRentalRate() * v.getVehicleRentCount());
		}
		return dailyRevenue;
	}

	static HashSet<String> getLocations() {
		Vehicle[] veh = new DatabaseHandler().output();
		HashSet<String> locations = new HashSet<String>();
		
		for(Vehicle v : veh) {
			locations.add(v.getLocationName());
		}
		return locations;
	}
	
	static void addVehicle() {
		double rentalRate;
		String locationName;
		int zipCode;
		String make;
		String model;
		int totalVehicles;
		int totalVehiclesRented;
		boolean numberChecked = false;
		while (!numberChecked) {
			try {

				System.out.println("Please enter the rental rate: ");
				rentalRate = Double.parseDouble(getInput());
				System.out.println("Please enter the location name: ");
				locationName = getInput();
				System.out.println("Please enter the zip code: ");
				zipCode = Integer.parseInt(getInput());
				System.out.println("Please enter the vehicle make: ");
				make = getInput();
				System.out.println("Please enter the vehicle model: ");
				model = getInput();
				System.out.println("Please enter the total vehicles: ");
				totalVehicles = Integer.parseInt(getInput());
				System.out.println("Please enter the total vehicles rented: ");
				totalVehiclesRented = Integer.parseInt(getInput());

				Vehicle v = new Vehicle(rentalRate, locationName, zipCode, make, model, totalVehicles,
						totalVehiclesRented);
				new DatabaseHandler().input(v);
				numberChecked = true;

			} catch (NumberFormatException e) {
				System.out.println("BRO, THAT IS NOT COOL!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				if(e.getMessage().equalsIgnoreCase("quit")) {
					break;
				}
			}
		}
	}
	
	static void addVehicle(int zip) {
		double rentalRate;
		String locationName;
		int zipCode = zip;
		String make;
		String model;
		int totalVehicles;
		int totalVehiclesRented;

		boolean numberChecked = false;
		while (!numberChecked) {
			try {

				System.out.println("Please enter the rental rate: ");
				rentalRate = Double.parseDouble(getInput());
				System.out.println("Please enter the location name: ");
				locationName = getInput();
				System.out.println("Please enter the vehicle make: ");
				make = getInput();
				System.out.println("Please enter the vehicle model: ");
				model = getInput();
				System.out.println("Please enter the total vehicles: ");
				totalVehicles = Integer.parseInt(getInput());
				System.out.println("Please enter the total vehicles rented: ");
				totalVehiclesRented = Integer.parseInt(getInput());

				Vehicle v = new Vehicle(rentalRate, locationName, zipCode, make, model, totalVehicles,
						totalVehiclesRented);
				new DatabaseHandler().input(v);
				numberChecked = true;

			} catch (NumberFormatException e) {
				System.out.println("BRO, THAT IS NOT COOL!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				if(e.getMessage().equalsIgnoreCase("quit")) {
					break;
				}
			}
		}
	}
	
	static void addVehicle(String locationNameIn) {
		double rentalRate;
		String locationName = locationNameIn;
		int zipCode;
		String make;
		String model;
		int totalVehicles;
		int totalVehiclesRented;

		boolean numberChecked = false;
		while (!numberChecked) {
			try {

				System.out.println("Please enter the rental rate: ");
				rentalRate = Double.parseDouble(getInput());
				System.out.println("Please enter the zip code: ");
				zipCode = Integer.parseInt(getInput());
				System.out.println("Please enter the vehicle make: ");
				make = getInput();
				System.out.println("Please enter the vehicle model: ");
				model = getInput();
				System.out.println("Please enter the total vehicles: ");
				totalVehicles = Integer.parseInt(getInput());
				System.out.println("Please enter the total vehicles rented: ");
				totalVehiclesRented = Integer.parseInt(getInput());

				Vehicle v = new Vehicle(rentalRate, locationName, zipCode, make, model, totalVehicles,
						totalVehiclesRented);
				new DatabaseHandler().input(v);
				numberChecked = true;

			} catch (NumberFormatException e) {
				System.out.println("BRO, THAT IS NOT COOL!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				if(e.getMessage().equalsIgnoreCase("quit")) {
					break;
				}
			}
		}
	}
	
	static void removeVehicle() {
		String locationName;
		int zipCode;
		String make;
		String model;
		
		boolean numberChecked = false;
		while (!numberChecked) {
			try {
				
				System.out.println("Please enter the location name: ");
				locationName = getInput();
				System.out.println("Please enter the zip code: ");
				zipCode = Integer.parseInt(getInput());
				System.out.println("Please enter the vehicle make: ");
				make = getInput();
				System.out.println("Please enter the vehicle model: ");
				model = getInput();
				
				Vehicle v = new Vehicle(0.0, locationName, zipCode, make, model, 0,
						0);
				new DatabaseHandler().removeVehicle(v);
				numberChecked = true;

			} catch (NumberFormatException e) {
				System.out.println("BRO, THAT IS NOT COOL!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				if(e.getMessage().equalsIgnoreCase("quit")) {
					break;
				}
			}
		}
	}
	
	static void removeVehicle(String locationNameIn) {
		String locationName = locationNameIn;
		int zipCode;
		String make;
		String model;
		boolean numberChecked = false;
		while (!numberChecked) {
			try {
				
				System.out.println("Please enter the zip code: ");
				zipCode = Integer.parseInt(getInput());
				System.out.println("Please enter the vehicle make: ");
				make = getInput();
				System.out.println("Please enter the vehicle model: ");
				model = getInput();
				
				Vehicle v = new Vehicle(0.0, locationName, zipCode, make, model, 0,
						0);
				new DatabaseHandler().removeVehicle(v);
				numberChecked = true;

			} catch (NumberFormatException e) {
				System.out.println("BRO, THAT IS NOT COOL!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				if(e.getMessage().equalsIgnoreCase("quit")) {
					break;
				}
			}
		}
	}
	
	static void removeVehicle(int zip) {
		String locationName;
		int zipCode = zip;
		String make;
		String model;
		
		boolean numberChecked = false;
		while (!numberChecked) {
			try {
				
				System.out.println("Please enter the location name: ");
				locationName = getInput();
				System.out.println("Please enter the vehicle make: ");
				make = getInput();
				System.out.println("Please enter the vehicle model: ");
				model = getInput();
				
				Vehicle v = new Vehicle(0.0, locationName, zipCode, make, model, 0,
						0);
				new DatabaseHandler().removeVehicle(v);
				numberChecked = true;

			} catch (NumberFormatException e) {
				System.out.println("BRO, THAT IS NOT COOL!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				if(e.getMessage().equalsIgnoreCase("quit")) {
					break;
				}
			}
		}
	}
	
	static String getInput() throws IOException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String output = br.readLine();
		if(output.equalsIgnoreCase("quit") || output.equalsIgnoreCase("q")){
			throw new Exception("quit");
		} else {
		return output;
		}
	}

}