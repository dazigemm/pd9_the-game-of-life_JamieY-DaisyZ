//This is MASH.java, the main driver for our game.

import java.util.*;

public class MASH{

    //Variables
    private int spinnernum;//Value of spinner
    private boolean finished;
    private int counter;//Main counter, adds each time <blah>
    private int index;//Counter within ArrayLists. Resets when done.
    private Random rand;

    //Categories
    private Category MASH;
    //Life
    private Category Job, RetirementAge, LivingLocation, 
	Pet, Salary, NumKids;
    //Stuy
    private Category GPA, Teacher, LockerFloor, 
	LunchPeriod, College, NumFrees;

    //Constructors
    public MASH(){
	spinnernum = 0; //Will be changed in stuff
	finished = false;
	counter = 1;//So does't kill first item incorrectly.
	index = 0;
    }


    //Methods
    public void game(){//The game
	//Player selects which game to run, STUY or LIFE.
	int version = gameSelect();// 0 for Stuy and 1 for Life
	if (version == 0){// Stuy Version

	    // Creating the ArrayList of data for each Category
	    for (int i = 0 ; i < 6; i++){
		switch(i) {
		case 0: ArrayList<String> GPAAL = new ArrayList<String>();
		    break;
		case 1: ArrayList<String> TeacherAL = new ArrayList<String>();
		    break;
		case 2: ArrayList<String> LockerFloorAL = new ArrayList<String>();
		    break;
		case 3: ArrayList<String> LunchPeriodAL = new ArrayList<String>();
		    break;
		case 4: ArrayList<String> CollegeAL = new ArrayList<String>();
		    break;
		case 5: ArrayList<String> NumFreesAL = new ArrayList<String>();
		    break;
		default: System.out.println ("Creating Category Error");
		    break;
		}

		for (int j = 0; j <3; j++){
		    
		    Scanner scan = new Scanner (System.in);
		    System.out.println ("Please give a");
		    
		}
	    }
	}
	else {//Life Version
	    // Creating the ArrayList of data for each Category
	    for (int i = 0 ; i < 6; i++){
		switch(i) {
		case 0: ArrayList<String> JobAL = new ArrayList<String>();
		    break;
		case 1: ArrayList<String> RetirementAgeAL = new ArrayList<String>();
		    break;
		case 2: ArrayList<String> LivingLocationAL = new ArrayList<String>();
		    break;
		case 3: ArrayList<String> PetAL = new ArrayList<String>();
		    break;
		case 4: ArrayList<String> SalaryAL = new ArrayList<String>();
		    break;
		case 5: ArrayList<String> NumKidsAL = new ArrayList<String>();
		    break;
		default: System.out.println ("Creating Category Error");
		    break;
		}
		
		for (int j = 0; j <3; j++){
		    
		    Scanner scan = new Scanner (System.in);
		    System.out.println ("Please give a");
		    
		}
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

    public static void main(String[] args){
	MASH game = new MASH();
	
	
    }
}