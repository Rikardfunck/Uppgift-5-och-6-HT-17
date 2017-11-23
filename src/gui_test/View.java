package gui_test;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class View {

	private JFrame frame;
	private JTextField textField_Name;
	private JTextField textField_pNbr;
	private Controller controller = new Controller();
	private Person person;

	private JTextField textField_accNbr;
	private JTextField textField_amount;
	private JButton btnNewButton_removePerson;
	private JButton btnNewButton_findPerson;
	private JButton btnNewButton_addPerson;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnLggTillKonto;
	private JButton btnCredit;
	private JButton btnWithdraw;
	private JLabel lblAccountNumber;
	private JLabel lblAmount;
	private JButton btnShowAccounts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 541, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnNewButton_removePerson = new JButton("Remove Person");
		btnNewButton_removePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_pNbr.getText();
				controller.removePerson(pNbr);
				textArea.setText("The person has been deleted.");
			}
		});
		btnNewButton_removePerson.setBounds(354, 108, 139, 25);
		frame.getContentPane().add(btnNewButton_removePerson);

		btnNewButton_findPerson = new JButton("Find Person");
		btnNewButton_findPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_pNbr.getText();
				Person p = controller.findPerson(pNbr);
				if (p != null) {
					textArea.setText(p.getName());
				} else {
					textArea.setText("The person can't be found.");

				}
			}
		});
		btnNewButton_findPerson.setBounds(354, 70, 139, 25);
		frame.getContentPane().add(btnNewButton_findPerson);

		btnNewButton_addPerson = new JButton("Add Person");
		btnNewButton_addPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_Name.getText();
				String pNbr = textField_pNbr.getText();
				Person p = new Person(pNbr, name);
				controller.addPerson(p);
				textArea.setText("The person has been added.");
			}
		});
		btnNewButton_addPerson.setBounds(354, 32, 139, 25);
		frame.getContentPane().add(btnNewButton_addPerson);

		textField_Name = new JTextField();
		textField_Name.setBounds(164, 33, 116, 22);
		frame.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);

		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(36, 36, 56, 16);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Id number:");
		lblNewLabel_1.setBounds(36, 71, 106, 16);
		frame.getContentPane().add(lblNewLabel_1);

		textField_pNbr = new JTextField();
		textField_pNbr.setBounds(164, 65, 116, 22);
		frame.getContentPane().add(textField_pNbr);
		textField_pNbr.setColumns(10);

		btnLggTillKonto = new JButton("Add account");
		btnLggTillKonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addAccount(new Account(textField_accNbr.getText()),
				controller.findPerson(textField_pNbr.getText()));
				Person tmp = controller.findPerson(textField_pNbr.getText());
				textArea.setText("Account " + (textField_accNbr.getText()) + " has been added for person " + tmp.getName());

			}
		});
		btnLggTillKonto.setBounds(354, 146, 139, 25);
		frame.getContentPane().add(btnLggTillKonto);

		textArea = new JTextArea();
		textArea.setBounds(36, 222, 270, 169);
		frame.getContentPane().add(textArea);

		btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amountInput = textField_amount.getText();
				String pNbr = textField_pNbr.getText();
				String nbr = textField_accNbr.getText();
				double amount = 0;
				try {
					amount = Double.parseDouble(amountInput);
					controller.credit(amount, pNbr, nbr);
					Account a = controller.findSpecificAccount(pNbr, nbr);
					if (a != null) {
						textArea.setText("Your balance is: " + a.getBalance());
					}
				} catch (NumberFormatException ex) {
					textArea.setText("Please enter a valid amount.");
				}

			}
		});
		btnCredit.setBounds(354, 271, 139, 25);
		frame.getContentPane().add(btnCredit);

		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amountInput = textField_amount.getText();
				String pNbr = textField_pNbr.getText();
				String nbr = textField_accNbr.getText();
				double amount = 0;
				try {
					amount = Double.parseDouble(amountInput);
					Account a = controller.findSpecificAccount(pNbr, nbr);
					if (amount > a.getBalance()) {
						textArea.setText("Insufficient funds.");
					} else if (a != null) {
						controller.withdraw(amount, pNbr, nbr);
						textArea.setText("Your balance is : " + a.getBalance());
					}

				} catch (NumberFormatException ex1) {

					textArea.setText("Please enter a valid amount.");
				}
			}
		});
		btnWithdraw.setBounds(354, 309, 139, 25);
		frame.getContentPane().add(btnWithdraw);

		lblAccountNumber = new JLabel("Account number:");
		lblAccountNumber.setBounds(36, 103, 106, 16);
		frame.getContentPane().add(lblAccountNumber);

		textField_accNbr = new JTextField();
		textField_accNbr.setBounds(164, 100, 116, 22);
		frame.getContentPane().add(textField_accNbr);
		textField_accNbr.setColumns(10);

		textField_amount = new JTextField();
		textField_amount.setBounds(164, 135, 116, 22);
		frame.getContentPane().add(textField_amount);
		textField_amount.setColumns(10);

		lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(36, 138, 56, 16);
		frame.getContentPane().add(lblAmount);

		btnShowAccounts = new JButton("Show accounts");
		btnShowAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pNbr = textField_pNbr.getText();
				textArea.setText("");
				for (Account a : controller.findPerson(pNbr).getAccounts()) {	
					textArea.append(a.getOwner().getName() + " owns account: " + a.getNbr() + "\n");
				}
				
			}
		});
		btnShowAccounts.setBounds(354, 184, 139, 25);
		frame.getContentPane().add(btnShowAccounts);

		JButton btnNewButton = new JButton("Show balance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nbr = textField_accNbr.getText();
				String pNbr = textField_pNbr.getText();

				Account a = controller.findSpecificAccount(pNbr, nbr);
				if (a != null) {
					textArea.setText("Your balance is : " + a.getBalance());
				}
			}
		});
		btnNewButton.setBounds(356, 230, 137, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
