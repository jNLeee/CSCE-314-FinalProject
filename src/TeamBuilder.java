/*
 * This class will be actually building the teams by using the CSCE314Student, Utility, and JavaKnowledgeComparator class.
 * Name: Justin N. Lee
 * UIN: 727000824
 * Email: jlee232435@tamu.edu
 */

import java.util.*;

public class TeamBuilder { //the main component of the program which makes the teams
	
	ArrayList<CSCE314Student[]> teambuild = new ArrayList<CSCE314Student[]>(); //array list that will contain all the correctly paired students
	ArrayList<CSCE314Student> combinedSections = new ArrayList<CSCE314Student>(); //array list that will contain all the students for all sections
	ArrayList<CSCE314Student> Section502 = new ArrayList<CSCE314Student>(); //array list that will contain all the 502 students
	ArrayList<CSCE314Student> Section503 = new ArrayList<CSCE314Student>();	//array list that will contain all the 503 students
	JavaKnowledgeComparator compare = new JavaKnowledgeComparator();
	Utility util = new Utility();
	
	public void makeTeam(String fileToRead, String fileToWrite) {
		
		if (util.readFile(fileToRead) == true) { //if it returns true than fill the array list with all the students from all sections in the input.csv	
			combinedSections = util.parseFile(fileToRead);
		}
		combinedSections.sort(compare); //sort all the students by their java knowledge
		
		for (int i = 0; i < combinedSections.size(); i++) { //iterating through all of the students in combinedSections
			if (502 == combinedSections.get(i).getsection()) { //for the students in section 502 add to their own list
				Section502.add(combinedSections.get(i));
			}
			else if (503 == combinedSections.get(i).getsection()) { //for the students in section 503 add to their own list
				Section503.add(combinedSections.get(i));
			}
		}
		
		if (Section502.size() % 2 == 0) { //if number of students isn't odd
			int j = Section502.size()-1; //starts j at the last index 
			for (int i = 0; i < (Section502.size()/2); i++) { //iterating through half of the section 502 size
				CSCE314Student[] pairs502 = new CSCE314Student[2];
				pairs502[0] = Section502.get(i);
				pairs502[1] = Section502.get(j);
				teambuild.add(pairs502); //add the section 502 pairs to the main teambuild array list
				--j;
			}
		}
		else { //otherwise if the number of students is odd then account for the student sub
			int j = Section502.size()-2; //starts j at the last index 
			for (int i = 0; i < (Section502.size()/2); i++) { //iterating through half of the section 502 size
				CSCE314Student[] pairs502 = new CSCE314Student[2];
				pairs502[0] = Section502.get(i);
				pairs502[1] = Section502.get(j);
				teambuild.add(pairs502); //add the section 502 pairs to the main teambuild array list
				--j;
			}
			CSCE314Student[] nopair = new CSCE314Student[2]; //a list for the sub and chosen from highest javaknowledge
			nopair[1] = new CSCE314Student();
			int i = Section502.size()-1;
			nopair[0] = Section502.get(i); 
			teambuild.add(nopair); //add the section 502 sub to the end of the main teambuild array list
		}
		
		if (Section503.size() % 2 == 0) { //if number of students isn't odd
			int j = Section503.size()-1; //starts j at the last index 
			for (int i = 0; i < (Section503.size()/2); i++) { //iterating through half of the section 503 size
				CSCE314Student[] pairs503 = new CSCE314Student[2]; //making a list of 503 pairs
				pairs503[0] = Section503.get(i);
				pairs503[1] = Section503.get(j);
				teambuild.add(pairs503); //add the section 503 pairs to the main teambuild array list
				--j;
			}
		}
		else { //otherwise if the number of students is odd then account for the student sub
			int j = Section503.size()-2; //starts j at the last index 
			for (int i = 0; i < (Section503.size()/2); i++) { //iterating through half of the section 503 size
				CSCE314Student[] pairs503 = new CSCE314Student[2]; //making a list of 503 pairs
				pairs503[0] = Section503.get(i);
				pairs503[1] = Section503.get(j);
				teambuild.add(pairs503); //add the section 503 pairs to the main teambuild array list
				--j;
			}
			CSCE314Student[] nopair = new CSCE314Student[2]; //a list for the sub and chosen from highest javaknowledge
			nopair[1] = new CSCE314Student();
			int i = Section503.size()-1;
			nopair[0] = Section503.get(i);
			teambuild.add(nopair); //add the section 503 sub to the end of the main teambuild array list
		}
 		
		util.writeFile(teambuild, fileToWrite); //will write all of the team pairs from the teambuild array list into the results.txt
	}
}
