package io.zipcoder.accounts;

import accountHolders.AccountHolder;

public class InvestmentAccount extends Account implements InterestEnabledAccount {

	private double interest;

	/**
	 * 
	 * @param accountHolder
	 *            must be an accountHolder
	 * @param interest
	 *            a value relative to 1 and greater than 0, where 1 is 0%
	 *            interest.
	 */
	protected InvestmentAccount(AccountHolder accountHolder, double interest) {
		super(accountHolder);
		this.setInterest(interest);
	}

	/**
	 * applies interest to the account, automatically debits and logs this as an
	 * interest transaction.
	 */
	public void applyInterest() {
		// balance *= this.interest
		this.creditAccount("interest", (this.getBalance() * this.interest - this.getBalance()));
	}

	public double getInterest() {
		return this.interest;
	}

	/**
	 * @param intrest
	 *            the interest to set, this should be relative to 1 (ie, setting
	 *            interest to 1 is equivalent to 0% interest; 1.01 is equivalent
	 *            to 1% interest) and cannot be negative.
	 */
	public void setInterest(double interest) {
		if (interest >= 0) {
			this.interest = interest;
		} else {
			throw new IllegalArgumentException("interest rate must be relative to 1, and greater than 0.");
		}
	}

}
