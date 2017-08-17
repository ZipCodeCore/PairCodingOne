package io.zipcoder;

import java.math.BigDecimal;

public class InvestmentAccount extends Account {
	
	private double interestRate;
	
	public InvestmentAccount(AccountHolder accountHolder, BigDecimal balance, long accountNumber, double interestRate) {
		super(accountHolder, balance, accountNumber);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void applyInterest(){
		
	}



	
	
	

}
