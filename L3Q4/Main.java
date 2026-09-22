import java.util.*;
import java.io.*;

public class Main{
	
	//Your task:
	//Todo(1) the main() method --- see Main_GivenCode.txt
	//Todo(2) the createTeams() method --- see Main_GivenCode.txt
	//Todo(3) the decideTasks() method --- see Main_GivenCode.txt
	public static void main(String [] args) throws FileNotFoundException
	{	
		System.out.print("Please input the file pathname: ");
		Scanner in = new Scanner(System.in);
		String filepathname = in.nextLine();
		
		Student[] students; //Define an array of students: Student[] students;
		students = Student.createStudentListFromFile(filepathname); //Call the given static method in the Student class for reading from file: Student.createStudentListFromFile(filepathname);
		
		System.out.println("\nTotal number of students: " + students.length);
		System.out.print("\nEnter the number of teams: ");
		int numOfTeams = in.nextInt();

		if(students.length % numOfTeams != 0){
			System.out.println("\nWrong input - It is not a factor of " + students.length+".");
			return;
		}

		Team[] teams; //Define an array of teams: Team [] 
		teams = createTeams(students,numOfTeams);//Call the private method (one of the 3 methods in Main.java) to create the teams for students: createTeams(students);
		
		//Print the grouping result:
		System.out.println("\nGrouping result:");				

		for(int i=0;i<numOfTeams;i++){
			System.out.println(teams[i].toString());
		}

		

		System.out.print("\nEnter " + numOfTeams +" task names (eg. \"Lab05 Lab06 Lab07 ..\"): ");
		String[] taskname = new String[numOfTeams];
		for(int i=0;i<numOfTeams;i++){
			taskname[i] = in.next();
		}
		//Create the assignments
		Assignment[] assignments; //Define an array of assignments: Assignment[] assignments 
		assignments = decideTasks(teams, in,numOfTeams,taskname);//Call the private method (one of the 3 methods in Main.java) to input the tasks for each team: decideTasks(teams, in); 
		
		//Display sorted listing by tasks:
		System.out.println("\nSorted listing by tasks:");

		for(int i=0;i<numOfTeams;i++){
			Assignment.printTaskTeam(taskname[i], assignments);
		}
	}

	private static Team[] createTeams(Student[] students, int numOfTeams) 
	{
		Team[] result; //Define an array of teams to store the result: Team[] result;
		result = new Team[numOfTeams]; //Create the array: new Team[5];
		
		int studentsPerTeam = students.length / numOfTeams;
        
        for (int i = 0; i < numOfTeams; i++) {
            char teamLetter = (char) ('A' + i);
            String teamName = "Team " + teamLetter;
            int startIndex = i * studentsPerTeam;
            int endIndex = startIndex + studentsPerTeam;
            
            result[i] = new Team(teamName, Arrays.copyOfRange(students, startIndex, endIndex));
        }
        
        return result;
	}

	//assignment of lab tasks to teams based on user input
	private static Assignment[] decideTasks(Team[] teams, Scanner in,int numOfTeams, String[] name)
	{
		Assignment[] assignments; //Define an array of assignments to store the result: Assignment[] assignments;
		assignments = new Assignment[numOfTeams]; //Create the array: new Assignment[5];

		System.out.print("\nEnter tasks for the teams (");
		for(int i=0;i<numOfTeams;i++){
			System.out.print(name[i]);
			if(i<numOfTeams-1){
					System.out.print(",");
				}
			}
			System.out.println("):");
		
		

		for (int i=0; i<numOfTeams; i++)
		{
			System.out.print(teams[i].getName() + ": "); //Prompt for a team: teams[i].getName()
			String taskName = in.next(); //Get user input of the task name from keyboard: in.next();
			assignments[i] = new Assignment(teams[i], new Task(taskName)); //Create the assignment for:  teams[i], new Task(taskName)
		}
		return assignments; //Return the result: return assignments;
	}

}
