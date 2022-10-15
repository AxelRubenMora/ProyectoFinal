package doll;

public class Person {
	protected String firstName;
	protected String midleName;
	protected String firstSourName;
	protected String SecondSurName;
	
	public Person() {
		
	}
	public Person(String firstName, String midleName, String firstSourName, String secondSurName) {
		super();
		this.firstName = firstName;
		this.midleName = midleName;
		this.firstSourName = firstSourName;
		this.SecondSurName = secondSurName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidleName() {
		return midleName;
	}
	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}
	public String getFirstSourName() {
		return firstSourName;
	}
	public void setFirstSourName(String firstSourName) {
		this.firstSourName = firstSourName;
	}
	public String getSecondSurName() {
		return SecondSurName;
	}
	public void setSecondSurName(String secondSurName) {
		this.SecondSurName = secondSurName;
	}
}
