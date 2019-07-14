package za.co.wethinkcode;
import za.co.wethinkcode.Flyable;
import za.co.wethinkcode.flyingthings.AircraftFactory;
import za.co.wethinkcode.weather.WeatherTower;
import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Simulator {
	public static PrintWriter writer;
	public static int runSim;
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
		if ( args.length == 1 ) {

			try{
				String data = Simulator.readStuff( args[0] );
				try {
					File filename = new File("./simulation.txt");
					filename.createNewFile();
					if ( filename.exists() && filename.isFile() )
					{
						Simulator.writer = new PrintWriter( filename );
						ArrayList<String> strings = new ArrayList<String>();
						String[] lines = data.split("\n", 0);
						String []temp;
						for ( String aircraft  : lines )
							strings.add( aircraft );
						Simulator.runSim = Integer.parseInt(lines[0]);
						strings.remove(0);
						int []flyDigits = new int[3];
						String AircraftName = new String("");
						String Aircraft = new String("");
						ArrayList<Flyable> F = new ArrayList<Flyable>();
						WeatherTower W = new WeatherTower();
						for ( String listItem : strings ) {
							temp = listItem.split( " ", 0 );
							Aircraft = Simulator.AircraftValidator( temp );
							AircraftName = Simulator.NameValidator( temp[1] );
							flyDigits = Simulator.CoordinatesValidator( temp );
							F.add( AircraftFactory.newAircraft( Aircraft, AircraftName,  flyDigits[0] , flyDigits[1], flyDigits[2]) );
						}
						for ( Flyable  vehicles : F) {
							vehicles.registerTower( W );
							vehicles.landing( W );
						}
						while ( Simulator.runSim-- > 0){
							W.changeWeather();
							for ( Flyable  vehicles : F) {
								vehicles.updateConditions( );
								vehicles.landing( W );
							}
						}
						Simulator.writer.flush();
						Simulator.writer.close();
					}
					}catch(IOException e) {
							System.out.println( e.getMessage() );
						}	
			} catch (FileNotFoundException e) {
					System.out.println( e.getMessage() );
			}
			runSim--;
		}
	}
}

