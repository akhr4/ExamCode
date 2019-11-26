import java.util.Scanner;
class Main{
    public static void main(String[] args){
        int size = 10;
        Bookshelf[] log = new Bookshelf[size];
        int counter= -1;
        int choice = -1;
        while (!(choice == 3)){
            counter = counter+1;
            System.out.println("Counter " + counter); 
            choice = inputint("1) Add 2) view 3) exit");
            if (choice == 3){
                System.out.println("Okay bye!");
                break; 
            }
            else if (choice == 1){
                enterdirectory(log, counter); 
            }
            else if (choice == 2){
                viewdirectory(log, counter);
                counter = -1;
            }
            else{
                choice = inputint("Invalid input 1)Add 2) View 3) Exit");
            }
        }
        //counter = menu(log, counter);
        System.exit(0);
    }

    public static void viewdirectory(Bookshelf[] log, int counter){
        for (int i=0; i<(counter-1); i++){
            System.out.println("Book " + (i+1) + " title name: " + gettitle(log[i]) + " quantity " + getquantity(log[i]));
        }
        return;
    }


    public static void enterdirectory(Bookshelf[] log, int counter){
            String newtitle = input("Enter title of book:");
            int stock = inputint("Enter stock left ");
            boolean found = false;
            if (counter != 0){
                for (int i = 0; i< (counter); i++){
                    if (newtitle.equals(gettitle(log[i]))){
                        int newvalue = getquantity(log[i])+stock;
                        setquantity(log[i], newvalue);
                        found = true; 
                    }    
                }
            }
            if (!found){
                Bookshelf entry = new Bookshelf();
                log[counter] = setquantity(entry, stock);
                log[counter] = settitle(entry,newtitle);
            }
            return;
    }

    public static String gettitle(Bookshelf c){
        return c.title;
    }

    public static Bookshelf settitle(Bookshelf c, String titlename){
        c.title = titlename;
        return c;
    }

    public static int getquantity(Bookshelf c){
        return c.quantity;
    }

    public static Bookshelf setquantity(Bookshelf c, int amount){
        c.quantity = amount;
        return c;
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

class Bookshelf{
    String title;
    int quantity;
}