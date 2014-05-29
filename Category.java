/**********
 * Andrew Fan: This is Category.java, the class containing the basic data for Categories.
 * This class uses an LinkedList to store values because it makes adding and removing less of a pain to deal with.
 * There is a chance this will just be scrapped and left to gather dust.
 *********/
import java.util.LinkedList;

public class Category{
    private LinkedList<String> data;
    private int size;//Important for checking if a category has only one element

    public Category(){
	data = new LinkedList<String>();
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