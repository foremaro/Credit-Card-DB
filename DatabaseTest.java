
/****************************************************
 * Testing class for CustomerDatabase and Customer
 * 
 * @author Ron Foreman 
 * @version 3/23/2015
 ***************************************************/
public class DatabaseTest
{
    public static void main(String args []) {
        String info = "male, Joe, Smith, 4/20/1963, addr, San Francisco, CA, 49401, Discover, 12345.67";
        Customer cust1 = new Customer(info);
        info = "female, Sally, Jones, 5/23/1990, addr1, Grand Rapids, MI, 49519, MasterCard, 500.99";
        Customer cust2 = new Customer(info);
        info = "female, Sansa, Stark, 7/02/1234, 1 Winterfell Drive, The North, WS, 11111, Visa, 9876543.21";
        Customer cust3 = new Customer(info);
        info = "male, Jon, Snow, 5/20/1229, 1 Winterfell Drive, The North, WS, 11111, Discover, 32.02";
        Customer cust4 = new Customer(info);
        info = "male, Bruce, Wayne, 05/01/1939, 1007 Mountain Drive, Gotham, IL, 99999, Visa, -74561.12";
        Customer cust5 = new Customer(info);

        CustomerDatabase db = new CustomerDatabase();
        db.addCustomer(cust1);
        db.addCustomer(cust2);
        db.addCustomer(cust3);
        db.addCustomer(cust4);
        db.addCustomer(cust5);

        System.out.println("Youngest: " + db.getYoungestCardholder());
        System.out.println("");
        System.out.println("Highest debt: " + db.getHighestDebt());
        System.out.println("");
        System.out.println(db.getCardSummary("Visa"));
        System.out.println("");
        System.out.println("Total Customers: " + db.countCustomers());
        System.out.println("");
        System.out.println("Customers in zip code 11111: " + db.countCustomers(11111));
        System.out.println("");
        System.out.println("Customers in zip code 49519: " + db.countCustomers(49519));
        System.out.println("");
        System.out.println("Mailing list containing 'in': " + db.getMailingList("IN"));
        System.out.println("");
        System.out.println("Customers' balance between $15.00 and $20,000.00: " + db.getMailingList(15.00, 20000.00));
        System.out.println("");
        System.out.println("Check for customer with negative balance: " + db.getMailingList(-75000.00, 1.00));

    }

}
