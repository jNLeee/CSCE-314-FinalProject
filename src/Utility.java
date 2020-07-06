/*
 * This class will be reading and parsing through a csv file and also be writing into a txt recording all the team pairs and another txt for error logging.
 * Name: Justin N. Lee
 * UIN: 727000824
 * Email: jlee232435@tamu.edu
 */

import java.io.*;  
import java.util.*;

public class Utility {
	String errorlogging = "Errors caught are logged in here: " + "\n"; //variable for adding errors into ErrorLogging.txt
	
	public boolean readFile(String inputFile) { //just checks to make sure the file is able to be read properly
		boolean doneRead = false;
		Scanner infile = null;
		try { 
			infile = new Scanner(new FileReader(inputFile)); 
			doneRead = true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found...");
			e.printStackTrace(); //prints errors
			System.exit(0); //exits the entire program
		}
		return doneRead;
	}
	
	public ArrayList<CSCE314Student> parseFile(String inputFile) { //takes care of all the actual file reading and parsing, afterwards it returns an array list with all the student info
		ArrayList<CSCE314Student> allStudentsList = new ArrayList<CSCE314Student>();
		Scanner infile = null;
		
		try { 
			infile = new Scanner(new FileReader(inputFile)); 
			infile.nextLine(); //skips the first line in csv
			while (infile.hasNextLine()) {
				String data = infile.nextLine(); //get the whole line and put into a string called data
				List<String> values = new ArrayList<String>(); //making array list to allow for easier modification of size in case of bad data
				String[] value_parse = data.split(","); //parsing the data by the commas
				
				for (int i = 0; i < value_parse.length; i++) {
					values.add(value_parse[i]);
				}
				if (values.size() > 8) { //accounts for the extra comma in "No, time to move on" from the data 
					values.remove(4);
				}
				
				ArrayList<Object> tempStud = new ArrayList<Object>();
				int JavaKnowledge = Integer.parseInt(values.get(1)); //converting the string knowledge to an integer
				tempStud.add(JavaKnowledge);
				
				String firstName = (values.get(4).split(" ")[0]);
				tempStud.add(firstName);
				
				String lastName = (values.get(4).split(" ")[1]);
				tempStud.add(lastName);

				String section = (values.get(5).split(" ")[0]);
				int Section = Integer.parseInt(section); //converting the string section to an integer
				tempStud.add(Section);
				
				String UIN = (values.get(6).split("@")[0]);
				tempStud.add(UIN);
				
				try { //check if rank is an integer and between 1-4 for the exception in input file
					int rank = Integer.parseInt(values.get(7)); //will throw an exception for ranks that aren't integers
					if (rank >= 1 && rank <= 4) { //if a valid rank then add to the list
						tempStud.add(rank);
						allStudentsList.add(new CSCE314Student((String)tempStud.get(1),(String)tempStud.get(2),(String)tempStud.get(4),(int)tempStud.get(0),(int)tempStud.get(3),(int)tempStud.get(5))); //adding the tempStud list into an allStudentsList
					}
					else { //an out of bounds rank will log that student into the ErrorLog.txt
						errorlogging = errorlogging + "In the file Uility.java, the student " + tempStud.get(1) + " " + tempStud.get(2) + " from Section " + tempStud.get(3) + " has an invalid rank value not in the range of 1-4." + "\n";
					}
				} catch (NumberFormatException rankError) { //a non integer rank will log that student into the ErrorLog.txt
					errorlogging = errorlogging + "In the file Uility.java, the student " + tempStud.get(1) + " " + tempStud.get(2) + " from Section " + tempStud.get(3) + " has an invalid, non integer rank value." + "\n";
				}
			}
			infile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found...");
			e.printStackTrace(); //prints errors
			System.exit(0); //exits the entire program
		}
		return allStudentsList;
	}
	
	public boolean writeFile(ArrayList<CSCE314Student[]> teambuild, String outputFile) {
		boolean doneWrite = false;
		try { //Create a new file that will print in the team pairs
			FileWriter outfile = new FileWriter("results.txt", false); 
			for (int i = 0; i < teambuild.size(); i++) { //iterating through teambuild size and and output each pair into the desired format onto a txt
				outfile.write(teambuild.get(i)[0].getsection() + " - " + teambuild.get(i)[0].getfirstName() + " " + teambuild.get(i)[0].getlastName() + " " + "(" + teambuild.get(i)[0].getJavaKnowledge() + ")" + " " + teambuild.get(i)[1].getfirstName() + " " + teambuild.get(i)[1].getlastName() + " " + "(" + teambuild.get(i)[1].getJavaKnowledge() + ")" + "\n");
			}
			outfile.close();
			doneWrite = true;
		} catch (IOException e) {
			System.out.println("File not found...");
			e.printStackTrace(); //prints errors
			System.exit(0); //exits the entire program
		}
		try { //Create a new file that will log in the errors caught
			FileWriter errorfile = new FileWriter("ErrorLog.txt");
			errorfile.write(errorlogging);
			errorfile.close();
		} catch (IOException e) {
			System.out.println("File not found...");
			e.printStackTrace(); //prints errors
			System.exit(0); //exits the entire program
		}
		return doneWrite;
	}
}
