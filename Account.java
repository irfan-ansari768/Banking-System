package BankingSystem;

public class Account extends Customer {

	private int balance;
	private int accountNumber;

	// Constructor
	public Account(String FName, String LName, int accountNumber, int balance) {

		setFirstName(FName);
		setLastName(LName);

		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	// Return balance
	public int getBalance() {
		return balance;
	}

	// Return account number
	public int getAccountNum() {
		return accountNumber;
	}

	// Deposit money
	public void deposit(int amount) {
		balance = balance + amount;
	}

	// Withdraw money
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}