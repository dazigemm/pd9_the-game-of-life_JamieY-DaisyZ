/*****************************************************
 * class CLList 
 * implements a circularly-linked list of doubly-linked nodes
 ******************************************************/
import java.util.ArrayList;
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
	String foo = "HEAD-> ";
	Category tmp = _head;
	for( int i = 0; i < _size; i++ ) {
	    foo += tmp + " <-> ";
	    tmp = tmp.getNext();
	}
	if ( foo.length() > 7 )
	    foo = foo.substring( 0, foo.length() - 5 );
	foo += " <--...back to HEAD";
	return foo;
    }


    public static void main( String[] args ) {

	CLList liz = new CLList();
	/*
	liz.add("kenneth");
	liz.add("jack");
	liz.add("tracy");
	*/
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
