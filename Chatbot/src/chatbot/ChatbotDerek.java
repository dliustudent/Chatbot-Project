package chatbot;

public class ChatbotDerek implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	int count = 0;
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
		ChatbotMain.print("Hi, "+ a + "!" + " Reptiles are a great species of animals! Tell me a species you would like to talk about.");
		response = ChatbotMain.getInput();
		while(!response.equals(goodbyeKeyword)) {
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow! You know about the skink! You are pretty cool!.");
				response = ChatbotMain.getInput();
			if (ChatbotMain.findKeyword(response, keywords[0], 0) >= 0) {
				ChatbotMain.print("What animal would you like to talk about?");
				response = ChatbotMain.getInput();
				count++;
			
			}
			}else {
				ChatbotMain.print("Sorry I do not understand! Give me another reptile!");
				response = ChatbotMain.getInput();
			}
		}
		ChatbotMain.print("Well, it was nice talking to you, "+Chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
	
	public boolean isUpset() {
		for (int i = 0; i < response.length(); i++) {
			if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				
				return true;
			}
		}
		
}
		

