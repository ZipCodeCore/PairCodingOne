package io.zipcoder.accounts;

import org.junit.Test;

import accountHolders.AccountHolder;
import accountHolders.Business;
import accountHolders.Person;
import io.zipcoder.accounts.InterestEnabledAccount;
import io.zipcoder.accounts.InvestmentAccount;

import org.junit.Assert;

public class InvestmentAccountTest {
	// This class also tests functionality written in the Accounts class

	@Test
	public void createInvestmentAccountTest() {

		// Given & When
		try {
			AccountHolder zac = new Person("Zac", "J", "Effron");
			InterestEnabledAccount investmentAccount = new InvestmentAccount(zac, 1.01);
		} catch (Exception e) {
			// if an error occurs the methods failed.
			Assert.fail();
		} // else everything worked

	}

	@Test
	public void creditInvestmentAccountTest() {

		// Given
		AccountHolder zac = new Person("Zac", "J", "Effron");
		InvestmentAccount investmentAccount = new InvestmentAccount(zac, 1.01);
		double amount = 100;

		// When
		investmentAccount.creditAccount(amount);

		// Then
		Assert.assertEquals("credit Investment Account Test - doubles were equal", amount,
				investmentAccount.getBalance(), 0.0);
	}

	@Test
	public void debitInvestentAccountTest() {

		// Given
		AccountHolder zac = new Business("Z. Effron Films Inc.");
		InvestmentAccount investmentAccount = new InvestmentAccount(zac, 1.01);
		investmentAccount.creditAccount(100.0);
		double expected = 50.0;

		// When
		investmentAccount.debitAccount(50.0);
		double actual = investmentAccount.getBalance();

		// Then
		Assert.assertEquals("debit Investment Account Test - doubles were equal", expected, actual, 0.0);
	}

	@Test
	public void applyInterstTest() {

		// Given
		AccountHolder zac = new Person("Zac", "J", "Effron");
		InvestmentAccount investmentAccount = new InvestmentAccount(zac, 1.01);
		investmentAccount.creditAccount(100.0);
		double expected = 100 * 1.01;

		// When
		investmentAccount.applyInterest();
		double actual = investmentAccount.getBalance();

		// Then
		Assert.assertEquals("debit Investment Account Test - doubles were equal", expected, actual, 0.0);
	}

	@Test
	public void getTransactionLogTest() {

		// Given
		AccountHolder zac = new Person("Zac", "J", "Effron");
		InvestmentAccount investmentAccount = new InvestmentAccount(zac, 1.01);
		investmentAccount.creditAccount(100.0);
		investmentAccount.debitAccount(30.0);
		investmentAccount.creditAccount(10.0);
		investmentAccount.applyInterest();

		String expected = "Transaction Log:"
				+ "\ntransaction type interest. Transaction amount: £0.80, new balance is: £80.80"
				+ "\ntransaction type credit account. Transaction amount: £10.00, new balance is: £80.00"
				+ "\ntransaction type debit account. Transaction amount: £30.00, new balance is: £70.00"
				+ "\ntransaction type credit account. Transaction amount: £100.00, new balance is: £100.00";

		// When
		String actual = investmentAccount.getTransactionLog(4);

		// Then
		Assert.assertEquals("getTransactionLogTest - strings were equal", expected, actual);

	}
	
	
	
}
