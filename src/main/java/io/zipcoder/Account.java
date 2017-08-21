package io.zipcoder;

import java.util.ArrayList;

public abstract class Account {
	public enum transactionType {
		DEPOSIT, WITHDRAWAL
	}

	private AccountHolder accountholder;
	private double balance;
	private final long ACCOUNTNUMBER;
	private ArrayList<Transaction> log;

	public Account(AccountHolder accountholder, double balance, long ACCOUNTNUMBER) {
		this.accountholder = accountholder;
		this.balance = balance;
		this.ACCOUNTNUMBER = ACCOUNTNUMBER;
		this.log = new ArrayList<Transaction>();
	}

	public AccountHolder getAccountholder() {
		return accountholder;
	}

	public double getBalance() {
		return balance;
	}

	public long getACCOUNTNUMBER() {
		return ACCOUNTNUMBER;
	}

	public boolean withdrawal(double amount) {
		addTransaction(-amount);
		return true;
	}

	public void deposit(double amount) {
		// Transaction tr=new Transaction(amount, balance);
		// addTransaction(tr);

		addTransaction(amount);

	}

	public String printLog(int n) {
		String logPrint = "Transactions:";

		for (int i = log.size() - 1; i >= log.size() - n; i--) {
			logPrint += "\n" + "amount: " + log.get(i).getAmount() + "\nremaining balance: "
					+ log.get(i).getRemBalance();
		}
		return logPrint;

	}

	public void addTransaction(double amount) {
		log.add(new Transaction(amount, balance));
		this.balance = log.get(log.size() - 1).getRemBalance();
	}

}
