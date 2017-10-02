package chatbot;

public class ChatbotDavid implements Topic {

	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] eaglesFacts;
	
	public ChatbotDavid() {
		String[] temp = {"Eagle","Penguin","Vulture","Hummingbird","bird"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "feathers";
		response = "";
		
		String[] facts = {"1","2","3"};
		eaglesFacts = facts;
		
	}
	
	@Override
	public void talk(String response) {
		
		 int x = (int) (Math.random()*3)+1;
		
		ChatbotMain.print("Hey! So you want to talk about birds, right? What do you want to know about birds.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, keywords[0], 0) >=0 ) {
				ChatbotMain.print(eaglesFacts[x]);
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, keywords[1], 0) >=0 ) {
				ChatbotMain.print("Did you know that penguin are one of a few birds that cannot fly.");
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, keywords[2], 0) >=0 ) {
				ChatbotMain.print("Did you know that vulture are scavenger?");
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, keywords[3], 0) >=0 ) {
				ChatbotMain.print("Did you know that a Hummingbird flaps its wings over 100 times per minutes?");
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >=0 ) {
				ChatbotMain.print("Do you know why bird fly in a V shape?");
				response = ChatbotMain.getInput();
			}
			else
			{
				ChatbotMain.print("What others birds do you want to talk about?");
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