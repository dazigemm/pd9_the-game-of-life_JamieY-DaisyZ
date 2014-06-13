//This is MASH.java, the main driver for our game.

import java.util.*;
import java.io.*;

public class MASH{

    //Variables
    private int spinnernum;//Value of spinner
    private boolean finished;
    private int counter;//Main counter, adds each time <blah>
    private int index;//Counter within ArrayLists. Resets when done.
    private Random rand;
    private CLList Categories;
    private int version;
    //Constructors
    public MASH(){
	spinnernum = 0; //Will be changed in stuff
	finished = false;
	counter = 1;//So does't kill first item incorrectly.
	index = 0;
	Categories  = new CLList();
	rand = new Random();
	version = 0;
    }

    /***Categories
    //Categories
    private Category MASH;
    //Life
    private Category Job, RetirementAge, LivingLocation, 
	Pet, Salary, NumKids;
    //Stuy
    private Category GPA, Teacher, LockerFloor, 
	LunchPeriod, College, NumFrees;
    ***/

    //********************* Methods for the game ***********************
    public int spinner(){
	spinnernum = rand.nextInt(8) + 2;//Arbitrary num as of right now.
	return spinnernum;
    }
    
    public int gameSelect(){//Stuy or Life. 
	Scanner scan = new Scanner(System.in);
	System.out.println("What do you want to play? Life or Stuy" );
	String userinput = scan.nextLine();
	
	if (userinput.equals("LIFE") ||
	    userinput.equals("life") ||
	    userinput.equals("Life")) 
	    return 1; 
	
	return 0; //Default value, will be 0 for STUY and 1 for LIFE
    }
    //Builds the structure of the game. 
    public void buildingGame() throws IOException {//The game

	Scanner reader = new Scanner(System.in);

	//Player selects which game to run, STUY or LIFE.
	version = gameSelect();// 0 for Stuy and 1 for Life

	//The following code creates the CLList containing the Categories.
	//A new ArrayList is made containing the hardcoded non-variable MASH
	//After that, categories are added and the data set to them is input by user via CreateAL and a constant that determines which print statement to use
	ArrayList<String> MASHAL = new ArrayList<String>();//MASH must be hardcoded
	Categories.add("MASH");//Create the first category
	
	if (version == 0){// Stuy Version
	    // Creating the ArrayList of data for each Category in CLList

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
	Categories.set(0, MASHAL);//The first category added is MASH. Setting data.
	//Now that the linked list of categories is prepared... 
	// Fill in Categories
	for (int i = 1; i < Categories.size(); i++) {
	    String names = Categories.get(i).getName();
	    System.out.println("Fill in your choices for " + names); 

	    
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


	    ArrayList<String> arr = new ArrayList<String>();
	    for (int a = 0; a < 3; a++) {
		
		System.out.print(a + 1 + " : ");


		while (reqNum && ! reader.hasNextInt()){
		    System.out.print("Please type an integer: ");
		    reader.nextLine();
		}
		String input = reader.nextLine();		
		int test = Integer.parseInt(input);
		System.out.println(test + " out of bounds");


		//FUNKY CODE
		if (reqNumLim) { 
		    while (test > 11 || test < 0) {
			System.out.print("Please type an integer between 0 and 10: ");
			reader.nextLine();
		    }
		}
		input = reader.nextLine();
		arr.add(input);
		
	    }
	    Categories.set(i, arr);
	}
	
    }

    public void play () throws IOException, InterruptedException{

	int spun = spinner();

	System.out.println(Categories);

	System.out.println("Spinning...");

	System.out.println("Spinning by " + spun);

	int counter = 1;//num nodes passed
	int node = 0;
	int index = 0; 
	int catSize = 0;

	while (! Categories.isThereOne() ) {
	    catSize = Categories.ALSize(node);
	    if (catSize == 1 || index >= catSize) {		   
		node++;
		index = 0;
	    }
	    else {
		System.out.println ( "looking at: "+ Categories.get(node, index));
		if (counter % spun == 0) {
		    String removed = Categories.remove(node, index);
		    System.out.println( removed + " is not in your " 
					+ Categories.get(node).getName() + " future!");
		    catSize = Categories.ALSize(node);
		    index--;
		    Thread.sleep(1000);
		}
		
		counter++;
		index++;
	    }
	    //System.out.println(Categories);
	}

	System.out.println(Categories);

	String results = "";
	for (int i = 0; i < Categories.size(); i++) {
	    results += Categories.get(i).getValue(0) + ",";
	}
	results = results.substring(0, results.length() - 1);
	System.out.println(results);//should be stored in text file
	if (version == 0) {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Stuy.txt", true));
	    writer.write (results + "\n");
	    writer.close();
	}
	else {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Life.txt", true));
	    writer.write (results + "\n");
	    writer.close();
	    
	}
    }
    public static void main(String[] args) throws IOException, InterruptedException{

	MASH game = new MASH();
	game.buildingGame();

	game.play();
	
    }

}
