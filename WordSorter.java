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
			//System.out.println(lower);

		ArrayList <String> [] order = new ArrayList[26];
		for(int x = 0; x < order.length; x++)
			order[x] = new ArrayList<String>();
		
		for(String temp: lower){
			char group = temp.charAt(0);
		if(group >= 'a' && group <='z'){
			int first = group - 'a';
			order[first].add(temp);

		}
		System.out.println(order);
		
		}

		
		
			
		
		}
}


