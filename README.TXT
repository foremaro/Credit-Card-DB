------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Credit Card DB
PURPOSE OF PROJECT: Import customer info from txt file and implement searching via GUI
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS: Ron Foreman
USER INSTRUCTIONS:
CIS
162
Project
4
Credit
Card
Database
Page
1
of
9
CIS 162 Project 4
A Credit Card Customer Database
Due Date
• at the start of lab on Tuesday, March 31st
Before Starting the Project
• Read sections 8.5 and 8.8 about ArrayLists
• Read this entire project description before starting
• Watch the video posted on BlackBoard
Learning Objectives
After completing this project you should be able to:
• use ArrayLists to maintain and process collections of objects
• use for-each loops
• split a String into an Array of tokens
• read data from external text files
• use static methods available in the Java library
Step 1: Create a New BlueJ Project
Step 2: Download Data File
• Download the “CustomerNames.txt” file and save it in the folder that BlueJ created for
this new project. There are 10,000 entries! You will not see it from within BlueJ but you
can see it from within the Windows Explorer.
Step 3: Create a class called Customer (5 pts)
Implement a class to maintain information about a credit card customer including: gender
(boolean), first name, last name, birth date (day, month, year), address, city, ST, zip code,
credit card brand and current balance (double).
• Provide appropriate names and data types for each of the instance variables.
• public Customer (String info) - a constructor that initializes all of the
instance variables to appropriate values given a single String. See information below
about parsing Strings into smaller pieces.
female, Amy, Zu, 4/9/1960, 54 Elm St, Any City, NC, 27834, Visa, 15339.19
• public boolean isFemale() – return true if female and false if male.
• public String getFirst()
• public String getLast()
• public String getAddress()
• public String getCity()
CIS
162
Project
4
Credit
Card
Database
Page
2
of
9
• public String getState()
• public String getCreditCard()
• public int getBirthDay()
• public int getBirthMonth()
• public int getBirthYear()
• public double getBalance()
• provide matching set methods for each instance variable. Although the set methods are
not used for this project it is good practice to provide them for most classes.
• public String toString( ) - return a formatted mailing label (a single String
with embedded newlines) . For example,
John Smith
123 Elm St.
Anytown, ST 12345
• public static void main(String args[]) – thoroughly test each of the
methods in this class.
Parsing Strings
Customer data is contained in a long string with values separated by commas. You must write
code that splits the long string into individual pieces and converts them to integers and doubles
as necessary. Blank spaces at the start and end of String must be removed with the trim()
method.
Limited sample of data
Amy, Zu, 4/9/1960, 15339.19
Here is sample code you will need to adapt. It is only processing six pieces of data.
public Customer(String info){
// Split the info string into multiple pieces separated by ‘,’ or ‘/’
String [] tokens = info.split(",|/");
first = tokens[0].trim();
last = tokens[1].trim();
month = Integer.parseInt(tokens[2].trim());
day = Integer.parseInt(tokens[3].trim());
year = Integer.parseInt(tokens[4].trim());
balance = Double.parseDouble(tokens[5].trim());
}
CIS
162
Project
4
Credit
Card
Database
Page
3
of
9
Step 4: Create a class called CustomerDatabase (65 pts)
Create a class that maintains an unlimited number of credit card customers. Unless otherwise
specified use the elegant for-each loop to search the ArrayList.
Class Fields
• Define an instance variable that holds an ArrayList of Customer. You should only
need ONE instance variable.
Constructor
This special method has the same name as the Class and generally initializes the fields.
• public CustomerDatabase ( ) - a constructor that instantiates an empty
ArrayList in one line of code. No customers are inserted yet.
Mutator Methods
A mutator method may modify class fields.
• public void readCustomerData(String filename) - open the provided
filename and read all the data. There are 10,000 entries in “FakeCustomers.txt”. Refer
to the information about reading text files later in this document.
• public void addCustomer (Customer c) – add the customer to the
ArrayList. This method contains one line of code.
Accessor Methods 