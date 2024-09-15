package io.zipcoder.accounts;

public interface InterestEnabledAccount {

	/**
	 * @return the interest
	 */
	double getInterest();

	/**
	 * @param intrest
	 *            the interest to set, this should be relative to 1 (ie, setting
	 *            interest to 1 is equivalent to 0% interest; 1.01 is equivalent to 1% interest) and cannot be
	 *            negative.
	 */
	void setInterest(double interest);

	/**
	 * applies interest to the account, automatically debits and logs this as an interest transaction.
	 */
	void applyInterest();

}