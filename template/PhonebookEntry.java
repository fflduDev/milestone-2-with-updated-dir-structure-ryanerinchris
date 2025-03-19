package template;

/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
 *   
 *   
 *   
 */

class PhonebookEntry{
	String type;
	String number;
	
	public PhonebookEntry(String type, String number) {
		this.type = type;
		this.number = number;
	}
	
	public String getType() {
		return type;
	}
	
	public String getPhoneNumber() {
		return number;
	}
 
}
	