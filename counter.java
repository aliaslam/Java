import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Accepts a string passed as a command line argument.
 * Counts the number of occurrences of each character in the string
 * Ignoring whitespace characters
 * Treating upper-case characters as if they were lower-case
 * Prints the counts to standard output
 * One to a line
 * Ordered lexicographically by character
 * As the character, followed by space, followed by the count, followed by a newline
 * 
 */

public class counter {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		if(args.length == 0){
			System.out.println("No arguments passed. Please pass in a string to count the chars");			
			System.exit(0);
		}		
	
		printCount(args[0]);		
	}
	
	/**
	 * 
	 * @param inputString
	 */
	public static void printCount(String inputString){
		
		String cleanString;
		String[] keyArray;
		String[] cArray;
		int count;
		
		cleanString = inputString.replaceAll("\\s",""); //Replace all space chars
		cleanString = cleanString.toLowerCase(); //Converts chars all to lower case		
		cArray = cleanString.split("(?!^)"); //Make an array of individual chars		
		Map<String, Integer> charCountMap = new HashMap<String, Integer>();
		
		//Get the count of all the char occurrences
		for(String s: cArray){
			count = charCountMap.containsKey(s) ? charCountMap.get(s) : 0;
			charCountMap.put(s, count + 1);
		}
		
		//Get all the keys from the hash map. All the dupes are automatically removed at this point.
		keyArray = charCountMap.keySet().toArray(new String[0]); 
		
		Arrays.sort(keyArray); //Sort the list of keys
		
		//Iterate over the sorted array of keys and print them along with their count from the hash map lookup
		for(String s: keyArray){
		    System.out.println(s + " " + charCountMap.get(s));
		}
	
	}	
	
}

