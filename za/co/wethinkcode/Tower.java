package za.co.wethinkcode;
import java.util.ArrayList;

public abstract class Tower {

	private ArrayList<Flyable> 	observers = new ArrayList<Flyable>();

	public 	void 	register( Flyable flyable ) {
		if ( !(this.observers.contains( flyable )) )
		{
			this.observers.add( flyable );
			System.out.println( flyable + " registered to weather tower");
		}
		return ;
	}

	public void		unregister( Flyable flyable ) {
		if ( this.observers.contains( flyable )) {
			this.observers.remove( flyable );
			System.out.println( flyable + " unregistered to weather tower");
		}
		else {
			System.out.println("I see none of this kind registered to the Tower");
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