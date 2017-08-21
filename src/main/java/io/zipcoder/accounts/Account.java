package io.zipcoder.accounts;

import java.util.ArrayList;

import accountHolders.AccountHolder;
import io.zipcoder.Transaction;

public abstract class Account {

	private final AccountHolder accountHolder;
	private double balance;
	protected final long accountNumber;
	private final ArrayList<Transaction> transactions;

	private static long accountNumberIncrementor = 0;

	protected Account(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
		this.balance = 0.00;
		this.transactions = new ArrayList<Transaction>();
		this.accountNumber = generateAccountNumber();
	}

	protected void creditAccount(double amount) {
		this.creditAccount("credit account", amount);
	}
	protected void creditAccount(String transactionType, double amount) {
		if (amount >= 0) {
			this.balance += amount;
			// transaction
			this.transactions.add(new Transaction(transactionType, amount, this.balance));
		} else {
			throw new IllegalArgumentException("amount cannot be negative");
		}
	}

	protected void debitAccount(double amount) {
		if (amount >= 0) {
			this.balance -= amount;
			// transaction
			this.transactions.add(new Transaction("debit account", amount, this.balance));
		} else {
			throw new IllegalArgumentException("amount cannot be negative");
		}
	}

	/**
	 * @return the accountHolder
	 */
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the transactions
	 */
	public ArrayList<Transaction> getTransactions() {
		return (ArrayList<Transaction>) this.transactions.clone();
	}

	public String getTransactionLog(int n) {
		
		StringBuilder returnBuilder = new StringBuilder("Transaction Log:");
		for (int i = transactions.size() -1; i >= transactions.size()-n; i--) {
			returnBuilder.append("\n" + transactions.get(i).toString());
		}
		return returnBuilder.toString();
	}

	private long generateAccountNumber() {
		accountNumberIncrementor++;
		return accountNumberIncrementor;
	}

}
