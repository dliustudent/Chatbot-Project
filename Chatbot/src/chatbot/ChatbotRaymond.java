package chatbot;

public class ChatbotRaymond implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String[] vowels;
	private String[] insults;
	private String secretKeyword;
	private String response;
	boolean vowelsFound;
	
	public ChatbotRaymond() {
		String[] temp = {"insects","bugs","flys","ant","butterfly","bee","mosquito"};
		keywords = temp;
		
		String[] tempVowels = {"a","e","i","o","u"};
		vowels = tempVowels;
		
		String[] tempInsults = {"stupid", "idiot", "dumb"};
		insults = tempInsults;
		
		vowelsFound = false;
		
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
	}
 
	@Override
	public void talk(String response) {
		ChatbotMain.print("I love talking about insects.");
		response = ChatbotMain.getInput();
		isGibberish(response);
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("I can't even. I love pugs so much. Wow. You are so cool.");
				response = ChatbotMain.getInput();
			}else {
				ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more. Tell me something else.");
				response = ChatbotMain.getInput();
			}
		}
		ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
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

}