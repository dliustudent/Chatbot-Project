package chatbot;

public class ChatbotVin implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	
	public ChatbotVin() {
		String[] temp = {"stuff","things","whatever","nothing"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
	}
	
	public void talk(String response) {
		ChatbotMain.print("Hey! So you want to talk about, ...");
		response = ChatbotMain.getInput();
		while(!response.equals(goodbyeKeyword)) {
				if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
					ChatbotMain.print("I can't even. I love pugs so much.");
					response = ChatbotMain.getInput();
				}else {
				ChatbotMain.print("Yeah.Cool");
				response = ChatbotMain.getInput();
				}
		}
		//access variable from other classess 
		ChatbotMain.print("Well it was nice talking to you, "+ ChatbotMain.chatbot.getUsername()+"!");
	}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length ; i++ ){
			if(ChatbotMain.findKeyword(response, keywords[i],0) >=0) {
				return true;
			}
		}
		return false;

	}
}

