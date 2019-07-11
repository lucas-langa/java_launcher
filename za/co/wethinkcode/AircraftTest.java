package za.co.wethinkcode;
import za.co.wethinkcode.flyingthings.Coordinates;
import za.co.wethinkcode.Flyable;
import za.co.wethinkcode.flyingthings.AircraftFactory;
import za.co.wethinkcode.weather.WeatherTower;
public class AircraftTest {
	public static void 	main(String [] args) {
		Coordinates place = new  Coordinates(2 ,3, 20);
		Flyable F = AircraftFactory.newAircraft("baloon", "xl", place.getLongitude(), place.getLatitude(), place.getHeight());
		WeatherTower W = new WeatherTower();
		F.registerTower( W );
		F.updateConditions();
	}
}
