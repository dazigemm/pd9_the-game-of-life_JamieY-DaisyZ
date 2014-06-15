//This is the Statistics.java file. It contains all the functions for statistican analysis of data.

//This class is meant to be instantiated ONCE and then for its methods to be called from outside.
import java.util.*;
import java.io.*;

public class Statistics{

    public Statistics(){//Constructor

    }

    //BELOW TWO METHODS SHOULD BE USED FOR OBTAINING STATISTICAL DATA.
    //Results are stored in text files using BufferedWriters and Filewriters.
    //Parsing is currently done using , DELIMITER ON SCANNER MUST BE SET TO USE THIS.
    //Default delimiter on scanner is white space.
    public void getStatisticsSTUY(){
	System.out.println("These are the statistics for STUY.\nUnfortunately, statistical data is not available for non-integer categories");
	File stuyfile = new File("./Stuy.txt");
    }
    
    public void getStatisticsLIFE(){
	System.out.println("These are the statistics for Life, the standard MASH game.\nUnfortunately, statistical data is not available for non-integer categories");
	File lifefile = new File("./Life.txt");
    }

    //STUY: MASH (String), GPA (int), Teacher (String), Locker Floor (int), Lunch Period (int), College (String), NumFrees (int)
    //LIFE: MASH (String), Job (String), Retirement Age (int), Living Location (String), Pet (String), Salary (int), NumKids (int)
    //MASH can be hardcoded since there are only four choices

    //Creates a String ArrayList from a column of text data. 
    public ArrayList<String> createAListStrFromFile(int column, File pathfile){//INCOMPLETE
	try{
	    Scanner scan = new Scanner(pathfile);
	    scan.useDelimiter(",");
	}catch(FileNotFoundException e){//Most likely File not Found Error
	    System.out.println("File Not Found. Make sure that the file: " + pathfile + " exists");
	    return null;
	}
	ArrayList<String> result = new ArrayList<String>();
	return result;
    }

    //Creates an Integer ArrayList from a column of text data.
    public ArrayList<Integer> createAListIntFromFile(int column, File pathfile){//INCOMPLETE
	try{
	    Scanner scan = new Scanner(pathfile);
	    scan.useDelimiter(",");
	}catch(FileNotFoundException e){//Most likely File not Found Error
	    System.out.println("File Not Found. Make sure that the file: " + pathfile + " exists");
	    return null;
	}
	ArrayList<Integer> result = new ArrayList<Integer>();
	return result;
    }

    public void printStatsInt(int[] data){//Do this before ArrayList version
	System.out.println("Dataset size:" + data.length);
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
    public double getMedian(int[] data){//WORKING CORRECTLY
	if(data.length==0){return -1;}
	if(data.length==1){return data[0];}
	int[] tempdata = heapsort(data);
	int datalength = tempdata.length;
	if(datalength%2==1){
	    return tempdata[(int)(datalength/2)];
	}else{
	    return tempdata[(int)(datalength/2)]+tempdata[(int)(datalength/2)-1];
	}
    }

    public double getMedian(ArrayList<Integer> data){//Maybe WORKING CORRECTLY
	if(data.size()==0){return -1;}
	if(data.size()==1){return data.get(0);}
	ArrayList<Integer> tempdata = heapsort(data);
	int datalength = tempdata.size();
	if(datalength%2==1){
	    return tempdata.get((int)(datalength/2));
	}else{
	    return tempdata.get((int)(datalength/2))+tempdata.get((int)(datalength/2)-1);
	}
    }

    //ACCESSORY FUNCTIONS

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
