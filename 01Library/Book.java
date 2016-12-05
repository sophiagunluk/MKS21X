public class Book{
    private String author;
    private String title;
    private String ISBN;
    public Book(){
	/*
	author = "No one";
	title = "Nothing";
	ISBN = "000000000";
	*/
    }
    public Book(String a, String t, String n){
    	author = a;
    	title = t;
    	ISBN = n;
    }
    public String getAuthor(){
	   return author;
    }
    public String getTitle(){
	   return title;
    }
    public String getISBN(){
	   return ISBN;
    }
    public void setAuthor(String a){
	   author = a;
    }
    public void setTitle (String t){
	   title = t;

    }
    public void setISBN  (String n){
	   ISBN = n;
    }
    public String toString(){
	   return "" + title + ", " + author + ", " + ISBN;
    }
}
