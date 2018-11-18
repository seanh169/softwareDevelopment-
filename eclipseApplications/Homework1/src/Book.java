/**
 * 
 * 
 * 
 * 
 * @author Sean Hamilton
 * 
 * @description - Simple book class with setters and getters
 *
 */
public class Book {
	
	//Private attributes of a Book
	private String title;
	private String author;
	private int ISBN;
	
	//Empty constructor necessary, I think Java does this for you now if you forget.
	public Book() {}
	
	//constructor for creating Book instance
	public Book(String title, String author, int ISBN) {
		this.title = title; 
		this.author = author;
		this.ISBN = ISBN;
	}
	
	//Simple method to display all information about our Book instance.
	public String info() {
		return "The title of this book is : " + this.title + "\n" + 
				"The author of this book is: " + this.author + "\n" + 
				"The ISBN : " + this.ISBN;
	}
	//Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	
	

}
