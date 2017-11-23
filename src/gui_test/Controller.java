package gui_test;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	PersonRegister register = new PersonRegister();
	Person p = new Person();
	Account acc; 
	JFrame customerFrame;

	public void addPerson(Person p) {
		register.addPerson(p);
	}

	public Person removePerson(String pNbr) {
		return register.removePerson(pNbr);
	}
	
	public Person findPerson(String pNbr) {
		return register.findPerson(pNbr); 
	}
	public void addAccount(Account a, Person p){
		p.addAccount(a);
		a.setOwner(p);
	}
	public void credit(double amount, String pNbr, String nbr){
		Account tmpAcc = findSpecificAccount(pNbr, nbr);
		if(tmpAcc != null){
			tmpAcc.credit(amount);
		}
		
	}
	public void withdraw(double amount, String pNbr, String nbr){
		Account tmpAcc = findSpecificAccount(pNbr,nbr);
		if(tmpAcc != null){
			tmpAcc.withdraw(amount);
		}
	}
	public ArrayList<Account> findPersonAccounts (String pNbr) {
		return register.findPersonAccounts(pNbr);
	}
	public void setOwner(Person p){
		
	}
	public Account findSpecificAccount (String pNbr, String nbr){
		ArrayList<Account> tmpList = register.findPersonAccounts(pNbr);
		if (tmpList != null) {
			for (Account a : tmpList) {
				if (a.getNbr().equals(nbr)) {
					return a;
				}	
			}
		}
		return null;
	}

}
