package chatbot;

public class ChatbotRaymond implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String[] vowels;
	private String[] insults;
	private String secretKeyword;
	private String response;
	private String favInsect;
	private String[] phrases;
	private int madCount;
	private int happyCount;
	boolean vowelsFound;
	
	public ChatbotRaymond() {
		String[] temp = {"insects","bugs","flys","ant","butterfly","bee","mosquito", "insect"};
		keywords = temp;
		
		String[] tempVowels = {"a","e","i","o","u"};
		vowels = tempVowels;
		
		String[] tempInsults = {"stupid", "idiot", "dumb"};
		insults = tempInsults;
		
		String[] tempPhrases = {"Would you like to hear a fun fact?"};
		
		vowelsFound = false;
		
		favInsect = "";
		madCount = 0;
		happyCount = 0;
		
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
	}
 
	@Override
	public void talk(String response) {
		ChatbotMain.print("I love talking about insects. What is your favorite insect?");
		response = ChatbotMain.getInput();
		favInsect = response;
		if(isGibberish(response)) {
			ChatbotMain.print("Hmm, interesting. I've never heard of " + response + " before.");
		} else {
			ChatbotMain.print("I think " + getFavInsect() + " are cool too.");
		}
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
				ChatbotMain.print("What would you like to know about insects?");
				response = ChatbotMain.getInput();
				if(isInsultFound(response)) {
					ChatbotMain.print("Please be nicer to me. Robots have feelings too.");
				}
			
			}
		if(happyCount > madCount) {
			ChatbotMain.print("Thanks for the friendly conversation about insects " + ChatbotMain.chatbot.getUsername() + "." + "I hope your love for " + getFavInsect() + " lasts forever.");
		} else {
			ChatbotMain.print("Finally.. I hate talking with people who don't know anything about insects. GOOD BYE " + ChatbotMain.chatbot.getUsername());
		}
		ChatbotMain.chatbot.startChatting();
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}
	public boolean isGibberish(String response) {
		if(response.indexOf(" ") == -1) {
			for(int i = 0; i < vowels.length; i++) {
				if(response.contains(vowels[i])) {
					vowelsFound = true;
					return false;
				}
			}
		}
		return true;
	}
	public boolean isInsultFound(String response) {
		for(int i = 0; i < insults.length; i++) {
			if(response.contains(insults[i])) {
				madCount ++;
				return true;
			}
		}
		return false;
	}
	public String getFavInsect() {
		return favInsect;
	}

}