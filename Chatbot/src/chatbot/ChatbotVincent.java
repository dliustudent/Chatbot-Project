package chatbot;

public class ChatbotVincent implements Topic {
	
	private String[] keywords;
	private String[] actualKey;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String name;
	private String mammal;
	
	private boolean skipMammal ;
	private boolean continueWhile;
	
	
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
		name = ChatbotMain.chatbot.getUsername();
		if (skipMammal == false) {
			ChatbotMain.print("Hello " +name+ " what Mammals do you want to talk about?");
			response = ChatbotMain.getInput();
		}else {
			response = mammal;
		}
		while(!response.equals(goodbyeKeyword)) {
			for(int i = 0 ; i < actualKey.length ; i++) {
				if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
					ChatbotMain.print("I can't even. I love pugs so much.");
					response = ChatbotMain.getInput();
				}else if (ChatbotMain.findKeyword(response, actualKey[i], 0) >= 0) {
					continueWhile = true;
					startTalking(actualKey[i]);
				}else
					ChatbotMain.print("Yeah.Cool");
			}

		} 
		//access variable from other classes
		ChatbotMain.print("Well it was nice talking to you, "+ ChatbotMain.chatbot.getUsername()+"!");
	}
	public void startTalking(String a){
		int i = 0;
		while(continueWhile == true) {
			if(a.equals("Lion")) {
				if (i == 0 ) {
					ChatbotMain.print("Lions are the king of the Savanna! Do you like Lions?");
					response = ChatbotMain.getInput();
					i += 1;
				}else if( i == 1) {
					if(ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
						ChatbotMain.print("Yeah I love Lions too!");
						response = ChatbotMain.getInput();
						continueWhile = false;
					}else if (ChatbotMain.findKeyword(response, "no", 0) >= 0){
						ChatbotMain.print("What why don't you like them?");
						response = ChatbotMain.getInput();
						ChatbotMain.print("It doesn't matter "+response+" they are still cool");
					}
				}
			}
		}
	}
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length ; i++ ){
			if(ChatbotMain.findKeyword(response, keywords[i],0) >=0) {
				mammal = keywords[i];
				skipMammal = false;
				return true;
			}else if (ChatbotMain.findKeyword(response, actualKey[i],0) >=0)  {
				mammal = actualKey[i];
				skipMammal = true;
				return true;
			}
		}
		return false;

	}
}


