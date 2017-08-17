package io.zipcoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

	private AccountHolder accountHolder;
	private BigDecimal balance;
	private final long accountNumber;
	private List<Transaction> transactionList;

	public Account(AccountHolder accountHolder, BigDecimal balance, long accountNumber) {
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.transactionList = new ArrayList<Transaction>();
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public boolean withdraw(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) > 0) {
			this.balance = balance.subtract(amount);
			this.transactionList.add(new Transaction(TransactionType.WITHDRAWAL, amount, this.balance));
			return true;
		} else {
			return false;
		}

	}

	public boolean deposit(BigDecimal amount) {

		if (amount.compareTo(BigDecimal.ZERO) > 0) {
			this.balance = balance.add(amount);
			this.transactionList.add(new Transaction(TransactionType.DEPOSIT, amount, this.balance));
			return true;
		} else {
			return false;
		}

	}

	public String printTransactions(int n) {
		String result = "";
		int index = transactionList.size();
		
		if (n <= index) {
			for (int i = 0; i < n; i++) {
				result+=transactionList.get(index-1)+"\n";
				index--;
			}
		}else{
			return "There are not enough transactions in this account.";
		}
		return result;
	}

}
