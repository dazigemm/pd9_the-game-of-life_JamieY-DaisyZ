//This is MASH.java, the main driver for our game.

import java.util.*;

public class MASH{

    //Variables
    private int spinnernum;//Value of spinner
    private boolean finished;
    private int counter;//Main counter, adds each time <blah>
    private int index;//Counter within ArrayLists. Resets when done.
    private Random rand;

    //Constructors
    public MASH(){
	spinnernum = 0; //Will be changed in stuff
	finished = false;
	counter = 1;//So does't kill first item incorrectly.
	index = 0;
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


    //Methods
    public void game(){//The game
	//Player selects which game to run, STUY or LIFE.
	int version = gameSelect();// 0 for Stuy and 1 for Life

	CLList gamelist = new CLList();
	ArrayList MASHAL = new ArrayList();//MASH must be hardcoded
	MASHAL.add("MANSION"); MASHAL.add("APARTMENT"); 
	MASHAL.add("STREET"); MASHAL.add("HOUSE");
	gamelist.set(0, MASHAL);//The first category added is MASH.
	
	if (version == 0){// Stuy Version

	    // Creating the ArrayList of data for each Category in CLList
	    for (int i = 0 ; i < 6; i++){
		switch(i) {
		case 0: gamelist.set(1, CreateAL(6));
		    break;
		case 1: gamelist.set(2, CreateAL(7));
		    break;
		case 2: gamelist.set(3, CreateAL(8));
		    break;
		case 3: gamelist.set(4, CreateAL(9));
		    break;
		case 4: gamelist.set(5, CreateAL(10));
		    break;
		case 5: gamelist.set(6, CreateAL(11));
		    break;
		default: System.out.println ("Creating Category Error");
		    break;
		}
	    }
	}
	else {//Life Version
	    // Creating the ArrayList of data for each Category in CLList
	    for (int i = 0 ; i < 6; i++){//For each category
		switch(i) {
		case 0: gamelist.set(1, CreateAL(0));
		    break;
		case 1: gamelist.set(2, CreateAL(1));
		    break;
		case 2: gamelist.set(3, CreateAL(2));
		    break;
		case 3: gamelist.set(4, CreateAL(3));
		    break;
		case 4: gamelist.set(5, CreateAL(4));
		    break;
		case 5: gamelist.set(6, CreateAL(5));
		    break;
		default: System.out.println ("Creating Category Error");
		    break;
		}
       	
	    }
	}
	
		
	//Stuff
	spinner();//Changes the spinnernum, doesn't need to use the return val.
	//Insert While loops running the game here
    }

    public int spinner(){
	spinnernum = rand.nextInt(10);//Arbitrary num as of right now.
	return spinnernum;
    }

    public int gameSelect(){//Stuy or Life. 
	Scanner scan = new Scanner(System.in);
	System.out.println("What do you want to play?");
	String userinput = scan.nextLine();

	if (userinput.equals("LIFE") ||
	    userinput.equals("life") ||
	    userinput.equals("Life"))
	    return 1; 

	return 0; //Default value, will be 0 for STUY and 1 for LIFE
    }

    //User creates the choices that will be put into each category.
    //The category will set its data to the AList returned by this method.
    public ArrayList<String> CreateAL(int constant){//constant determines the print statement
	final int JOB_C = 0;
	final int RETAGE_C = 1;
	ArrayList<String> returnAL = new ArrayList<String>();//to return
	Scanner miniscanner = new Scanner(System.in);

	loop(3){//Three things per Array List
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

    public static void main(String[] args){
	MASH game = new MASH();
	
	
    }
}
