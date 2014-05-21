
/**
 * 
 * Accepts N lap times passed as command line arguments of the format "00:00:00"
 * Calculates their average and outputs the result in the same format "00:00:00"
 * Skips any invalid or incorrectly formatted arguments.
 * Exits if no arguments are passed in or only invalid arguments are passed in.
 *
 */

public class stopwatch {
	
	public static final int NUM_OF_HSECONDS_IN_ONE_MINUTE = 6000;
	public static final int NUM_OF_HSECONDS_IN_ONE_SECOND = 100;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		int totalTime = 0;
		int numOfValidInputs = 0;
		
		if(args.length == 0){
			System.out.println("No arguments passed. Please pass in times of format 00:00:00.");			
			System.exit(0);
		}
		
		for (String t: args) {		    	
	    	if(isValidTimeString(t)){
	    		totalTime += makeHSeconds(t);
	    		numOfValidInputs++;
	    	}	    	
		 }
		
		if(numOfValidInputs == 0){
			System.out.println("No valid arguments passed. Please pass in times of format 00:00:00.");			
			System.exit(0);
		}

		System.out.println(makeTimeString(totalTime/numOfValidInputs));
		
	}
	
	
	/**
	 * Given a String of format "00:00:00", this returns the total time in hundredth of a second.  
	 * @param String time
	 * @return int
	 */
	public static int makeHSeconds(String time){
		
		int minutes = 0, sec = 0, hsec = 0, totalHSeconds = 0;
		String[] parts = time.split(":");
		
		minutes = Integer.parseInt(parts[0]);
		sec = Integer.parseInt(parts[1]);
		hsec = Integer.parseInt(parts[2]);
		
		totalHSeconds += (minutes > 0) ? minutes * NUM_OF_HSECONDS_IN_ONE_MINUTE : 0;
		totalHSeconds += (sec > 0) ? sec * NUM_OF_HSECONDS_IN_ONE_SECOND : 0;
		totalHSeconds += hsec;	
		return totalHSeconds;
	}

	
	/**
	 * Given time in hundredth of a second, this returns time is format "00:00:00"  
	 * @param int totalHSec
	 * @return String
	 */
	public static String makeTimeString(int totalHSec) {

		int minutes = 0, sec = 0, hsec = 0;		
		hsec = totalHSec;
		
		minutes = hsec / NUM_OF_HSECONDS_IN_ONE_MINUTE;	//How many minutes are present;
		hsec = (minutes > 0) ? hsec - (minutes * NUM_OF_HSECONDS_IN_ONE_MINUTE) : hsec;
		
		sec = hsec / NUM_OF_HSECONDS_IN_ONE_SECOND; //How many seconds are present;
		hsec = (sec > 0) ? hsec - (sec * NUM_OF_HSECONDS_IN_ONE_SECOND) : hsec;		
		
		return String.format("%02d:%02d:%02d", minutes, sec, hsec);
	}
	
	
	/**
	 * Uses a regex to validate the format of a given time string.
	 * @param String time
	 * @return bool
	 */
	public static boolean isValidTimeString(String time){
		String TIMESTRING_PATTERN = "[0-5][0-9]:[0-5][0-9]:[0-9][0-9]"; //Strictly validates a string of format "00:00:00"
		return (time.matches(TIMESTRING_PATTERN));
	}

}
