import java.util.*;
import java.io.*;
import java.lang.Math;
import java.text.NumberFormat;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/******************************************************
 * maintains unlimited number of credit card customers
 * 
 * @author Ron Foreman
 * @version 3/21/2015
 ******************************************************/
public class CustomerDatabase
{
    /** a collection of customers */
    private ArrayList<Customer> list;

    /******************************************************
    Constructor method to instantiate array list
     ******************************************************/
    public CustomerDatabase () {
        list = new ArrayList<Customer>();       
    }

    /******************************************************
    reads customer data file
    @param filename of data file
     ******************************************************/
    public void readCustomerData(String filename) {

        // start with a fresh ArrayList
        list.clear();
        
        String info;
        try{
            // open the BufferedReader
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            String text;

            // keeps reading while there is more data
            while (sc.hasNext()) {
                text = sc.nextLine();

                // add the new customer to the ArrayList
                Customer c = new Customer(text);
                list.add(c);
            }
            sc.close();

            // Could not find file or other error
        }catch(FileNotFoundException error1) {
            System.out.println("Failed to read the data file: " + filename);
        }
    }

    /*************************************************
    adds customer to arraylist
    @param c
     **************************************************/
    public void addCustomer (Customer c) {
        list.add(c);
    }

    /*************************************************
    How many customers are there?
    @return number of students
     **************************************************/
    public int countCustomers() {
        return list.size();
    }

    /*************************************************
    returns number of customers with zip as zipcode
    @return number of customers with same zipcode
     *************************************************/
    public int countCustomers (int Zip) {
        // creates new arrayList to hold matching customers
        ArrayList<Customer> neighbors = new ArrayList<Customer>();

        for(Customer c: list) {
            // if customer's matches, added to local arraylist neighbors
            if(c.getZip() == Zip)
                neighbors.add(c);
        }
        return neighbors.size();
    }

    /**************************************************
    customers that have zero debt
    @return number of customer with no debt
     ***************************************************/
    public int countDebtFree() {
        // creates arrayList to hold zero debt customers
        ArrayList<Customer> debtFree = new ArrayList<Customer>();

        for(Customer c: list) {
            // if balance is basically zero, added to temporary arraylist debtFree
            if(c.getBalance() < 0.0001) 
                debtFree.add(c);
        }
        return debtFree.size();        
    }

    /**************************************************
     * customer with highest debt
     * @return customer with highest debt
     **************************************************/
    public Customer getHighestDebt() {
        // first customer set to highest debt in order to begin comparison to entire arraylist
        Customer high = list.get(0);
        for(Customer c: list) {
            if(c.getBalance() > high.getBalance())
                high = c;
        }
        return high;
    }

    /**************************************************
    gets youngest customer
    @return youngestCardHolder
     **************************************************/
    public Customer getYoungestCardholder() {
        Customer youngest = list.get(0);
        for(Customer c: list) {            
            // compares birth years
            if (c.getYear() > youngest.getYear()) {
                youngest = c;
            }            
            // if years are equal
            else if (c.getYear() == youngest.getYear()) {     
                // birth months compared
                if (c.getMonth() > youngest.getMonth()) {
                    youngest = c;
                }                
                // if birth months and birth years equal
                if (c.getMonth() == youngest.getMonth()) {               
                    // compare birthdays
                    if (c.getDay() >= youngest.getDay()) {
                        youngest = c;
                    }                    
                }                
            }            
        }
        
        return youngest;
    }

    /*************************************************
    returns a string that summarizes the total number
    of cards and average debt for request card type
    @return summary
    @param card type Visa, Discover, or MasterCard
     **************************************************/
    public String getCardSummary(String card) {
        // creates temp arrayList to hold cards matching param card type
        ArrayList<Customer> sameCard = new ArrayList<Customer>();

        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        // if any card other than visa, MC, Disc entered, error msg displayed
        if(!card.equals("Visa") && !card.equals("Discover") && !card.equals("MasterCard")){
            JOptionPane.showMessageDialog(null,"Card not found.");
            return "Card not found.";
        }

        for(Customer c: list) {
            // if cards match, added to temporary arraylist
            if (c.getCreditCard().equals(card))
                sameCard.add(c);
        }
        
        // card not found, list will be zero, returns msg
        if (sameCard.size() == 0){
            return "card not found.";
        }
        
        double sum = 0.00;
        double average = 0.00;
        
        // sums each customer's balance in the temp arraylist
        for(Customer c: sameCard) {
            sum+=c.getBalance();
        }

        // calculate average
        average = sum / sameCard.size();
        
        String str = card + ": " + sameCard.size() + " cards with average balance of " 
            + (fmt.format(average)) + ".\n";

        return str;
    }

    /**************************************************
    returns an ArrayList of all cardholders who have
    a balance between low and high (inclusive)
    @return list of customers with balance b/t low and high
     **************************************************/
    public ArrayList <Customer> getMailingList(double low, double high) {
        ArrayList<Customer> mailingList = new ArrayList<Customer>();

        for(Customer c: list) {
            // if balance between low and high parameters, added to temp arraylist
            if(c.getBalance() >= low && c.getBalance()<= high)
                mailingList.add(c);
        }

        return mailingList;
    }

    /**************************************************
     * returns arraylist of all cardholders that have
     * a city or state that contains 'keyword' ignoring case
     **************************************************/
    public ArrayList <Customer> getMailingList(String keyword) {

        // creates temporary arraylist to hold customers matching search parameter
        ArrayList<Customer> searchKey = new ArrayList<Customer>();

        for(Customer c: list) {
            // if a city name contains keyword
            if(c.getCity().toLowerCase().contains(keyword.toLowerCase())==true)
                searchKey.add(c);
            // if keyword is 2 chars and matches customer State
            else if (c.getState().toLowerCase().contains(keyword.toLowerCase()))
                searchKey.add(c);
        }
        return searchKey;
    }
}
