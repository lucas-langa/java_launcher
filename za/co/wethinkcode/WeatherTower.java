package za.co.wethinkcode;
import za.co.wethinkcode.weather.WeatherProvider;

public class WeatherTower extends Tower{
	
	public String 	getWeather( Coordinates coordinates ) {
		WeatherProvider meh = WeatherProvider.getProvider();
		return ( meh.getCurrentWeather( coordinates ) );
	}

	public void changeWeather( ) {
		this.conditionsChanged();
	}
}
