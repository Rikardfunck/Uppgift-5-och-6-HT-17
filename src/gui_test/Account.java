package gui_test;

public class Account {

	private String nbr;
	private double balance;
	private Person owner;
	
	public Account (String nbr) {
		this.nbr =nbr;
	}
	public void setBalance(double newBalance) { //Behövs ej, värdet är 0 via default.
		this.balance = newBalance;
	} 
	public double getBalance() {
		return balance;
	}
	public void credit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) {
		if (amount>balance) {
			System.out.println("Du har inte tillräckligt med pengar.");
		}
		else 
			balance -= amount;
	}
	public void setNbr(String newNbr) {
		this.nbr = newNbr;
	}
	public String getNbr() {
		return nbr;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner (Person newOwner) {
		this.owner = newOwner;
	}
}
