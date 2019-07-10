import za.co.wethinkcode.*;
import za.co.wethinkcode.coordinates.Coordinates;
import za.co.wethinkcode.weather.WeatherProvider;
public class AircraftTest {
	public static void 	main(String [] args) {
		Coordinates place = new  Coordinates(2 ,3, 20);
		Flyable F = AircraftFactory.newAircraft("baloon", "xl", place.getLongitude(), place.getLatitude(), place.getHeight());
		WeatherTower W = new WeatherTower();
		F.registerTower( W );
		F.updateConditions();
	}
}