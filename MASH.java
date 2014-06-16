//This is MASH.java, the main driver for our game.

import java.util.*;
import java.io.*;

public class MASH{

    //Variables
    private boolean finished;
    private int counter;//Main counter, adds each time <blah>
    private int index;//Counter for ArrayLists. Resets at new ArrayList.
    private Random rand;
    private CLList Categories;
    private int version;

    //Constructors
    public MASH(){
	Categories  = new CLList();
	rand = new Random();
	finished = false;
	counter = 1;//So does't kill first item incorrectly.
	index = 0;
	version = 0;// Sets default game to Stuy.
    }

    //********************* Methods for the game ***********************

    //Spinner will randomly generate a number between 2 and 10
    //This is to insure that the game will not pick a number that is too low. 
    public int spinner(){
	return rand.nextInt(8) + 2;
    }
    

    //This takes in the user input of the game. The default game is Stuy. 
    public int gameSelect(){//Stuy or Life. 
	Scanner scan = new Scanner(System.in);
	System.out.println("What do you want to play? Please select between 'Life' or 'Stuy'!" 
			   + " \n The Stuy version of the MASH is its default.");
	String userinput = scan.nextLine();
	String caps = userinput.toUpperCase();
	if (caps.equals("LIFE") ||
	    userinput.equals("1")) {
	    version = 1;
	    System.out.println ("\nYou will be playing LIFE version!!!" );
	} else {	
	version = 0; //Default value, will be 0 for STUY and 1 for LIFE
	System.out.println ("\nYou will be playing STUY version!!!" );
	}

	return version;
    }


    //Builds the structure of the game. 
    public void buildingGame() throws IOException, InterruptedException {//The game

	Scanner reader = new Scanner(System.in);

	//Player selects which game to run, STUY or LIFE.
	gameSelect();// 0 for Stuy and 1 for Life
	Thread.sleep(1000);

	//The following code creates the CLList containing the Categories.
	//A new ArrayList is made containing the hardcoded non-variable MASH
	//After that, categories are added and the data set to them is input by user via CreateAL and a constant that determines which print statement to use
	ArrayList<String> MASHAL = new ArrayList<String>();//MASH must be hardcoded
	Categories.add("MASH");//Create the first category, MASH, which is in both versions
	
	if (version == 0){// Stuy Version
	    // Creating the ArrayList of data for each Category in CLList

	    //Finishes building MASH Categories
	    MASHAL.add("Mathematics Department"); 
	    MASHAL.add("Art and Technology Department"); 
	    MASHAL.add("Sciences Departments"); 
	    MASHAL.add("Humanities Department");
	    
	    Categories.add("GPA"); 
	    Categories.add("Teacher"); 
	    Categories.add("Locker Floor"); 
	    Categories.add("Lunch Period");
	    Categories.add("College");
	    Categories.add("Number of Frees");
	}
	else {//Life Version
	    // Creating the ArrayList of data for each Category in CLList
	    	    
	    MASHAL.add("MANSION"); 
	    MASHAL.add("APARTMENT"); 
	    MASHAL.add("STREET"); 
	    MASHAL.add("HOUSE");

	    Categories.add("Job");
	    Categories.add("Retirement Age");
	    Categories.add("Living Location");
	    Categories.add("Pet");
	    Categories.add("Salary");
	    Categories.add("Number of Kids");
	}

	//Now that the linked list of categories is prepared... 
	Categories.set(0, MASHAL);//The first category added is MASH. Setting data.

	// Fill in Categories

	/****** Basic Working Version ********
	for (int i = 1; i < Categories.size(); i++) {
	    System.out.println("Fill in your choices for " + 
			       Categories.get(i).getName());

	    ArrayList<String> arr = new ArrayList<String>();
	    for (int a = 0; a < 3; a++) {

		System.out.print(a + 1 + " : ");
		String input = reader.nextLine();
		arr.add(input);

	    }
	    Categories.set(i, arr);
	}
	********End of Basic Version***************/

	//	/************More Complex Version****************
	//This will try to limit the user's input abilities
	for (int i = 1; i < Categories.size(); i++) {
	    String names = Categories.get(i).getName();
	    System.out.println("Fill in your choices for " + names); 
	    
	    //Figures out of the Categories will need Integers and Limitations
	    boolean reqNum = names.equals ("Retirement Age")|| 
	    	names.equals ("Salary")||
	    	names.equals ("Number of Kids")||
	    	names.equals ("GPA")||
	    	names.equals ("Locker Floor")||
	    	names.equals ("Lunch Period")||
	    	names.equals ("Number of Frees");
	    

	    boolean reqNumLim = names.equals ("Locker Floor")||
	    	names.equals ("Lunch Period")||
	    	names.equals ("Number of Frees");
	    
	    if (reqNum){
		System.out.println("Please input an integer.");
	    }

	    //Adding Userinput to ArrayLists
	    ArrayList<String> arr = new ArrayList<String>();
	    for (int a = 0; a < 3; a++) {
		
		System.out.print(a + 1 + " : ");

		//Checks for Integers
		while (reqNum && ! reader.hasNextInt()){
		    System.out.print("Please type an integer: ");
		    reader.nextLine();
		}
		String tempinput = reader.nextLine();
		String input = tempinput.toUpperCase();

		//Checks for blank inputs
		while (input.trim().equals("")){//isEmpty()){
		    System.out.print ("Please try another option: ");
		    input = reader.nextLine();
		}

		//Checks for numbers between 0 and 10 if needed for Category
		if (reqNumLim){
		   
		    int testing = Integer.parseInt(input);
		    while (testing > 10 || testing < 1){
			System.out.print("Please pick a number between 0 and 10: ");
			input = reader.nextLine();
			try{
			    testing = Integer.parseInt(input);
		    
			}
			catch(NumberFormatException e){
			    //To ensure integer input
			    //System.out.print ("Please type an integer between 0 and 10: ");
			    //input = reader.nextLine();
			    //System.out.print("Number!!! ");
			}
		    }
		}

		arr.add(input);
		
	    }
	    Categories.set(i, arr);
	}
	//	***************End of Complex Version***********************/
    }

