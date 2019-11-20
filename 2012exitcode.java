import java.util.Scanner;
class Main{
    public static String input(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static void main(String[] args){
        int size = 20;
        String[] newspaper = new String[size];
        String[] tabloid = new String[size];
        String[] wing = new String[size];
        String paperin = " ";
        String tabloidin;
        String wingin;
        int index = 0;
        while (!(paperin.equals("END"))){
            paperin = input("Newspaper: ");
            if (paperin.equals("END")){
                break;
            }
            newspaperstore(newspaper, paperin, index);
            tabloidin = input("Tabloid or Broadsheet");
            tabloidstore(tabloid,tabloidin, index);
            wingin = input("Left wing or right wing: ");
            wingstore(wing, wingin, index);
            index = index + 1; 
            
        }
        showarray(newspaper, tabloid, wing,index);
    }

    public static void newspaperstore(String[] newspaper, String paperin, int index){
        newspaper[index] = paperin;
    }

    public static void tabloidstore(String[] tabloid, String tabloidin, int index){
        tabloid[index] = tabloidin; 
    }

    public static void wingstore(String[] wing, String wingin, int index){
        wing[index] = wingin;
    }

    public static void showarray(String[] newspaper, String[] tabloid, String[] wing, int index){
    for (int i = 0; i < index; i++){
            System.out.println("The " + newspaper[i] + " is a " + wing[i] + " wing " + tabloid[i]);        }
    }
}
