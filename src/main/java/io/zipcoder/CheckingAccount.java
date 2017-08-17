package io.zipcoder;

import java.math.BigDecimal;

public class CheckingAccount extends Account {
	
	private boolean canOverDraft;


	public CheckingAccount(AccountHolder accountHolder, BigDecimal balance, long accountNumber, boolean canOverDraft) {
		super(accountHolder, balance, accountNumber);
		this.canOverDraft=canOverDraft;
	}


	public boolean isCanOverDraft() {
		return canOverDraft;
	}


	public void setCanOverDraft(boolean canOverDraft) {
		this.canOverDraft = canOverDraft;
	}

	@Override
	public boolean withdraw(BigDecimal amount){
		return false;
	}
	
	
	
	

}
