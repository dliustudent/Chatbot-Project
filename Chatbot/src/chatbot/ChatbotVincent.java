package chatbot;

public class ChatbotVincent implements Topic {
	
	private String[] keywords;
	private String[] actualKey;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	
	public ChatbotVincent() {
		String[] temp = {"Mammal","Mammals"};
		keywords = temp;
		
		String[] real = {"Lion","Elephant"};
		actualKey = real;
		
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
	}
	
	public void talk(String response) {
		ChatbotMain.print("Hey! What Mammals do you want to talk about?");
		response = ChatbotMain.getInput();
		while(!response.equals(goodbyeKeyword)) {
			for(int i = 0 ; i < actualKey.length ; i++) {
				if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
					ChatbotMain.print("I can't even. I love pugs so much.");
					response = ChatbotMain.getInput();
				}else if (ChatbotMain.findKeyword(response, actualKey[i], 0) >= 0) {
					
				}
			}
			ChatbotMain.print("Yeah.Cool");
			response = ChatbotMain.getInput();

		}
		//access variable from other classes
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

