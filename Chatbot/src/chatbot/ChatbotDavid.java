package chatbot;

public class ChatbotDavid implements Topic {

	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotDavid() {
		String[] temp = {"stuff","thing","whatever","nothing"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
		
	}
	
	@Override
	public void talk(String response) {
		ChatbotMain.print("Hey! So you want to talk about generic borning things, huh? I love talking about that.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >=0 ) {
				ChatbotMain.print("I can't even. I love pugs so much. Wow. You are so cool.");
				response = ChatbotMain.getInput();
			}
			else
			{
				ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more. Tell me something else");
				response = ChatbotMain.getInput();
			}
			
		}
		//access variables from other classes.
		ChatbotMain.print("Well, it was nice talking with you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i=0; i < keywords.length; i++) {
			//IMPORTANT (ON THE RUBRIC)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >=0) {
				return true;
			}
		}
		return false;
	}


}