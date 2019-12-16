import java.util.*;
class main{
    public static void main(String[] args){
        int size = 7;
        Cashflow Guardian = new Cashflow();
        Cashflow Times = new Cashflow();
        Cashflow Independant = new Cashflow();
        int[] Guardianlist = new int[size];
        int[] Timeslist = new int[size];
        int[] Independantlist = new int[size];
        menu(size,Guardian,Times,Independant,Guardianlist,Timeslist,Independantlist);
    }
    
    public static void menu(int size,Cashflow Guardian, Cashflow Times, Cashflow Independant, int[] Guardianlist, int[] Timeslist, int[] Independantlist){
        String exit = "N";
        String choice = "Y";
        while (!(choice.equalsIgnoreCase(exit))){
            makerecords(Guardian,Times,Independant);
            recordingval(size,Guardian,Times,Independant,Guardianlist,Timeslist,Independantlist);
            choice = input("Do you want to start a new week?"); 
        }
        System.exit(0);
    }
    
    public static void makerecords(Cashflow Guardian,Cashflow Times,Cashflow Independant){
        setname(Guardian, "Guardian");
        setbuy(Guardian, inputint("How much did you buy the Guardian for?"));
        setsell(Guardian, inputint("How much did you sell the Guardian for?"));
        setname(Times, "Times");
        setbuy(Times, inputint("How much did you buy the Times for?"));
        setsell(Times, inputint("How much did you sell the Times for?"));
        setname(Independant,"Independant");
        setbuy(Independant, inputint("How much did you buy the Independant for?"));
        setsell(Independant, inputint("How much did you sell the Independant for?"));
    }
    public static void recordingval(int size,Cashflow Guardian, Cashflow Times, Cashflow Independant, int[] Guardianlist, int[] Timeslist, int[] Independantlist){
        int bought;
        int sold;
        int profit; 
        for (int i=0; i<size; i++){
            System.out.println("Day " + (i+1));
            bought = inputint(getname(Guardian) +  ": " + "How many copies bought?");
            sold = inputint(getname(Guardian) + ": " + "How many copies sold?");
            profit = (sold * getsell(Guardian)) - (bought * getbuy(Guardian));
            Guardianlist[i] = profit;

            bought = inputint(getname(Times) + ": " + "How many copies bought?");
            sold = inputint(getname(Times) + ": " + "How many copies sold?");
            profit = (sold * getsell(Times)) - (bought * getbuy(Times));
            Timeslist[i] = profit;

            bought = inputint(getname(Independant) + ": " + "How many copies bought?");
            sold = inputint(getname(Independant) + ": " + "How many copies sold?");
            profit = (sold * getsell(Independant)) - (bought * getbuy(Independant));
            Independantlist[i] = profit;
        }
        for(int i=0; i<size;i++){
            System.out.println(getname(Guardian) + "\n Day " + (i+1) + " Profit: " + Guardianlist[i]);
        }
        for(int i=0; i<size;i++){
            System.out.println(getname(Times) + "\n Day " + (i+1) + " Profit: " + Timeslist[i]);
        }
        for(int i=0; i<size;i++){
            System.out.println(getname(Independant) + "\n Day " + (i+1) + " Profit: " + Independantlist[i]);
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

    public static Cashflow setbuy(Cashflow c, int price){
        c.buy = price;
        return c;
    }

    public static Cashflow setsell(Cashflow c, int price){
        c.sell = price;
        return c;
    }

     public static Cashflow setname(Cashflow c, String name){
        c.name = name;
        return c;
    }

  
    public static String getname(Cashflow c){
        return c.name;
    }

    public static int getbuy(Cashflow c){
        return c.buy;
    }

    public static int getsell(Cashflow c){
        return c.sell;
    }

}
class Cashflow{
    String name; 
    int buy;
    int sell;
    int profit;
}