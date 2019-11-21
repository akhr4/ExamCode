import java.util.Scanner;

class football{
    public static void main(String[] args){
        int size = 8;
        String[] hometeam = new String[size];
        String[] awayteam = new String[size];
        int[] hometeamscore = new int[size];
        int[] awayteamscore = new int[size];
        addMatches(size, hometeam,awayteam);
        for (int i= 0; i <size; i++){
            addScores(size,hometeam, awayteam, hometeamscore, awayteamscore);
        }
        printScores(size,hometeam, awayteam, hometeamscore, awayteamscore);
    }

    public static void addMatches(int size,String[] hometeam, String[] awayteam){
        for (int i=0; i<size; i++){
            hometeam[i] = input("Enter the name of hometeam " + (i+1));
            awayteam[i] = input("Enter the name of the awayteam " + (i+1));
        }
    }

    public static void addScores(int size, String[] hometeam, String[] awayteams, int[] hometeamscore, int[] awayteamscore){
        int index = -1;
        boolean found = false;
        for (int i= 0; i<size;i++){
            while (!(found)){
                String added = input("Enter the name of the home team you want to add the score for");
                for (int j=0; j<size; j++){
                    if (hometeam[j].equals(added)){
                        index = j;
                        found = true;
                        hometeamscore[index] = inputInt("Enter the home team's score");
                        awayteamscore[index] = inputInt("Enter the away team's score");
                    }
                }
                if (found == false){
                    System.out.println("That team is not recognised");
                }   
                
            }
            
        }
    }

    public static void printScores(int size, String[] hometeam, String[] awayteam, int[] hometeamscore, int[] awayteamscore){
        for (int i =0; i<size; i++){
            System.out.println((i+1) + " The home team " + hometeam[i] + " scored " + hometeamscore[i] + " and the away team, " + awayteam[i] + " scored " + awayteamscore[i]);
        }
    }

    public static String input(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputInt(String message){
        return Integer.parseInt(input(message));
    }
}
