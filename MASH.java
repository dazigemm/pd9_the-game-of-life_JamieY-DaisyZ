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


    //Methods
    public void game(){//The game
	//Player selects which game to run, STUY or LIFE.

	//Stuff
	spinner();//Changes the spinnernum, doesn't need to use the return val.
    }

    public int spinner(){
	spinnernum = rand.nextInt(10);//Arbitrary num as of right now.
	return spinnernum;
    }


    public static void main(String[] args){
	MASH game = new MASH();
	
	
    }
}