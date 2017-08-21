package accountHolders;

public class Person extends AccountHolder{
	
	private String firstName;
	private String middleInitials;
	private String lastName;
	
	
	//TODO:
	// ??? toString - returns output of getName ???
	
	public Person(String firstName, String middleInitials, String lastName){
		setFirstName(firstName);
		setMiddleInitials(middleInitials);
		setLastName(lastName);
	}
	
	public String getName(){
		return getFirstName() + " " + getMiddleInitials() + " " + getLastName(); // format??
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleInitials
	 */
	public String getMiddleInitials() {
		return middleInitials;
	}
	/**
	 * @param middleInitials the middleInitials to set
	 */
	public void setMiddleInitials(String middleInitials) {
		this.middleInitials = middleInitials;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
