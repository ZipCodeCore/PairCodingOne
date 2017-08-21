package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class InterestAccountTest {
	@Test
	public void applyInterestTest() {
		// Given
		PersonalAccountHolder testAccount = new PersonalAccountHolder("halide", "bey", "I");
		InterestAccount testInterestAccount = new InterestAccount(5.0, testAccount, 100.0, 9);
		double expected = 105.0;
		// When
		testInterestAccount.applyInterest();
		double actual = testInterestAccount.getBalance();
		// Then
		Assert.assertEquals(actual, expected, 0.0);
	}

	@Test
	public void withdrawalTest() {
		// Given
		PersonalAccountHolder testAccount = new PersonalAccountHolder("halide", "bey", "I");
		InterestAccount testCheckingAccount = new InterestAccount(9.0, testAccount, 100.0, 9);
		
		double expected = -50.0;
		// When
		testCheckingAccount.withdrawal(150);
		double actual = testCheckingAccount.getBalance();
		// Then
		Assert.assertEquals(expected, actual, 0.0);
	}

}
