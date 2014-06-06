/*****************************************************
 * class CLList 
 * implements a circularly-linked list of doubly-linked nodes
 ******************************************************/
import java.util.ArrayList;
import java.io.*;

public class CLList {

    // only 1 head/tail/front/end pointer is necessary,
    // since the list is circularly-linked
    private Category _head;
    private int _size = 0;

    public CLList() {
	_head = null;
	_size = 0;
    }

    public int size() { return _size; }

    //adds a new category named x, with an empty arraylist
    public boolean add( String x ) {

	if ( size() == 0 ) {
	    _head = new Category( x, null, null );
	    _head.setNext( _head );
	    _head.setPrev( _head );
	}
	else {
	    Category oldLast = _head.getPrev();

	    // insert new node between head and oldLast
	    _head.setPrev( new Category( x, oldLast, _head) );
	    oldLast.setNext( _head.getPrev() );
        }
	_size++;

	return true;
    }

    //gets the category/node at the index
    public Category get( int index ) {

	Category tmp = _head;

	for( int i = 0; i < index % size(); i++ )
	    tmp = tmp.getNext();

	return tmp;
    }

    //gets the node and returns the value at index index in its arrayList
    public String get (int n, int index) {
	Category tmp = _head;

	for( int i = 0; i < index % size(); i++ )
	    tmp = tmp.getNext();

	return tmp.getValue(index);
    }

    //originally set cargo in dllnode
    //now sets data of category at index to newVal and returns oldVal (foo)
    public ArrayList<String> set( int index, ArrayList<String> newVal ) {

	ArrayList<String> foo;
	Category tmp = _head;

	for( int i = 0; i < index % size(); i++ )
	    tmp = tmp.getNext();

	foo = tmp.setData( newVal );
	
	return foo;
    }

    public String toString() {
	String foo = "";//HEAD-> ";
	Category tmp = _head;
	for( int i = 0; i < _size; i++ ) {
	    foo += tmp + " <-> ";
	    tmp = tmp.getNext();
	}
	if ( foo.length() > 7 )
	    foo = foo.substring( 0, foo.length() - 5 );
	//foo += " <--...back to HEAD";
	return foo;
    }

    //checks if there is only 1 thing in each category
    public boolean isThereOne () {
	
	for (int i = 0; i < _size; i++) {
	    if (get(i).getSize() != 1) 
		return false;
	}

	return true;
    }

    public String remove (int node, int index) {
	return get(node).remove(index);
    }

    public static void main( String[] args ) throws IOException{

	BufferedReader reader =
	    new BufferedReader(new InputStreamReader(System.in));

	CLList Categories = new CLList();
	Categories.add("spouse");
	Categories.add("job");
	Categories.add("number of kids");
	Categories.add("salary");
	Categories.add("retirement age");
	Categories.add("living location");

	for (int i = 0; i < Categories.size(); i++) {
	    System.out.println("Fill in your choices for " + 
			       Categories.get(i).getName());

	    ArrayList<String> arr = new ArrayList<String>();
	    for (int a = 0; a < 3; a++) {
		
		System.out.print(a + 1 + " : ");
		String input = reader.readLine();
		arr.add(input);
		
	    }
	    Categories.set(i, arr);
	}

	System.out.println(Categories);
	//System.out.println(Categories.get(7));

	System.out.println("Spinning...");

	int spun = 2;
	int counter = 1;//num nodes passed
	int node = 0;
	int index = 0; 
	while (! Categories.isThereOne() ) {
	    int catSize = Categories.get(node).getSize();
	   	if (catSize == 1 
		    || index >= catSize) {
		   
		    node++;
		    index = 0;
		}
	    if (counter % spun == 0) {
		
		if (catSize == 1 
		    || index >= catSize) {
		   
		    node++;
		    index = 0;
		}
		String removed = Categories.remove(node, index);
		System.out.println( removed + 
				    " is not in your future" + Categories.get(node).getName());
	    }
	    counter++;
	    index++;
	    //System.out.println(Categories);
	}
	System.out.println(Categories);

	String results = "";
	for (int i = 0; i < Categories.size(); i++) {
	    results += Categories.get(i).getValue(0) + ",";
	}
	results = results.substring(0, results.length() - 1);
	System.out.println(results);//should be stored in text file
	/*
	CLList liz = new CLList();
	
	liz.add("kenneth");
	liz.add("jack");
	liz.add("tracy");
	
	liz.add("partner"); // added partner category
	ArrayList<String> p = new ArrayList<String>();
	p.add("kenneth");
	p.add("jack");
	p.add("tracy");

	liz.set(0, p);

	liz.add("pet");
	liz.get(1).add("dog");
	System.out.println(liz);

	System.out.println("\ntesting get()...");
	for( int i = 0; i < liz._size; i++ ) {
	    System.out.println("node " + i + " contains " + liz.get(i) );
	    System.out.println(liz);
	}
	/*
	System.out.println("\ntesting set()...");
	for( int i = 0; i < liz._size; i++ ) {
	    System.out.println( liz.set( i, "rock"+i ) );
	    System.out.println(liz);
	}
	*/
    }//end main

}//end class CLList
