public class WeatherProvider {

	private WeatherProvider weatherProvider;
	private String[] weather;

	private 	WeatherProvider() {
		return ;
	}

	public WeatherProvider 	getProvider( ) {
		return ( this );
	}

	public String 	getCurrentWeather( Coordinates coordinates ) {
		return ("");
	}
}