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
		students = Student.createStudentListFromFile(filepathname);; //Call the given static method in the Student class for reading from file: Student.createStudentListFromFile(filepathname);
	
		System.out.println("Total number of students: " + students.length);
		System.out.print("Enter the number of team: ");	
		int numOfTeams = in.nextInt();

		if(students.length%numOfTeams!=0){
			System.out.println("Wrong input - It is not a factor of " + students.length);
			in.close();
			return;
		}

		Team[] teams; //Define an array of teams: Team [] 
		teams = createTeams(students , numOfTeams);//Call the private method (one of the 3 methods in Main.java) to create the teams for students: createTeams(students);

		
		//Print the grouping result:
		System.out.println("\nGrouping result: ");				
		System.out.println(teams[0].toString());
		System.out.println(teams[1].toString());
		System.out.println(teams[2].toString());
		System.out.println(teams[3].toString());
		System.out.println(teams[4].toString());
		
		//Create the assignments
		Assignment[] assignments; //Define an array of assignments: Assignment[] assignments 
		assignments = decideTasks(teams, in);//Call the private method (one of the 3 methods in Main.java) to input the tasks for each team: decideTasks(teams, in); 
		
		//Display sorted listing by tasks:
		System.out.println("\nSorted listing by tasks: ");
		Assignment.printTaskTeam("Lab05", assignments);
		Assignment.printTaskTeam("Lab06", assignments);
		Assignment.printTaskTeam("Lab07", assignments);
		Assignment.printTaskTeam("Lab08", assignments);
		Assignment.printTaskTeam("Lab09", assignments);
		
		in.close();
	}

	private static Team[] createTeams(Student[] students, int numOfTeams) 
	{
		Team[] result; //Define an array of teams to store the result: Team[] result;
		result = new Team[numOfTeams]; //Create the array: new Team[5];

		int left =0;
		int studentPerTeam = students.length/numOfTeams;

		for(int i=0;i<numOfTeams;i++){
			char teamLetter = (char)('A'+i);	
			result[i] = new Team("Team " + teamLetter, Arrays.ccopyOfRange(students,left,right));
			left= right;
			right=(students.length-left)/numOfTeams;
		}
		return result; //Return the result: return result;
	}

	//assignment of lab tasks to teams based on user input
	private static Assignment[] decideTasks(Team[] teams, Scanner in)
	{
		Assignment[] assignments; //Define an array of assignments to store the result: Assignment[] assignments;
		assignments = new Assignment[5]; //Create the array: new Assignment[5];
				
		System.out.println("\nEnter tasks for the teams (Lab05,Lab06,Lab07,Lab08,Lab09): ");
		for (int i=0; i<5; i++)
		{
			System.out.print(teams[i].getName() + ": "); //Prompt for a team: teams[i].getName()
			String taskName = in.next(); //Get user input of the task name from keyboard: in.next();
			assignments[i] = new Assignment(teams[i], new Task(taskName)); //Create the assignment for:  teams[i], new Task(taskName)
		}
		return assignments; //Return the result: return assignments;
	}

}
