import java.util.*;
class Main{
    public static void main(String[] args){
        int size = 10;
        Car[] carsarray = new Car[size];
        for (int i=0; i< carsarray.length; i++){
            String temp = input("Enter the car model");
            Car newcar = new Car();
            carsarray[i] = setmodel(newcar, temp);
        }
        for (int j=0; j< carsarray.length; j++){
            System.out.println("Model: " + j + " " + getmodel(carsarray[j]));
        }
    }

    public static String getmodel(Car c){
        return c.model;
    }

    public static Car setmodel(Car c, String modelname){
        c.model = modelname;
        return c;
    }
    
    public static String input(String m){
        System.out.println(m);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
class Car{
    String model;
}