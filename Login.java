package BankingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {

	private JTextField usernameField;
	private JPasswordField passwordField;

	private JButton loginButton;
	private JButton clearButton;

	public Login() {

		super("Banking System - Login");

		setLayout(null);

		// Title
		JLabel title = new JLabel("BANKING SYSTEM");
		title.setFont(new Font("Arial", Font.BOLD, 25));
		title.setBounds(120, 30, 300, 40);
		add(title);

		// Username
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(70, 100, 100, 30);
		add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setBounds(170, 100, 200, 30);
		add(usernameField);

		// Password
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(70, 150, 100, 30);
		add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(170, 150, 200, 30);
		add(passwordField);

		// Login button
		loginButton = new JButton("Login");
		loginButton.setBounds(120, 210, 100, 35);
		add(loginButton);

		// Clear button
		clearButton = new JButton("Clear");
		clearButton.setBounds(240, 210, 100, 35);
		add(clearButton);

		// Login action
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String username = usernameField.getText();

				String password = new String(passwordField.getPassword());

				// Demo login details
				if (username.equals("irfan") && password.equals("1234")) {

					JOptionPane.showMessageDialog(Login.this, "Login successful!");

					// Close login window
					dispose();

					// Open banking system
					openBankingSystem();

				} else {

					JOptionPane.showMessageDialog(Login.this, "Invalid username or password!");
				}
			}
		});

		// Clear action
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				usernameField.setText("");
				passwordField.setText("");
			}
		});

		setSize(450, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void openBankingSystem() {

		// Read accounts from CSV
		String file = "Accounts.csv";

		ReadAccounts readAccounts = new ReadAccounts(file);

		// Get account information
		java.util.LinkedList<String> firstNames = readAccounts.getFirstNames();

		java.util.LinkedList<String> lastNames = readAccounts.getLastNames();

		java.util.LinkedList<Integer> accountList = readAccounts.getAccounts();

		java.util.LinkedList<Integer> balanceList = readAccounts.getBalances();

		// Create account list
		java.util.LinkedList<Account> accounts = new java.util.LinkedList<Account>();

		// Create Account objects
		for (int i = 0; i < firstNames.size(); i++) {

			accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
		}

		// Open GUI
		GUI gui = new GUI(accounts);

		gui.setSize(1000, 700);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}

	public static void main(String[] args) {

		new Login();
	}
}
