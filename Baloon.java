public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	/*
	* constructor when packages
	*/
	public 			Baloon( String name, Coordinates coordinates ) {
		super( name, coordinates );
	}

	public void 	updateConditions( ) {
		String currentWeather = this.weatherTower.getWeather( this.coordinates );
		if ( currentWeather.equals("SUN") ) {
			coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() , coordinates.getHeight() + 4 );
		} else if ( currentWeather.equals("RAIN")) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude() , coordinates.getHeight() - 5);
		} else if ( currentWeather.equals("FOG") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude() , coordinates.getHeight() - 3);
		} else if ( currentWeather.equals("SNOW") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
		}
		System.out.println("Updating balloon conditions");
		return ;
	}

	public void 	registerTower( WeatherTower  weatherTower ) {
		System.out.println("Updating balloon registertower");
		return ;
	}
}
