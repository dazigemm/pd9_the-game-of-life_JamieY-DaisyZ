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
	System.out.println("GPA Data");
	printStatsInt(createAListIntFromFile(1, stuyfile));//GPA
	System.out.println("Locker Floor Data");
	printStatsInt(createAListIntFromFile(3, stuyfile));//Locker Floor
	System.out.println("Lunch Period Data");
	printStatsInt(createAListIntFromFile(4, stuyfile));//Lunch Period
	System.out.println("Number of Frees Data");
	printStatsInt(createAListIntFromFile(6, stuyfile));//NumFrees
    }
    
    public void getStatisticsLIFE(){
	System.out.println("These are the statistics for Life, the standard MASH game.\nUnfortunately, statistical data is not available for non-integer categories");
	File lifefile = new File("./Life.txt");
	System.out.println("Retirement Age Data");
	printStatsInt(createAListIntFromFile(2, lifefile));//RetAge
	System.out.println("Salary Data");
	printStatsInt(createAListIntFromFile(5, lifefile));//Salary
	System.out.println("Number of Kids Data");
	printStatsInt(createAListIntFromFile(6, lifefile));//NumKids
    }

    //STUY: MASH (String), GPA (int), Teacher (String), Locker Floor (int), Lunch Period (int), College (String), NumFrees (int)
    //LIFE: MASH (String), Job (String), Retirement Age (int), Living Location (String), Pet (String), Salary (int), NumKids (int)
    //MASH can be hardcoded since there are only four choices

    //Creates a String ArrayList from a column of text data. 
    public ArrayList<String> createAListStrFromFile(int column, File pathfile){//INCOMPLETE
	ArrayList<String> result = new ArrayList<String>();
	try{
	    Scanner scan = new Scanner(pathfile).useDelimiter("\\s*,\\s*");
	    while(scan.hasNextLine()){
		for(int i = 0; i<column; i++){
		    if(scan.hasNext()){
			scan.next();
		    }else{
			System.out.println("Scanner has reached end of line. ERROR.");
			return null;
		    }
		}
		String temp = scan.next();
		result.add(temp);//Add next one to the arraylist.
		scan.nextLine();//Advance scanner to next line.
		if(!scan.hasNext()){//security b/c infinite loop 
		    break;
		}
	    }
	    //TEST CODE
	    //System.out.println("Finished while loop");
	}catch(FileNotFoundException e){//Most likely File not Found Error
	    System.out.println("File Not Found. Make sure that the file: " + pathfile + " exists");
	    return null;
	}
	return result;
    }
    
    //Creates an Integer ArrayList from a column of text data.
    public ArrayList<Integer> createAListIntFromFile(int column, File pathfile){//INCOMPLETE
	ArrayList<Integer> result = new ArrayList<Integer>();
	try{
	    Scanner scan = new Scanner(pathfile).useDelimiter("\\s*,\\s*");
	    while(scan.hasNextLine()){
		for(int i = 0; i<column; i++){
		    if(scan.hasNext()){
			scan.next();
		    }else{
			System.out.println("Scanner has reached end of line. ERROR.");
			return null;
		    }
		}
		String temp = scan.next();
		//System.out.println(temp);//TEST
		result.add(Integer.parseInt(temp));//Add next one to the arraylist.
		scan.nextLine();//Advance scanner to next line.
		//System.out.println("Moving to next line");//Test
		//System.out.println(result);//TEST
		if(!scan.hasNext()){//security b/c infinite loop 
		    break;
		}
	    }
	}catch(FileNotFoundException e){//Most likely File not Found Error
	    System.out.println("File Not Found. Make sure that the file: " + pathfile + " exists");
	    return null;
	}catch(NumberFormatException e){
	    System.out.println("Number Format Exception. Most likely, a $ , or . was inserted into a number input.");
	    return null;
	}
	return result;
    }

    public void printStatsInt(int[] data){
	System.out.println("Dataset size:" + data.length);
	System.out.println("Median:" + getMedian(data));
	System.out.println("Mean:" + getMean(data));
    }
    public void printStatsInt(ArrayList<Integer> data){
	System.out.println("Dataset size:" + data.size());
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
	Statistics stat = new Statistics();
	stat.getStatisticsSTUY();
	//stat.getStatisticsLIFE();
    }

}
