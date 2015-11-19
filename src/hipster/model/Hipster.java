package hipster.model;

public class Hipster
{
	private String name;
	private String[] hipsterPhrases;
	private Book[] hipsterBooks;

	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
		setupArray();
		setupBooks();
	}

	private void setupArray()
	{
		hipsterPhrases[0] = "I don't like breathing, it's too mainstream";
		hipsterPhrases[1] = "I liked pizza before it was cool";
		hipsterPhrases[2] = "I was offended by Starbucks before it was cool";
		hipsterPhrases[3] = "I had public data members back when it was 'unique'.";
	}

	private void setupBooks()
	{
		Book firstBook, secondBook, thirdBook;

		firstBook = new Book();
		firstBook.setAuthor("Bram Stoker");
		firstBook.setTitle("Dracula");
		firstBook.setSubject("Horror");
		firstBook.setPageCount(408);
		firstBook.setPrice(4.99);

		secondBook = new Book();
		secondBook.setAuthor("Frank Herbert");
		secondBook.setTitle("Dune");
		secondBook.setSubject("Science Fiction");
		secondBook.setPageCount(412);
		secondBook.setPrice(9.99);

		thirdBook = new Book();
		thirdBook.setAuthor("Ayn Rand");
		thirdBook.setTitle("Atlas Shrugged");
		thirdBook.setSubject("Philisophical Fiction");
		thirdBook.setPageCount(1188);
		thirdBook.setPrice(12.99);

		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPhrases(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}

	public Book[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	public void setHipsterBooks(Book[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}
}
