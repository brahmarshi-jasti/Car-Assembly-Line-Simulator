// The Remove Thread removes a car from the selected slot 
class RemoveThread extends Thread
{
	private AssemblyLine 	assemblyLine;			// The same explanation as given above
	private JTextArea 		threadsTextArea;		// The same explanation as given above
	private JButton			removeThreadButton;		// The same explanation as given above
	private int				no_of_CarsAdded;		// The same explanation as given above
	private int				no_of_Iterations;		// The same explanation as given above
	
	// Constructor Method
	RemoveThread(AssemblyLine assemblyLine, JTextArea threadsTextArea,JButton removeThreadButton)
	{
		this.assemblyLine 		= assemblyLine;
		this.threadsTextArea	= threadsTextArea;
		this.removeThreadButton	= removeThreadButton;
		no_of_Iterations		= no_of_CarsAdded	=	0;
	}
	
	// Run Method
	public void run()
	{
		synchronized(assemblyLine)
		{
			while(no_of_CarsAdded < 30)
			{
				try
				{
					while(!assemblyLine.isStarted())
					{
						long x = System.currentTimeMillis();
						no_of_Iterations++;
						threadsTextArea.append("\n\nREMOVE THREAD RUNNING\n");
						threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
						removeThreadButton.setBackground(Color.GREEN);
						Thread.sleep(2000);
						removeThreadButton.setBackground(Color.GRAY);
						threadsTextArea.append("Remove Thread Going in Waiting State\n");
						long s = System.currentTimeMillis();
						long executionTime = s - x;
						threadsTextArea.append("\nIteration Execution Time:" + executionTime +" Milli Seconds"+"\n");
						//assemblyLine.notifyAll();
						assemblyLine.wait();
					}
					long x = System.currentTimeMillis();
					no_of_Iterations++;
					threadsTextArea.append("\n\nREMOVE THREAD RUNNING\n");
					threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
					removeThreadButton.setBackground(Color.GREEN);
					Slot[] slots = assemblyLine.getSlots();
					for (int i =0; i<slots.length; i++)
					{
						threadsTextArea.append("Remove Thread Checking For Slot No: " + (i+1) +"\n");
						Slot s = slots[i];
						if(s.isEmpty())
							threadsTextArea.append("Status: Slot Empty\n");
						else
						if (!s.getCar().isEngineFitted())
							threadsTextArea.append("Status: Engine Not Fitted \n");
						else
						if (!s.getCar().isTyreFitted())
							threadsTextArea.append("Status: Tyres Not Fitted \n");
						else
						if (!s.getCar().isLightSystemFitted())
							threadsTextArea.append("Status: Light System Not Fitted \n");
						else 
						{
							threadsTextArea.append("Status: ...Removing Car From The Slot \n");
							Thread.sleep(2000);
							s.removeCarFromSlot();
							s.getEngineButton().setBackground(Color.GRAY);
							s.getTyreButton().setBackground(Color.GRAY);
							s.getLightSystemButton().setBackground(Color.GRAY);
							no_of_CarsAdded++;
							threadsTextArea.append("Status: Car Removed From The Slot \n");
						}
					}
					threadsTextArea.append("Light System Thread Going in Waiting State\n");
					long s = System.currentTimeMillis();
					long executionTime = s - x;
					if(executionTime < 2000) { Thread.sleep(2000 - executionTime); executionTime = (System.currentTimeMillis() - x); }
					threadsTextArea.append("\nIteration Execution Time:" + executionTime +" Milli Seconds" +"\n");
					removeThreadButton.setBackground(Color.GRAY);
					assemblyLine.notifyAll();
					assemblyLine.wait();
				}catch(InterruptedException e1){}
			}
			threadsTextArea.append("\nREMOVE THREAD FINISHED THE TASK\n\n"); 
		}
	}// End of Run Method
}