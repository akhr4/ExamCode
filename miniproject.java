/* Author: Ayushi Khetani
Project: Chat Bot
Level 1-8
*/

import java.util.*; //For Scanner input
import java.io.*; //For File I/O

class botS{
	//Main class running and conducting the bulk of the code 
    	public static void main(String[] args){
        	print("Hi human! I was just bought into existence. Please help me find out who I am......");
		botProfile bot = new botProfile();
		bot = setName (bot, input("What will my new name be?"));
		
		print("I see, so my new name is " + getName(bot)+ "? Nice to meet you!");
        	String humanName = introduction();
       		hobby(humanName); 
		MusicPrompt[] record = recordHolder();
		musicQuestion(record, humanName); 
		String[] questionMath = mathQ();
		String[] answerMath = mathA();
		mainConvo(questionMath,answerMath);
		}

	//Making records in this method by using accessor methods. These are all wrapped into a array to be passed out to be used in another method 
	public static MusicPrompt[] recordHolder(){
		MusicPrompt rap = new MusicPrompt();
		rap.genre = "rap";
		rap.artist1="eminem";
		rap.artist2="drake";
		rap.artist3="stormzy";

		MusicPrompt metal = new MusicPrompt();
		metal.genre="metal";
		metal.artist1="metallica";
		metal.artist2="ac dc";
		metal.artist3="guns n roses";

		MusicPrompt pop = new MusicPrompt();
		pop.genre="pop";
		pop.artist1="madonna";
		pop.artist2="beyonce";
		pop.artist3="rihanna";
		
		MusicPrompt[] record = new MusicPrompt[3];
		record[0] = rap;
		record[1] = metal;
		record[2] = pop;
		return record;
		
	}
	
	//introduction method that asks the user's name and outputs a small message as an introduction
	public static String introduction(){
		String name = input("Now you know me, I want to know you. What is your name?"); 
		print("Hello, " + name + ". It is nice to meet you!"); 
		return name;
	}

	//Method asking about hobby and how long they have done it only taking int inputs - has while loop validation as well as wrong data type validation
    	public static void hobby(String humanName){
		String userHobby = input("What is your favourite hobby?");
      		print("Wow " + humanName + "! " + userHobby + " sounds super cool! Maybe we should try it some time.");
	  	boolean valid = true;
	  	while (valid){
	  		try{
			int duration = inputInt("So how many years have you been doing this?");
			if (duration < 2 && duration > 0){ //If they use a positive number less than 6....
				print("You haven't been doing that for long have you?");
			}
			else{
				print("Sounds like you love what you are doing if you have been doing it for that long!");
			}
			valid = false;
			}
		  	catch (NumberFormatException e){
				print("You can't have... How is that even a number?? I will ask again;");
		  	}
	  	}
    	}

	//Main loop which does the conversation + Arrays that have potential conversation starters 
	public static void mainConvo(String[] questionMath, String[] answerMath){
		String menuchoice = "";
		String[] colour = {"colour","rainbow","paint","art","bored"};
		String[] quiz = {"play", "bored","puzzle","quiz","math"};
		String[] animal = {"animal", "dog", "cat","safari","cute"};
		String[] smalltalk = {"I can listen to you yap all day! Haha", "That's nice,you are fun to talk to!", "I love chatting", "I am tired, I think you should let me go","It's time to go", "I like that too!", "Sounds like you had a good day!"};
		while (!(menuchoice.contains("bye"))){
			menuchoice = input("What do you want to talk about?");
			for (int i = 0; i<5; i++){
				if (menuchoice.contains(colour[i])){
					colour();
				}
				else if (menuchoice.contains(quiz[i])){
					mathQuiz(questionMath,answerMath);
				}
				else if (menuchoice.contains(animal[i])){
					String responseTwo = input("What is your favourite animal:");
					print("Well aren't " + responseTwo + " so cute! I would like one as a pet, wouldn't you?");
				}
			}
			if(menuchoice.equals("bye")){
                showFile();
				System.exit(0);
			}
			else{
				print(smalltalk[randomNum(6,0)]); //Random digits 0-6 inclusive for indexing 
			}	
		}

	}
	
	//Asking user to input any colours they like to form a rainbow 
	public static void colour(){
		String rainbow[] = new String[6];
		print("I am quite an artist in my free time! Let's create a virtual rainbow! I love creating new art pieces! Just give me 6 colours and I will draw them for you");
		for (int i = 0; i<6; i++){
			String archcolour = input("What colour shall I made arch " + (i+1) + " ?");
			rainbow[i] = archcolour;
		}
		SortingString(rainbow); 
		print(Arrays.toString(rainbow));
		print("Now that is a beautiful rainbow!");
		System.exit(0);
	}
	

