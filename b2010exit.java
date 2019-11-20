import java.util.Scanner 
class Main{
    public static String input(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static int inputInt(String message){
        return Integer.parseInt(input(message));
    }
    
    public static Double inputDouble(String message){
        return Double.parseDouble(input(message));
    }
    
    public static void main(String[] args){
        int size = 10000;
        String[] dvdname = new String[size];
        Double[] dvdprice = new Double[size];
        String enquiry = "";
        while (!(enquiry.equalsIgnoreCase("exit"))){
            enquiry = input("Do you want to find, add or exit ?");
            if (enquiry.equalsIgnoreCase("find")){
                findDVD(dvdname, dvdprice)
            }
            else if (enquiry.equalsIgnoreCase("add")){
                addDVD(dvdname,dvdprice);
            }
            else if (enquiry.equalsIgnoreCase("exit")){
                System.exit(0);
            }
            else{
                System.out.println("That is not understood, only input add, find or exit");
            }
        }
    }
    
    public static void addDVD(String[] dvdname, Double[] dvdprice){
        int index = inputInt("Enter the shelf you want to check");
        double price = inputDouble("Enter DVD price:");
        String dvd = input("Enter the DVD name:");
        while (!(index < 0)){
            System.out.println("Your input is not understood");
            index = inputInt("Enter the shelf you want to check");
        } 
        dvdname[index] = dvd;
        dvdprice[index] = price;
    }
    
    public static void findDVD(String[] dvdname, String[] dvdprice){
        String dvd = input("Enter the DVD you want to search for");
        boolean found = false;
        while (!(found)){
            for (int i=0, i<dvd.length, i++){
              if (dvdname[i] == dvd)
            }
        }
    }
}
