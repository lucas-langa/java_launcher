package za.co.wethinkcode.flyingthings;
import za.co.wethinkcode.weather.WeatherTower;
import za.co.wethinkcode.Flyable;
import za.co.wethinkcode.Simulator;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	/*
	* constructor when packages
	*/
	Baloon( String name, Coordinates coordinates ) {
		super( name, coordinates );
	}

	public void 	updateConditions( ) {
		this.weatherTower = new WeatherTower();
		String currentWeather = weatherTower.getWeather( this.coordinates );

		Simulator.writer.println("changing from these Coordinates:  " + this.coordinates );
		if ( currentWeather.equals("SUN") ) {
			coordinates = new Coordinates( coordinates.getLongitude() + 2, coordinates.getLatitude() , coordinates.getHeight() + 4 );
		} else if ( currentWeather.equals("RAIN")) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude() , coordinates.getHeight() - 5);
		} else if ( currentWeather.equals("FOG") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude() , coordinates.getHeight() - 3);
		} else if ( currentWeather.equals("SNOW") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
		}
		Simulator.writer.println("To these: " + this.coordinates );
		Simulator.writer.println( "Updating baloon " + this.name + " conditions from " + currentWeather + " to " + ( currentWeather = weatherTower.getWeather(coordinates) ) );
		return ;
	}
	
	public void 	registerTower( WeatherTower  weatherTower ) {
		this.weatherTower = weatherTower;
		this.weatherTower.register( this );
		Simulator.writer.println("Tower says" + this + " registered to tower");
		return ;
	}
}
