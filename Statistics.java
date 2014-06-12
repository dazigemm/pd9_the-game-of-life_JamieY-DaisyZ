//This is the Statistics.java file. It contains all the functions for statistican analysis of data.

//This class is meant to be instantiated ONCE and then for its methods to be called from outside.
import java.util.*;

public class Statistics{

    public Statistics(){//Constructor

    }

    //Creates a String ArrayList from a column of text data. 
    public ArrayList<String> createAListStrFromFile(int column){
	return null;
    }

    //Creates an Integer ArrayList from a column of text data.
    public ArrayList<Integer> createAListIntFromFile(int column){
	return null;
    }

    public void printStatsInt(int[] data){
	System.out.println("Median:" + getMedian(data));
	System.out.println("Mean:" + getMean(data));
    }

    /*********************************************
	   STATISTICAL FUNCTIONS BELOW 
    *********************************************/
    
    //MEAN FUNCTIONS
    public double getMean(int[] dataM){
	if(dataM.length==0){return -1;}
	if(dataM.length==1){return dataM[0];}
	int temp = 0;
	for(int i = 0; i<dataM.length; i++){
	    temp+=dataM[i];
	}
	temp/=dataM.length;
	return temp;
    }

    public double getMean(ArrayList<Integer> dataM){
	if(dataM.size()==0){return -1;}
	if(dataM.size()==1){return dataM.get(0);}
	int temp = 0;
	for(int i = 0; i<dataM.size(); i++){
	    temp+=dataM.get(i);
	}
	temp/=dataM.size();
	return temp;
    }

    //MEDIAN FUNCTIONS
    //REQUIRES A HEAPSORT OR OTHER SORTING ALGORITHM
    //TYPECASTING TO INT TRUNCATES
    public double getMedian(int[] data){//INCOMPLETE.
	if(data.length==0){return -1;}
	if(data.length==1){return data[0];}
	int[] tempdata = heapsort(data);
	int datalength = tempdata.length;
	if(datalength%2==1){
	    return data[(int)(data.length/2)];
	}else{
	    
	}
	return 0;
    }

    public double getMedian(ArrayList<Integer> data){//incomplete
	if(data.size()==0){return -1;}
	if(data.size()==1){return data.get(0);}
	ArrayList<Integer> tempdata = heapsort(data);
	int datalength = tempdata.size();
	if(datalength%2==1){

	}else{

	}
	return 0;
    }

    public ArrayList<Integer> heapsort(ArrayList<Integer> data){
	ArrayList<Integer> returnArr = new ArrayList<Integer>(data.size());
	ALMinHeap heapity = new ALMinHeap();
	for(int i = 0; i<data.size(); i++){
	    heapity.add(data.get(i));
	}
	for(int i = 0; i<data.size(); i++){
	    returnArr.set(i, heapity.removeMin());
	}
	return returnArr;
    }

    public int[] heapsort(int[] data){//WORKS
	int[] returnArr = new int[data.length];
	ALMinHeap heapity = new ALMinHeap();
	for(int i = 0; i<data.length; i++){
	    heapity.add(data[i]);
	}
	for(int i = 0; i<data.length; i++){
	    returnArr[i] = heapity.removeMin();
	}
	return returnArr;
    }

    public void printArray(int[]a){
	String result = "[ ";
	for(int i = 0; i<a.length; i++){
	    result+=a[i]+" ";
	}
	result+="]";
	System.out.println(result);
    }

    public static void main(String[] args){
	Statistics lol = new Statistics();
	//test heap sort
	System.out.println("Testing Heap Sort");
	int[] nyah = {1,56,2,4,2,52,432,41,424,1,242,312,42,12,312};
	lol.printArray(nyah);
        lol.printStatsInt(nyah);
    }

}
