import java.util.*;
public abstract class Tower {

	private ArrayList<Flyable> 	observers;
	public 	void 	register( Flyable flyable ) {
		this.observers.add( flyable );
		System.out.println( flyable + " registered to weather tower");
		return ;
	}

	public void		unregister( Flyable flyable ) {
		if ( this.observers.contains( flyable )) {
			this.observers.remove( flyable );
			System.out.println( flyable + " unreg}istered to weather tower");
		}
		else {
			System.out.println("I see none of this kind registered to the Tower");
		}

		return ;
	}

	protected void 	conditionsChanged( ) {
		return ;
	}
}