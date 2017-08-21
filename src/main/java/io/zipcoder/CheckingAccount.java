package io.zipcoder;

import io.zipcoder.Account.transactionType;

public class CheckingAccount extends Account {
	private boolean noOver;

	public CheckingAccount(boolean noOver, AccountHolder accountholder, double balance, long ACCOUNTNUMBER) {
		super(accountholder, balance, ACCOUNTNUMBER);
		this.noOver = noOver;
	}

	public boolean isNoOver() {
		return noOver;
	}

	public void setNoOver(boolean noOver) {
		this.noOver = noOver;
	}

	@Override
	public void withdrawal(double amount) {
		if (!noOver || (noOver && amount<=super.getBalance())){
			addTransaction(-amount);
		}else
			System.out.println("You do not have sufficient funds for this transaction!!!!");
	}

}
