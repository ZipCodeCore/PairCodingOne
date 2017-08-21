package io.zipcoder.accountHolders;

import org.junit.Assert;
import org.junit.Test;

import accountHolders.Person;

public class PersonTest {

	@Test
	public void testGetName() {
		
		boolean couldCreateAccount = true;
		
		try{
			// Given
			Person p = new Person ("Alfred","H.G.","Wells");
			String expected = "Alfred H.G. Wells";
			
			// When
			String actual = p.getName();
			
			// Then
			Assert.assertEquals("testGetName() - strings were equal",expected, actual);
			
		} catch (Exception e) {
			couldCreateAccount = false;
		}
		Assert.assertTrue("testGetName() - failed to create a person",couldCreateAccount);
	}

}
