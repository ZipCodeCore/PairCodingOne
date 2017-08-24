package io.zipcoder;

import org.junit.Test;
import org.junit.Assert;

public class TransactionTest {

	@Test
	public void createTransactionAndPrintToStringTest() {

		// Given
		Transaction t = new Transaction("intrest accured", 1.5, 101.5);
		String expected = "transaction type intrest accured. "
				+ "Transaction amount: £1.50, new balance is: £101.50";

		// When
		String actual = t.toString();

		// Then
		Assert.assertEquals("create a transaction and test the toString method, "
				+ "no error was thrown and string was as expected",
				expected, actual);
	}

}
