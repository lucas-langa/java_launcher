package za.co.wethinkcode.flyingthings;
import za.co.wethinkcode.Flyable;
import za.co.wethinkcode.Simulator;
import za.co.wethinkcode.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	JetPlane( String name, Coordinates coordinates ) {
		super( name, coordinates );
	}

	public void 	updateConditions( ) {
		String currentWeather = this.weatherTower.getWeather( this.coordinates );

		Simulator.writer.println("changing from these Coordinates:  " + this.coordinates );
		if ( currentWeather.equals("SUN") ) {
			coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() + 10, coordinates.getHeight() + 2 );
		} else if ( currentWeather.equals("RAIN")) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight() );
		} else if ( currentWeather.equals("FOG") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight() );
		} else if ( currentWeather.equals("SNOW") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
		}
		Simulator.writer.println("To these: " + this.coordinates );
		Simulator.writer.println( "JetPane " + this + " changing conditions from " + currentWeather + " to " + ( currentWeather = weatherTower.getWeather(coordinates) ) );
		return ;
	}

	public void 	registerTower( WeatherTower  weatherTower ) {
		this.weatherTower = weatherTower;
		this.weatherTower.register( this );
		return ;
	}

	public 	void	landing( WeatherTower weatherTower ) {
		if ( coordinates.getHeight() >= 100) {
			coordinates = new Coordinates( coordinates.getLongitude() , coordinates.getLatitude() , 100 );
		}
		if ( coordinates.getHeight() <= 0 ) {
			weatherTower.unregister( this );
		}
	}
}