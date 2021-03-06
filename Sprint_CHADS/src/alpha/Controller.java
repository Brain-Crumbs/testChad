package alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {

		while (true) {
			View.clear();

			Chad menuOption = View.inputHandler(View.displayMenu());
			if (menuOption == Chad.QUIT) {

				View.displayExit();
			}
			if (menuOption == Chad.ERROR) {

				View.displayError();
			}
			if (menuOption == Chad.ADDVEHICLE) {

				FunctionHandler.addVehicle();
			}
			if (menuOption == Chad.REMOVEVEHICLE) {

				FunctionHandler.removeVehicle();
			}
			if(menuOption == Chad.LOCATIONNAMES) {
	
				View.displayLocationNames(FunctionHandler.getLocations());
				subMenuHandler(View.getName());
			}
			if (menuOption == Chad.DISPLAYALL) {

				View.displayOutput(new DatabaseHandler().output());
				
			} 
			if (menuOption == Chad.ZIPCODE) {

				subMenuHandler(Integer.parseInt(View.getZip()));
			}

		}

	}

	
	public static void subMenuHandler(String locationName) {

		while(true) {
			View.clear();
			Chad subMenuOption = View.inputHandler(View.displaySubMenu(locationName));
	
			if (subMenuOption == Chad.OUTPUTALL) {
				Vehicle[] vehiclesOut = FunctionHandler.filterByName(new DatabaseHandler().output(), locationName);
				View.displayOutput(vehiclesOut);	
			}
			if (subMenuOption == Chad.AVAILABLEVEHICLES) {
				int noVehicles = FunctionHandler.getAvailableVehicles(locationName);
				View.displayOutput(noVehicles);
			}
			if (subMenuOption == Chad.OUTPUTDAILYRATE) {
				double dailyRate = FunctionHandler.getDailyRate(locationName);
				View.displayOutput(dailyRate, subMenuOption);
			}
			if (subMenuOption == Chad.DAILYREVENUE) {
				Double dailyRevenue = FunctionHandler.getDailyRevenue(locationName);
				View.displayOutput(dailyRevenue, subMenuOption);
			}
			if (subMenuOption == Chad.ADDVEHICLE) {
				FunctionHandler.addVehicle(locationName);
				
			}
			if (subMenuOption == Chad.REMOVEVEHICLE) {
				FunctionHandler.removeVehicle(locationName);
			}
			if (subMenuOption == Chad.ERROR) {
				View.displayError();
			}
			if (subMenuOption == Chad.RETURNTOMAIN) {

				break;
			}
			if (subMenuOption == Chad.QUIT) {
				View.displayExit();
			}
		}
	}

	public static void subMenuHandler(int zip) {
		while(true) {
			View.clear();
			Chad subMenuOption = View.inputHandler(View.displaySubMenu(zip));
			
			if (subMenuOption == Chad.OUTPUTALL) {
				Vehicle[] vehiclesOut = FunctionHandler.filterByZip(new DatabaseHandler().output(), zip);
				View.displayOutput(vehiclesOut);
			}
			if (subMenuOption == Chad.AVAILABLEVEHICLES) {
				int noVehicles = FunctionHandler.getAvailableVehicles(zip);
				View.displayOutput(noVehicles);
			}
			if (subMenuOption == Chad.OUTPUTDAILYRATE) {
				Double dailyRate = FunctionHandler.getDailyRate(zip);
				View.displayOutput(dailyRate, subMenuOption);
			}
			if (subMenuOption == Chad.DAILYREVENUE) {
				Double dailyRevenue = FunctionHandler.getDailyRevenue(zip);
				View.displayOutput(dailyRevenue, subMenuOption);
			}
			if (subMenuOption == Chad.ADDVEHICLE) {
				FunctionHandler.addVehicle(zip);
			}
			if (subMenuOption == Chad.REMOVEVEHICLE) {
				FunctionHandler.removeVehicle(zip);
			}
			if (subMenuOption == Chad.ERROR) {
				View.displayError();
			}
			if (subMenuOption == Chad.RETURNTOMAIN) {
				break;
			}
			if (subMenuOption == Chad.QUIT) {
				View.displayExit();
			}
		}
	}
	

}