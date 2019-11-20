import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Food crisps = new Food();
	    Food beans = new Food();
	    Food soup = new Food();
	    Food yog = new Food();
	    crisps.name = "crisps";
	    beans.name = "beans";
	    soup.name = "soup";
	    yog.name = "yoghurt";
	    crisps.sodium = 0.9;
	    beans.sodium = 0.4;
	    soup.sodium = 0.22;
	    yog.sodium = 0.06;
	    crisps.contentlevel = "high";
	    beans.contentlevel = "high";
	    soup.contentlevel = "medium";
	    yog.contentlevel = "low";
	    System.out.println("I can tell you about the salt content of the following food: /n Crisps, Yoghurt, Soup, Baked beans");
	    String choice = " ";
	    while (!(choice.equalsIgnoreCase("end"))){
	        choice = input("Please type in the foods you want to see and enter END to stop:");
	        information(choice, crisps,beans,soup,yog);
	    }
	    System.out.println("Eat healthily, goodbye!");
	}
	public static String input(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
	public static void information(String choice, Food crisps, Food beans, Food soup, Food yog){
	    if (choice.equalsIgnoreCase(crisps.name)){
	       System.out.println(crisps.name + " that is " + crisps.sodium + " of sodium per 100g. . The salt content is " + crisps.contentlevel);
	    }
	    else if (choice.equalsIgnoreCase(beans.name) ){
	       System.out.println(beans.name + " that is " + beans.sodium + " of sodium per 100g. . The salt content is " + beans.contentlevel); 
	    }
	    else if (choice.equalsIgnoreCase(soup.name) ){
	       System.out.println(soup.name + " that is " + soup.sodium + " of sodium per 100g. . The salt content is " + soup.contentlevel); 
	    }
	    else if ( choice.equalsIgnoreCase(yog.name) ){
	       System.out.println(yog.name + " that is " + yog.sodium + " of sodium per 100g. . The salt content is " + yog.contentlevel); 
	    }
	    else{
	        System.out.println("Sorry, I dont know that one");
	    }
	}
}

class Food{
    String name;
    double sodium;
    String contentlevel;
}
