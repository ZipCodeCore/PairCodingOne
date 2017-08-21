package io.zipcoder.accounts;

public interface InterestEnabledAccount {

	/**
	 * @return the interest
	 */
	double getInterest();

	/**
	 * @param intrest
	 *            the interest to set
	 */
	void setInterest(double interest);
	
	/**
	 * applies interest to the account
	 */
	void applyInterest();
	
}