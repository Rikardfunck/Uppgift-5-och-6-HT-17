package gui_test;

import java.util.ArrayList;

public class Person {
	
	private String pNbr;
	private String name;
	
	private ArrayList<Account> accounts = new ArrayList<Account>(); 
	
	public Person (String pNbr, String name) {
		this.name=name;
		this.pNbr=pNbr;
	}
	public Person(){
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void addAccount (Account a) {
		accounts.add(a);
	}
	public void setPNbr (String newPNbr) {
		this.pNbr = newPNbr;
	}
	public String getpNbr() {
		return pNbr;
	}
	public String getName () {
		return name;
	}
	public void setName (String newName) {
		name = newName;
	}
}
