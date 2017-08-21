package io.zipcoder.account;

import java.math.BigDecimal;

import io.zipcoder.holder.AccountHolder;

public class SavingAccount extends InvestmentAccount{
	
	private boolean canOverDraft;


	public SavingAccount(AccountHolder accountHolder, BigDecimal balance, long accountNumber, boolean canOverDraft,double interestRate) {
		super(accountHolder, balance, accountNumber,interestRate);
		this.canOverDraft=canOverDraft;
	}


	public boolean isCanOverDraft() {
		return canOverDraft;
	}


	public void setCanOverDraft(boolean canOverDraft) {
		this.canOverDraft = canOverDraft;
	}

	@Override
	public void withdraw(BigDecimal amount){
		if(amount.subtract(this.getBalance()).compareTo(BigDecimal.ZERO)>0){
			if(isCanOverDraft()){
				super.withdraw(amount);
			}else{
				System.out.println("This accoun't doesn't have enough founds.");
			}
		}else{
			super.withdraw(amount);
		}
	}

}
