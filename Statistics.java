//This is the Statistics.java file. It contains all the functions for statistican analysis of data.

//This class is meant to be instantiated ONCE and then for its methods to be called from outside.

public class Statistics{

    public Statistics(){//Constructor

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
    //REQUIRES A HEAPSORT OR OTHER SORTING ALGORITHM


    public static ArrayList<Integer> heapsort(ArrayList<Integer> data){//untested Heap Sort.
	ArrayList<Integer> returnArr = new ArrayList<Integer>(data.size());
	ALMinHeap heapity = new ALMinHeap();
	for(int i = 0; i<data.size(); i++){
	    heapity.add(data.get(i));
	}
	for(int i = 0; i<data.size; i++){
	    returnArr.set(i, heapity.removeMin());
	}
	return returnArr;
    }

}
