package io.zipcoder;

public class BusinessAccountHolder extends AccountHolder {
	private final String BUSINESSNAME;
	
	public BusinessAccountHolder (String bizname){
		this.BUSINESSNAME=bizname;
	}
	public String getBizName (){
		return BUSINESSNAME;
	}
}
