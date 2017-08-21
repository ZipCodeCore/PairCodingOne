package io.zipcoder.transaction;

import java.math.BigDecimal;

public class Transaction {
	
	private final TransactionType type;
	private final BigDecimal amount;
	private final BigDecimal remainingBalance;
	
	
	public Transaction(TransactionType type, BigDecimal amount, BigDecimal remainingBalance ){
		
		this.type = type;
		this.amount = amount;
		this.remainingBalance = remainingBalance;
		
	}


	@Override
	public String toString() {
		return "Transaction: [Type=" + type + ", Amount=" + amount + ", Remaining Balance=" + remainingBalance + "]";
	}
	
	

}
