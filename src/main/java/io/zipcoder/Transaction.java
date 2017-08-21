package io.zipcoder;

public class Transaction {
	private final double amount;
	private final double remBalance;

	public Transaction(double amount, double balance) {
		this.amount = amount;
		this.remBalance = balance+amount;
	}

	public double getAmount() {
		return amount;
	}

	public double getRemBalance() {
		return remBalance;
	}

}
