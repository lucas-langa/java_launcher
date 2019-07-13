package za.co.wethinkcode.weather;
import za.co.wethinkcode.Flyable;
import java.util.ArrayList;
import za.co.wethinkcode.Simulator;

public abstract class Tower {

	private ArrayList<Flyable> 	observers = new ArrayList<Flyable>();

	public 	void 	register( Flyable flyable ) {
		if ( !(this.observers.contains( flyable )) )
		{
			this.observers.add( flyable );
			Simulator.writer.println( flyable + " registered to weather tower");
		}
		return ;
	}

	public void		unregister( Flyable flyable ) {
		if ( this.observers.contains( flyable )) {
			this.observers.remove( flyable );
			Simulator.writer.println( flyable + " unregistered to weather tower");
		}
		else {
			Simulator.writer.println("I see none of this kind registered to the Tower");
		}

		return ;
	}

	protected void 	conditionsChanged( ) {
		for ( Flyable observers : this.observers ) {
			observers.updateConditions();
		}
		return ;
	}
}