import java.util.*;
class Main{
    public static void main(String[] args){
        int size = inputint("How many bus routes are there?");
        Route[] buses = new Route[size];
        filldetails(buses, size);
        allocatedriver(buses, size);
        menu(buses, size);
    }

    public static void filldetails(Route[] buses, int size){
        for (int i=0; i<size; i++){
            int userbusroute = inputint("Please enter a bus route " + (size-i) + " left.");
            String userstarting = input("Start Location?");
            String userending = input("End location?");
            Route index = new Route();
            setroute(index,userbusroute);
            setstart(index, userstarting);
            setend(index, userending);
            buses[i] = index;
        }
        return;
    }

    public static void allocatedriver(Route[] buses, int size){
        
        System.out.println("Time to start a new day");
        for (int i=0; i<size; i++){
            String userdriver = input("Who is the driver for the bus route " + getroute(buses[i]));
            setdriver(buses[i],userdriver);
        }
        return;
    }

    public static void menu(Route[] buses, int size){
        int choice = -1;
        int counter = -1;
        while (choice != 3){
            counter = counter +1;
            choice = inputint("Do you want to 1) Print all routes 2) Start a new day 3) End");
            if (choice == 3){
                System.out.println("Bye!");
                break;
            }
            else if (choice == 2){
                counter = -1;
                allocatedriver(buses, size);
            }
            else if (choice == 1){
                showroutes(buses, size);
            }
            else{
                choice = inputint("Invalid input \nDo you want to 1) Print all routes 2) Start a new day 3) End");
            }
        }
        return;
    }

    public static void showroutes(Route[] buses, int size){
        for (int i=0; i <size; i++){
            System.out.println(getdriver(buses[i]) + " is on route " + getroute(buses[i]) + " from " + getstart(buses[i]) + " to " + getend(buses[i]) );
        }
        return;
    }

    public static String input(String m){
        System.out.println(m);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputint(String m){
        return Integer.parseInt(input(m));
    }

    public static Route setstart(Route r, String start){
        r.startloc = start;
        return r;
    }

    public static Route setend(Route r, String end){
        r.endloc = end;
        return r;
    }

    public static Route setdriver(Route r, String driver){
        r.driver = driver;
        return r;
    }

    public static Route setroute(Route r, int route){
        r.route = route;
        return r;
    }

    public static String getstart(Route r){
        return r.startloc;
    }

    public static String getend(Route r){
        return r.endloc;
    }
    
    public static int getroute(Route r){
        return r.route;
    }

    public static String getdriver(Route r){
        return r.driver; 
    }
}

class Route{
    int route;
    String startloc;
    String endloc;
    String driver;
}