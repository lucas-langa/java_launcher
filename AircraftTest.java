public class AircraftTest {
	public static void 	main(String [] args) {
		Coordinates place = new  Coordinates(2 ,3, 20);
		Flyable F = AircraftFactory.newAircraft("baloon", "xl", place.getLongitude(), place.getLatitude(), place.getHeight());
	}
}