import java.util.Scanner;
class Main{
    public static void main(String[] args){
        int[] temp = new int[6];
        for (int i=0; i<temp.length; i++){
            temp[i] = inputint("What is the temperature at " + (i+1) + " pm?");
        }
        forcaster(temp);
    }

    public static void forcaster(int[] temp){
        int index;
        for(index = 0; index<temp.length; index ++){
            System.out.print((index+1) + " pm. Degrees " + temp[index] + " ");
            determiner(temp, index);
        }
    }

    public static void determiner(int[] temp, int index){
        if(temp[index] >39 || temp[index] < -24){
            System.out.println("I don't believe you");
        }
        else if(temp[index] >19 && temp[index] < 40){
            System.out.println("What a scorcher");
        }
        else if(temp[index] > 9 && temp[index] < 20){
            System.out.println("Boring!");
        }
        else if(temp[index] > -25 && temp[index] < 10){
            System.out.println("Chilly, put your thermals on");
        }
    }

    public static int inputint(String m){
        System.out.println(m);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}