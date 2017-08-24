package io.zipcoder.accounts;

import io.zipcoder.accountHolders.AccountHolder;

public class SavingsAccount extends CheckingAccount implements InterestEnabledAccount {

	private double interest;
	
	public SavingsAccount(AccountHolder accountHolder, double overdraftLimit, boolean canHaveOverdraft) {
		super(accountHolder, overdraftLimit, canHaveOverdraft);
	}

	public double getInterest() {
		return this.interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public void applyInterest() {
		this.creditAccount("interest", (this.getBalance() * this.interest - this.getBalance()));
	}

}
