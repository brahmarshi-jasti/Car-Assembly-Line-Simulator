// Class to Fit an Engine into a Car held by a Slot 
class EngineThread extends Thread
{
	private AssemblyLine 	assemblyLine;				// 	Assembly Line instance
	private JTextArea 		threadsTextArea;			//	The JTextArea instance of the Frame to write various messages
	private JButton			engineThreadButton;			//	EngineThread Button of the Frame
	private int				no_of_CarsAdded;			//  count of the cars into which the engines has been added
	private int				no_of_Iterations;			//	count of how many times the thread has got a chance to execute
	
	// Constructor Method
	EngineThread(AssemblyLine assemblyLine, JTextArea threadsTextArea,JButton engineThreadButton)
	{
		this.assemblyLine 		= assemblyLine;
		this.threadsTextArea	= threadsTextArea;
		this.engineThreadButton	= engineThreadButton;
		no_of_Iterations		= no_of_CarsAdded	=	0;
	}
	
	// run Method
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
						threadsTextArea.append("\n\nENGINE THREAD RUNNING\n");
						threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
						engineThreadButton.setBackground(Color.GREEN);
						Thread.sleep(2000);
						engineThreadButton.setBackground(Color.GRAY);
						threadsTextArea.append("Engine Thread Going in Waiting State\n");
						long s = System.currentTimeMillis();
						long executionTime = s - x;
						threadsTextArea.append("Iteration Execution Time:" + executionTime +" Milli Seconds"+"\n");
						//assemblyLine.notifyAll();
						assemblyLine.wait();
					}
					long x = System.currentTimeMillis();
					no_of_Iterations++;
					threadsTextArea.append("\n\nENGINE THREAD RUNNING\n");
					threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
					engineThreadButton.setBackground(Color.GREEN);
					Slot[] slots = assemblyLine.getSlots();
					for (int i =0; i<slots.length; i++)
					{
						threadsTextArea.append("Engine Thread Checking For Slot No: " + (i+1) +"\n");
						Slot s = slots[i];
						if(s.isEmpty())
							threadsTextArea.append("Status: Slot Empty\n");
						else
						if ( s.getCar().isEngineFitted())
							threadsTextArea.append("Status: Engine Already Fitted \n");
						else
							{
							threadsTextArea.append("Status: ...Adding Engine into Car\n");
							Thread.sleep(1000);
							Car c = s.getCar();
							c.fitEngine();
							JButton b1 = s.getEngineButton();
							b1.setBackground(Color.GREEN); 
							no_of_CarsAdded++;
							threadsTextArea.append("Status: Engine Added To Car \n");
						}
					}
					
					threadsTextArea.append("Adder Thread Going in Waiting State\n");
					long s = System.currentTimeMillis();
					long executionTime = s - x;
					if(executionTime < 2000) { Thread.sleep(2000 - executionTime); executionTime = (System.currentTimeMillis() - x); }
					threadsTextArea.append("\nIteration Execution Time:" + executionTime +" Milli Seconds" +"\n");
					engineThreadButton.setBackground(Color.GRAY);
					assemblyLine.notifyAll();
					assemblyLine.wait();
				}catch(InterruptedException e1){}
			}
			threadsTextArea.append("\nENGINE THREAD FINISHED THE TASK\n\n"); 
		}
	}// End of Run Method
}