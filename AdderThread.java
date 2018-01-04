// Class to Add a Car to various Slots of an Assembly Line
class AdderThread extends Thread
{
	private AssemblyLine 	assemblyLine;		// 	Assembly Line instance
	private JTextArea 		threadsTextArea;	//	The JTextArea instance of the Frame to write various messages
	private JButton			adderThreadButton;	//	AdderThread Button of the Frame
	private int				no_of_CarsAdded;	//	count of how many cars has been added
	private int				no_of_Iterations;	// 	count of how many times the thread has got a chance to execute
	
	// Constructor Method
	AdderThread(AssemblyLine assemblyLine, JTextArea threadsTextArea,JButton adderThreadButton)
	{
		this.assemblyLine 		= assemblyLine;
		this.threadsTextArea	= threadsTextArea;
		this.adderThreadButton	= adderThreadButton;
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
						threadsTextArea.append("\n\nADDER THREAD RUNNING\n");
						threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
						adderThreadButton.setBackground(Color.GREEN);
						Thread.sleep(2000);
						adderThreadButton.setBackground(Color.GRAY);
						threadsTextArea.append("Adder Thread Going in Waiting State\n");
						long s = System.currentTimeMillis();
						long executionTime = s - x;
						threadsTextArea.append("Iteration Execution Time:" + executionTime +" Milli Seconds"+"\n");
						assemblyLine.wait();
					}
					
					long x = System.currentTimeMillis();
					no_of_Iterations++;
					threadsTextArea.append("\n\nADDER THREAD RUNNING\n");
					threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
					adderThreadButton.setBackground(Color.GREEN);
					Slot[] slots = assemblyLine.getSlots();
					for (int i =0; i<slots.length; i++)
					{
						threadsTextArea.append("Adder Thread Checking For Slot No: " + (i+1) +"\n");
						Slot s = slots[i];
						if(!s.isEmpty())
							threadsTextArea.append("Status: Slot Already Full\n");
						else
						{
							threadsTextArea.append("Status: Slot Empty .. Adding Car\n");
							Thread.sleep(1000);
							s.addCarToSlot(new Car());
							JButton b1 = s.getEngineButton();
							JButton b2 = s.getTyreButton();
							JButton b3 = s.getLightSystemButton();
							b1.setBackground(Color.RED); b2.setBackground(Color.RED); b3.setBackground(Color.RED);
							no_of_CarsAdded++;
							threadsTextArea.append("Status: Car Added\n");
						}
					}
					
					threadsTextArea.append("Adder Thread Going in Waiting State\n");
					long s = System.currentTimeMillis();
					long executionTime = s - x;
					if(executionTime < 2000) { Thread.sleep(2000 - executionTime); executionTime = (System.currentTimeMillis() - x); }
					threadsTextArea.append("\nIteration Execution Time:" + executionTime +" Milli Seconds" +"\n");
					adderThreadButton.setBackground(Color.GRAY);
					assemblyLine.notifyAll();
					assemblyLine.wait();
				}catch(InterruptedException e1){}
			}
			threadsTextArea.append("\nADDER THREAD FINISHED THE TASK\n\n"); 
		}
	}// End of Run Method
}// End of AdderThread Class