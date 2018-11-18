



public class BookTest {
	
	public static void main(String[] args) {
		Book testBook = new Book("SeansBook", "Sean", 121234);
		System.out.println(testBook.info());
		System.out.println("----End Test 1----");
		System.out.println(testBook.getTitle());
		testBook.setTitle("Harry Potter");
		System.out.println(testBook.getTitle());
		System.out.println("----End Test 2----");
		System.out.println(testBook.getAuthor());
		testBook.setAuthor("JKROWLING");
		System.out.println(testBook.getAuthor());
		System.out.println("----End Test 3----");
		System.out.println(testBook.getISBN());
		testBook.setISBN(595572);
		System.out.println(testBook.getISBN());
		System.out.println("----End Test 4----");
		System.out.println(testBook.info());
		System.out.println("----End Test 5----");
		
		
		
		
	}

}
