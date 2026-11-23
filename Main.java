package BankingSystem;

import java.util.LinkedList;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {

		// PART 1 – Basic Banking System

		System.out.println("~~~~~~===== PART 1: Basic Banking System =====~~~~~~");

		Account account1 = new Account("Jeffrey", "Ting", 1, 2000);
		Account account2 = new Account("Hiran", "Patel", 2, 1000);

		System.out.println("Account 1 balance: Rs" + account1.getBalance()); // 2000
		System.out.println("Account 2 balance: Rs" + account2.getBalance()); // 1000

		account1.deposit(250);
		System.out.println("Account 1 balance after depositing Rs250: Rs" + account1.getBalance()); // 2250

		account2.withdraw(500);
		System.out.println("Account 2 balance after withdrawing Rs500: Rs" + account2.getBalance()); // 500

		Transaction t = new Transaction();
		t.transfer(account1, account2, 250);

		System.out.println("Account 1 balance after transferring Rs250 to Account 2: Rs" + account1.getBalance()); // 2000
		System.out.println("Account 2 balance after receiving Rs250 from Account 1: Rs" + account2.getBalance()); // 750

		
		// PART 2 – CSV File Input
		
		System.out.println("\n~~~~~~===== PART 2: Banking System with CSV =====~~~~~~");
		String file = "Accounts.csv";
		LinkedList<Account> accounts = new LinkedList<>();
		ReadAccounts readAccounts = new ReadAccounts(file);

		LinkedList<String> firstNames = readAccounts.getFirstNames();
		LinkedList<String> lastNames = readAccounts.getLastNames();
		LinkedList<Integer> accountList = readAccounts.getAccounts();
		LinkedList<Integer> balanceList = readAccounts.getBalances();

		for (int i = 0; i < firstNames.size(); i++) {
			accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
		}

		System.out.println("Accounts loaded from CSV:");
		for (Account acc : accounts) {
			System.out.println("  " + acc.getFirstName() + " " + acc.getLastName() + " | Acc No: " + acc.getAccountNum()
					+ " | Balance: Rs" + acc.getBalance() + "\n");
		}

		// Test Part 2 accounts
		accounts.get(0).deposit(500);
		System.out.println("\nAfter depositing Rs500 to account index 0:");
		System.out.println("  Balance: Rs" + accounts.get(0).getBalance());

		accounts.get(1).withdraw(200);
		System.out.println("After withdrawing Rs200 from account index 1:");
		System.out.println("  Balance: Rs" + accounts.get(1).getBalance());

		Transaction t2 = new Transaction();
		t2.transfer(accounts.get(0), accounts.get(1), 300);
		System.out.println("After transferring Rs300 from index 0 to index 1:");
		System.out.println("Account 0 balance: Rs" + accounts.get(0).getBalance());
		System.out.println("Account 1 balance: Rs" + accounts.get(1).getBalance());

		
		// PART 3 – GUI
		GUI gui = new GUI(accounts);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(980, 625);
		gui.setVisible(true);
	}
}