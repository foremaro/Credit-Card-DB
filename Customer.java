
/**********************************************************
 * Class to maintain info about credit card customers
 * 
 * @author Ron Foreman 
 * @version 3/21/2015
 **********************************************************/
public class Customer
{
    /** customer gender */
    private boolean isFemale;

    /** customer name */
    private String firstName, lastName;

    /** customer birthdate */
    private int day, month, year;

    /** customer address */
    private String address;

    /** customer city and state*/
    private String city, state;

    /** customer zip */
    private int zip;

    /** credit card brand */
    private String CCbrand;

    /** current balance */
    private double balance;

    public Customer (String info) {
        // splits info into 12 sections
        String [] tokens = info.split(",|/");
        
        if (tokens[0].equals("female")){
            this.isFemale = true;
        }
        else {
            //return false;
        }        
        firstName = tokens[1].trim();
        lastName = tokens[2].trim();
        month = Integer.parseInt(tokens[3].trim());
        day = Integer.parseInt(tokens[4].trim());
        year = Integer.parseInt(tokens[5].trim());
        address = tokens[6].trim();
        city = tokens[7].trim();
        state = tokens[8].trim();
        zip = Integer.parseInt(tokens[9].trim());
        CCbrand = tokens[10].trim();
        balance = Double.parseDouble(tokens[11].trim());
        
        // instantiation
        this.isFemale = isFemale;
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.CCbrand = CCbrand;
        this.balance = balance;
    }

    /******************************************************************
    Customer's gender
    @return true if female
     ******************************************************************/
    public boolean isFemale() {
        // if female return true
        if (isFemale==true){
            return true;
        }
        else
            return false;
    }

    /******************************************************************
    returns first name
    @return firstName
     ******************************************************************/
    public String getFirst() {
        return firstName;
    }

    /******************************************************************
    returns last name
    @return lastName
     ******************************************************************/
    public String getLast() {
        return lastName;
    }

    /******************************************************************
    returns address
    @return address
     ******************************************************************/
    public String getAddress() {
        return address;
    }

    /******************************************************************
    returns city
    @return city
     *******************************************************************/
    public String getCity() {
        return city;
    }

    /******************************************************************
    returns state
    @return state
     ******************************************************************/
    public String getState() {
        return state;
    }

    /******************************************************************
    returns credit card brand
    @return CCbrand
     ******************************************************************/
    public String getCreditCard() {
        return CCbrand;
    }

    /******************************************************************
    returns birth day
    @return day
     ******************************************************************/
    public int getDay() {
        return day;
    }

    /******************************************************************
    returns birth month
    @return month
     ******************************************************************/
    public int getMonth() {
        return month;
    }

    /******************************************************************
    returns birth year
    @return year
     ******************************************************************/
    public int getYear() {
        return year;
    }

    /******************************************************************
    returns balance
    @return balance
     ******************************************************************/
    public double getBalance () {
        return balance;
    }

    /*****************************************************************
     * return zip                               
     ****************************************************************/
    public int getZip() {
        return zip;
    }

    /******************************************************************
    sets gender
    @param g
     ******************************************************************/
    public void setIsFemale(boolean g) {
        String gender = "";
        // if customer's gender is female, return true
        if(gender.equals("female")) {
            this.isFemale = g;
        }
        
    }

    /*****************************************************************
    sets first name
    @param first
     *****************************************************************/
    public void  setFirstName(String first) {
        firstName = first;
    }

    /*****************************************************************
    sets last name
    @param last
     *****************************************************************/
    public void setLastName(String last) {
        lastName = last;
    }

    /*****************************************************************
    sets address
    @param addy
     *****************************************************************/
    public void setAddress(String addy) {
        address = addy;
    }

    /*****************************************************************
    sets city
    @param City
     *****************************************************************/
    public void setCity(String City) {
        city = City;
    }

    /*****************************************************************
    sets state
    @param State
     *****************************************************************/
    public void setState (String State) {
        state = State;
    }

    /*****************************************************************
    sets credit card brand
    @param CC
     *****************************************************************/
    public void setCCbrand(String CC) {
        CCbrand = CC;
    }

    /*****************************************************************
    sets birth day
    @param Day
     *****************************************************************/
    public void setBirthDay(int Day) {
        day = Day;
    }

    /*****************************************************************
    sets birth month
    @param Month
     *****************************************************************/
    public void setBirthMonth(int Month) {
        month = Month;
    }

    /*****************************************************************
    sets birth year
    @param Year
     *****************************************************************/
    public void setBirthYear (int Year) {
        year = Year;
    }

    /*****************************************************************
    sets balance
    @param Balance
     *****************************************************************/
    public void setBalance(int Balance) {
        balance = Balance;
    }

    /*****************************************************************
     * returns a formatted mailing label
     *****************************************************************/
    public String toString() {
        String str = firstName + " " + lastName + "\n" + address + "\n"
            + city + ", " + state + " " + zip;
        return str;
    }

    /*****************************************************************
     * main method for testing 
     *****************************************************************/
    public static void main(String args[]) {
         Customer cust1 = new Customer("male, The, Rock, 4/18/1980, 54 Elm St, Any Town, PA, 99111, Discover, 5555.05");
         System.out.println(cust1);
         System.out.println("");
         System.out.println("female? " + cust1.isFemale());
         System.out.println("Get cust1's first and last name: " + cust1.getFirst() + " " + cust1.getLast());
         System.out.println("Get balance: " + cust1.getBalance());
         System.out.println("Get year/month/day: " + cust1.getYear() + "/" + cust1.getMonth() + "/" + cust1.getDay());
         System.out.println("What's his address?" + "\n" + cust1.getAddress());
         System.out.println("What type of card does he use?\n" + cust1.getCreditCard());
         System.out.println("");
         
         System.out.println("Let's add another customer: cust2");
         Customer cust2 = new Customer("female, Gwen, Paltrow, 5/1/1975, 123 Hollyweird Blvd, Hollyweird, CA, 90210, MasterCard, 10500.23");
         System.out.println("");
         System.out.println(cust2);
         System.out.println("female? " + cust2.isFemale());
         System.out.println("hoped so. City St and Zip? \n" + cust2.getCity() + "," + cust2.getState() + "," + cust2.getZip());
         System.out.println("Address and day/month of birth: \n" + cust2.getAddress() + " " + cust2.getDay() + "/" + cust2.getMonth());
         System.out.println("Card type and balance: " + cust2.getCreditCard() + " " + cust2.getBalance());
         

    }

}
