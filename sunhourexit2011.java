import java.util.Scanner;
class sunshine{
    public static void main(String[] args){
        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        int[] sunhours = new int[7];
        entersun(days, sunhours);
        forcast(days,sunhours);        
        }

    public static void entersun(String[] days, int[] sunhours){
        int hour = 2;
        for (int i=0; i<days.length; i++){
            hour = inputInt("Enter the amount of hours on day " + days[i]);
            while (!(hour > 0)){
                System.out.print("You can't have negative hours!");
                hour = inputInt("Enter the amount of hours on day " + days[i]);
            }
            sunhours[i] = hour;
        }
    }

    public static void forcast(String[] days, int[] sunhours){
        String description; 
        for (int i=0; i<days.length; i++){
            if (sunhours[i] < 3){
                description = "dull";
                System.out.println("On " + days[i] + " there was " + sunhours[i] + " of sunshine. It was a " + description + " day.");
            }
            else if (sunhours[i] > 2 && sunhours[i] < 6){
                description = "nice";
                System.out.println("On " + days[i] + " there was " + sunhours[i] + " of sunshine. It was a " + description + " day.");
            }
            else if  (sunhours[i] > 5){
                description = "scorching";
                System.out.println("On " + days[i] + " there was " + sunhours[i] + " of sunshine. It was a " + description + " day.");
            }
        }
    }

    public static int inputInt(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}