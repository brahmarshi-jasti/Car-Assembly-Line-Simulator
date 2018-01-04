// Driver Class
class Simulator
{
	
	// Shared Variables Among the Threads
	private static AssemblyLine	assemblyLine 		= 	new AssemblyLine();					//  An Assembly Line Instance
	private static JTextArea threadsTextArea		=	new JTextArea(10,100);				//	Area to show the Traces of Thread Execution 
	private static JScrollPane adderscroller		=	new JScrollPane(threadsTextArea);	//	Slider for ThreadsTextArea
	
	// Main Frame Window Instance
	private static JFrame assemblyFrame 			= 	new JFrame("Car Assembly Line");
	
	// Assembly Controller Variables
	private static JLabel carAssemblyController 	= 	new JLabel("Car Assembly Controller");
	private static JButton initialize 				= 	new JButton("Initilize");				// Initialize Button 
	private static JButton start 					= 	new JButton("Start");					// Start Button
	
	
	// Slot Panel Variables
	private static JLabel carAssemblyLineLabel		=	new JLabel("Car Assembly Line");

	// Slot 1 Variables
	private static JLabel  slot1	=	new JLabel("Slot I");
	private static JButton slot1E	=	new JButton("E");
	private static JButton slot1T	=	new JButton("T");
	private static JButton slot1L	=	new JButton("L");
 
	// Slot 2 Variables
	private static JLabel slot2		=	new JLabel("Slot II");
	private static JButton slot2E	=	new JButton("E");
	private static JButton slot2T	=	new JButton("T");
	private static JButton slot2L	=	new JButton("L");

	// Slot 3 Variables
	private static JLabel slot3		=	new JLabel("Slot III");
	private static JButton slot3E	=	new JButton("E");
	private static JButton slot3T	=	new JButton("T");
	private static JButton slot3L	=	new JButton("L");

	// Slot 4 Variables
	private static JLabel slot4		=	new JLabel("Slot IV");
	private static JButton slot4E	=	new JButton("E");
	private static JButton slot4T	=	new JButton("T");
	private static JButton slot4L	=	new JButton("L");

	// Slot 5 Variables
	private static JLabel slot5		=	new JLabel("Slot V");
	private static JButton slot5E	=	new JButton("E");
	private static JButton slot5T	=	new JButton("T");
	private static JButton slot5L	=	new JButton("L");

	// Slot 6 Variables
	private static JLabel slot6		=	new JLabel("Slot VI");
	private static JButton slot6E	=	new JButton("E");
	private static JButton slot6T	=	new JButton("T");
	private static JButton slot6L	=	new JButton("L");

	// Slot 7 Variables
	private static JLabel slot7		=	new JLabel("Slot VII");
	private static JButton slot7E	=	new JButton("E");
	private static JButton slot7T	=	new JButton("T");
	private static JButton slot7L	=	new JButton("L");

	// Slot 8 Variables
	private static JLabel slot8		=	new JLabel("Slot VIII");
	private static JButton slot8E	=	new JButton("E");
	private static JButton slot8T	=	new JButton("T");
	private static JButton slot8L	=	new JButton("L");
	
	// Slot 9 Variables
	private static JLabel slot9		=	new JLabel("Slot IX");
	private static JButton slot9E	=	new JButton("E");
	private static JButton slot9T	=	new JButton("T");
	private static JButton slot9L	=	new JButton("L");

	// Slot 10 Variables
	private static JLabel slot10	=	new JLabel("Slot X");
	private static JButton slot10E	=	new JButton("E");
	private static JButton slot10T	=	new JButton("T");
	private static JButton slot10L	=	new JButton("L");

