import java.util.Scanner;
class airport{
    public static void main(String[] args){
        int quant = 10;
        String[] passengers = new String[quant];
        enterPass(passengers);
        checkPass(passengers);
    }

    public static String input(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void enterPass(String[] passengers){
        for (int i=0; i<passengers.length; i++){
            passengers[i] = input("Enter passenger " + (i+1) + ":");
        }
    }
    
    public static void checkPass(String[] passengers){
        String quiery = input("Enter the passenger you want to check");
        boolean found = false;
        while (!(quiery.equals("END"))){
            for (int i =0; i <passengers.length; i++){
                if (passengers[i].equals(quiery)){
                    found = true;
                    break;
                }
            }
        if (found){
            System.out.println(quiery + " has been found");
        }
        else{
            System.out.println(quiery + " does not have a ticket");
        }
        found = false; 
        quiery = input("Enter the passenger you want to check");  
        }   
    }
}
