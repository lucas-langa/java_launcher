package za.co.wethinkcode.flyingthings;

public abstract class Aircraft{
	protected long 				id;
	protected String 			name;
	protected Coordinates 		coordinates;
	private static long			idCounter = 1;

	protected			 Aircraft( String name, Coordinates coordinates ) {
		this.id = this.nextId();
		this.name = name;
		this.coordinates = coordinates;
		return ;
	}

	@Override
	public String toString() {
		return ( this.name + "#" + this.id );
	}

	public long 	nextId( ) {
		return ( Aircraft.idCounter++ );
	}
}