package io.zipcoder;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import io.zipcoder.account.InvestmentAccount;
import io.zipcoder.holder.AccountHolder;
import io.zipcoder.holder.Business;

public class InvestmentAccountTest {
	
	private InvestmentAccount target;
	
	
	
	@Before
	public void setup(){
		AccountHolder holderFixture = new Business("JP Morgan");
		target = new InvestmentAccount(holderFixture, new BigDecimal("10.00"), 1000001, 3.5);
	}
	
	@Test
	public void test_applyInterest_success(){
		//:Given
		
		
	}

}
