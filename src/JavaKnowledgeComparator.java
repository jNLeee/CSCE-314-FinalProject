/*
 * This class will be making comparisons between the student's knowledge of Java and sort them accordingly.
 * Name: Justin N. Lee
 * UIN: 727000824
 * Email: jlee232435@tamu.edu
 */

import java.util.*;

public class JavaKnowledgeComparator implements Comparator<CSCE314Student> {
	public int compare(CSCE314Student stud1, CSCE314Student stud2) {
		if (stud1.getJavaKnowledge() > stud2.getJavaKnowledge()) {return 1;} // return > 0, then stud1 has more Java experience
		else if (stud1.getJavaKnowledge() < stud2.getJavaKnowledge()) {return -1;} // return < 0, then stud2 has more Java experience
		else {return 0;} // return = 0, then both students have same Java experience
	}
}
