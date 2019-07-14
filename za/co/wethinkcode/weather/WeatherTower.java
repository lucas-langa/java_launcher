package za.co.wethinkcode.weather;
import za.co.wethinkcode.WeatherProvider;
import za.co.wethinkcode.flyingthings.Coordinates;

public class WeatherTower extends Tower {
	
	public String 	getWeather( Coordinates coordinates ) {
		WeatherProvider meh = WeatherProvider.getProvider();
		return ( meh.getCurrentWeather( coordinates ) );
	}

	public void changeWeather( ) {
		this.conditionsChanged();
	}
}
