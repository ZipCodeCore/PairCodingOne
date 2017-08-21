package io.zipcoder.accounts;

import accountHolders.AccountHolder;

public class InvestmentAccount extends Account implements InterestEnabledAccount {

	private double interest;

	protected InvestmentAccount(AccountHolder accountHolder, double interest) {
		super(accountHolder);
		this.interest = interest;
	}

	public void applyInterest() {
		// balance *= this.interest
		this.creditAccount("interest", (this.getBalance() * this.interest - this.getBalance()));
	}

	public double getInterest() {
		return this.interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

}
