/*
 * This class will be an abstract class that will get the first and last names of the students.
 * Name: Justin N. Lee
 * UIN: 727000824
 * Email: jlee232435@tamu.edu
 */

public abstract class Person {
	
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) { //Person constructor
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getfirstName() {return firstName;}
	public String getlastName() {return lastName;}
	public void setfirstName(String firstName) {this.firstName = firstName;}
	public void setlastName(String lastName) {this.lastName = lastName;}
	public String toString() {return firstName + " " + lastName;}
}
