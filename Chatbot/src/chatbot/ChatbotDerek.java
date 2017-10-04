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
				for(int i = 0 ; i < keywords.length ; i++) {
					if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
						ChatbotMain.print("Wow! You know about skinks? You are amazing!");
						response = ChatbotMain.getInput();
					}else if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
						ChatbotMain.print("I can't even. I love "+ response +" so much.");
						response = ChatbotMain.getInput();
					}
				}
				ChatbotMain.print("I don't know what you are talking about");
				response = ChatbotMain.getInput();
		 }
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
			ChatbotMain.print("You said" + response + "already!");
		}
	}
		
	public boolean sameWord(String userInput) {
		if(ChatbotMain.findKeyword(userInput, response, 0)>= 0 ){
			return true;
		}
		return false;
	} 
}

