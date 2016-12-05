abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(){
    }
    public LibraryBook(String a, String t, String n, String c){
    	setAuthor(a);
    	setTitle(t);
    	setISBN(n);
    	callNumber = c;
    }
    public String getCN(){
	   return callNumber;
    }
    public void setCN(String c){
	   callNumber = c;
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    public  int compareTo(LibraryBook book){
	   return callNumber.compareTo(book.callNumber);
    }
}
