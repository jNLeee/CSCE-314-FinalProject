/*
 * This class will be the main driver and puts together the teamMaker: TeamBuilder.
 * Name: Justin N. Lee
 * UIN: 727000824
 * Email: jlee232435@tamu.edu
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("This team building program reads in a input.csv file and the outputs a results.txt and ErrorLog.txt file.\n");
		TeamBuilder teamBuild = new TeamBuilder(); //making my TeamBuilder object
		teamBuild.makeTeam("input.csv", "results.txt");
	}
}
