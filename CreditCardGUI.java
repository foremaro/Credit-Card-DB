import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.lang.*;
/***********************************************************************
 * GUI front end for a Credit Card database 
 * 
 * @author Ron Foreman
 * @version 3/23/2015
 **********************************************************************/
public class CreditCardGUI extends JFrame implements ActionListener{

    /** main display text area */
    private JTextArea displayArea;

    CustomerDatabase db;

    /** Labels */
    JLabel min, max, cityStOut;

    /** Buttons */
    JButton CitySt, debt, young, high, zip;

    /** Text fields */
    JTextField minTxt, maxTxt, CityStTxt;

    /** menu items */
    private JMenuBar menus;
    private JMenu fileMenu;
    private JMenu testMenu;
    private JMenuItem quitItem;
    private JMenuItem openItem; 
    private JMenuItem countItem;
    private JMenuItem summaryItem;

    /*********************************************************************
    Main Method - intantiate and display the GUI
     *********************************************************************/
    public static void main(String arg[]){

        CreditCardGUI theGUI = new CreditCardGUI();
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        theGUI.setTitle("Credit Card Database");
        theGUI.pack();
        theGUI.setVisible(true);
    }

    /*********************************************************************
    Constructor - instantiates and displays all of the GUI commponents
     *********************************************************************/
    public CreditCardGUI(){

        db = new CustomerDatabase();

        // setup GridBay Layout
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();
        loc.anchor = GridBagConstraints.LINE_START;     
        loc.insets = new Insets(2, 2, 2, 2);

        // create the Results Area for the Center area
        displayArea = new JTextArea(20,40);
        JScrollPane scrollPane = new JScrollPane(displayArea);  
        loc.gridx = 0;
        loc.gridy = 0; 
        loc.gridwidth = 6;
        loc.gridheight = 5;
        add(scrollPane, loc);
        loc.gridwidth = 1;
        loc.gridheight = 1;  

        // buttons instantiated
        CitySt = new JButton("Search City/ST");
        debt = new JButton("Search Debt");
        young = new JButton("youngest");
        high = new JButton("highest");
        zip = new JButton("Search by Zip");

        // add labels and text fields at bottom of screen 
        GridBagConstraints positionB1;
        positionB1 = new GridBagConstraints();
        positionB1.gridx = 6;
        positionB1.gridy = 0;
        add(CitySt, positionB1);

        GridBagConstraints positionB2;
        positionB2 = new GridBagConstraints();
        positionB2.gridx = 6;
        positionB2.gridy = 1;
        add(debt, positionB2);

        GridBagConstraints positionB3;
        positionB3 = new GridBagConstraints();
        positionB3.gridx = 6;
        positionB3.gridy = 2;
        add(young, positionB3);

        GridBagConstraints positionB4;
        positionB4 = new GridBagConstraints();
        positionB4.gridx = 6;
        positionB4.gridy = 3;
        add(high, positionB4);

        GridBagConstraints positionB5;
        positionB5 = new GridBagConstraints();
        positionB5.gridx = 6;
        positionB5.gridy = 4;
        add(zip, positionB5);

        // Labels instantiated
        min = new JLabel("Min $ ");
        max = new JLabel("Max $ ");
        cityStOut = new JLabel("City/ST ");

        // Text fields instantiated, actionlisteners registered
        minTxt = new JTextField (7);
        minTxt.addActionListener(this);
        maxTxt = new JTextField (7);
        maxTxt.addActionListener(this);
        CityStTxt = new JTextField (15);
        CityStTxt.addActionListener(this);

        // Labels and text fields placed on bottom of pane
        GridBagConstraints panelPosition = new GridBagConstraints();
        panelPosition.gridx = 0;
        panelPosition.gridy = 6;
        add(min, panelPosition);
        panelPosition.gridx = 1;
        panelPosition.gridy = 6;
        add(minTxt, panelPosition);
        panelPosition.gridx = 2;
        panelPosition.gridy = 6;
        add(max, panelPosition);
        panelPosition.gridx = 3;
        panelPosition.gridy = 6;
        add(maxTxt, panelPosition);
        panelPosition.gridx = 4;
        panelPosition.gridy = 6;
        add(cityStOut, panelPosition);
        panelPosition.gridx = 5;
        panelPosition.gridy = 6;
        add(CityStTxt, panelPosition);

        // register all buttons with the action listener 
        CitySt.addActionListener(this);
        debt.addActionListener(this);
        young.addActionListener(this);
        high.addActionListener(this);
        zip.addActionListener(this);

        // set up File menus
        setupMenus();
        pack();

    }

    /*********************************************************************
    List all entries given an ArrayList of customers

    @param c list of customers
     *********************************************************************/
    private void displayCustomers(ArrayList <Customer> c){

        // clear the terminal window
        displayArea.setText("");

        // display each customer on a separte line
        displayArea.append(c + "\n");
        displayArea.setText("");
    }

