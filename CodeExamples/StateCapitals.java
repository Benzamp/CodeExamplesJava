package CodeExamples;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class StateCapitals {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Map< String, String > lineMap = new HashMap< String, String >();
		lineMap = fileToMap();
		
		int correct = 0;
		int incorrect = 0;
		int finalScore = 0;
		
		String answer = "";
		
		System.out.println("Guess the state's capital to earn points. Type \"quit\" at anytime to quit.\n");
		System.out.println("Type in your name: ");
		String name = scan.nextLine();
		
		while(!answer.equals("quit"))
		{
			Object[] keys = lineMap.keySet().toArray();
			
			Object key = keys[new Random().nextInt(keys.length)];
			
			System.out.println("What is the capital of " + key + "?");
			answer = scan.nextLine().toLowerCase();
				
			if (answer.equals(lineMap.get(key).toLowerCase()))
			{
				System.out.println("That is correct!\n");
				correct++;
				finalScore++;
			}
			if (answer.equals("quit"))
			{
				continue;	
			} 
			else if (!answer.equals(lineMap.get(key).toLowerCase()))
			{
				System.out.println("Incorrect. The answer is: " + lineMap.get(key) + "\n");
				incorrect++;
				finalScore--;
			}
		}
		
		System.out.println("\nCorrect: " + correct);
		System.out.println("Incorrect: " + incorrect);
		System.out.println("Final Score: " + finalScore + "\n");
		System.out.println("\n\n");
		
		//Attempted to add leaderboard mechanic to the program, but didn't have time to finish it; would need a database
		//printLeaderboard(name, finalScore);
		
		System.out.println("\nThanks for Playing!");
		
		System.exit(0);
	}
	
	public static Map< String, String > fileToMap() {
		BufferedReader in = readFile();
		String line;
		Map< String, String > lineMap = new HashMap< String, String >();
		
		try {
			while((line = in.readLine()) != null)
			{
				String[] lineSplit = line.replaceAll("\\s","").split("-", 2);
				if (lineSplit.length >= 2)
				{
					String key = lineSplit[0];
					String value = lineSplit[1];
					lineMap.put(key, value);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lineMap;
	}
	
	public static BufferedReader readFile() {
		Frame f = new Frame();
		// open dialog box to find file path
		FileDialog foBox = new FileDialog(f, "Select the file location", FileDialog.LOAD);
		System.out.println("The dialog box may appear behind Eclipse"
				+ "\n Choose file location.\n");
		foBox.setVisible(true);
		
		
		// get path of file
		String foName = foBox.getFile();
		String dirPAth = foBox.getDirectory();
		
		// create file instance with found file path
		File inFile = new File(dirPAth + foName);
		if (!inFile.exists()) {
			System.out.println("File does not exist");
			System.exit(0);
		}
		
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(inFile));
		} catch (IOException e) {
			System.out.println("You threw an exception.");
		}
		
		return in;
	}
	
	/*public static void printLeaderboard(String name, int finalScore) {
	
	String rankedOne = "None";
	String rankedTwo = "None";
	String rankedThree = "None";
	
	int rankedOneScore = 0;
	int rankedTwoScore = 0;
	int rankedThreeScore = 0;
	
	if (finalScore > rankedThreeScore)
		{
			rankedThree = name;
			rankedThreeScore = finalScore;
		}
		else if (finalScore > rankedTwoScore && finalScore > rankedThreeScore)
		{
			rankedTwo = name;
			rankedTwoScore = finalScore;
			rankedThree = rankedTwo;
			rankedThreeScore = rankedTwoScore;
		}
		else if (finalScore > rankedOneScore && finalScore > rankedTwoScore && finalScore > rankedThreeScore)
		{
			rankedOne = name;
			rankedOneScore = finalScore;
			rankedTwo = rankedOne;
			rankedTwoScore = rankedOneScore;
			rankedThree = rankedTwo;
			rankedThreeScore = rankedTwoScore;
		}
		
		System.out.println("__________Leader Board__________"
				+ "\n********************************"
				+ "\n| " + rankedOne + "                       " + rankedOneScore
				+ "\n--------------------------------"
				+ "\n| " + rankedTwo + "                       " + rankedTwoScore
				+ "\n--------------------------------"
				+ "\n| " + rankedThree + "                     " + rankedThreeScore
				+ "\n________________________________");
		
	}*/
}
