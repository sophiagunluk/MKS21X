public class ReferenceBook extends LibraryBook{
	private String collection;
	public ReferenceBook(String a, String t, String n, String c, String co){
    	setAuthor(a);
    	setTitle(t);
    	setISBN(n);
    	setCN(c);
    	collection = co;
    }
    public void setCollection(String c){
    	collection = c;
    }
    public String getCollection(){
    	return collection;
    }
    public void checkout(String patron, String date){
    	System.out.println( "cannot check out a reference book");
    }
    public void returned(){
    	System.out.println("reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus(){
    	return "non-circulating reference book";
    }
    public String toString(){
    	return super.toString() + ", " + collection;
    }
}