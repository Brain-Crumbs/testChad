package alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Controller {
//BROH I COMMITED A COMMENT

	public static void main(String[] args) {

		while (true) {

			Chad menuOption = View.inputHandler(View.displayMenu());
			if (menuOption == Chad.QUIT) {
				View.displayExit();
			}
			if (menuOption == Chad.ERROR) {
				View.displayError();
			if (menuOption == Chad.ADDVEHICLE) {
				FunctionHandler.addVehicle();
			}
			if (menuOption == Chad.REMOVEVEHICLE) {
				FunctionHandler.removeVehicle();
			}
			} else {
				Handler(menuOption);
			}

		}

	}

	public static void Handler(Chad menuOption) {

		if (menuOption == Chad.DISPLAYALL) {

			View.displayOutput(new DatabaseHandler().output());
			
		} else if (menuOption == Chad.ZIPCODE) {

			int zip = Integer.parseInt(View.getZip());
			
			
			while(true) {
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
			
			
		} else if (menuOption == Chad.NAME) {

			String locationName = View.getName();
			while(true) {
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

	}

	

}
