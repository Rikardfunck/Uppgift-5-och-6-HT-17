package gui_test;

public class Test_GUI {

	public static void main(String[] args) {

		
		Controller c = new Controller();
		
		Person a = new Person("123", "hej"); 
		
		c.addPerson(a);
//		c.removePerson("123");
		c.findPerson("123");
		a.addAccount(new Account("22"));
		
		
		
		String pNbr = "123";
		
		for (Account acc : c.findPerson(pNbr).getAccounts()) {
		System.out.print(acc.getNbr());
		}
		
//		System.out.println(x);
		
	}

}
