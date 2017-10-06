package chatbot;

public class ChatbotDerek implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	int f;
	private String secretResponse;
	private String regularResponse;
	private String[] love;
	private String[] hate;
	private String[] loved;
	
	public ChatbotDerek() {
		String[] temp = {"reptile","reptiles", "alligator", "crocodile", "lizard", "snake", "turtle", "tortoise",};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "skink";
		response = "";
		f = 0;
		String[] b = {"love", "like"};
		love = b;
		String[] d = {"hate", "dislike"};
		hate = d;
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
		ChatbotMain.print("Hi, "+ a + "!" + " Reptiles are extremely cool! What reptile would you like to talk about?");
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
						if(regularResponse.equals(response)) {
							ChatbotMain.print("Stop copying me!");
							f++;
							response = ChatbotMain.getInput();
						}
						if (f >= 2)
						{
							ChatbotMain.print("I am warning you. Stop copying me.");
							response = ChatbotMain.getInput();
						}
						ChatbotMain.print(regularResponse);
						response = ChatbotMain.getInput();
					}
				} 
				
				 ChatbotMain.print("Try typing alligator, crocodile, lizard, snake, turtle, or tortoise");
				 response = ChatbotMain.getInput();}
			}
		 	

	public void emotion()
	{
		String c = ChatbotMain.getInput();
		for(int i = 0 ; i < love.length ; i++) {
			if(ChatbotMain.findKeyword(c, love[i], 0) >= 0) {
				ChatbotMain.print("I know right! That reptile is awesome!");
		for(int j = 0 ; j < hate.length ; j++) {
			if(ChatbotMain.findKeyword(c, hate[i], 0) >= 0) {
				ChatbotMain.print("Aww, thats too bad! I don't think that reptile sucks but ok.");
					}
				} 
			}
		}
	}
}

