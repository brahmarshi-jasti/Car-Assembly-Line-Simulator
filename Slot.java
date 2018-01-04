// The Slot Class Encapsulates the attributes of a Typical Slot of an Assembly Line
class Slot
{
	private JLabel slotHeadingLabel;		// Slot Heading Label (For Example "Slot I","Slot II" etc. )
	private JButton engineButton;			// Engine Button of Slot
	private JButton tyreButton;				// Tyre Button of Slot 
	private JButton lightSystemButton;		// Light System Button of Slot 
	private Car 	car;					// Car held by the Slot
	
	// Constructor Method
	Slot(JLabel slotHeadingLabel, JButton engineButton, JButton tyreButton, JButton lightSystemButton)
	{
		this.slotHeadingLabel 	= slotHeadingLabel;
		this.engineButton 		= engineButton;
		this.tyreButton			= tyreButton;
		this.lightSystemButton	= lightSystemButton;
		this.car				= null; 				// <-- Initially Slot Holds No Car
	}
	
	// Accessor Methods
	public JLabel getSlotHeadingLabel()		{ return this.slotHeadingLabel;}
	public JButton getEngineButton()		{ return this.engineButton;}
	public JButton getTyreButton()			{ return this.tyreButton;}
	public JButton getLightSystemButton()	{ return this.lightSystemButton;}
	public Car getCar() 					{ return this.car; }
	
	// Method to Add a car into a Slot
	public void addCarToSlot(Car c)	
	{ 
		this.car = c;	
	}
	
	// Method to Remove a car From a Slot
	public void removeCarFromSlot()
	{
		this.car = null;
	}
	
	// Method to check if a slot holds a car or empty
	public boolean isEmpty()
	{
		if (this.car == null ) 	return true; 
		else 					return false;
	}
}// End of Class Slot