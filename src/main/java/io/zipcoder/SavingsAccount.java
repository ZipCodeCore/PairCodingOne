package io.zipcoder;

public class SavingsAccount extends InterestAccount {
	private boolean noOver;

	public SavingsAccount(boolean noOver, double interestRate, AccountHolder accountholder, double balance,
			long ACCOUNTNUMBER) {
		super(interestRate, accountholder, balance, ACCOUNTNUMBER);
		this.noOver = noOver;
	}

	public boolean isNoOver() {
		return noOver;
	}

	public void setNoOver(boolean noOver) {
		this.noOver = noOver;
	}
	@Override
	public boolean withdrawal(double amount) {
		if (!noOver || (noOver && amount <= super.getBalance())) {
			addTransaction(-amount);
			return true;
		} else
			System.out.println("You do not have sufficient funds for this transaction!!!!");
		return false;
	}

}
