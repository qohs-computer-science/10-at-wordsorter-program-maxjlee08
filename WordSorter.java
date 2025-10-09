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
			
			
		}
		ArrayList<String> lower = new ArrayList<>();
		for(String x: words){
			lower.add(x.toLowerCase());
		}
			System.out.println(lower);

		for(int i= 0; i < lower.size(); i++)
			for(x = lower.size(); x < lower.size()+1; x--)
				if(i.value() == x.value())
		}
		

	}
}