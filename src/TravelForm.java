import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import javax.swing.*;
/**
	A frame that shows the travel information.
	@author: Jingyi Guo
	@date:   01/27/13
*/

public class TravelForm extends JFrame
{
	private JLabel fromLabel;
	private JLabel toLabel;
	private JLabel returnLabel;
	private JLabel passengersLabel;
	private JLabel departureLabel;
	private JTextField fromField;
	private JTextField toField;
	private JButton button1;
	private JComboBox rRangeCombo;
	private JComboBox rYearCombo;
	private JComboBox rDateCombo;
	private JComboBox rMonthCombo;
	private JComboBox dRangeCombo;
	private JComboBox dYearCombo;
	private JComboBox dDateCombo;
	private JComboBox dMonthCombo;
	private JComboBox passengersCombo;
	private ActionListener listener;
	private ActionListener listener1;
	private String dMonth;
	private String rMonth;
	private String dDate;
	private String rDate;
	private String dYear;
	private String rYear;
	private String dRange;
	private String rRange;
	private String passengers;
	private String from;
	private String to;
	private Date Date1;
	private Date dDate2;
	private String dTestDate;
	private String rTestDate;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 250;
	String[] months = { "January", "February","March","April","May","June","July","August","September","October","November","December"};
	String[] days = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25",
	"26","27","28","29","30","31"};
	String[] ranges = {"anytime","morning","noon","evening","late night"};
	GridBagLayout gridbag = new GridBagLayout();

	/**
		Constructs the frame.
   */
	public TravelForm()
	{
		super("Travel Form");
		GridBagConstraints constraints;
		setLayout(gridbag);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button1 = new JButton("Submit");
		ActionListener listener1 = new ClickListener();
      	button1.addActionListener(listener1);
		listener = new ChoiceListener();
		buildComp();
		addComponent(fromLabel, 0, 0, 1, 1, 10, 100,GridBagConstraints.NONE, GridBagConstraints.WEST,new Insets(20,20,0,0));
		addComponent(fromField, 1, 0, 9, 1, 90, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(20,-40,0,20));
		addComponent(toLabel, 0, 1, 1, 1, 10, 100,GridBagConstraints.NONE, GridBagConstraints.WEST,new Insets(0,20,0,0));
		addComponent(toField, 1, 1, 9, 1, 90, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,-40,0,20));
		addComponent(departureLabel, 0, 2, 1, 1, 10, 100,GridBagConstraints.NONE, GridBagConstraints.WEST,new Insets(0,20,0,0));
		addComponent(dMonthCombo, 1, 2, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,0));
		addComponent(dDateCombo, 2, 2, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,0));
		addComponent(dYearCombo, 3, 2, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,0));
		addComponent(dRangeCombo, 4, 2, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,20));
		addComponent(returnLabel, 0, 3, 1, 1, 10, 100,GridBagConstraints.NONE, GridBagConstraints.WEST,new Insets(0,20,0,0));
		addComponent(rMonthCombo, 1, 3, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,0));
		addComponent(rDateCombo, 2, 3, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,0));
		addComponent(rYearCombo, 3, 3, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,0));
		addComponent(rRangeCombo, 4, 3, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,20));
		addComponent(passengersLabel, 0, 4, 1, 1, 10, 100,GridBagConstraints.NONE, GridBagConstraints.WEST,new Insets(0,20,0,0));
		addComponent(passengersCombo, 1, 4, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,0,0));
		addComponent(button1, 4, 5, 1, 1, 10, 100,GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST,new Insets(0,0,15,20));
	}
	/**
      Creates the component.
   */
	public void buildComp()
	{
		fromLabel = new JLabel("From");
		toLabel = new JLabel("To");
		fromField = new JTextField();
		fromField.setText("");
		toField = new JTextField();
		toField.setText("");

		passengersLabel = new JLabel("Passengers");
		passengersCombo = new JComboBox();
		passengersCombo.addItem("1");
		passengersCombo.addItem("2");
		passengersCombo.addItem("3");
		passengersCombo.addItem("4");
		passengersCombo.addItem("5");
		passengersCombo.addItem("6");
		passengersCombo.addItem("7");
		passengersCombo.addItem("8");
		passengersCombo.addItem("9");
		passengersCombo.addItem("10");
		passengersCombo.setBorder
		(new TitledBorder(new EtchedBorder()));
		passengersCombo.addActionListener(listener);

		departureLabel = new JLabel("Departure Date");
		returnLabel = new JLabel("Return Date");
		passengersLabel = new JLabel("Passengers");
		dMonthCombo = new JComboBox();
		for(int i = 0; i < months.length; i++)
		{
		dMonthCombo.addItem(months[i]);
		}
		dMonthCombo.addActionListener(listener);
		dMonthCombo.setBorder
		(new TitledBorder(new EtchedBorder()));

		rMonthCombo = new JComboBox();
		for(int i = 0; i < months.length; i++)
		{
			rMonthCombo.addItem(months[i]);
		}
		rMonthCombo.addActionListener(listener);
		rMonthCombo.setBorder
		(new TitledBorder(new EtchedBorder()));

		rDateCombo = new JComboBox();
		for(int i = 0; i < days.length; i++)
		{
			rDateCombo.addItem(days[i]);
		}
		rDateCombo.addActionListener(listener);
		rDateCombo.setBorder
		(new TitledBorder(new EtchedBorder()));

		dDateCombo = new JComboBox();
		for(int i = 0; i < days.length; i++)
		{
			dDateCombo.addItem(days[i]);
		}

		dDateCombo.addActionListener(listener);
		dDateCombo.setBorder
		(new TitledBorder(new EtchedBorder()));

		rYearCombo = new JComboBox();
		rYearCombo.addItem("2011");
		rYearCombo.addItem("2012");
		rYearCombo.addActionListener(listener);
		rYearCombo.setBorder
		(new TitledBorder(new EtchedBorder()));

		dYearCombo = new JComboBox();
		dYearCombo.addItem("2011");
		dYearCombo.addItem("2012");
		dYearCombo.addActionListener(listener);
		dYearCombo.setBorder
		(new TitledBorder(new EtchedBorder()));

		rRangeCombo = new JComboBox();
		for(int i = 0; i < ranges.length; i++)
		{
			rRangeCombo.addItem(ranges[i]);
		}
		rRangeCombo.addActionListener(listener);
		rRangeCombo.setBorder
		(new TitledBorder(new EtchedBorder()));

		dRangeCombo = new JComboBox();
		for(int i = 0; i < ranges.length; i++)
		{
			dRangeCombo.addItem(ranges[i]);
		}
		dRangeCombo.addActionListener(listener);
		dRangeCombo.setBorder
		(new TitledBorder(new EtchedBorder()));
	}
	/**
		Set component's constraints and add it to panel.
		@param component a component added to the panel
		@param gridx the x position of the cell that holds the component
		@param gridy the y position of the cell that holds the component
		@param gridwidth the number of cells the component occupies in a horizontal direction
		@param gridheight the number of cells the component occupies in a vertical direction
		@param weightx a value that indicates the component size relative to other components on the same row of the grid
		@param weighty a value that indicates its size relative to components on the same grid column
		@param fill a value that determines where the component is displayed within its cell
		@param anchor a value that determines whether the component expands horizontally or vertically to fill its cell
   */
	private void addComponent(Component component, int gridx, int gridy,
	int gridwidth, int gridheight, int weightx, int weighty, int fill,
	int anchor,Insets whitespace)
	{
		 GridBagConstraints constraints = new GridBagConstraints();
		 constraints.gridx = gridx;
		 constraints.gridy = gridy;
		 constraints.gridwidth = gridwidth;
		 constraints.gridheight = gridheight;
		 constraints.weightx = weightx;
		 constraints.weighty = weighty;
		 constraints.fill = fill;
		 constraints.anchor = anchor;
		 constraints.insets = whitespace;
		 gridbag.setConstraints(component, constraints);
		 add(component);
	 }
	 /**
	      Gets user's text input.
	*/
	public void readText()
	{
	   from = fromField.getText();
	   to = toField.getText();
	}
	/**
		Gets user choice for departure,return date and passengers number.
	*/
	public void setFlight()
	{
		dTestDate ="2011" + "-" + "01" + "-" + "01";
		rTestDate ="2011" + "-" + "01" + "-" + "01";
		int dmindex=0;
		int rmindex=0;
		dMonth = (String) dMonthCombo.getSelectedItem();
		for(int i=0;i<12;i++)
		{
			if (dMonth == months[i]){
				dmindex =i+1;
			}
		}
		String ds = "" + dmindex;
		//change one digit to two digits
		if(ds.length()==1)
		{
			ds="0"+ds;
		}
		rMonth = (String) rMonthCombo.getSelectedItem();
		for(int i=0;i<12;i++)
		{
			if (rMonth == months[i])
			{
				rmindex =i+1;
			}
		}
		String rs = "" + rmindex;
		if(rs.length()==1)
		{
			rs="0"+rs;
		}
		dDate = (String) dDateCombo.getSelectedItem();
		rDate = (String) rDateCombo.getSelectedItem();
		dYear = (String) dYearCombo.getSelectedItem();
		rYear = (String) rYearCombo.getSelectedItem();
		dRange = (String) dRangeCombo.getSelectedItem();
		rRange = (String) rRangeCombo.getSelectedItem();
		passengers = (String) passengersCombo.getSelectedItem();
		dTestDate =dYear + "-" + ds + "-" + dDate;
		rTestDate =rYear + "-" + rs + "-" + rDate;
	}
	/**
		Test if the return date is before the departure date.
		@param dedate a departure date
		@param redate a return date
		@return true if return date is before departure date or false if not
	*/
	public boolean isBefore (String dedate, String redate)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(dTestDate);
			Date date2 = sdf.parse(rTestDate);
			if(date2.compareTo(date1)<0){
			//System.out.println("Date1 is before Date2");
			return true;
			}
		}
		catch(ParseException ex)
		{
			ex.printStackTrace();
			return false;
			//System.out.println("error");
    	}
    	return false;
	}
	/**
		Test date is valid or not.
		@param inDate a test date
		@return true if date is valid or false if the date is not valid
	*/
	public boolean isValidDate(String inDate)
	{
		if (inDate == null)
		{
		  return false;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (inDate.trim().length() != dateFormat.toPattern().length())
		{
			//System.out.println("length");
			//System.out.println(inDate.trim().length());
			//System.out.println(inDate.trim());
			//System.out.println(dateFormat.toPattern().length());
			return false;
		}
		dateFormat.setLenient(false);
		try
		{
		  //parse the inDate parameter
		  dateFormat.parse(inDate.trim());
		}
		catch (ParseException pe)
		{
			System.out.println("paseexception");
			return false;
		}
		return true;
	}

	public class ChoiceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setFlight();
		}
	}

	public class ClickListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent e)
	   {
	      //System.out.println("clicked.");
	      //System.out.println(dTestDate);
	      //System.out.println(isValidDate(dTestDate));
			readText();
			setFlight();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
			Date dDate = dateFormat.parse(dTestDate);
			Date rDate = dateFormat.parse(rTestDate);
			}catch(ParseException ex){
				ex.printStackTrace();
				System.out.println("wrong");
			}
			if (from.length() == 0||to.length()==0 ||!isValidDate(rTestDate)||!isValidDate(dTestDate)||isBefore(dTestDate,rTestDate))
			{
				JOptionPane.showMessageDialog(null, "Error, please check!","Error",JOptionPane.ERROR_MESSAGE);
				if (from.length() == 0)
				System.out.println("from error");
				else if(to.length()==0)
				System.out.println("to error");
				else if(!isValidDate(rTestDate))
				{
				System.out.println("testdater error");
				System.out.println(rTestDate);
				}
				else if(!isValidDate(dTestDate))
				System.out.println("testdated error");
				else if(isBefore(dTestDate,rTestDate))
				System.out.println("return before departure error");
		   }
		   else
		   {
				JOptionPane.showMessageDialog(null, "Number of passengers: " +passengers + "\n"
				+"From: "+from+"\n"
				+"To: "+to+"\n"
				+"Departing: "+dMonth + " "+dDate+ " "+dYear+" "+dRange+"\n"
				+"Returning: "+rMonth+ " "+rDate+ " "+rYear+" "+rRange + "\n","Itinerary",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
