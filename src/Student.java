/*
 * This class will inherit from the Person class and get the UIN and Rank of the students.
 * Name: Justin N. Lee
 * UIN: 727000824
 * Email: jlee232435@tamu.edu
 */

public class Student extends Person{
	private String UIN;
	private Rank rank;
	
	public enum Rank {Freshman, Sophomore, Junior, Senior;} 
	
	public Student(String firstName, String lastName, String UIN, int rankNum) { //Student constructor
		super(firstName, lastName);
		this.UIN = UIN;
		setRank(rankNum);
	}
	
	public String getUIN() {return UIN;}
	public void setUIN(String UIN) {this.UIN = UIN;}
	public void setRank(int rank) { //assigning each class rank to its appropriate numbering
		if (rank == 1) {this.rank = Rank.Freshman;}
		else if (rank == 2) {this.rank = Rank.Sophomore;}
		else if (rank == 3) {this.rank = Rank.Junior;}
		else if (rank == 4) {this.rank = Rank.Senior;}
	}
	
	public String toString() {return UIN;}
}
