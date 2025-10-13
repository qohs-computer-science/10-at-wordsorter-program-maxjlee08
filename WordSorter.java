import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		ArrayList<String> words = new ArrayList<>();

		Scanner in = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	
		String word = "";
		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			System.out.println(word);
			words.add(word);
			
		//Make it all lower case	
		}
		ArrayList<String> lower = new ArrayList<>();
		for(String x: words){
			lower.add(x.toLowerCase());
		}
			//System.out.println(lower);
		//Make it all in order(group them)
		for(int i = 0; i<lower.size()-1; i++){
			int val = i;
			for(int y = i +1; y < lower.size(); y++){
				if(lower.get(y).compareTo(lower.get(val))<0){
					val=y;
				}
			}
			String order = lower.get(i);
			lower.set(i, lower.get(val));
			lower.set(val, order);
		}
		System.out.println("____________________________________");
		System.out.println("[Alphabetical Order]");
		System.out.println(lower);
		
		//Take out the duplicates
		ArrayList<String> unique = new ArrayList<>();			
		
		}
}


