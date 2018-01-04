
class TyreThread extends Thread
{
	private AssemblyLine 	assemblyLine;			// The same explanation as given above
	private JTextArea 		threadsTextArea;		// The same explanation as given above
	private JButton			tyreThreadButton;		// The same explanation as given above
	private int				no_of_CarsAdded;		// The same explanation as given above
	private int				no_of_Iterations;		// The same explanation as given above
	
	TyreThread(AssemblyLine assemblyLine, JTextArea threadsTextArea,JButton tyreThreadButton)
	{
		this.assemblyLine 		= assemblyLine;
		this.threadsTextArea	= threadsTextArea;
		this.tyreThreadButton	= tyreThreadButton;
		no_of_Iterations		= no_of_CarsAdded	=	0;
	}
	
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
						threadsTextArea.append("\n\nTYRE THREAD RUNNING\n");
						threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
						tyreThreadButton.setBackground(Color.GREEN);
						Thread.sleep(2000);
						tyreThreadButton.setBackground(Color.GRAY);
						threadsTextArea.append("Tyre Thread Going in Waiting State\n");
						long s = System.currentTimeMillis();
						long executionTime = s - x;
						threadsTextArea.append("\nIteration Execution Time:" + executionTime +" Milli Seconds"+"\n");
						//assemblyLine.notifyAll();
						assemblyLine.wait();
					}
					long x = System.currentTimeMillis();
					no_of_Iterations++;
					threadsTextArea.append("\n\nTYRE THREAD RUNNING\n");
					threadsTextArea.append("Iteration Number:"+no_of_Iterations+"\n");
					tyreThreadButton.setBackground(Color.GREEN);
					Slot[] slots = assemblyLine.getSlots();
					for (int i =0; i<slots.length; i++)
					{
						threadsTextArea.append("Tyre Thread Checking For Slot No: " + (i+1) +"\n");
						Slot s = slots[i];
						if(s.isEmpty())
							threadsTextArea.append("Status: Slot Empty\n");
						else
						if (!s.getCar().isEngineFitted())
							threadsTextArea.append("Status: Engine Not Fitted \n");
						else
						if (s.getCar().isTyreFitted())
							threadsTextArea.append("Status: Tyres Already Fitted \n");
						else
							{
							threadsTextArea.append("Status: ...Adding Tyres into Car\n");
							Thread.sleep(1000);
							Car c = s.getCar();
							c.fitTyres();
							JButton b1 = s.getTyreButton();
							b1.setBackground(Color.GREEN); 
							no_of_CarsAdded++;
							threadsTextArea.append("Status: Tyres Added To Car \n");
						}
					}
					
					threadsTextArea.append("Tyre Thread Going in Waiting State\n");
					long s = System.currentTimeMillis();
					long executionTime = s - x;
					if(executionTime < 2000) { Thread.sleep(2000 - executionTime); executionTime = (System.currentTimeMillis() - x); }
					threadsTextArea.append("\nIteration Execution Time:" + executionTime +" Milli Seconds" +"\n");
					tyreThreadButton.setBackground(Color.GRAY);
					assemblyLine.notifyAll();
					assemblyLine.wait();
				}catch(InterruptedException e1){}
			}
			threadsTextArea.append("\nTYRE THREAD FINISHED THE TASK\n\n"); 
		}
	}// End of Run Method
}// 