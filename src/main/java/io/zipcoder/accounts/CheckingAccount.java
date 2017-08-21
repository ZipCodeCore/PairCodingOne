package io.zipcoder.accounts;

import accountHolders.AccountHolder;

public class CheckingAccount extends Account {

	private boolean canHaveOverdraft = false;
	private double overdraftLimit = 0.0;

	public CheckingAccount(AccountHolder accountHolder, 
			double overdraftLimit, boolean canHaveOverdraft) {
		super(accountHolder);
		this.setOverdraftLimit(overdraftLimit);
		this.setCanHaveOverdraft(canHaveOverdraft);
	}

	@Override
	public void debitAccount(double amount) {
		if (this.canHaveOverdraft() && this.getBalance() - amount >= -(this.getOverdraftLimit())) {
			super.debitAccount(amount);
		} else if (this.getBalance() - amount >= 0) {
			super.debitAccount(amount);
		}
	}

	/**
	 * @return the canHaveOverdraft
	 */
	public boolean canHaveOverdraft() {
		return canHaveOverdraft;
	}

	/**
	 * @param canHaveOverdraft
	 *            the canHaveOverdraft to set
	 */
	public void setCanHaveOverdraft(boolean canHaveOverdraft) {
		this.canHaveOverdraft = canHaveOverdraft;
	}

	/**
	 * @return the overdraftLimit
	 */
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	/**
	 * @param overdraftLimit
	 *            the overdraftLimit to set
	 */
	public void setOverdraftLimit(double overdraftLimit) {
		if (overdraftLimit >= 0) {
			this.overdraftLimit = overdraftLimit;
		} else {
			this.overdraftLimit = 0;
		}
	}

}
