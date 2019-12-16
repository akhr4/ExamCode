import java.util.*; 

class main{
    public static void main(String[] args){
        Queue q = newQueue(10); //Making a new queue object of size 10 
        // Adding to q that is called q - first element is "One"
        enQueue(q, "One"); 
        enQueue(q, "Two");
        enQueue(q, "Three");
        enQueue(q, "Four");
        enQueue(q, "Five");
        enQueue(q, "Six");
        enQueue(q, "Seven");
        //Removing elements from the queue and printing them as they leave 
        System.out.println(deQueue(q)); //FIFO - One would leave first 
        System.out.println(deQueue(q)); //Two leaves 
        System.out.println(deQueue(q)); // Three Leaves 
        System.out.println(deQueue(q)); //Four Leaves 
        enQueue(q,"Eight"); //Add Eight to the back of the queue
        System.out.println(deQueue(q)); //Five leaves
        System.out.println(deQueue(q)); //Six leaves 
    }

    public static Queue newQueue(int n){ //Create a new queue object 
        Queue q = new Queue(); //New object 
        String array[] = new String[n]; //Create a new array of specified size 
        q.names = array; //Make a new array onject 
        q.queuesize = 0; //Set the initial size to 0 
        return q; //Return the whole queue out
    }

//Add item onto the bakc of the queue 
    public static void enQueue(Queue q, String entry){ 
        if (q.queuesize < q.names.length){ //If the queue isn't full - Size of queue is less than the set array size 
            q.names[q.queuesize] = entry; //Set the value at the index of queue size to the input (Using the array in the Queue class to store this)
            q.queuesize +=1; //Increment the size of queue 
        }
    }

//Remove item from queue 
    public static String deQueue(Queue q){ 
        String front = q.names[0]; //Store the front element to be returned and printed if wanted 
        if (q.queuesize != 0){ //IF the queue is not empty 
            for (int i = 0; i < q.queuesize; i++){ //For the all of the non zero elements in the queue
                q.names[i] = q.names[i+1]; // Overwrite the first element to get rid of it and shove all of the others up 1
            }
            q.queuesize -=1; //Decrease the size by 1 as someone left 
        }
        else{
            System.out.print("Empty Queue"); //State the queue is empty and nothing can be removed
            }
        return front; //Return the element that was once in front - This can be printed 
    }
}
 
//Queue class that contains the array to be used as a queue and the size 
class Queue{
    String[] names; 
    int queuesize;
}