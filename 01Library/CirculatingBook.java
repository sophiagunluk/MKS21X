public class CirculatingBook extends LibraryBook{
	private String currentHolder;
	private String dueDate; 
	public CirculatingBook(String a, String t, String n, String c){
    	setAuthor(a);
    	setTitle(t);
    	setISBN(n);
    	setCN(c);
    	currentHolder = null;
    	dueDate = null;
    }
    public void setCH(String ch){
    	currentHolder = ch;
    }
    public void setDD(String dd){
    	dueDate = dd;
    }
    public String getCH(){
    	return currentHolder;
    }
    public String getDD(){
    	return dueDate;
    }
    public void checkout(String patron, String date){
    	currentHolder = patron;
		dueDate = date;
    }
    public void returned(){
    	currentHolder = null;
    	dueDate = null;
    }
    public String circulationStatus(){
    	if (currentHolder == null){
    		return "" + currentHolder + ", " + dueDate;
    	}
    	return "book available on shelves";
    }
    public String toString(){
    	if (currentHolder == null){
    		return super.toString();
    	}
    	return super.toString() + ", " + currentHolder + ", " + dueDate;
    }

}