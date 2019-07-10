package za.co.wethinkcode;

public abstract class AircraftFactory {

	public static Flyable newAircraft( String type, String name, int longitude, int latitude, int height ) {
		Coordinates manIdkTryingAnything = new Coordinates(longitude, latitude, height);
		if ( type.toLowerCase().equals("baloon") )
			return new Baloon( name, manIdkTryingAnything );
		else if ( type.toLowerCase().equals("Helicopter") )
			return new Helicopter( name, manIdkTryingAnything );
		else if ( type.toLowerCase().equals("JetPlane") )
			return new JetPlane( name, manIdkTryingAnything );
		return ( null );
	}
}