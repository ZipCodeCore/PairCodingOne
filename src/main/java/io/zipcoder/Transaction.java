package io.zipcoder;

//import java.util.Date;

public class Transaction {
	
	//private Date timeStamp;
	private final String type;
	private final double transactionAmount;
	private final double newBalance;
	
	public Transaction(String type, double transactionAmount, double newBalance){
		this.type = type;
		this.transactionAmount = transactionAmount;
		this.newBalance = newBalance;
		//this.timeStamp = new Date();
	}
	
	/**
	 * @return the transactionAmount
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}
	/**
	 * @return the remaining
	 */
	public double getRemaining() {
		return newBalance;
	}
	
	public String toString(){
		return String.format("transaction type %s. Transaction amount: £%.2f, new balance is: £%.2f",this.type, getTransactionAmount(), getRemaining());
		//return "transaction type " + this.type + ". Transaction amount: £" + this.transactionAmount + ", new balance is: £" + this.newBalance;
	}
}
