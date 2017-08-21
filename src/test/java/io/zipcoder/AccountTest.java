package io.zipcoder;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import io.zipcoder.account.Account;
import io.zipcoder.holder.AccountHolder;
import io.zipcoder.holder.Person;

import org.junit.Assert;

public class AccountTest {
	
	class AccountFixture extends Account{

		public AccountFixture(AccountHolder accountHolder, BigDecimal balance, long accountNumber) {
			super(accountHolder, balance, accountNumber);
		}
		
	}
	
	private Account target;
	
	@Before
	public void setup(){
	 AccountHolder holderFixture = new Person("Jhonny", "Anything", "Tom");	
	 target = new AccountFixture(holderFixture,new BigDecimal("10.00"),100000001);	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_createAccount_negativeBalance(){
		//:Given	
		AccountHolder holderFixture = new Person("Jhonny", "Anything", "Tom");	
		//:When
		new AccountFixture(holderFixture, new BigDecimal("-10.00"), 1000002);
		
	}
	
	@Test
	public void test_deposit_success(){
		//:When
		target.deposit(new BigDecimal("3.00"));
		//:Then
		Assert.assertEquals(new BigDecimal("13.00"), target.getBalance());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_deposit_amountUnderZero(){	
		
		//:When
		target.deposit(new BigDecimal("-3.00"));
	}
	
	@Test
	public void test_withdraw_success(){

		//:When
		target.withdraw(new BigDecimal("2.00"));
		
		//:Then
		Assert.assertEquals(new BigDecimal("8.00"), target.getBalance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_withdraw_amountUnderZero(){
		
		//:When
		target.withdraw(new BigDecimal("-2.00"));		
	
	}
	
	@Test
	public void test_withdraw_overdraft(){
		//:Given
		
		//:When
		target.withdraw(new BigDecimal("20.00"));
		
		//:Then
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