	//Takes in the user's input and does comparison with recorded music types to respond accordingly. 
   	public static void musicQuestion(MusicPrompt[] record, String humanName){
		String favouriteMusic = input("I know your hobby, so I want to talk about mine. I love music, what is your favourite type of music?"); 
	  	// [0] Rap [1] Metal [2] Pop for Record array indexing 
	        if (favouriteMusic.contains(record[0].genre)){
			print("My top three favourite "+ record[0].genre + " artists are \n" + record[0].artist1+ "\n" + record[0].artist2+ "\n" + record[0].artist3);
	      	}
	      	else if (favouriteMusic.contains(record[2].genre)){
			print("My top three favourite " + record[2].genre+ " artists are \n" + record[2].artist1+ "\n" + record[2].artist2+ "\n" + record[2].artist3);
	      	}
	      	else if (favouriteMusic.contains(record[1].genre)){
			print("My top three favourite " + record[1].genre+ " artists are \n" + record[1].artist1+ "\n" + record[1].artist2+ "\n" + record[1].artist3);
	      	}
	      	else{
		//If the genre is not found, the user has a chance to elaborate
        		print("Sorry I dont know what " + favouriteMusic + " is to be honest. Tell me more");
        		String favArtist1 = input("Tell me about your number 1 favourite artist");
			String favArtist2 = input("Tell me about your number 2 favourite artist");
			String favArtist3 = input("Tell me about your number 3 favourite artist");
			writeToFile(humanName, favArtist1, favArtist2, favArtist3);
			print("I am going to start listening to those artists now! But I want to tell you my favourite artist first!");
			int rand = randomNum(2,0);
			print("One of my favourite genres include " + record[rand].genre+ ". My favourite music artists are \n" + record[rand].artist1+ "\n" + record[rand].artist2+ "\n" + record[rand].artist3);		
      		}
      		return;
    	}
	
	//Bubble Sort for Strings 
	public static void SortingString(String[] array) {
		String tempVar;
		boolean sortFinish = false;
		while (!(sortFinish)) {
			sortFinish = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i+1].compareToIgnoreCase(array[i]) < 0) { //.compareTo simply compares letters of items using ASCII code of letter 1 and also case is ignored. 
					tempVar = array[i+1];
					array[i+1] = array[i];
					array[i] = tempVar;
					sortFinish = false;
				}
			}
		}
	}
	
	//Array full on math questions
	public static String[] mathQ(){
		String questionMath[] = new String[10];
		questionMath[0] = "How many sides does a quadrilateral have?"; 
		questionMath[1] = "How many kilograms are there in a ton? One _____";
		questionMath[2] = "How many dots are there on a dice?";
		questionMath[3] = "What do you call numbers that can’t be expressed as a fraction? _______ numbers ";
		questionMath[4] = "There are 604,800 ______ in a year.";
		questionMath[5] = "What is the name of the formula that states a^2 + b^2 = c^2 ? ______ theorem";
		questionMath[6] = "What part of maths deals with the study of motion?";
		questionMath[7] = "What must all probability add up to?";
		questionMath[8] = "How many sides does a dodecahedron have?";
		questionMath[9] = "What process is the inverse to differentiation?";
		return questionMath;
	}
	
	//Array full of answers in response to the math questions 
	public static String[] mathA(){
		String answerMath[] = new String[10];
		answerMath[0] = "four";
		answerMath[1] = "thousand";
		answerMath[2] = "twenty one";
		answerMath[3] = "irrational";
		answerMath[4] = "seconds";
		answerMath[5] = "pythagoras";
		answerMath[6] = "mechanics";
		answerMath[7] = "one";
		answerMath[8] = "twelve";
		answerMath[9] = "integration";
		return answerMath;
	}
	
	public static int mathQuiz(String[] questionMath, String[] answerMath){
		String ready = input("Lets play a math quiz! It is pretty fun and you will learn loads! There are 5 questions. Are you ready?");
		int mathScore = 0;
		for(int i=0; i <= 5; i++){
			int rand = randomNum(4,0);
			String response = input(questionMath[rand]);
			if (response.contains(answerMath[rand])){
				print("Well done! " + answerMath[rand] + " is the right answer!");
				mathScore =+1;
			}
			else{
				print("Good try but that is not correct." + answerMath[rand] + " is the correct answer.");
			}
		}
		System.out.println("You got " + mathScore + " correct");
		if (mathScore < 6){
			print("That is a pretty bad score. Did you really pass math in highschool?");
		}
		else{
			print("Well, aren't you a smart cookie");
		}
		return mathScore;
	}
	
    	//String input method that uses Scanner
	public static String input(String message){
		System.out.println(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().toLowerCase();
    	}

    	//Integer input method
    	public static int inputInt(String message){
    		return Integer.parseInt(input(message));
    	}

	//Method to implement print messages so instead of using System.out.println , print can be used
	public static void print(String message){
		System.out.println(message);
	}

	//RANDOM NUMBER GENERATOR UP = Upper Lim,it LW = Lower Limit 
	public static int randomNum(int UP , int LW){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(UP) + LW;
		return randomInt; 
	}
	
	public static void writeToFile(String humanName, String artist1, String artist2, String artist3){
		String filename = "ChatbotChat.txt";
		try{
			String text = humanName + " recommends " + artist1 + ", " + artist2 + ", " + artist3;
			PrintWriter writeTF = new PrintWriter(new FileOutputStream(filename, true));
			writeTF.append(text + "\n");
			writeTF.close();
			
		} 
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}


    //Showing the file contents thtough the scanner method. 
    public static void showFile(){
		System.out.println("These are the songs you and other people have recommended!");
        try{ //Use of try catch to lloe compilation and not throw an error in
            File filename = new File("ChatbotChat.txt");
            Scanner printer  = new Scanner(filename); //To print a file type 
            printer.useDelimiter("\\Z"); //White space character 
            System.out.println(printer.next());
        }
        catch (FileNotFoundException e){
			e.printStackTrace();
		}
    }
	
	////
	//*******************Accessor Methods to be used in the record making of the chatbot*******************
	public static String getName(botProfile b){
		return b.name;
	}
    

    
    	public static botProfile setName(botProfile b, String name){
      		b.name = name;
      		return b;
    	}
    
    
	//*******************************************************************************************************
} //End class 


//Class creations......
class MusicPrompt{
	String genre;
  	String artist1;
  	String artist2;
  	String artist3;
}

class botProfile{
	String name;

}
