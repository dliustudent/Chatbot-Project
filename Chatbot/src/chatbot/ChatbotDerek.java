package chatbot;

public class ChatbotDerek implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotDerek() {
		String[] temp = {"this", "that", "or", "me"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "marvelous";
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
		ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that. So tell me more!");
		response = ChatbotMain.getInput();
		while(!response.equals(goodbyeKeyword)) {
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Marvelous is a great word.");
				response = ChatbotMain.getInput();
			}else {
				ChatbotMain.print("Thats so cool! Tell me more or something else!");
				response = ChatbotMain.getInput();
				}
		}
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
}
		

