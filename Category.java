/**********
 * Andrew Fan: This is Category.java, the class containing the basic data for Categories.
 * This class uses an ArrayList to store values because it's less mind boggling than a LinkedList, which is more efficient but harder to comprehend becaue there would be a Circularly Linked List of Linked Lists. It will function as a DLLNode.
 *********/
import java.util.ArrayList;

public class Category{

    private ArrayList<String> data;
    private String name;
    private Category _nextNode, _prevNode;

    // Constructors... too many
    public Category(){//Avoid
	data = new ArrayList<String>();
	_prevNode = _nextNode = null;
	name = "";
    }

    public Category(String name){//good constructor
	data = new ArrayList<String>();
	_prevNode = _nextNode = null;
	name = name;
    }

    public Category (String name, Category prev, Category nxt) {
	this(name);
	_nextNode = nxt;
	_prevNode = prev;
    }
    public Category (String name, ArrayList<String> input, Category prev, Category nxt) {
	this(name, prev, nxt);
	data = input;
    }

    public void add(String s){
	data.add(s);
    }

    // ********** Mutators *********

    public ArrayList<String> setData (ArrayList<String> input) {
	ArrayList<String> tmp  = data;
	data = input;
	return tmp;
    }

    public String setName (String newName) {
	String tmp = name;
	name = newName;
	return tmp;
    }

    public Category setNext ( Category newNext ) {
	Category tmp = _nextNode;
	_nextNode = newNext;
	return tmp;
    }

    public Category setPrev ( Category newPrev ) {
	Category tmp = _prevNode;
	_prevNode = newPrev;
	return tmp;
    }
    public String remove(int index){
	String retval = data.remove(index);
	return retval;
    }

    //ACCESSORS
    public String getValue(int index){
	return data.get(index);
    }

    public String getName(){
	return name;
    }

    public Category getNext() { return _nextNode; }
    public Category getPrev() { return _prevNode; }

    public int getSize(){
	return data.size();
    }

    public boolean isEmpty(){//This has its uses
	return data.isEmpty();
    }



    //Add other required methods here. As long as it works with the project, it is fine.

    public String toString(){
	return data.toString();
    }

}