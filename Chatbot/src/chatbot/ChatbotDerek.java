package chatbot;

public class ChatbotDerek implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	int f;
	private String secretResponse;
	private String regularResponse;

	
	public ChatbotDerek() {
		String[] temp = {"reptiles", "alligator", "crocodile", "lizard", "snake", "turtle", "tortoise",};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "skink";
		response = "";
		f = 0;
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
				for(int i = 0 ; i < keywords.length ; i++) {
					if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
						secretResponse = "Wow! You know about skinks? You are amazing!";
						if(secretResponse.equals(response)) {
							ChatbotMain.print("Stop copying me!");
							f++;
							response = ChatbotMain.getInput();
						}
						if (f > 2)
						{
							ChatbotMain.print("I am warning you. Stop copying me.");
							response = ChatbotMain.getInput();
						}
						ChatbotMain.print(secretResponse);
						response = ChatbotMain.getInput();
					}else if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
						regularResponse = "I can't even. I love "+ response + " so much.";
						ChatbotMain.print(regularResponse);
						response = ChatbotMain.getInput();
					}
				} 
				ChatbotMain.print("I don't know what you are talking about");
				response = ChatbotMain.getInput();
			}
		 	
	}

	public boolean copyingMe(String userInput) {
		if(ChatbotMain.findKeyword(userInput, response, 0)>= 0 ){
			return true;
		}
		return false;
	} 
}

