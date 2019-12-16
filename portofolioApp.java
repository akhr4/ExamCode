import java.util.Scanner;
class portofolioApp{
    public static void main(String[] args){
        int size = 5;
        Stock[] stocksInvested = new Stock[5];
        stocksInvested = createstocks(stocksInvested);
        int choice = -1;
        int counter = -1;
        while (!(choice == 6)){
            choice = inputInt("1) Display All 2) Buy shares 3)Sell Shares 4)Reprice stock 5)Total Value 6) Exit");
            if (choice == 6){
                System.out.println("Exit Portfolio");
                break;
            }
            else if (choice == 1){
                showAll(stocksInvested,counter);
            }
            else if (choice == 2){
                counter = counter+1;
                buyShares(stocksInvested,counter);
            }
            else if (choice == 3){
                sell(stocksInvested,counter);
            }
            else if (choice == 4){
                reprice(stocksInvested,counter);
            }
            else if (choice == 5){
            }
            else{
                choice = inputInt("Invalid input 1) Display All 2) Buy shares 3)Sell Shares 4)Reprice stock 5)Total Value 6) Exit");
            }
        }
        System.exit(0);
}

 

public static void buyShares(Stock[] stocksInvested,int counter){
    String shareName = input("Enter name of share:");
    int shareAmount = inputInt("Enter the amount purchased:");
    double sharePrice = Double.parseDouble(input("Enter price of share:"));
    stocksInvested[counter] = Stock.Stock(shareName,shareAmount,sharePrice);
    return;
}

 public static Stock[] createstocks(Stock[] stocksInvested){
     stocksInvested[0] = Stock.Stock("Apple", 3, 3.3);
     return stocksInvested;
     //Keep going until index 4

 }

public static void showAll(Stock[] stocksInvested, int counter){
    for (int i =0; i <stocksInvested.length; i++){
       System.out.println("Stock number: " + (i+1));
       System.out.println("Stock name " + stocksInvested[i].getName());
       System.out.println("Stock quantity " + stocksInvested[i].getShares());
       System.out.println("Price per unit :" + stocksInvested[i].getPrice());
       System.out.println("");
    }
}

 

public static void sell(Stock[] stocksInvested, int counter){
    String nameToBeSold = input("Enter the name of the stock to be sold : ");
    boolean found = false;
    for (int i=0; i< stocksInvested.length; i++){
        if (stocksInvested[i].getName().equals(nameToBeSold)){
            found = true;
            int quantityToBeSold = inputInt("Enter the amount you want to sell: ");
            int soldStatus = Stock.sellShares(stocksInvested[i],quantityToBeSold); //Either returns 0 if inefficient amount to sell else actually gives the value of existant shares - quantityToBeSold
            if (soldStatus != 0){ //If it is valid to sell stock (If amount wanted to sell is less than what is there), then print value left and reset value for continual use
                System.out.println ("Successfully sold, there are " + soldStatus + " stocks left");
    stocksInvested[i].setShares(soldStatus); //As it has been sold, change the quantity left to what it is after being sold
}
            else{
                System.out.println("Insufficient quantity to be selling at that magnitude");
}
}
break;
}
    if (!found){
        System.out.println("Stock not found"); //If what the user entered is not there, then tell them that it isnt
}
return;
}

 

public static void reprice(Stock[] stocksInvested, int counter){
    String nameToBeRepriced = input("Enter the name of the stock to be repriced : ");
    boolean found = false;
    for (int i=0; i< stocksInvested.length; i++){
    if (stocksInvested[i].getName().equals(nameToBeRepriced)){
        found = true;
        double newPrice = Double.parseDouble(input("Enter the new price of this stock: "));
        stocksInvested[i].setPrice(newPrice);
}
break;
}
if (!found){
    System.out.println("Stock not found. Reprice unsuccessful"); //If what the user entered is not there, then tell them that it isnt
}
return;
}
//Input method for strings
public static String input(String message){
    System.out.println(message);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
}
 
//Input method for integers
public static int inputInt(String message){
    return Integer.parseInt(input(message));  
}

 

}

class Stock{
String name;
int shares;
double price;

 

//Allow for stock to be made
public static Stock Stock(String name, int shares, double price){
    Stock stockObj = new Stock();
    stockObj.setName(name);
    stockObj.setShares(shares);
    stockObj.setPrice(price);
    return stockObj;
}

 

public double buyShares(int newShares){
    setShares(getShares()+newShares);
    return (getShares() * getPrice());
}

 

public static int sellShares(Stock object, int amount){
    if (amount > object.getShares()){
        return 0;
}
else{
        object.setShares(object.getShares() - amount);
        return object.getShares();
}
}

 

public double getStockValue(){
    return (getPrice() * getShares());
}

 

//Setters
public void setName(String name){
this.name = name;
}

 

public void setShares(int shares){
    this.shares = shares;
}

 

public void setPrice(double price){
    this.price = price;
}

 

//Getters
public String getName(){
    return name;
}

 

public int getShares(){
    return shares;
}

 

public double getPrice(){
    return price;
}
}