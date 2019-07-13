package za.co.wethinkcode;
import za.co.wethinkcode.flyingthings.Coordinates;

public class WeatherProvider {

	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = { "SUN", "SNOW", "RAIN", "FOG" };

	private 	WeatherProvider() { 
	}

	public static WeatherProvider 	getProvider( ) {
		return ( WeatherProvider.weatherProvider );
	}

	public String 	getCurrentWeather( Coordinates coordinates ) {
		double w = Math.random() * (( coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() ) % 21);
		int x = (int)w;

		if ( x < 5 )
			return ( weather[1] );
		if ( x < 10 )
			return ( weather[3] );
		if ( x < 15 )
			return ( weather[2] );
		if ( x < 20 )
			return ( weather[0] );
		return (" ");
	}
}