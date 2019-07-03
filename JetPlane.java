public class JetPlane extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	/*
	* constructor when packages
	*/
	public 			JetPlane( String name, Coordinates coordinates ) {
		super( name, coordinates );
	}

	public void 	updateConditions( ) {
		String currentWeather = this.weatherTower.getWeather( this.coordinates );

		if ( currentWeather.equals("SUN") ) {
			coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() + 10, coordinates.getHeight() + 2 );
		} else if ( currentWeather.equals("RAIN")) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight() );
		} else if ( currentWeather.equals("FOG") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight() );
		} else if ( currentWeather.equals("SNOW") ) {
			coordinates = new Coordinates( coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
		}
		return ;
	}

	public void 	registerTower( WeatherTower  weatherTower ) {
		System.out.println("Updating balloon registertower");
		return ;
	}
}