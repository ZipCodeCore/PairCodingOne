package accountHolders;

public class Business extends AccountHolder{

	private String businessName;
	
	public Business(String businessName) {
		this.businessName = businessName;
	}

	public String getName(){
		return this.getBusinessName();
	}
	
	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
}
