package template;

import java.util.*;

/**
 * PhonebookHandler - supports 
 * Phonebook operations
 * 
 * Use a map to build the Phonebook
 * key: Contact
 * value: List<phonebookEntries>
 */

public class PhonebookHandler implements iPhonebookHander{
	
	private Map<Contact, List<PhonebookEntry>> phonebook = new HashMap();
	
	public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {
		this.phonebook = phonebook;
	}
	@Override
	public List<Contact> sortByName() {
		List<Contact> keys = new ArrayList<>(phonebook.keySet());
		int n = phonebook.size();
		boolean swapped;
		
		   for (int i = 0; i < n - 1; i++) {
	            swapped = false;
	            for (int j = 0; j < n - i - 1; j++) {
	                if (keys.get(j).compareTo(keys.get(j + 1)) > 0) {
	                    Collections.swap(keys, j, j + 1);
	                    swapped = true;
	                }
	            }
	            if (!swapped) {
	                break;
	            }
	        }
	        return keys;
	    }
	@Override
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = sortedContacts.size()-1;
		while(low <= high) {	
			int mid = (low+high)/2;
			Contact midContact = sortedContacts.get(mid);
			
			int comparison = midContact.getName().compareTo(name);
			
			if(comparison == 0) {
				return phonebook.get(midContact);
			}
			else if(comparison < 0){
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		
		}
			
		return null;
	}

	@Override
	public void display(List<Contact> sortedContacts) {
		for(Contact x: sortedContacts) {
			System.out.println(x.getName());
		}
	}

 
}
