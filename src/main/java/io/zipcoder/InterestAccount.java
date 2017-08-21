package io.zipcoder;

public class InterestAccount extends Account {
	private double interestRate;

	public InterestAccount(double interestRate, AccountHolder accountholder, double balance, long ACCOUNTNUMBER) {
		super(accountholder, balance, ACCOUNTNUMBER);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void applyInterest(){
		double interestToDeposit = getBalance() * (interestRate/100);
		addTransaction(interestToDeposit);
	}

}
