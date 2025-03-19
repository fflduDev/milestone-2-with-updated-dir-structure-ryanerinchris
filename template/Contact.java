package template;

/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */
import java.util.ArrayList;
import java.util.List;

/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

class Contact {
	String name;
	List<PhonebookEntry> numbers = new ArrayList<PhonebookEntry>();
	public Contact(String name) {
		this.name = name;
		
	}
	public void addPhoneBookEntry(String name, String number) {
		PhonebookEntry a = new PhonebookEntry(name, number);
		numbers.add(a);
		
		
	}
	public List<PhonebookEntry> getPhonebookEntry() {
		return numbers;
	}
	public String getName() {
		return name;
	}
	public int compareTo(Contact x) {
		return name.compareTo(x.getName());
	}
	public String toString() {
		String s="";
		s+=("Name: "+name+", Phone Numbers: [");
		for(int i=0;i<=numbers.size()-1;i++) {
			s+=numbers.get(i).toString();
			if(i<numbers.size()-1) {
				s+=(", ");
			}
		}
		s+=("]");
		return s.toString();
		
	}
	@Override
	public int hashCode() {
		int hashValue =  (int) name.charAt(2);
		
		return hashValue;
	}
	
	 

}
