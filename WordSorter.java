//Max Lee
//10/14/2025
//This code creates a menu that when the user chooses an option it completes a specific task.
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		boolean again = true;
		ArrayList<String> words = new ArrayList<>();
		Scanner keyB = new Scanner(System.in);
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
		for(int i = 0; i < lower.size(); i++)
			if(i==0 || !lower.get(i).equals(lower.get(i-1))){
				unique.add(lower.get(i));
			}
			System.out.println("____________________________________");
			System.out.println("[Without Duplicates]");
			System.out.println(unique);

		//Make the menu
		while(again){		
		System.out.println("1) Print out all words starting with a specific letter:");
		System.out.println("2) Print out all words in their letter groups:");
		System.out.println("3) Print the number of unique words:");
		System.out.println("4) Search if a word is in the article:");
		System.out.println("5) Remove a word from the data structure:");
		System.out.println("6) Exit");
		System.out.print("Choose an Option: ");
		int choice = keyB.nextInt();
		//Input from the keyboard
		if(choice==1){
		ArrayList<String> firstChar = new ArrayList<>();			
		System.out.println("Input a letter of a word you would like to find: ");
		char letter = keyB.next().charAt(0);
		for(int x = 0; x < unique.size(); x++){
		String find = unique.get(x);
		if(find.charAt(0) == letter){
			firstChar.add(find);
			}//end if
		
		}//end for
		
		System.out.println("______________________");
		System.out.println(firstChar);
	}//end if
	//print out all of the words 
		else if(choice==2){
		for(char order = 'a'; order <= 'z'; order++){
		System.out.println("Letter: " + order);
		boolean found = false;

			for(String a : unique){
				if(Character.toLowerCase(a.charAt(0))==order){
					System.out.println(a);
					found = true;
				}//end if
			}//end for
			if(!found){
				System.out.println("Empty List");
			}//end if
		}//end for
	}//end else if
		//print out the number of unique words
		else if(choice==3){
		System.out.println("There are " + unique.size() + " unique words in the article");
	}//end else if

	//Searh and determine if a word is in the article
	else if(choice==4){
		System.out.print("Enter a word you would like to search for: ");
		String search = keyB.next().toLowerCase();
		
		if(unique.contains(search)){
			System.out.println("Word found in the article");
		}
			else{
			System.out.println("Word NOT found in the article");
			}//end else
		}//end if
	//If user wants to remove a word
	else if(choice==5){
		System.out.print("Enter a word you want to remove: ");
		String remove = keyB.next().toLowerCase();

		if(unique.contains(remove)){
			unique.remove(remove);
			System.out.println("Word successfully removed from the list.");}
		else
		System.out.println("Word Not found in the article.");
		}//end if
	

	else if(choice==6){
		System.out.println("Goodbye!");
		again=false;
	}//end if
	}
	//Go again
	
	System.out.println("Would you like to continue? 1:Yes 2:No");
	int another = keyB.nextInt();	
	if(another==1)
		again = true;
	else
		again = false;
	
		}//end main
}//end class