    /*********************************************************************
    In response to the menu selection - display card summaries
     *********************************************************************/
    private void showSummaries(){
        // display summaries for each credit card type
        String visa = "Visa";
        String discover = "Discover";
        String mastercard = "MasterCard";

        displayArea.append(db.getCardSummary(visa) + "\n");
        displayArea.append(db.getCardSummary(discover) + "\n");
        displayArea.append(db.getCardSummary(mastercard) + "\n");
    }

    /*********************************************************************
    Respond to menu selections and button clicks

    @param e the button or menu item that was selected
     *********************************************************************/
    public void actionPerformed(ActionEvent e){

        Customer c = null;
        String errorMessage = "Did you forget to open a file?";

        // FIX ME: either open a file or warn the user no file has been opened}
        if(e.getSource() == openItem) {
            openFile();

        }
        else if (db.countCustomers()==0) {
            JOptionPane.showMessageDialog(null, errorMessage);
        }

        //  quit application if Quit menu item selected
        if (e.getSource() == quitItem){
            System.exit(1);

            // display summaries for all three card types    
        }else if (e.getSource() == summaryItem){
            showSummaries();
        }
        
        // display results in response to Count menu selected   
        if (e.getSource() == countItem) {
            displayArea.setText("");
            displayArea.append("Total Customers: " + Integer.toString(db.countCustomers()));
            displayArea.append("\n");
            displayArea.append("Customers that are Debt Free: " + Integer.toString(db.countDebtFree()));
            displayArea.append("\n");
        }

        // search for youngest cardholder
        if(e.getSource()== young){
            displayArea.setText("");
            c = db.getYoungestCardholder();
            displayArea.append(c.toString());
            displayArea.append("\n");
        }

        // search for highest debt     
        if(e.getSource() == high) {
            //displayArea.setText("");
            c = db.getHighestDebt();
            displayArea.append(c.toString());
            displayArea.append("\n");
        }

        // search for city / state phrases and display results    
        if(e.getSource() == CitySt) {
            // if textfield is empty
            if(CityStTxt.getText().equals("") == true) {
                JOptionPane.showMessageDialog(null, "Please enter either a city name or state");
                //return null;
            }
            else{

                displayArea.setText("");
                String search = CityStTxt.getText();
                ArrayList <Customer> textSearch = db.getMailingList(search);
                displayCustomer(textSearch);
            }        
        }

        // search for range of debt values    
        if(e.getSource() == debt) {
            // if textfield is empty
            if(minTxt.getText().equals("") == true) {
                JOptionPane.showMessageDialog(null, "Please enter a minimum value");

            }
            // if textfield is empty
            else if(maxTxt.getText().equals("") == true) {
                JOptionPane.showMessageDialog(null, "Please enter a maximum value");
            }
            else {
                displayArea.setText("");
                double low = Double.parseDouble(minTxt.getText());                      
                double high = Double.parseDouble(maxTxt.getText());
                ArrayList <Customer> custs = db.getMailingList(low, high);
                displayCustomer(custs);
            }
        }
        // search by zip code using input window
        if(e.getSource() == zip) {
            displayArea.setText("");
            int zipSearch = Integer.parseInt(JOptionPane.showInputDialog("Please enter a zip code"));
            int result = db.countCustomers(zipSearch);
            displayArea.append("Customers in zip code " + zipSearch + ":" + " " + Integer.toString(result) + "\n");

        }
    }

    /*********************************************************************
    method displays mailing of each customer in the provided list
    @ param list
     *********************************************************************/
    private void displayCustomer (ArrayList <Customer> list) {
        displayArea.setText("");
        for(int i=0; i < list.size(); i++) {
            displayArea.append(list.get(i) + "\n");
            displayArea.append("\n");
        }

        displayArea.append(list.size() + " customers found. \n");
    }

    /*********************************************************************
    In response to the menu selection - open a data file
     *********************************************************************/
    private void openFile(){

        // create a File Chooser to open in the current directory
        JFileChooser fc = new JFileChooser();
        File currentDir = new File(System.getProperty("user.dir"));
        fc.setCurrentDirectory(currentDir);

        // display the file choose
        int returnVal = fc.showOpenDialog(this);

        // did the user select a file?
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();

            db.readCustomerData(filename);

        }
    }

    /*********************************************************************
    Set up the menu items
     *********************************************************************/
    private void setupMenus(){

        // create menu components
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        openItem = new JMenuItem("Open...");
        testMenu = new JMenu("Test");
        countItem = new JMenuItem("Counts");
        summaryItem = new JMenuItem("Summaries");

        // assign action listeners
        quitItem.addActionListener(this);
        openItem.addActionListener(this);
        countItem.addActionListener(this);
        summaryItem.addActionListener(this);

        // display menu components
        fileMenu.add(openItem);
        fileMenu.add(quitItem);
        testMenu.add(countItem);
        testMenu.add(summaryItem);    
        menus = new JMenuBar();

        menus.add(fileMenu);
        menus.add(testMenu);
        setJMenuBar(menus);
    }   
}
