package template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestHarness {

	// Contact overrides hashcode && equals.  Observe collision here.
	private static Map<Contact, List<PhonebookEntry>> phonebook = new HashMap<>();
	private static Contact p1, p2, p3, p4, p5;
	private static PhonebookHandler phonebookHander;


	public static void main(String[] args) throws InterruptedException {
		init();
		phonebookHander = new PhonebookHandler(phonebook);
		
		List<Contact> sortedContacts = TEST_Sort(phonebookHander);
		//TODO: 2 cases:
		//display non equality using your overriden equals method
		//display equality using your overriden equals method
		
		TEST_Equals(p1, p2);
		TEST_Equals(p3, p3);
		
		//TODO: 2 cases:
		//display hashcode case that demonstrates collision
		//display hashcode case that demonstrates non- collision
		
		TEST_hashcode(p4, p1);
		TEST_hashcode(p1, p3);
		
		//Create the phonebook handler
		phonebookHander = new PhonebookHandler(phonebook);
		
		//TODO
		//call 
		//List<Contact> sortedContacts = TEST_Sort(phonebookHander);
		System.out.println("Displaying Sorted Contacts");

		TEST_Display(sortedContacts);
		
		//TODO
		// 2 cases:
		// 1) a call to search finds the user and displays their entries 
		//(2) a call to search does not find the user & displays some detail illustrating same
		TEST_Search(phonebookHander, sortedContacts, "Juan");
		 

	}

	// 
	public static List<Contact> TEST_Sort(PhonebookHandler phonebookHandler) {
		//TODO: call your phonebookHander & have it sort the contacts.  Return those.
		
		List<Contact> sortedContacts = phonebookHander.sortByName();
		return sortedContacts;
	}

	
	public static void TEST_Search(PhonebookHandler phonebookHandler, List<Contact> sortedContacts, String name) {
		//TODO: use the sorted contacts and a name to search for.  
	  
		
		System.out.println("\n -- Search results for " + name + " -- ");
		List<PhonebookEntry> selectedEntries = phonebookHander.binarySearch(sortedContacts, name);
		for (PhonebookEntry entry : selectedEntries) {
			
			System.out.println("Entries for " + name + " " +  entry.getType() + " " + entry.getPhoneNumber());
		}
	}
	
	public static void TEST_Display(List<Contact> sortedContacts) {
		phonebookHander.display(sortedContacts);
	}

	public static void TEST_Equals(Contact r1, Contact r2) {

		System.out.println("Checking r1.equals(r2) for: \n" + r1.toString() + "\n" + r2.toString());
		System.out.println(r1.equals(r2));

		System.out.println();
	}

	public static void TEST_hashcode(Contact r1, Contact r2) {

		System.out.println("Checking r1.hashcode = r2.hashcode for: \n" + r1.toString() + "\n" + r2.toString());
		if (r1.hashCode() == r2.hashCode()) {
			System.out.println("Hash matches - we're in the same bucket ( collision!): " + r1.hashCode());

		} else {
			System.out.println("NO hash match: " + r1.hashCode() + " / " + r2.hashCode());

		}
		System.out.println();
	}
 

	/** TODO
	 * 
	 * Build 5 contacts
	 * Add 1-3 phonebook entries per contact.   Some must have > 1.
	 * 'Put' into the phonebook map key-value pairs of the form contact, List<PhonebookEntries>
	 * 
	 * Feel free to update 
	 * 
	 * @throws InterruptedException
	 */
	public static void init() throws InterruptedException {

		System.out.println("Building Contacts ....");
		TimeUnit.SECONDS.sleep(1);

		p1 = new Contact("Jan");
		p2 = new Contact("Stan");
		p3 = new Contact("Juan");
		p4 = new Contact("Mun");
		p5 = new Contact("Ran");

		System.out.println("Building Phonebook Entries ....");
		TimeUnit.SECONDS.sleep(1);

		p1.addPhoneBookEntry("2034032233", "Home");
		p1.addPhoneBookEntry("5532233322", "Cell");
		p1.addPhoneBookEntry("1120092829", "Work");

		p2.addPhoneBookEntry("1034032233", "Home");
		p2.addPhoneBookEntry("2532233322", "Cell");
		p2.addPhoneBookEntry("3120092829", "Work");

		p3.addPhoneBookEntry("4034032233", "Home");
		p3.addPhoneBookEntry("5532233322", "Cell");
		p3.addPhoneBookEntry("6120092829", "Work");

		p4.addPhoneBookEntry("6034032233", "Home");
		p4.addPhoneBookEntry("3532233322", "Cell");
		p4.addPhoneBookEntry("1120092829", "Work");

		p5.addPhoneBookEntry("0034032233", "Home");
		p5.addPhoneBookEntry("0532233322", "Cell");
		p5.addPhoneBookEntry("0120092829", "Work");

		System.out.println("Adding Entries to the phonebook ....\n");
		TimeUnit.SECONDS.sleep(1);

		phonebook.put(p1, p1.getPhonebookEntry()); // put ultimately calls overriden hashCode
		phonebook.put(p2, p2.getPhonebookEntry());
		phonebook.put(p3, p3.getPhonebookEntry());
		phonebook.put(p4, p4.getPhonebookEntry());
		phonebook.put(p5, p5.getPhonebookEntry());

	}

}

