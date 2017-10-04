package chatbot;

public class ChatbotDerek implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	int countRage;
	boolean spam;
	
	public ChatbotDerek() {
		String[] temp = {"reptiles", "alligator", "crocodile", "lizard", "snake", "turtle", "tortoise",};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "skink";
		response = "";
	}
	
	public boolean isTriggered(String response) {
		for(int i =0; i <keywords.length; i++) {
			//important on the rubric it explains to use findKeyword
			if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;  
	}
 
	public void talk(String response) {
		String a = Chatbot.getUsername();
		
		countRage = 0;
		
		ChatbotMain.print("Hi, "+ a + "!" + " Reptiles are a great species of animals! Tell me a species you would like to talk about.");
		
		response = ChatbotMain.getInput();
		
		while(!response.equals(goodbyeKeyword)) {
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow! You know about the skink! You are pretty cool!.");
			}
			
			if (ChatbotMain.findKeyword(response, keywords[0], 0) >= 0) {
					ChatbotMain.print("I think" + keywords[0] + "is also a great reptile! What do you know about it?");
					response = ChatbotMain.getInput();
					countingWord(response);
			}else {
				ChatbotMain.print("Sorry I do not understand! Give me another reptile!");
				response = ChatbotMain.getInput();
			}
		}	
		ChatbotMain.print("Well, it was nice talking to you, "+Chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
	
	public void countingWord(String response) {
		String a = response;
		countRage++;
		if (countRage>=1 && countRage <3) {
			ChatbotMain.print("you said" + a +"already!");
		}
		if (countRage>=3 && countRage <5) {
			ChatbotMain.print("Stop saying" + a +"already!");
		}
		if (countRage>=5 && countRage <7) {
			ChatbotMain.print("I am serious. Stop saying" + a +"already you idiot!");
		}
	}
	public void upsetString() {
		if(countRage > 1) {
			ChatbotMain.print("You said snake already!");
		}
	}
		
	public boolean sameWord(String userInput) {
		if(ChatbotMain.findKeyword(userInput, "snake", 0)>= 0 ){
			return true;
		}
		return false;
	} 
}

