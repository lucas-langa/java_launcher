package za.co.wethinkcode.flyingthings;
import za.co.wethinkcode.weather.WeatherTower;
import za.co.wethinkcode.Flyable;

public class 	Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	/*
	* constructor later, packages and what not
	*/
	Helicopter( String name, Coordinates coordinates ) {
		super( name, coordinates );
	}

	public void 	updateConditions() {
		String currentWeather = this.weatherTower.getWeather( this.coordinates );

		System.out.println("changing from these Coordinates:  " + this.coordinates );
		if ( currentWeather.equals("SUN") ) {
			coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() , coordinates.getHeight() + 2 );
		} else if ( currentWeather.equals("RAIN")) {
			coordinates = new Coordinates( coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight() );
		} else if ( currentWeather.equals("FOG") ) {
			coordinates = new Coordinates( coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() );
		} else if ( currentWeather.equals("SNOW") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
		}
		System.out.println("To these: " + this.coordinates );
		System.out.println( "Updating Helicopter " + this.name + " conditions from " + currentWeather + " to " + ( currentWeather = weatherTower.getWeather(coordinates) ) );
		return ;
	}

	public void		registerTower( WeatherTower weatherTower ) {
		this.weatherTower = weatherTower;
		this.weatherTower.register( this );
		return ;
	}
}