	// Various Thread Buttons of Frame
	private static JButton adderThreadButton  		=	new JButton("Adder  Thread");
	private static JButton engineThreadButton 		=	new JButton("Engine Thread");
	private static JButton tyreThreadButton   		=	new JButton("Tyre   Thread");
	private static JButton lightThreadButton  		=	new JButton("Light  Thread");
	private static JButton removeThreadButton 		=	new JButton("Remove Thread");
	

	
	// Method to Display the Main Frame Window
	public static void displayFrame()
	{
		/* Starting the Creation of the Main Control Panel */

		// Panel For Displaying "Car Assembly Controller" JLabel
		JPanel controlPanel1 = new JPanel();
		controlPanel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		controlPanel1.add(carAssemblyController,BorderLayout.CENTER);
		
		// Panel for Holding "Initialize" and "Start" Buttons
		JPanel controlPanel2 = new JPanel();
		controlPanel2.add(initialize);
		controlPanel2.add(start);

		// Panel for Holding controlPanel1 and controlPanel2
		
		JPanel mainControlPanel = new JPanel();
		mainControlPanel.setLayout(new BoxLayout(mainControlPanel,BoxLayout.Y_AXIS));
		mainControlPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainControlPanel.add(controlPanel1);
		mainControlPanel.add(controlPanel2);
		
		/* Ending the Creation of Main Control Panel */

		/* Starting the Creation of the Car Assembly Line Panel */
		
		// Panel For Holding "Car Assembly Line" Label
		JPanel carAssemblyLinePanel	=	new JPanel();
		carAssemblyLinePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		carAssemblyLinePanel.add(carAssemblyLineLabel,BorderLayout.CENTER);
		
		// Panels For Holding Slot 1 to Slot 10
		JPanel slotPanel1	=	new JPanel();
		slotPanel1.setLayout(new BoxLayout(slotPanel1,BoxLayout.Y_AXIS));
		JPanel slot1ETLPanel = new JPanel();
		slot1ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot1ETLPanel.add(slot1E);
		slot1ETLPanel.add(slot1T);
		slot1ETLPanel.add(slot1L);
		slotPanel1.add(slot1);
		slotPanel1.add(slot1ETLPanel);

		JPanel slotPanel2	=	new JPanel();
		slotPanel2.setLayout(new BoxLayout(slotPanel2,BoxLayout.Y_AXIS));
		JPanel slot2ETLPanel = new JPanel();
		slot2ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot2ETLPanel.add(slot2E);
		slot2ETLPanel.add(slot2T);
		slot2ETLPanel.add(slot2L);
		slotPanel2.add(slot2);
		slotPanel2.add(slot2ETLPanel);
		
		JPanel slotPanel3	=	new JPanel();
		slotPanel3.setLayout(new BoxLayout(slotPanel3,BoxLayout.Y_AXIS));
		JPanel slot3ETLPanel = new JPanel();
		slot3ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot3ETLPanel.add(slot3E);
		slot3ETLPanel.add(slot3T);
		slot3ETLPanel.add(slot3L);
		slotPanel3.add(slot3);
		slotPanel3.add(slot3ETLPanel);

		JPanel slotPanel4	=	new JPanel();
		slotPanel4.setLayout(new BoxLayout(slotPanel4,BoxLayout.Y_AXIS));
		JPanel slot4ETLPanel = new JPanel();
		slot4ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot4ETLPanel.add(slot4E);
		slot4ETLPanel.add(slot4T);
		slot4ETLPanel.add(slot4L);
		slotPanel4.add(slot4);
		slotPanel4.add(slot4ETLPanel);

		JPanel slotPanel5	=	new JPanel();
		slotPanel5.setLayout(new BoxLayout(slotPanel5,BoxLayout.Y_AXIS));
		JPanel slot5ETLPanel = new JPanel();
		slot5ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot5ETLPanel.add(slot5E);
		slot5ETLPanel.add(slot5T);
		slot5ETLPanel.add(slot5L);
		slotPanel5.add(slot5);
		slotPanel5.add(slot5ETLPanel);

		JPanel slotPanel6	=	new JPanel();
		slotPanel6.setLayout(new BoxLayout(slotPanel6,BoxLayout.Y_AXIS));
		JPanel slot6ETLPanel = new JPanel();
		slot6ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot6ETLPanel.add(slot6E);
		slot6ETLPanel.add(slot6T);
		slot6ETLPanel.add(slot6L);
		slotPanel6.add(slot6);
		slotPanel6.add(slot6ETLPanel);

		JPanel slotPanel7	=	new JPanel();
		slotPanel7.setLayout(new BoxLayout(slotPanel7,BoxLayout.Y_AXIS));
		JPanel slot7ETLPanel = new JPanel();
		slot7ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot7ETLPanel.add(slot7E);
		slot7ETLPanel.add(slot7T);
		slot7ETLPanel.add(slot7L);
		slotPanel7.add(slot7);
		slotPanel7.add(slot7ETLPanel);

		JPanel slotPanel8	=	new JPanel();
		slotPanel8.setLayout(new BoxLayout(slotPanel8,BoxLayout.Y_AXIS));
		JPanel slot8ETLPanel = new JPanel();
		slot8ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot8ETLPanel.add(slot8E);
		slot8ETLPanel.add(slot8T);
		slot8ETLPanel.add(slot8L);
		slotPanel8.add(slot8);
		slotPanel8.add(slot8ETLPanel);

		JPanel slotPanel9	=	new JPanel();
		slotPanel9.setLayout(new BoxLayout(slotPanel9,BoxLayout.Y_AXIS));
		JPanel slot9ETLPanel = new JPanel();
		slot9ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot9ETLPanel.add(slot9E);
		slot9ETLPanel.add(slot9T);
		slot9ETLPanel.add(slot9L);
		slotPanel9.add(slot9);
		slotPanel9.add(slot9ETLPanel);

		JPanel slotPanel10	=	new JPanel();
		slotPanel10.setLayout(new BoxLayout(slotPanel10,BoxLayout.Y_AXIS));
		JPanel slot10ETLPanel = new JPanel();
		slot10ETLPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot10ETLPanel.add(slot10E);
		slot10ETLPanel.add(slot10T);
		slot10ETLPanel.add(slot10L);
		slotPanel10.add(slot10);
		slotPanel10.add(slot10ETLPanel);

		// Panel For Holding Five Slot Panels
		JPanel slotPanel1_10	=	new JPanel();
		//slotPanel1_10.setLayout(new BoxLayout(slotPanel1_10,BoxLayout.X_AXIS));
		slotPanel1_10.setLayout(new GridLayout(2,5));
		slotPanel1_10.add(slotPanel1);
		slotPanel1_10.add(slotPanel2);
		slotPanel1_10.add(slotPanel3);
		slotPanel1_10.add(slotPanel4);
		slotPanel1_10.add(slotPanel5);
		slotPanel1_10.add(slotPanel6);
		slotPanel1_10.add(slotPanel7);
		slotPanel1_10.add(slotPanel8);
		slotPanel1_10.add(slotPanel9);
		slotPanel1_10.add(slotPanel10);
		
		// Panel For Holding Whole Slot Panel
		JPanel mainSlotPanel = new JPanel();
		//mainSlotPanel.setLayout(new BoxLayout(mainSlotPanel,BoxLayout.Y_AXIS));
		mainSlotPanel.setLayout(new GridLayout(2,1));
		mainSlotPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainSlotPanel.add(carAssemblyLinePanel);
		mainSlotPanel.add(slotPanel1_10);

		/* Ending the Creation of Slot Panel */

		/* Starting The Creation of Thread Panel */

		JPanel threadPanel = new JPanel();
		//threadPanel.setLayout(new BoxLayout(threadPanel,BoxLayout.X_AXIS));
		threadPanel.setLayout(new GridLayout(1,10));
		//threadPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//threadPanel.add(new JLabel(""));
		threadPanel.add(adderThreadButton);
		threadPanel.add(new JLabel(""));
		threadPanel.add(engineThreadButton);
		threadPanel.add(new JLabel(""));
		threadPanel.add(tyreThreadButton);
		threadPanel.add(new JLabel(""));
		threadPanel.add(lightThreadButton);
		threadPanel.add(new JLabel(""));
		threadPanel.add(removeThreadButton);
				
		JPanel textAreaPanel = new JPanel();
		textAreaPanel.add(adderscroller);
		adderscroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		adderscroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JPanel mainThreadPanel = new JPanel();
		mainThreadPanel.setLayout(new GridLayout(2,1));
		
		mainThreadPanel.add(threadPanel);
		mainThreadPanel.add(textAreaPanel);
		
		start.setEnabled(false);
		slot1E.setEnabled(false);slot1T.setEnabled(false);slot1L.setEnabled(false);
		slot2E.setEnabled(false);slot2T.setEnabled(false);slot2L.setEnabled(false);
		slot3E.setEnabled(false);slot3T.setEnabled(false);slot3L.setEnabled(false);
		slot4E.setEnabled(false);slot4T.setEnabled(false);slot4L.setEnabled(false);
		slot5E.setEnabled(false);slot5T.setEnabled(false);slot5L.setEnabled(false);
		slot6E.setEnabled(false);slot6T.setEnabled(false);slot6L.setEnabled(false);
		slot7E.setEnabled(false);slot7T.setEnabled(false);slot7L.setEnabled(false);
		slot8E.setEnabled(false);slot8T.setEnabled(false);slot8L.setEnabled(false);
		slot9E.setEnabled(false);slot9T.setEnabled(false);slot9L.setEnabled(false);
		slot10E.setEnabled(false);slot10T.setEnabled(false);slot10L.setEnabled(false);
		
		adderThreadButton.setEnabled(false);
		engineThreadButton.setEnabled(false);
		tyreThreadButton.setEnabled(false);
		lightThreadButton.setEnabled(false);
		removeThreadButton.setEnabled(false); 
		
		threadsTextArea.setEditable(false);

		assemblyFrame.add(mainControlPanel,BorderLayout.NORTH);
		assemblyFrame.add(mainSlotPanel,BorderLayout.CENTER);
		assemblyFrame.add(mainThreadPanel,BorderLayout.SOUTH);
		assemblyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		assemblyFrame.setVisible(true);
		assemblyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// End of display Method
	
	// Method to Populate Components of Various Slots
	public static void populateSlots()
	{
		Slot[] slots = assemblyLine.getSlots();
		slots[0] = new Slot(slot1,slot1E,slot1T,slot1L);
		slots[1] = new Slot(slot2,slot2E,slot2T,slot2L);
		slots[2] = new Slot(slot3,slot3E,slot3T,slot3L);
		slots[3] = new Slot(slot4,slot4E,slot4T,slot4L);
		slots[4] = new Slot(slot5,slot5E,slot5T,slot5L);
		slots[5] = new Slot(slot6,slot6E,slot6T,slot6L);
		slots[6] = new Slot(slot7,slot7E,slot7T,slot7L);
		slots[7] = new Slot(slot8,slot8E,slot8T,slot8L);
		slots[8] = new Slot(slot9,slot9E,slot9T,slot9L);
		slots[9] = new Slot(slot10,slot10E,slot10T,slot10L);
	}// End of populateSlots Method
	
	// Driver Method 
	public static void main(String args[])
	{
		displayFrame();
		populateSlots();
		
		final	AdderThread 	adderThread 	=	new AdderThread(assemblyLine, threadsTextArea,adderThreadButton);
		final	EngineThread 	engineThread 	=	new EngineThread(assemblyLine, threadsTextArea,engineThreadButton);
		final	TyreThread 		tyreThread 		=	new TyreThread(assemblyLine, threadsTextArea,tyreThreadButton);
		final	LightThread 	lightThread 	=	new LightThread(assemblyLine, threadsTextArea,lightThreadButton);
		final	RemoveThread 	removeThread 	=	new RemoveThread(assemblyLine, threadsTextArea,removeThreadButton);
		
		initialize.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
			start.setEnabled(true);
			slot1E.setEnabled(true); slot1T.setEnabled(true);slot1L.setEnabled(true);
			slot2E.setEnabled(true);slot2T.setEnabled(true);slot2L.setEnabled(true);
			slot3E.setEnabled(true);slot3T.setEnabled(true);slot3L.setEnabled(true);
			slot4E.setEnabled(true);slot4T.setEnabled(true);slot4L.setEnabled(true);
			slot5E.setEnabled(true);slot5T.setEnabled(true);slot5L.setEnabled(true);
			slot6E.setEnabled(true);slot6T.setEnabled(true);slot6L.setEnabled(true);
			slot7E.setEnabled(true);slot7T.setEnabled(true);slot7L.setEnabled(true);
			slot8E.setEnabled(true);slot8T.setEnabled(true);slot8L.setEnabled(true);
			slot9E.setEnabled(true);slot9T.setEnabled(true);slot9L.setEnabled(true);
			slot10E.setEnabled(true);slot10T.setEnabled(true);slot10L.setEnabled(true);
			adderThreadButton.setEnabled(true);
			engineThreadButton.setEnabled(true);
			tyreThreadButton.setEnabled(true);
			lightThreadButton.setEnabled(true);
			removeThreadButton.setEnabled(true); 
			threadsTextArea.setEditable(true);
			initialize.setEnabled(false);
			
			slot1E.setBackground(Color.GRAY);slot1T.setBackground(Color.GRAY);slot1L.setBackground(Color.GRAY);
			slot2E.setBackground(Color.GRAY);slot2T.setBackground(Color.GRAY);slot2L.setBackground(Color.GRAY);
			slot3E.setBackground(Color.GRAY);slot3T.setBackground(Color.GRAY);slot3L.setBackground(Color.GRAY);
			slot4E.setBackground(Color.GRAY);slot4T.setBackground(Color.GRAY);slot4L.setBackground(Color.GRAY);
			slot5E.setBackground(Color.GRAY);slot5T.setBackground(Color.GRAY);slot5L.setBackground(Color.GRAY);
			slot6E.setBackground(Color.GRAY);slot6T.setBackground(Color.GRAY);slot6L.setBackground(Color.GRAY);
			slot7E.setBackground(Color.GRAY);slot7T.setBackground(Color.GRAY);slot7L.setBackground(Color.GRAY);
			slot8E.setBackground(Color.GRAY);slot8T.setBackground(Color.GRAY);slot8L.setBackground(Color.GRAY);
			slot9E.setBackground(Color.GRAY);slot9T.setBackground(Color.GRAY);slot9L.setBackground(Color.GRAY);
			slot10E.setBackground(Color.GRAY);slot10T.setBackground(Color.GRAY);slot10L.setBackground(Color.GRAY);
			
			adderThreadButton.setBackground(Color.GRAY);			engineThreadButton.setBackground(Color.GRAY);
			tyreThreadButton.setBackground(Color.GRAY);			    lightThreadButton.setBackground(Color.GRAY);
			removeThreadButton.setBackground(Color.GRAY);
			
			threadsTextArea.append("Assembly Line Initialized\n");
			assemblyLine.initialize();
			adderThread.start();
			engineThread.start();
			tyreThread.start();
			lightThread.start();
			removeThread.start();
			}
		});
		
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				assemblyLine.start();
				synchronized(assemblyLine)  {assemblyLine.notifyAll();}
				start.setEnabled(false);
			}
		});
	}// End of main Method
}// End of Driver class