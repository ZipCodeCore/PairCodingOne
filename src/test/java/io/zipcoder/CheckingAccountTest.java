package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class CheckingAccountTest {

	@Test
	public void withdrawalTest() {
		// Given
		PersonalAccountHolder testAccount = new PersonalAccountHolder("halide", "bey", "I");
		CheckingAccount testCheckingAccount = new CheckingAccount(true, testAccount, 100.0, 9);
		double expected = 50.0;
		// When
		testCheckingAccount.withdrawal(50);
		double actual = testCheckingAccount.getBalance();
		// Then
		Assert.assertEquals(expected, actual, 0.0);
	}

	@Test
	public void withdrawalNegativeTest() {
		// Given
		PersonalAccountHolder testAccount = new PersonalAccountHolder("halide", "bey", "I");
		CheckingAccount testCheckingAccount = new CheckingAccount(true, testAccount, 100.0, 9);
		double expected = 100.0;
		// When
		testCheckingAccount.withdrawal(150);
		double actual = testCheckingAccount.getBalance();
		// Then
		Assert.assertEquals(expected, actual, 0.0);
	}
	
	@Test
	public void withdrawalPositiveTest() {
		// Given
		PersonalAccountHolder testAccount = new PersonalAccountHolder("halide", "bey", "I");
		CheckingAccount testCheckingAccount = new CheckingAccount(false, testAccount, 100.0, 9);
		double expected = -50.0;
		// When
		testCheckingAccount.withdrawal(150);
		double actual = testCheckingAccount.getBalance();
		// Then
		Assert.assertEquals(expected, actual, 0.0);
	}

}