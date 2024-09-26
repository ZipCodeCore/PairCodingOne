package io.zipcoder.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.zipcoder.holder.AccountHolder;
import io.zipcoder.transaction.Transaction;
import io.zipcoder.transaction.TransactionType;

public abstract class Account {

	private final AccountHolder accountHolder;
	private BigDecimal balance;
	private final long accountNumber;
	private final List<Transaction> transactionList;

	public Account(AccountHolder accountHolder, BigDecimal balance, long accountNumber) {
		if(balance.compareTo(BigDecimal.ZERO)<0){
			throw new IllegalArgumentException("Initial balance can't be negative");
		}
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.transactionList = new ArrayList<Transaction>();
		addTransaction(TransactionType.CREATION, balance, balance);
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

	public void withdraw(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) > 0) {
			this.balance = balance.subtract(amount);
			this.transactionList.add(new Transaction(TransactionType.WITHDRAWAL, amount, this.balance));
		} else {
			 throw new IllegalArgumentException("The amount is negative.");
		}

	}

	public void deposit(BigDecimal amount) {

		if (amount.compareTo(BigDecimal.ZERO) > 0) {
			this.balance = balance.add(amount);
			this.addTransaction(TransactionType.DEPOSIT, amount, this.balance);

		} else {
			throw new IllegalArgumentException("Amount can't be negative.");
		}

	}
	
	protected void addTransaction(TransactionType type, BigDecimal amount, BigDecimal remainingBalance ){
		transactionList.add(new Transaction(type, amount, remainingBalance));
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
