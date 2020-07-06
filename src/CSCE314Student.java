/*
 * This class will inherit from the Student class and get the JavaKnowledge and section number of students.
 * Name: Justin N. Lee
 * UIN: 727000824
 * Email: jlee232435@tamu.edu
 */

public class CSCE314Student extends Student {
	private int JavaKnowledge;
	private int section;
	
	public CSCE314Student() { //default constructor
		super("", "", "", 0);
		JavaKnowledge = 0;
		section = 0;
	}
	
	public CSCE314Student(String firstName, String lastName, String UIN, int JavaKnowledge, int section, int rankNum) { //CSCE314Student constructor
		super(firstName, lastName, UIN, rankNum);
		this.JavaKnowledge = JavaKnowledge;
		this.section = section;
	}
	
	public int getJavaKnowledge() {return JavaKnowledge;}
	public int getsection() {return section;}
	public void setJavaKnowledge(int JavaKnowledge) {this.JavaKnowledge = JavaKnowledge;}
	public void setsection(int section) {this.section = section;}

	public String toString() {return getsection() + " " + getJavaKnowledge();}
}
