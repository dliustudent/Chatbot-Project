package chatbot;

public class ChatbotVincent implements Topic {
	
	private String[] keywords;
	private String[] actualKey;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String name;
	private String mammal;

	private String likes;
	private String dislikes;
	private String lastTalk;
	
	private boolean skipMammal ;
	private boolean continueWhile;
	private boolean startedConversation;
	private boolean ignoreStatement;
	
	private int triggerMad;
	
	
	public ChatbotVincent() {
		String[] temp = {"Mammal","Mammals"};
		keywords = temp;
		
		String[] real = {"Lion","Elephant"};
		actualKey = real;
		
		startedConversation = false;
		lastTalk = "";
		likes = "";
		dislikes = "";
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
		
		triggerMad = 0 ;
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
					if(ignoreStatement == true) {
						returnTalk();
					}
					i = 0;
					response = ChatbotMain.getInput();
				}else if(i == actualKey.length ) {
					ChatbotMain.print("Yeah.Cool");
					response = ChatbotMain.getInput();
				}
			}


		} 
		//access variable from other classes
		ChatbotMain.print("Well it was nice talking to you, "+ ChatbotMain.chatbot.getUsername()+"!");
	} 
	public void startTalking(String s) {
		String b = s;
		while(continueWhile == true) {
		if((!likes.contains(b) && dislikes.contains(b)) || (likes.contains(b) && dislikes.contains(b)) || (!likes.contains(b) && !dislikes.contains(b))) {
			ignoreStatement = true;
			startedConversation = true;
			if(b.equals("Lion")) {
				lastTalk = "Lion";
				ChatbotMain.print("Lions are the king of the Savannas. Do you like them!");
				response = ChatbotMain.getInput();
				while(continueWhile == true) { // need this to make sure that it doesn't loop the entire conversation again
					if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
					likes += "Lion ";
					ChatbotMain.print("Me too I love lions!");
					continueWhile = false; // Ends Conversation of liking lions
					}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
						ChatbotMain.print("What why do you hate them?");
						dislikes += "Lion ";
						response = ChatbotMain.getInput();
						ChatbotMain.print("It doesn't matter "+response+" they are still cool");
						continueWhile = false; // Ends conversation of disliking lions
					}else {
						ChatbotMain.print("I don't know what you're talking about. Please answer my question");
						response = ChatbotMain.getInput();
					}
					
				}
				
			}
		}else {
			ignoreStatement = false;
			if (likes.contains(b)) {
				if (triggerMad < 4) {
					ChatbotMain.print("I know that you like "+ b + " but lets talk about a different mammal now");
					continueWhile = false;
					triggerMad += 1;
				}else {
					ChatbotMain.print("I know that you hate "+ b +" BUT LETS TALK ABOUT A DIFFERENT ANIMAL ALREADY NOT " + b + " PLEASE.");
					continueWhile = false;
				}
			}else if (dislikes.contains(b)) {
				if (triggerMad < 4) {
					ChatbotMain.print("I know that you hate "+ b +" but lets talk about a different mammal now");
					continueWhile = false;
					triggerMad += 1;
				}else {
					ChatbotMain.print("I know that you hate "+ b +" BUT LETS TALK ABOUT A DIFFERENT ANIMAL ALREADY NOT " + b + " PLEASE.");
					continueWhile = false;
				}
				
			}
		}
			
		}
		return;
		
	}
	public void returnTalk(){
		if (startedConversation == true) {
			ChatbotMain.print("We just talked about " + lastTalk + ", which mammal do you want to talk about now!");
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
