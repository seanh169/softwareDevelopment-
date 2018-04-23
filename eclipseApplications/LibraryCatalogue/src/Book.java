
public class Book {
	
	//Properties 
	String title;
	int pageCount;
	int ISBN;
	boolean isCheckedOut; //whether or not it is checked out.
	int dayCheckedOut = -1;
	
	
	public Book(String bookTitle, int bookPageCount, int bookISBN) {
		this.title = bookTitle;
		this.pageCount = bookPageCount;
		this.ISBN = bookISBN;
		isCheckedOut = false;
	}
	//Getters and Setters
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPageCount() {
		return this.pageCount;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}
	public boolean isCheckedOut() {
		return isCheckedOut;
	}
	public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut) {
		this.isCheckedOut = newIsCheckedOut;
		setDayCheckedOut(currentDayCheckedOut);
	}
	public int getDayCheckedOut() {
		return dayCheckedOut;
	}
	private void setDayCheckedOut(int dayCheckedOut) {
		this.dayCheckedOut = dayCheckedOut;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
