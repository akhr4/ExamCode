import java.util.Scanner;
class playgroup{
    public static void main(String args[]){
        int size = 6;
        String[] toddlers = {"ann","jen","jay","dan","liv","jim"};
        int[] ages = {3,4,5,2,3,4};
        boolean[] present = {false,false,false,false,false,false};
        int[] price = {0,0,0,0,0,0};
        menu(toddlers,ages,present,price);
    }

    public static String input(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static int inputint(String message){
        return Integer.parseInt(input(message));
    }

    public static void menu(String[] toddlers, int[] ages, boolean[] present, int[] price){
        int choice = -1;
        while (!(choice == 2)){
            choice = inputint("Do you wish to 1) Name a toddler 2) Print a summary");
            if (choice == 1){
                checktoddler(toddlers, ages,present,price);
            }
            if (choice !=1){
                System.out.println("That is an invalid input");
            }
        }
        summary(toddlers, ages,present,price);
    }

    public static void checktoddler(String[] toddlers, int[] ages, boolean[] present, int[] price){
        String name = input("Enter the name of the toddler").toLowerCase();
        boolean found = false;
        for (int i=0; i<toddlers.length; i++){
            if (toddlers[i].equals(name)){
                present[i] = true;
                if (ages[i] < 3){
                    price[i] = 3;
                }
                else{
                    price [i] = 5;
                }
                found = true;
                System.out.println(name + " is registered, charge " + price[i] + " pounds.");
            }
        }
        if (found == false){
            System.out.println("This child is not registered");
        }
    }

    public static void summary(String[] toddlers, int[] ages, boolean[] present, int[] price){
        System.out.println("This week, the following attended:");
        int total = 0;
        for (int i=0; i < present.length; i++){
            if (present[i] == true){
                System.out.println(toddlers[i] + " age " + ages[i]);
            }
        }
        for (int j=0; j<price.length; j++){
            total = total + price[j];
        }
        System.out.println("You should have collected " + total + " pounds this week");
        
    }
}
