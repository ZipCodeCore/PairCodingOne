package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class PersonalAccountHolderTest {
	@Test
	public void PersonalAccountHolderTest(){
		//Given
		PersonalAccountHolder test= new PersonalAccountHolder("halide", "bey", "I");
		String expected="halidebeyI";
		//When
		String actual = test.getFirstName()+test.getLastName()+test.getMiddleInitial();
		//Then
		Assert.assertEquals(actual,expected);
	}

}
