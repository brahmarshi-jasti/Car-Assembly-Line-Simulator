
// The Car Class Encapsulates the features of a Car 
class Car
{
	private boolean engineFitted;		// boolean variable to indicate whether engine is fitted into car or not
	private boolean tyreFitted;			// boolean variable to indicate whether tyres are fitted into car or not
	private boolean lightSystemFitted;	// boolean variable to indicate whether light system is fitted into car or not
	// Constructor Method
	Car()
	{
		engineFitted = tyreFitted = lightSystemFitted = false;	// Initially no part part is fitted into car
	}
	
	// Accessor Methods
	public boolean isEngineFitted() 		{ return engineFitted;}
	public boolean isTyreFitted()			{ return tyreFitted;}
	public boolean isLightSystemFitted()	{ return lightSystemFitted;}
	public boolean iCarReady()				{ return engineFitted && tyreFitted && lightSystemFitted;  }
	
	// Methods to fit Engine, Tyres and Light System into Car
	public void fitEngine() 	{ engineFitted = true;}
	public void fitTyres()		{ tyreFitted = true;  }
	public void fitLightSystem(){ lightSystemFitted = true;}	
	
} // End of Class Car