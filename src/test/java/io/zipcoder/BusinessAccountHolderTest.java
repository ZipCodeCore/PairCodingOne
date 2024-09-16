package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;


public class BusinessAccountHolderTest {
	@Test
	public void BusinessAccountHolderTest() {
		//Given
		BusinessAccountHolder test = new BusinessAccountHolder("NAME");
		String expected="NAME";
		//When
		String actual = test.getBizName();
		//Then
		Assert.assertEquals(expected, actual);
		
	}

}
