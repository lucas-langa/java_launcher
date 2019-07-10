package za.co.wethinkcode.weather;
import za.co.wethinkcode.coordinates.Coordinates;

public class WeatherProvider {

	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = { "SUN", "SNOW", "RAIN", "FOG" };

	private 	WeatherProvider() { 
	}

	public static WeatherProvider 	getProvider( ) {
		return ( WeatherProvider.weatherProvider );
	}

	public String 	getCurrentWeather( Coordinates coordinates ) {
		int w = ( coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() ) % 4;
		if ( w < 5 )
			return ( weather[1] );
		if ( w < 10 )
			return ( weather[3] );
		if ( w < 15 )
			return ( weather[2] );
		if ( w < 20 )
			return ( weather[0] );
		return (" ");
	}
}