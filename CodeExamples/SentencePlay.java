package CodeExamples;

import java.util.*;

public class SentencePlay {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please type in a sentence: ");
		String sentence = scan.nextLine();
		String newSentence = "";
		
		for(int i = 0; i < sentence.length(); i++)
		{
			if (Character.isLetterOrDigit(sentence.charAt(i)) || Character.isWhitespace(sentence.charAt(i)))
			{
				newSentence += sentence.charAt(i);
			}
		}
		
		sentence = newSentence;
		System.out.println(newSentence);
		
		
		String[] words = sentence.split(" ");
		List<String> wordList = new ArrayList<String>();
		
		System.out.println("Here is your sentence backwards: ");
		reverseSentence(sentence);
		
		System.out.println("Now when I split it, do you want case sensitivity? (y/n)");
		String selection = scan.nextLine();
		
		if(selection.equals("y"))
		{
			for (String word : words)
			{
				wordList.add(word);
			}
			
			System.out.println("List of words: " + sentence);
		}
		else if(selection.equals("n"))
		{
			for (String word : words)
			{
				word = word.toLowerCase();
				wordList.add(word);
			}
			
			System.out.println("List of words: " + sentence.toLowerCase());
		}
		else
		{
			System.out.println("Invalid Selection");
		}
		
		sortAlpha(wordList);
		sortBackwards(wordList);
		shuffle(wordList);
		removeDuplicates(wordList);
	}
	
	public static void reverseSentence(String sentence)
	{
		String reverse = "";
		
		for (int i = sentence.length() -1; i >=0; i--)
		{
			reverse += sentence.charAt(i);
		}
		
		System.out.println(reverse);
	}
	
	public static void sortAlpha(List<String> wordList)
	{
		
		
		Collections.sort(wordList);
		
		StringBuilder sb = new StringBuilder();
		for (String word : wordList)
		{
			sb.append(word + " ");
		}
		
		System.out.println("Sorted alphabetically: " + sb.toString());
	}
	
	public static void sortBackwards(List<String> wordList)
	{	
		Collections.sort(wordList, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for (String word : wordList)
		{
			sb.append(word + " ");
		}
		
		System.out.println("Sorted backwards: " + sb.toString());
	}
	
	public static void shuffle(List<String> wordList)
	{
		Collections.shuffle(wordList);
		
		StringBuilder sb = new StringBuilder();
		for (String word : wordList)
		{
			sb.append(word + " ");
		}
		
		System.out.println("Shuffled: " + sb.toString());
	}
	
	public static void removeDuplicates(List<String> wordList)
	{
		
		Collections.sort(wordList);
		
		List<String> newList = new ArrayList<String>();
		
		for (String s : wordList)
		{
			if(!newList.contains(s))
			{
				newList.add(s);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (String str : newList)
		{
			sb.append(str + " ");
		}
		
		System.out.println("Without duplicates, sorted alphabetically: " + sb.toString());
		//System.out.println(newList.toString());
	}

}
