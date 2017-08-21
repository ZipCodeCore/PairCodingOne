package io.zipcoder;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.zipcoder.account.SavingAccount;
import io.zipcoder.holder.AccountHolder;
import io.zipcoder.holder.Business;

public class SavingAccountTest {

	private SavingAccount target;
	
	@Before
	public void setup(){
		AccountHolder holderFixture = new Business("JP Morgan");
		target = new SavingAccount(holderFixture, new BigDecimal("10.00"), 100001, true, 3.5);
	}
	
	@Test
	public void test_withdraw_noProtected(){
		//:When
		target.withdraw(new BigDecimal("20.00"));
		//:Then
		Assert.assertEquals(new BigDecimal("-10.00"), target.getBalance());
	}
	
	@Test
	public void test_withdraw_isProtected(){
		//:When
		target.setCanOverDraft(false);
		target.withdraw(new BigDecimal("20.00"));
		//:Then
		Assert.assertEquals(new BigDecimal("10.00"), target.getBalance());
	}
	
	@Test
	public void test_withdraw_isProtectedEnoughFounds(){
		//:When
		target.setCanOverDraft(false);
		target.withdraw(new BigDecimal("5.00"));
		//:Then
		Assert.assertEquals(new BigDecimal("5.00"), target.getBalance());
	}
	
}
