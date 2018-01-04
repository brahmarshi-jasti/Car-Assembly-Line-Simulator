// The LightThread Class adds Light System to a Car 
class LightThread extends Thread
{
	private AssemblyLine 	assemblyLine;		// The same explanation as given above
	private JTextArea 		threadsTextArea;	// The same explanation as given above 
	private JButton			lightThreadButton;	// The same explanation as given above 
	private int				no_of_CarsAdded;	// The same explanation as given above
	private int				no_of_Iterations;	// The same explanation as given above
	
	// Constructor Method
	LightThread(AssemblyLine assemblyLine, JTextArea threadsTextArea,JButton lightThreadButton)
	{
		this.assemblyLine 		= assemblyLine;
		this.threadsTextArea	= threadsTextArea;
		this.lightThreadButton	= lightThreadButton;
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
						threadsTextArea.append("\n\nLIGHT SYSTEM THREAD RUNNING\n");
						threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
						lightThreadButton.setBackground(Color.GREEN);
						Thread.sleep(2000);
						lightThreadButton.setBackground(Color.GRAY);
						threadsTextArea.append("Light System Thread Going in Waiting State\n");
						long s = System.currentTimeMillis();
						long executionTime = s - x;
						threadsTextArea.append("\nIteration Execution Time:" + executionTime +" Milli Seconds"+"\n");
						//assemblyLine.notifyAll();
						assemblyLine.wait();
					}
					long x = System.currentTimeMillis();
					no_of_Iterations++;
					threadsTextArea.append("\n\nLIGHT SYSTEM THREAD RUNNING\n");
					threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
					lightThreadButton.setBackground(Color.GREEN);
					Slot[] slots = assemblyLine.getSlots();
					for (int i =0; i<slots.length; i++)
					{
						threadsTextArea.append("Light System Thread Checking For Slot No: " + (i+1) +"\n");
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
						if (s.getCar().isLightSystemFitted())
							threadsTextArea.append("Status: Light System Already Fitted \n");
						else 
						{
							threadsTextArea.append("Status: ...Adding Light System into Car\n");
							Thread.sleep(1000);
							Car c = s.getCar();
							c.fitLightSystem();
							JButton b1 = s.getLightSystemButton();
							b1.setBackground(Color.GREEN); 
							no_of_CarsAdded++;
							threadsTextArea.append("Status: Light System Added To Car \n");
						}
					}
					
					threadsTextArea.append("Light System Thread Going in Waiting State\n");
					long s = System.currentTimeMillis();
					long executionTime = s - x;
					if(executionTime < 2000) { Thread.sleep(2000 - executionTime); executionTime = (System.currentTimeMillis() - x); }
					threadsTextArea.append("\nIteration Execution Time:" + executionTime +" Milli Seconds" +"\n");
					lightThreadButton.setBackground(Color.GRAY);
					assemblyLine.notifyAll();
					assemblyLine.wait();
				}catch(InterruptedException e1){}
			}
			threadsTextArea.append("\nLIGHT SYSTEM THREAD FINISHED THE TASK\n\n"); 
		}
	}// End of Run Method
}