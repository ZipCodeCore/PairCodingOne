package io.zipcoder;
import org.junit.Assert;
import org.junit.Test;
public class SavingsAccountTest {
	@Test
	public void withdrawalTest(){
		//Given
		PersonalAccountHolder testAccount= new PersonalAccountHolder ("halide","bey","I");
		SavingsAccount testSavingsAccount = new SavingsAccount(true, 5.0, testAccount, 100.0, 9);
		boolean expected=true;
		//When
		boolean actual=testSavingsAccount.withdrawal(50);
		//Then
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void withdrawalNegativeTest(){
		//Given
		PersonalAccountHolder testAccount= new PersonalAccountHolder ("halide","bey","I");
		SavingsAccount testSavingsAccount = new SavingsAccount(true, 5.0, testAccount, 100.0, 9);
		boolean expected=false;
		//When
		boolean actual=testSavingsAccount.withdrawal(150);
		//Then
		Assert.assertEquals(expected, actual);
	}

}
