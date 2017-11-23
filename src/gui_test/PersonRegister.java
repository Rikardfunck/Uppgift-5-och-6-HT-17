package gui_test;

import java.util.ArrayList;

public class PersonRegister {
	
	private ArrayList<Person>personList = new ArrayList<Person>();
	
	public void addPerson (Person p) {
		personList.add(p);
	}
	public Person findPerson(String pNbr) {
		for (Person tmp : this.personList) {
			if (tmp.getpNbr().equals(pNbr)) {
				return tmp;
			}
		}
		return null;
	}
	public Person removePerson (String pNbr) {	
		Person p = this.findPerson(pNbr);
		this.personList.remove(p);
		return p; 
	}
	
	public ArrayList<Account> findPersonAccounts (String pNbr) {
		Person p = this.findPerson(pNbr);
		if (p != null) {
			return p.getAccounts();
		}
		return null;
	}
}