    public void play () throws IOException, InterruptedException{

	int spun = spinner();

	System.out.println("\n ");
	System.out.println(Categories);
	System.out.println("\n ");
	System.out.println("Spinning...");
	Thread.sleep(2000);
	System.out.println("Spinning by " + spun);

	int counter = 1;//num nodes passed
	int node = 0;
	int index = 0; 
	int catSize = 0;

	//As long as there are more than one option left in each category, 
	//it will continue to go through each node and arraylist, removing the an 
	//option that is dictated by the 'spun'. 

	while (! Categories.isThereOne() ) {
	    catSize = Categories.ALSize(node);
	    if (catSize == 1 || index >= catSize) {		   
		node++;
		index = 0;
	    }
	    else {
		//System.out.println ( "looking at: "+ Categories.get(node, index));
		if (counter % spun == 0) {
		    String removed = Categories.remove(node, index);
		    System.out.println( removed + " is not your future " 
					+ Categories.get(node).getName() );
		    catSize = Categories.ALSize(node);
		    index--;
		    Thread.sleep(1000);
		}
		
		counter++;
		index++;
	    }
	    //System.out.println(Categories);
	}
	
	//Printing out Results......
	System.out.println(Categories);

	String results = "";
	for (int i = 0; i < Categories.size(); i++) {
	    results += Categories.get(i).getValue(0) + ",";
	}

	System.out.println("Results: " + results);//should be stored in text file

	System.out.println("\nThank you for playing!!!\n") ;
	if (version == 0) {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Stuy.txt", true));
	    writer.write (results + "\n");
	    writer.close();
	    Thread.sleep(2000);
	    System.out.println("If you would like to check out other player's results, \n" 
			       + "Please open 'Stuy.txt' or compile and run 'Statistics.java'!" );
	}
	else {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Life.txt", true));
	    writer.write (results + "\n");
	    writer.close();

	    Thread.sleep(1000);
	    System.out.println("If you would like to check out other player's results, \n" 
			       + "Please open 'Life.txt' or compile and run 'Statistics.java'!"	);  
	}
    }


    public static void main(String[] args) throws IOException, InterruptedException{
	MASH game = new MASH();

	System.out.println ("WELCOME TO M.A.S.H.");
	Thread.sleep(500);

	game.buildingGame();
	game.play();
    }



}
