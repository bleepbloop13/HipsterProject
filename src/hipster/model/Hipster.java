package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	
	public Hipster()
	{
		this.name= "";
		this.hipsterPhrases= new String[4];
		setupArray();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "I don't like breathing, it's too mainstream";
		hipsterPhrases[1] = "I liked pizza before it was cool";
		hipsterPhrases[2] = "I was offended by before it was cool";
		hipsterPhrases[3] = "I had public data members back when it was 'unique'.";
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
}
