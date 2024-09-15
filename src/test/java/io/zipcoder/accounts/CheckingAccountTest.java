package io.zipcoder.accounts;

import org.junit.Test;

import io.zipcoder.accountHolders.AccountHolder;
import io.zipcoder.accountHolders.Person;
import io.zipcoder.accounts.CheckingAccount;

import org.junit.Assert;

public class CheckingAccountTest {

	@Test
	public void setOverdraftLimitTest() {

		// Given (1)
		AccountHolder zac = new Person("Zac", "J", "Effron");
		CheckingAccount checkingAccount = new CheckingAccount(zac, 0, true);
		double expectedT1 = 100.0;

		// When (1)
		checkingAccount.setOverdraftLimit(100);
		double actualT1 = checkingAccount.getOverdraftLimit();

		// Then (1)
		Assert.assertEquals("setOverdraftLimitTest - limit >= 0 - expected number matched actual", expectedT1, actualT1,
				0);

		// Given (2)
		double expectedT2 = 0;

		// When (2)
		checkingAccount.setOverdraftLimit(-100);
		double actualT2 = 0;

		// Then (2)
		Assert.assertEquals("setOverdraftLimitTest - limit < 0 - expected number matched actual", expectedT2, actualT2,
				0);

	}
	
	@Test
	public void debitAccountTest(){
		
		//Given (1,2,3)
		AccountHolder zac = new Person("Zac", "J", "Effron");
		CheckingAccount checkingAccount = new CheckingAccount(zac, 0, true);	
		checkingAccount.creditAccount(100);
		
		// ------ Test 1, debit account outside of overdraft, normally
		
		// Given (1)
		double expected = 50.0;
		
		// When (1)
		checkingAccount.debitAccount(50);
		double actual = checkingAccount.getBalance();
		
		// Then (1)
		Assert.assertEquals("debitAccounTest() - regular debit test", expected, actual,0);		

		// ------ Test 2, debit account more than the overdraft limit 
		
		// Given (2)
		checkingAccount.setCanHaveOverdraft(true);
		checkingAccount.setOverdraftLimit(100);
		double expected2 = -50;
		
		// When (2)
		checkingAccount.debitAccount(100);
		double actual2 = checkingAccount.getBalance();
		
		// Then (3)
		Assert.assertEquals("debitAccounTest() - debit into allowed overdraft range", expected2, actual2,0);		
		
		// ------ Test 3, debit account within the overdraft limit and see if everything works.
		
		// Given (3)
		checkingAccount.debitAccount(100); // should not be allowed, and balance would be equal
		double expected3 = -50;
		
		//When (3)
		double actual3 = checkingAccount.getBalance();
		
		// Test (3)
		Assert.assertEquals("debitAccounTest() - debit into unallowed overdraft range", expected3, actual3,0);		
	}

}
