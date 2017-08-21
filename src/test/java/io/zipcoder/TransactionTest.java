package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {
	@Test
	public void PersonalAccountHolderTest(){
		//Given
		Transaction test = new Transaction (50.0, 2.0);
		double expected=50.0;
		//When
		double actual = test.getAmount();
		//Then
		Assert.assertEquals(actual,expected);
	}

}
