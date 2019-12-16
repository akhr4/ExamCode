import java.util.Scanner;
class Main{
    public static void main(String[] args){
        int size = 50;
        String[] item = new String[size];
        int[] quantity = new int[size];
        int[] price = new int[size];
        int counter = enteritems(item, quantity, price);
        System.out.println(counter);
        ammend(item, quantity, price, counter);
    }

    public static int enteritems(String[] item, int[] quantity, int[] price){
        String choice = " ";
        int counter = 0;
        while (!(choice.equals("EXIT"))){
            
            choice = input("Item " + (counter+1));
            if (choice.equals("EXIT")){
                break;
            }
            item[counter] = choice; 
            quantity[counter] = inputint("Enter the amount of " + choice);
            price[counter] = inputint ("Enter the price of " + choice + " in GBP");
            counter =+1;
        }
        return counter;
    }

    public static void printall(String[] item, int[] quantity, int[] price, int counter){
        for (int i=0; i < counter; i++){
            System.out.println(i + ": " + item[i] + ": " + quantity[i] + " left at " + price[i] + " GBP");
        }
    }

    public static void ammend(String[] items, int[] quantity, int[] price, int counter){
        printall(items, quantity, price, counter);
        int choice = 1;
        while (!(choice == 0)){
            choice = inputint("Enter the number of the item that you have sold");
            if (choice > (counter+1) && choice < 0){
                choice = inputint("Enter the number of the item that you have sold");
                ammend(items, quantity, price, counter);
            }
            int index = choice -1;
            if (quantity[index] < 1){
                System.out.println("You have none in stock");
            }
            else{
            quantity[index] = quantity[index] -1;
            }
            printall(items, quantity, price, counter);
        }
    }
    public static String input(String m){
        System.out.println(m);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static int inputint(String m){
        return Integer.parseInt(input(m));
    }
   
    
}