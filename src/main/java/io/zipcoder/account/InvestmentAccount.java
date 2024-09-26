package io.zipcoder.account;

import java.math.BigDecimal;

import io.zipcoder.holder.AccountHolder;

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
		
		BigDecimal interestBD = new  BigDecimal(this.interestRate);
		
		BigDecimal totalInterest = interestBD.multiply(this.getBalance()).divide(new BigDecimal("100.00"));
		
		super.deposit(totalInterest);
		
	}



	
	
	

}
