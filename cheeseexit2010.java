import java.util.Scanner;
class Main{
        public static void main(String[] args){
            String userCheese = " ";
            while (!(userCheese.equalsIgnoreCase("crackers"))){
              userCheese = input("What cheese do you fancy Gromit?").toLowerCase();
              quoteProvided(userCheese);
            }
        }
        
        public static void quoteProvided(String userCheese){
            if (userCheese.contains("gorgonzola")){
                System.out.println("I do like a bit of Gorgonzola");
            }
            else if (userCheese.contains("cheddar")){
                System.out.println("I could just fancy some cheese, Gromit. What do you say? Cheddar");
            }
            else if (userCheese.contains("wensleydale")){
                System.out.println("We’ve no cheese, not even Wensleydale");
            }
            else if (userCheese.contains("gruyere")){
                System.out.println("We’ve no cheese, not even Gruyere");
            }
            else if (userCheese.contains("crackers")){
                System.out.println("No cheese, Gromit. Not a bit in the house.");
            }
            else{
                System.out.println("I don't know... it's like no cheese I've ever tasted... " + userCheese); 
            }
        
        } 
        
        public static String input(String message){
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
}
