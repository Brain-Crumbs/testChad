package alpha;

public enum Chad {

	DISPLAYALL,LOCATIONNAMES,ZIPCODE,OUTPUTDAILYRATE,AVAILABLEVEHICLES,
	DAILYREVENUE,NAME,ADDVEHICLE,REMOVEVEHICLE,QUIT,ERROR,
	OUTPUTALL, RETURNTOMAIN;
	
	//Hello all Chads
	
	private String Chad() {
		switch(ordinal()) {
		case 0:
			return "Display All";
		case 1:
			return "LocationNames";
		case 2:
			return "Zipcode";
		case 3:
			return "OutputDailyRate";
		case 4:
			return "AvailableVehicles";
		case 5:
			return "DailyRevenue";
		case 6:
			return "Name";
		case 7:
			return "AddVehicle";
		case 8:
			return "RemoveVehicle";
		case 9:
			return "Quit";
		case 10:
			return "BRO!!";
		case 11:
			return "OutputAll Bro";
		case 12:
			return "We are headed back to main Bro!";
		default:
			return null;
		}
	}
	
	@Override
	public String toString() {
		switch(ordinal()) {
		case 0:
			return "Display All";
		case 1:
			return "LocationNames";
		case 2:
			return "Zipcode";
		case 3:
			return "OutputDailyRate";
		case 4:
			return "AvailableVehicles";
		case 5:
			return "DailyRevenue";
		case 6:
			return "Name";
		case 7:
			return "AddVehicle";
		case 8:
			return "RemoveVehicle";
		case 9:
			return "Quit";
		case 10:
			return "BRO!!";
		case 11:
			return "OutputAll Bro";
		case 12:
			return "We are headed back to main Bro!";
		default:
			return null;
		}
	}
}
