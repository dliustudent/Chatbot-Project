package chatbot;

import java.util.Scanner;

public class ChatbotMain {

	public static final Chatbot chatbot = new Chatbot();
	private static Scanner inputSource = new Scanner(System.in);
	//use static only if it is the same everywhere, wants it to be accessed independent of instances
	
		public static void main(String[] args) {
		chatbot.startChatting();
			  
		} 
		
		// copied from classwork Utilities
		/*
		 * @return the index of the keyword after startPsn that is isolated and has no negations or -1 otherwise
		 */
		
		public static int findKeyword(String searchString, String keyword, int startPsn) {
			//make lower case
			searchString = searchString.toLowerCase();
			keyword = keyword.toLowerCase();
			
			int psn = searchString.indexOf(keyword, startPsn);
			
			while (psn >= 0) {
				if (keywordIsIsolated(psn,keyword,searchString) && noNegations(searchString, psn)) {
					return psn;
				}else {
					psn = searchString.indexOf(keyword, psn+1);//returns the index of the NEXT keyword
				}
			}
				return -1; 
				
		}
	
		public static boolean keywordIsIsolated(int psn, String keyword, String s){
			keyword = keyword.toLowerCase();
			String wordAfter = "";
			String wordBefore = "";
			s = s.toLowerCase();
			
			try {
				wordAfter = s.substring(psn+keyword.length()+1,psn+keyword.length()+2);
			}catch(Exception ex) {
				wordAfter = "";
			}
			try {
				wordBefore = s.substring(psn-1,psn);
			}catch(Exception ex) {
				wordBefore = "";
			}
			if((wordAfter.equals("") || wordAfter.compareTo("z") < -26) && (wordBefore.equals("") || wordBefore.compareTo("z") < -26)) {
				return true;
			}else {
				return false;
			}
			
		}
	
		public static boolean noNegations(String s, int psn){
			int secondSpace = psn -1;
			int firstSpace = -1;
			for(int i = 0; i < secondSpace; i++) {
				if(s.substring(i,i+1).compareTo(" ") == 0) {
					firstSpace = i;
				}
			}
			if(firstSpace == -1) {
				return true;
			}
			String word = s.substring(firstSpace+1,secondSpace);
			if(word.equals("not") || word.equals("no")){
				return false;
			}
				return true;
		}
	
	
		public static String getInput(){
			return inputSource.nextLine();
		}
	
		public static void print(String s){
			multiLinePrint(s);
		}
	
		public static void multiLinePrint(String s){
			String printString = "";
			int cutoff = 50;
			//this while loop last as long as there are words left in the original String
			while(s.length() > 0){
				
				String currentCut = "";
				String nextWord = "";
	
				//while the current cut is still less than the line length 
				//AND there are still words left to add
				while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){
	
					//add the next word
					currentCut += nextWord;
	
					//remove the word that was added from the original String
					s = s.substring(nextWord.length());
	
					//identify the following word, exclude the space
					int endOfWord = s.indexOf(" ");
	
					//if there are no more spaces, this is the last word, so add the whole thing
					if(endOfWord == -1) {
						endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
					}
	
					//the next word should include the space
					nextWord = s.substring(0,endOfWord+1);
				}
	
				printString +=currentCut+"\n";
	
			}
			System.out.print(printString);
		}
	
		public static int getIntegerInput() {
			print("Please enter an integer.");
			String integerString = getInput();
			boolean isInteger = false;
			int value = 0;
			while(!isInteger){
				try{
					value = Integer.parseInt(integerString);
					//will not continue if an error above is thrown
					isInteger = true;//exits loop if entry is valid
				}catch(NumberFormatException e){
					print("You must enter an integer. You better try again.");
					integerString = getInput();
				}
			}
			return value;
		}
	}


