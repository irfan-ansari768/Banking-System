package BankingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Window.Type;

public class GUI extends JFrame {

	private Transaction transferObject = new Transaction();
	private StringBuilder sbAllData = new StringBuilder();
	private LinkedList<Account> globalAccounts;

	private JLabel showAllData1;

	private JButton showAllButton;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;

	private JTextField accDeposit;
	private JTextField accWithdraw;
	private JTextField acc1Transfer;
	private JTextField acc2Transfer;
	private JTextField depositInput;
	private JTextField withdrawInput;
	private JTextField transferAmount;

	private JTextPane txtpnHello_1;
	private JTextPane txtpnHello_2;
	private JLabel lblNewLabel_7;
	private JTextPane textPane;

	public GUI(LinkedList<Account> accounts) {

		super("Banking System");

		globalAccounts = accounts;

		// JFrame Settings
		setSize(791, 527);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		// Populate all accounts
		for (Account acc : globalAccounts) {

			sbAllData.append("Name: ").append(acc.getFirstName()).append(" ").append(acc.getLastName())
					.append(" | Account No: ").append(acc.getAccountNum()).append(" | Balance: Rs")
					.append(acc.getBalance()).append("\n");
		}

		// BUTTONS

		showAllButton = new JButton("Show All");
		showAllButton.setFont(new Font("Times New Roman", Font.BOLD, 14));

		depositButton = new JButton("Deposit");
		depositButton.setFont(new Font("Times New Roman", Font.BOLD, 12));

		withdrawButton = new JButton("Withdraw");
		withdrawButton.setFont(new Font("Times New Roman", Font.BOLD, 12));

		transferButton = new JButton("Transfer");
		transferButton.setFont(new Font("Times New Roman", Font.BOLD, 12));

		// TEXTFIELDS

		accDeposit = new JTextField("");
		depositInput = new JTextField("");

		accWithdraw = new JTextField("");
		withdrawInput = new JTextField("");

		acc1Transfer = new JTextField("");
		acc2Transfer = new JTextField("");
		transferAmount = new JTextField("");

		// LABEL

		showAllData1 = new JLabel("Press 'Show All' to see accounts");
		showAllData1.setForeground(new Color(0, 0, 0));
		showAllData1.setFont(new Font("Times New Roman", Font.BOLD, 14));

		// BOUNDS

		showAllButton.setBounds(10, 30, 150, 30);
		showAllData1.setBounds(10, 74, 757, 92);

		accDeposit.setBounds(20, 236, 200, 30);
		depositInput.setBounds(240, 236, 150, 30);
		depositButton.setBounds(422, 235, 120, 30);

		accWithdraw.setBounds(20, 330, 200, 30);
		withdrawInput.setBounds(240, 330, 150, 30);
		withdrawButton.setBounds(422, 329, 120, 30);

		acc1Transfer.setBounds(20, 436, 200, 30);
		acc2Transfer.setBounds(244, 436, 200, 30);
		transferAmount.setBounds(468, 436, 150, 30);
		transferButton.setBounds(628, 435, 120, 30);

		// ADD COMPONENTS

		getContentPane().add(showAllButton);
		getContentPane().add(showAllData1);

		getContentPane().add(accDeposit);
		getContentPane().add(depositInput);
		getContentPane().add(depositButton);

		getContentPane().add(accWithdraw);
		getContentPane().add(withdrawInput);
		getContentPane().add(withdrawButton);

		getContentPane().add(acc1Transfer);
		getContentPane().add(acc2Transfer);
		getContentPane().add(transferAmount);
		getContentPane().add(transferButton);

		// LABELS

		JLabel lblNewLabel = new JLabel("Account No (Deposit)");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 196, 150, 30);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Deposit Amount");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(240, 196, 113, 30);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Account No (Withdraw)");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 302, 150, 18);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Withdraw Amount");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(240, 302, 120, 18);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("From Account No");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(22, 402, 120, 24);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("To Account No");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(244, 402, 120, 24);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Transfer Amount");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(468, 402, 120, 24);
		getContentPane().add(lblNewLabel_6);

		// PANELS

		JTextPane txtpnHello = new JTextPane();
		txtpnHello.setBackground(new Color(231, 255, 249));
		txtpnHello.setBounds(10, 189, 745, 90);
		getContentPane().add(txtpnHello);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 74, 745, 92);
		getContentPane().add(textArea);

		txtpnHello_1 = new JTextPane();
		txtpnHello_1.setBackground(new Color(231, 255, 241));
		txtpnHello_1.setBounds(10, 286, 745, 90);
		getContentPane().add(txtpnHello_1);

		txtpnHello_2 = new JTextPane();
		txtpnHello_2.setBackground(new Color(231, 255, 241));
		txtpnHello_2.setBounds(10, 387, 745, 90);
		getContentPane().add(txtpnHello_2);

		// BUTTON EFFECT

		addButtonEffect(showAllButton);
		addButtonEffect(depositButton);
		addButtonEffect(withdrawButton);
		addButtonEffect(transferButton);

		lblNewLabel_7 = new JLabel("BANKING SYSTEM");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_7.setBounds(276, 0, 247, 30);
		getContentPane().add(lblNewLabel_7);

		textPane = new JTextPane();
		textPane.setBackground(new Color(192, 192, 192));
		textPane.setBounds(0, 0, 767, 492);
		getContentPane().add(textPane);

		// HANDLER

		HandlerClass handler = new HandlerClass();

		showAllButton.addActionListener(handler);
		depositButton.addActionListener(handler);
		withdrawButton.addActionListener(handler);
		transferButton.addActionListener(handler);

		setVisible(true);
	}

	// BUTTON COLOR EFFECT

	private void addButtonEffect(JButton button) {
		Color originalColor = button.getBackground();
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				button.setBackground(Color.GRAY);
			}

			public void mouseReleased(MouseEvent e) {
				button.setBackground(originalColor);
			}
		});
	}

	// UPDATE CSV

	private void updateCSV() {
		try {

			FileWriter writer = new FileWriter("Accounts.csv");
			for (Account acc : globalAccounts) {
				writer.write(acc.getFirstName() + "," + acc.getLastName() + "," + acc.getAccountNum() + ","
						+ acc.getBalance() + "\n");
			}
			writer.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error updating CSV file.");
		}
	}

	// HANDLER CLASS

	private class HandlerClass implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// SHOW ALL
			if (e.getSource() == showAllButton) {
				sbAllData = new StringBuilder();
				for (Account acc : globalAccounts) {
					sbAllData.append("Name: ").append(acc.getFirstName()).append(" ").append(acc.getLastName())
							.append(" || Acc No: ").append(acc.getAccountNum()).append(" || Balance: Rs.")
							.append(acc.getBalance()).append("\n");
				}
				showAllData1.setText("<html>" + sbAllData.toString().replace("\n", "<br>") + "</html>");
			}

			// DEPOSIT

			if (e.getSource() == depositButton) {
				try {

					int accNum = Integer.parseInt(accDeposit.getText().trim());
					int amount = Integer.parseInt(depositInput.getText().trim());

					// Add Insufficient Validation
					if (amount <= 0) {
						JOptionPane.showMessageDialog(null, "Invalid amount. Please enter valid deposit amount.");
						return;
					}

					for (Account acc : globalAccounts) {
						if (acc.getAccountNum() == accNum) {
							acc.deposit(amount);
							updateCSV();

							JOptionPane.showMessageDialog(null, "Deposited Rs " + amount + " to account " + accNum
									+ "\nNew balance: Rs " + acc.getBalance());
							return;
						}
					}

					JOptionPane.showMessageDialog(null, "Account not found.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Enter valid values.");
				}
			}

			// WITHDRAW

			if (e.getSource() == withdrawButton) {
				try {

					int accNum = Integer.parseInt(accWithdraw.getText().trim());
					int amount = Integer.parseInt(withdrawInput.getText().trim());

					// Negative or zero withdrawal
					if (amount <= 0) {
						JOptionPane.showMessageDialog(null, "Invalid amount. Please enter valid withdrawal amount.");
						return;
					}

					for (Account acc : globalAccounts) {

						if (acc.getAccountNum() == accNum) {

							// ADDED INSUFFICIENT AMOUNT CONDITION
							if (amount > acc.getBalance()) {
								JOptionPane.showMessageDialog(null, "Insufficient Amount");
								return;
							}
							acc.withdraw(amount);
							updateCSV();
							JOptionPane.showMessageDialog(null, "Withdrew Rs " + amount + " from account " + accNum
									+ "\nNew balance: Rs " + acc.getBalance());
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "Account not found.");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Enter valid values.");
				}
			}

			// TRANSFER

			if (e.getSource() == transferButton) {
				try {

					int accNum1 = Integer.parseInt(acc1Transfer.getText().trim());
					int accNum2 = Integer.parseInt(acc2Transfer.getText().trim());
					int amount = Integer.parseInt(transferAmount.getText().trim());

					Account src = null;
					Account dst = null;
					
					// Negative or zero withdrawal
					if (amount <= 0) {
						JOptionPane.showMessageDialog(null, "Invalid amount. Please enter valid withdrawal amount.");
						return;
					}

					for (Account acc : globalAccounts) {
						if (acc.getAccountNum() == accNum1) {
							src = acc;
						}
						if (acc.getAccountNum() == accNum2) {
							dst = acc;
						}
					}
					if (src != null && dst != null) {

						// ADDED INSUFFICIENT AMOUNT CONDITION
						if (amount > src.getBalance()) {
							JOptionPane.showMessageDialog(null, "Insufficient Amount");
							return;
						}

						transferObject.transfer(src, dst, amount);
						updateCSV();

						JOptionPane.showMessageDialog(null, "Transfer Successful");
					} else {
						JOptionPane.showMessageDialog(null, "One or both accounts not found.");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Enter valid values.");
				}
			}
		}
	}
}