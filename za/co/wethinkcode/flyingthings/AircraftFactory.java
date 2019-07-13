package za.co.wethinkcode.flyingthings;
import za.co.wethinkcode.Flyable;

public abstract class AircraftFactory {

	public static Flyable newAircraft( String type, String name, int longitude, int latitude, int height ) {
		Coordinates manIdkTryingAnything = new Coordinates(longitude, latitude, height);
		System.out.println("New " + type + " " + name);
		if ( type.equals("Baloon") )
			return new Baloon( name, manIdkTryingAnything );
		else if ( type.equals("Helicopter") )
			return new Helicopter( name, manIdkTryingAnything );
		else if ( type.equals("JetPlane") )
			return new JetPlane( name, manIdkTryingAnything );
		return ( null );
	}
}