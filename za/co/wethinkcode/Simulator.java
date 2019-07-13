package za.co.wethinkcode;
import za.co.wethinkcode.flyingthings.Coordinates;
import za.co.wethinkcode.Flyable;
import za.co.wethinkcode.flyingthings.AircraftFactory;
import za.co.wethinkcode.weather.WeatherTower;
import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Simulator {
	public static PrintWriter writer;
	public static String AircraftValidator( String[] data ) {
        if ( data[0].equals("Baloon") || data[0].equals("Helicopter") || data[0].equals("JetPlane") )
        {
            return ( data[0] );
        }
        else
            throw new IllegalArgumentException("unacceptable aircraft type");
    }

    public static String NameValidator( String name ) {
        if ( name == null )
            throw new IllegalArgumentException("string is empty");
        return ( name );
    }

    public static int[] CoordinatesValidator( String[] coordinates ) {
        int[] newCoordinates = new int[3];
        try
        {
            newCoordinates[0] = Integer.parseInt( coordinates[2] );
            newCoordinates[1] = Integer.parseInt( coordinates[3] );
            newCoordinates[2] = Integer.parseInt( coordinates[4] );
        }
        catch ( NumberFormatException e ) {
            System.out.println( e.getMessage() + " somewhere in that file, some string is not a number" );
        }
        return ( newCoordinates );
    }

    public static String readStuff( String stuff ) throws Exception {

        File file = new File( stuff );
        BufferedReader br = new BufferedReader( new FileReader(file) );
        
        String st;
        String res = "";
        while ( ( st = br.readLine() ) != null)
            res += st + "\n";
        br.close();
        return (res);
    }
	public static void 	main(String [] args) throws Exception {
		if ( args[0].length() > 0 ) {
			String data = Simulator.readStuff( args[0] );
			
			ArrayList<String> strings = new ArrayList<String>();
			String[] lines = data.split("\n", 0);
			String []temp;
			for ( String aircraft  : lines )
				strings.add( aircraft );
			strings.remove(0);
			int []flyDigits = new int[3];
			String AircraftName = new String("");
			String Aircraft = new String("");
			WeatherTower W = new WeatherTower();
			ArrayList<Flyable> F = new ArrayList<Flyable>();
			Coordinates place;
			for ( String listItem : strings ) {
				temp = listItem.split( " ", 0 );
				Aircraft = Simulator.AircraftValidator( temp );
				AircraftName = Simulator.NameValidator( temp[1] );
				flyDigits = Simulator.CoordinatesValidator( temp );
				place = new Coordinates( flyDigits[0] , flyDigits[1], flyDigits[2] );
				F.add( AircraftFactory.newAircraft( Aircraft, AircraftName, place.getLongitude(), place.getLatitude(), place.getHeight()) );
			}
			for ( Flyable  vehicles : F) {
				vehicles.registerTower( W );
				vehicles.updateConditions();
			}
		}
	}
}
