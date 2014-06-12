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

    //Constructors
    public MASH(){
	spinnernum = 0; //Will be changed in stuff
	finished = false;
	counter = 1;//So does't kill first item incorrectly.
	index = 0;
	Categories  = new CLList();
	rand = new Random();
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
    public void game() throws IOException {//The game

	Scanner reader = new Scanner(System.in);

	//Player selects which game to run, STUY or LIFE.
	int version = gameSelect();// 0 for Stuy and 1 for Life

	//The following code creates the CLList containing the Categories.
	//A new ArrayList is made containing the hardcoded non-variable MASH
	//After that, categories are added and the data set to them is input by user via CreateAL and a constant that determines which print statement to use
	ArrayList<String> MASHAL = new ArrayList<String>();//MASH must be hardcoded
	MASHAL.add("MANSION"); 
	MASHAL.add("APARTMENT"); 
	MASHAL.add("STREET"); 
	MASHAL.add("HOUSE");
	Categories.add("MASH");//Create the first category
	Categories.set(0, MASHAL);//The first category added is MASH. Setting data.
	
	if (version == 0){// Stuy Version
	    // Creating the ArrayList of data for each Category in CLList
	    Categories.add("GPA"); 
	    Categories.add("Teacher"); 
	    Categories.add("Locker Floor"); 
	    Categories.add("Lunch Period");
	    Categories.add("College");
	    Categories.add("Number of Frees");
	}
	else {//Life Version
	    // Creating the ArrayList of data for each Category in CLList
	    Categories.add("Job");
	    Categories.add("Retirement Age");
	    Categories.add("Living Location");
	    Categories.add("Pet");
	    Categories.add("Salary");
	    Categories.add("Number of Kids");
	}
	
	//Now that the linked list of categories is prepared... 
	// Fill in Categories
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

    }

    public void play () throws InterruptedException{

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

    }

    /******************************* Don't know if we need ***********************************
    //User creates the choices that will be put into each category.
    //The CLList will create a category with its data set to the AList returned by this method.
    public ArrayList<String> CreateAL(int constant){//constant determines the print statement
	final int JOB_C = 0;
	final int RETAGE_C = 1;
	ArrayList<String> returnAL = new ArrayList<String>();//to return
	Scanner miniscanner = new Scanner(System.in);

	for(int i=0;i<3;i++){//Three things per Array List
	    switch(constant){//0-5 are life, 6-11 are Stuy
	    case 0: System.out.println("Type in a new selection for Job");
		break;
	    case 1: System.out.println("Type in a new selection for Retirement Age");
		break;
 	    case 2: System.out.println("Type in a new selection for Neighborhood");
		break;
	    case 3: System.out.println("Type in a new selection for Pet");
		break;
	    case 4: System.out.println("Type in a new selection for Salary");
		break;
	    case 5: System.out.println("Type in a new selection for Number of Kids");
		break;
	    case 6: System.out.println("Type in a new selection for GPA");
		break;
	    case 7: System.out.println("Type in a new selection for Teacher");
		break;
	    case 8: System.out.println("Type in a new selection for Locker Floor");
		break;
	    case 9: System.out.println("Type in a new selection for Lunch Period");
		break;
	    case 10: System.out.println("Type in a new selection for College");
		break;
	    case 11: System.out.println("Type in a new selection for Number of Free periods");
		break;
		//Other choices here
		
	    default: System.out.println("Error while creating User ArrayList.");
		break;
	    }
	
	    String userinput = miniscanner.nextLine();
	    userinput = userinput.toUpperCase();//Standardize Here
	    returnAL.add(userinput);//Add the choice to the ArrayList
	}
	return returnAL;
    }
    ***************** End of Potentially Removable Code **********/


    public static void main(String[] args) throws IOException, InterruptedException{
	MASH game = new MASH();
	game.game();

	game.play();
	
    }

}
