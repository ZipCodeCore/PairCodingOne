package io.zipcoder.accounts;

import org.junit.Assert;
import org.junit.Test;

import io.zipcoder.accountHolders.Business;

public class SavingsAccountTest {

	@Test
	public void testApplyInterest() {
		
		// :Given
		Business b = new Business("Jerome Savings Inc.");
		SavingsAccount s = new SavingsAccount(b, 0, true);
		s.setInterest(1.01);
		s.setOverdraftLimit(1000);
		s.debitAccount(100);
		s.creditAccount(200);
		double expected = (0-100+200)*1.01;
		
		// :When
		s.applyInterest();
		double actual = s.getBalance();
		
		// :Then
		Assert.assertEquals("testApplyInterest - doubles matched", expected, actual, 0.001);
	}

}
