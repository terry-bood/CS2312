import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Attendance {
    private int[] students;
    private int[] attendees;

    public Attendance() throws FileNotFoundException {
        students = new int[20];
		attendees = new int[20];
		Scanner sStudents = new Scanner(new File("StudentList.txt"));
		Scanner sAttendees = new Scanner(new File("AttendanceLog.txt"));
        for(int i=0;i<20;i++){
            students[i] = sStudents.nextInt();
            attendees[i] = sAttendees.nextInt();
        }

        
    	sStudents.close();
		sAttendees.close();

    }

    public boolean belongToClass(int studentID){
        for(int i=0;i<20;i++){
            if(students[i]==studentID)
                return true;
        }
        return false;
    }

    public boolean isPresent(int studentID){
        for(int i=0;i<20;i++){
            if(attendees[i]==studentID)
                return true;
        }
        return false;
    }
    
    public void istAbsentees(){
        int count = 0;
        System.out.println("List of absentees:");
        for(int i=0;i<20;i++){
            if(!isPresent(students[i])){
                System.out.println(students[i]);
                count++;
            }
        }
        System.out.println("Total count: " + count);
        System.out.println();
    }

    public void listWalkIn(){
        System.out.println("List of walk-in students:");
        for(int i=0;i<20;i++){
            if(!belongToClass(attendees[i]) && attendees[i] !=0){
                System.out.println(attendees[i]);
            }
        }
    }
    
}
