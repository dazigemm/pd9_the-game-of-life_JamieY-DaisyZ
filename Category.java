/**********
 * Andrew Fan: This is Category.java, the class containing the basic data for Categories.
 * This class uses an ArrayList to store values because it's less mind boggling than a LinkedList, which is more efficient but harder to comprehend becaue there would be a Circularly Linked List of Linked Lists.
 *********/
import java.util.ArrayList;

public class Category{
    private ArrayList<String> data;
    private int size;//Important for checking if a category has only one element

    public Category(){
	data = new ArrayList<String>();
	size = 0;
    }

    public void add(String s){
	data.add(s);
	size++;
    }

    public String remove(int index){
	String retval = data.remove(index);
	size--;
	return retval;
    }

    public String get(int index){
	return data.get(index);
    }

    public String peekFirst(){
	return data.peekFirst();
    }

    public boolean isEmpty(){//This has its uses
	return size==0;
    }

    public int getSize(){
	return size;
    }

    //Add other required methods here. As long as it works with the project, it is fine.

    public String toString(){
	return data.toString();
    }

}