//This is the Statistics.java file. It contains all the functions for statistican analysis of data.

//This class is meant to be instantiated ONCE and then for its methods to be called from outside.

public class Statistics{

    private ALMinHeap minheap;
    private ALMaxHeap maxheap;

    public Statistics(){//Constructor
	minheap = new ALMinHeap();
	maxheap = new ALMaxHeap();
    }

    //Creates a String ArrayList from a column of text data. 
    public ArrayList<String> createAListfromFile(int column){
	return null;
    }

    //Creates an Integer ArrayList from a column of text data.
    public ArrayList<Integer> createAListfromFile(int column){
	return null;
    }

    /*********************************************
	   THROWAWAY FUNCTIONS BELOW 
    *********************************************/
    
    //MEAN FUNCTIONS
    public double getMean(int[] dataM){
	int temp = 0;
	for(int i = 0; i<dataM.length; i++){
	    temp+=dataM[i];
	}
	temp/=dataM.length;
	return temp;
    }

    public double getMean(ArrayList<Integer> dataM){
	int temp = 0;
	for(int i = 0; i<dataM.size(); i++){
	    temp+=dataM.get(i);
	}
	temp/=dataM.size();
	return temp;
    }

    //MEDIAN FUNCTIONS

}