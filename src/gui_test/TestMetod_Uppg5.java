package gui_test;

public class TestMetod_Uppg5 {

	public static void main(String[] args) {

		
		Person p1 = new Person("970301", "Rikard");
		Account a1 = new Account("1234");
		Account a2 = new Account("2345");
		
		Person p2 = new Person("940407", "Jossan");
		Account a3 = new Account("3456");
		Account a4 = new Account("4567");
		
		PersonRegister r1 = new PersonRegister();
		r1.addPerson(p1);
		r1.addPerson(p2);
		
		p1.addAccount(a1);
		a1.setOwner(p1);
		p1.addAccount(a2);
		a2.setOwner(p1);
		
		p2.addAccount(a3);
		a3.setOwner(p2);
		p2.addAccount(a4);
		a4.setOwner(p2);
		
		System.out.println("Personer i registret");
		System.out.println(r1.findPerson("940407").getName() + " med personnummer: " + p1.getpNbr());
		System.out.println(r1.findPerson("970301").getName() + " med personnummer: " + p2.getpNbr());
		System.out.println("");
		System.out.println("Konton i registret");
		System.out.println("Kontonummer: " + a1.getNbr() + ", saldo: " + a1.getBalance());
		System.out.println(");
		
		
		for(Account a : r1.findPersonAccounts("970301")){  //Går in i listan som håller Accounts och tar ut alla objekt av Account a för pNbr "970301".
			System.out.println("konto: " + a.getNbr() + " ägs av: " + a.getOwner().getName()); //Skriver ut alla konton som ägs av personen med pNbr "970301" och även dennes namn.
		}
		System.out.println("");
		for (Account b : r1.findPersonAccounts("940407")) { //Samma som ovan fast för pNbr "940407".
			System.out.println("Konto: " + b.getNbr() + " ägs av " + b.getOwner().getName()); //Samma som ovan fast för pNbr "940407".
		}
//		r1.removePerson("940407");
//		r1.findPerson(p1.getpNbr()); 
	}
}

