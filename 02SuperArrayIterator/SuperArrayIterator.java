import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator{
	private SuperArray ary;
	private int counter;
	public SuperArrayIterator(SuperArray sa){
		counter = 0;
		ary = sa;
	}
	public boolean hasNext(){
		return counter < ary.size();
	}
	public String next(){
		if (!hasNext()){
			throw new NoSuchElementException();
		}
		counter++;
		return ary.get(counter-1);
	}
	public void remove(){
		throw new UnsupportedOperationException();
	}
}