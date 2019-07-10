package za.co.wethinkcode;
import za.co.wethinkcode.coordinates.Coordinates;
public abstract class Aircraft{
	protected long 			id;
	protected String 		name;
	protected Coordinates 	coordinates;
	private long			idCounter;

	protected			 Aircraft( String name, Coordinates coordinates ) {
		this.name = name;
		this.coordinates = coordinates;
		System.out.println("new Aircraft Spawned" + this.name );
		return ;
	}

	public long 	nextId( ) {
		return (0);
	}
}