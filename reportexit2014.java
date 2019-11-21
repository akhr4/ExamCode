import java.util.Scanner;
class reportCard{

    public static void main(String[] args){
        int size = 10; //Set to 500
        String[] Student = new String[size];
        int[] maths = new int[size];
        int[] computing = new int[size];
        int[] english = new int[size];
        String studentName = "a";
        int len = -1;
        while (!(studentName.equals("0"))){
            len = len+1;
            studentName = input("Enter the student name:"); 
            if (studentName.equals("0")){
                break;
            }
            Student[len] = studentName;
        }
        mathresults(size, Student,maths,len);
        compresults(size, Student,computing,len);
        englishresults(size, Student,english,len);
        report(size, Student,maths,computing, english, len);
    }

    public static String input(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputint(String message){
        return Integer.parseInt(input(message));
    }

    public static void mathresults(int size, String[] Student, int[] maths, int len){
        for (int i=0; i< len; i++){
            maths[i] = inputint("What is the predicted Mathematics grade for " + Student[i]);
        }
    }

    public static void compresults(int size, String[] Student, int[] computing, int len){
        for (int i=0; i< len; i++){
            computing[i] = inputint("What is the predicted Computing grade for " + Student[i]);
        }
    }

    public static void englishresults(int size, String[] Student, int[] english, int len){
        for (int i=0; i< len; i++){
            english[i] = inputint("What is the predicted English grade for " + Student[i]);
        }
    }

    public static void report(int size, String[] Student,int[] maths,int[] computing, int[] english, int len){
        for(int i=0; i <len; i++){
            System.out.println("The report card for " + Student[i] + "\n Mathematics: " + maths[i] + "\n Computing: " + computing[i]+ "\n English: " + english[i]);
        }     
    }
}