package chatbot;

public class ChatbotVincent implements Topic {
	
	private String[] keywords;
	private String[] actualKey;
	private String[] hateWords;
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
	private String triggerAbout;
	
	
	public ChatbotVincent() {
		String[] temp = {"Mammal","Mammals"};
		keywords = temp;
		
		String[] real = {"Lion","Elephant"};
		actualKey = real;
		
		String[] hate = {"ugly","bad","big","rude","stupid","bad","vulgar","weak"};
		hateWords = hate;
		
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
					ChatbotMain.print("");
					response = ChatbotMain.getInput();
				}else if (ChatbotMain.findKeyword(response, actualKey[i], 0) >= 0) {
					continueWhile = true;
					startTalking(actualKey[i]);
					if(ignoreStatement == true) {
						returnTalk();
					}
					i = 0;
					response = ChatbotMain.getInput();
				}
			}
			ChatbotMain.print("Yeah I don't know what your talking about. Let talks about a mammal :);");
			response = ChatbotMain.getInput();


		} 
		//access variable from other classes
		ChatbotMain.print("Well it was nice talking to you, "+ ChatbotMain.chatbot.getUsername()+"!");
	} 
	public void startTalking(String s) {
		String b = s.toLowerCase();
		while(continueWhile == true) {
		if((!likes.contains(b) && dislikes.contains(b)) || (likes.contains(b) && dislikes.contains(b)) || (!likes.contains(b) && !dislikes.contains(b))) {
			System.out.println(likes);
			System.out.println(dislikes);
			ignoreStatement = true;
			startedConversation = true;
			if(!s.equals(lastTalk)) {
				triggerMad = 0;
			}
			if(ChatbotMain.findKeyword(b, "Lion", 0) >= 0) {
				lastTalk = "Lion";
				ChatbotMain.print("Lions are the king of the Savannas. Do you like them!");
				response = ChatbotMain.getInput();
				while(continueWhile == true) { // need this to make sure that it doesn't loop the entire conversation again
					if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
						handleLike(b);
					}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
						handleDislikes(b);
					}else {
						ChatbotMain.print("I don't know what you're talking about. Please answer my question");
						response = ChatbotMain.getInput();
					} 
					
				}
				 
			}else if (ChatbotMain.findKeyword(b, "Elephant", 0) >= 0) {
				
			}else {
				continueWhile = false;
			}
		}else {
			ignoreStatement = false;
			if (likes.contains(b)) {
				if (triggerMad < 4) {
					ChatbotMain.print("I know that you like "+ b + " but lets talk about a different mammal now");
					continueWhile = false;
					triggerMad += 1;
					triggerAbout = b;
				}else {
					ChatbotMain.print("I know that you hate "+ b +" BUT LETS TALK ABOUT A DIFFERENT ANIMAL ALREADY NOT " + b + " PLEASE.");
					continueWhile = false;
				}
			}else if (dislikes.contains(b)) {
				if (triggerMad < 4) {
					ChatbotMain.print("I know that you hate "+ b +" but lets talk about a different mammal now");
					continueWhile = false;
					triggerMad += 1;
					triggerAbout = b;
				}else {
					ChatbotMain.print("I know that you hate "+ b +" BUT LETS TALK ABOUT A DIFFERENT ANIMAL ALREADY NOT " + b + " PLEASE.");
					continueWhile = false;
				}
				
			}
		}
			
		}
		return;
		
	}
	public void handleLike(String b) {
		likes += b+" ";
		ChatbotMain.print("Me too I love " + b +"!");
		continueWhile = false; // Ends Conversation of liking lions
		return;
	}
	public void handleDislikes(String b){
		ChatbotMain.print("What why do you hate them?");
		dislikes += b+" ";
		response = ChatbotMain.getInput();
		System.out.println(checkForBadWord(response));
		if (!checkForBadWord(response).equals("nothing")) {
			ChatbotMain.print("It doesn't matter if they are "+checkForBadWord(response) + " " + b + " still cool");
		}else {
			ChatbotMain.print("It doesn't matter they are still cool");
		}
		continueWhile = false; // Ends conversation of disliking lions
		return;
	}
	
	public String checkForBadWord(String response){
		for(int i = 0 ; i < hateWords.length; i ++) {
			if(ChatbotMain.findKeyword(response, hateWords[i],0) >=0) {
				String a = hateWords[i];
				return a;
			}
		}
		return "nothing";
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
