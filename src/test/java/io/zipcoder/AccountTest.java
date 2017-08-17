package io.zipcoder;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class AccountTest {
	
	private InvestmentAccount target;
	
	@Before
	public void setup(){
	 AccountHolder holderFixture = new PersonalAccountHolder("Jhonny", "Anything", "Tom");	
	 target = new InvestmentAccount(holderFixture,new BigDecimal("10.00"),100000001, 3.5);	
	}
	
	@Test
	public void test_deposit_success(){
		//:Given
		boolean result = target.deposit(new BigDecimal("3.00"));
		//:When
		
		//:Then
		Assert.assertTrue(result);
		Assert.assertEquals(new BigDecimal("13.00"), target.getBalance());
		
	}
	
	@Test
	public void test_deposit_amountUnderZero(){	
		//:Given
		boolean result = target.deposit(new BigDecimal("-3.00"));
		//:When
				
		//:Then
		Assert.assertFalse(result);
	}
	
	@Test
	public void test_withdraw_success(){
		//:Given
		
		//:When
		boolean result = target.withdraw(new BigDecimal("2.00"));
		
		//:Then
		Assert.assertTrue(result);
		Assert.assertEquals(new BigDecimal("8.00"), target.getBalance());
	}
	
	@Test
	public void test_withdraw_amountUnderZero(){
		//:Given
		
		//:When
		boolean result = target.withdraw(new BigDecimal("-2.00"));
		
		//:Then
		Assert.assertFalse(result);
	
	}
	
	@Test
	public void test_withdraw_overdraft(){
		//:Given
		
		//:When
		boolean result = target.withdraw(new BigDecimal("20.00"));
		
		//:Then
		Assert.assertTrue(result);
		Assert.assertEquals(new BigDecimal("-10.00"), target.getBalance());
	
	}
	
	@Test
	public void test_printTransactions_success(){
		//:Given
		
		target.deposit(new BigDecimal("30.00"));
		target.withdraw(new BigDecimal("10.00"));
		//:When
		String result = target.printTransactions(2);
		
		String expected ="Transaction: [Type=" + "WITHDRAWAL" + ", Amount=" + "10.00" + ", Remaining Balance=" + "30.00" + "]\n"+
				         "Transaction: [Type=" + "DEPOSIT" + ", Amount=" + "30.00" + ", Remaining Balance=" + "40.00" + "]\n";
				         
						 
		//:Then
		
		Assert.assertEquals(expected, result);
		
		
	}
	
	
	
}
