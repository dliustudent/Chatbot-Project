package chatbot;

public class ChatbotVincent implements Topic {
	
	private Topic Derek;
	private Topic David;
	private Topic Raymond;
	
	private String[] keywords;
	private String[] actualKey;
	private String[] hateWords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String name;
	private String mammal;

	private String likes; // couldn't do array so used a String that separate animals name with spaces
	private String dislikes; //  Example: "Lion Elephant Panda ect"
	private String lastTalk;
	
	private boolean skipMammal ; // Booleans for whiles and conditions to skip.
	private boolean continueWhile;
	private boolean startedConversation;
	private boolean ignoreStatement;
	private boolean checkingOthers;
	
	private int triggerMad; 
	private String triggerAbout;
	
	private int gibberishMad; // created this because I didn't want triggerMad and gibberishMad to be the same thing.
	
	
	private boolean  finished;// check to see if you talked about all the animals
	private int finishedCounter;
	
	
	public ChatbotVincent() {
	
		String[] temp = {"Mammal","Mammals","x","x","x","x","x"}; // didn't want to do try catch for the for loop
		keywords = temp;										  // added extra data into array so it doesn't go exception out of bound
		
		String[] real = {"lion","elephant","panda","dog","cat","gorilla"};
		actualKey = real;
		
		String[] hate = {"ugly","bad","big","rude","stupid","bad","vulgar","weak"};
		hateWords = hate;
		
		startedConversation = false;
		lastTalk = "";
		likes = "";
		dislikes = "";
		goodbyeKeyword = "bye";
		secretKeyword = "Harambe";
		response = "";
		
		triggerMad = 0 ;
		
		finished = false;
		finishedCounter = 0;
	}											
	
	public void talk(String response) {	
		Derek = ChatbotMain.chatbot.getDerek();
		David = ChatbotMain.chatbot.getDavid();
		Raymond = ChatbotMain.chatbot.getRaymond();
		name = ChatbotMain.chatbot.getUsername();
		if (skipMammal == false) {
			ChatbotMain.print("Hello " +name+ " what Mammals do you want to talk about?");
			response = ChatbotMain.getInput();
		}else {
			response = mammal;
		}
		while(!response.equals(goodbyeKeyword) || finished == true) {
			checkForOtherTypes(response);
			isFinished();
			for(int i = 0 ; i < actualKey.length ; i++) {
				if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
					ChatbotMain.print("RIP HARAMBE WE WILL NEVER FORGET YOU");
					response = ChatbotMain.getInput();
				}else if (ChatbotMain.findKeyword(response, actualKey[i], 0) >= 0) {
					continueWhile = true;
					startTalking(actualKey[i]);
					
					if(ignoreStatement == true) {
						returnTalk();
					}
					
					response = ChatbotMain.getInput();
					i = -1;
				}
			}
			if(gibberishMad < 3) {
				gibberishMad += 1;
				String word = "";
				for(int i = 0; i<actualKey.length; i++) { // helper statement
					if(handleCondition(actualKey[i])) { // return all the animals that you didn't talk about yet
						if(i == actualKey.length - 1) {
							word += "and "+actualKey[i]+"s "; // add "and" in front of second to last word
						}else {
							word += actualKey[i]+"s ";
						}
					}
				}
				ChatbotMain.print("Yeah I don't know what your talking about. Lets talk about "+ word);
				response = ChatbotMain.getInput();
			}else {
				if(gibberishMad == 3) {
					gibberishMad += 1;
					ChatbotMain.print("Say something that I understand or I'm not going to talk to you anymore!");
					response = ChatbotMain.getInput();
				}else{
					ChatbotMain.print("I don't understand what your saying :/. I'm not talking to you anymore "+ ChatbotMain.chatbot.getUsername()+"!");
					response = "bye";
				}
			}

		} 
		if(finished == true) {
			ChatbotMain.print("Well it was nice talking to you, "+ ChatbotMain.chatbot.getUsername()+"! I'll send you to the other bots now!");
			ChatbotMain.chatbot.returnChatting();
		}
		else if(gibberishMad < 3) {
			ChatbotMain.print("Well it was nice talking to you, "+ ChatbotMain.chatbot.getUsername()+"!");
		}
		ChatbotMain.chatbot.returnChatting();
	} 
	public void startTalking(String s) { // handle the talking. Redundant because it just copy and paste.
		String b = s.toLowerCase();		//Limit the amount of animals you can talk about, to shorten code
		while(continueWhile == true) {
		if(handleCondition(b)) {
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
				lastTalk = "Elephant";
				ChatbotMain.print("Elephants are the largest land animals in the world. Do you like them!");
				response = ChatbotMain.getInput();
				while(continueWhile == true) {
					if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
						handleLike(b);
					}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
						handleDislikes(b);
					}else {
						ChatbotMain.print("I don't know what you're talking about. Please answer my question");
						response = ChatbotMain.getInput();
					} 
				}
			}
				else if (ChatbotMain.findKeyword(b, "Panda", 0) >= 0) {
					lastTalk = "Panda";
					ChatbotMain.print("Panda are black and white bears. In the wild, they are found in thick bamboo forests, high up in the mountains of central China. Do you like them!");
					response = ChatbotMain.getInput();
					while(continueWhile == true) {
						if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
							handleLike(b);
						}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
							handleDislikes(b);
						}else {
							ChatbotMain.print("I don't know what you're talking about. Please answer my question");
							response = ChatbotMain.getInput();
						} 
						
					}
			}else if (ChatbotMain.findKeyword(b, "dog", 0) >= 0) {
				lastTalk = "dog";
				ChatbotMain.print("A dogs sense of smell is more than 1 million times stronger than that of a person. Do you like them!");
				response = ChatbotMain.getInput();
				while(continueWhile == true) {
					if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
						handleLike(b);
					}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
						handleDislikes(b);
					}else {
						ChatbotMain.print("I don't know what you're talking about. Please answer my question");
						response = ChatbotMain.getInput();
					} 
					
				}
		}else if (ChatbotMain.findKeyword(b, "cat", 0) >= 0) {
			lastTalk = "cat";
			ChatbotMain.print("Domestic cats love to play, this is especially true with kittens who love to chase toys and play fight. Play fighting among kittens may be a way for them to practice and learn skills for hunting and fighting. Do you like them!");
			response = ChatbotMain.getInput();
			while(continueWhile == true) {
				if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
					handleLike(b);
				}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
					handleDislikes(b);
				}else {
					ChatbotMain.print("I don't know what you're talking about. Please answer my question");
					response = ChatbotMain.getInput();
				} 
				
			}
	}else if (ChatbotMain.findKeyword(b, "gorilla", 0) >= 0) {
		lastTalk = "gorilla	";
		ChatbotMain.print("Gorillas are ground-dwelling, predominantly herbivorous apes that inhabit the forests of central Africa. Do you like them!");
		response = ChatbotMain.getInput();
		while(continueWhile == true) {
			if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
				handleLike(b);
			}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
				handleDislikes(b);
			}else {
				ChatbotMain.print("I don't know what you're talking about. Please answer my question");
				response = ChatbotMain.getInput();
			} 
			
		}
}
				else {
				continueWhile = false;
			}
		}else { // checks if you already talked about an animal
			ignoreStatement = false; // ignore the returnTalk method.
			if (likes.contains(b)) {
				if (triggerMad < 2) {
					ChatbotMain.print("I know that you like "+ b + " but lets talk about a different mammal now");
					continueWhile = false;
					triggerMad += 1;
					triggerAbout = b;
				}else {
					ChatbotMain.print("I know that you hate "+ b +" BUT LETS TALK ABOUT A DIFFERENT ANIMAL ALREADY, NOT " + b + " PLEASE.");
					continueWhile = false;
				}
			}else if (dislikes.contains(b)) {
				if (triggerMad < 2) {
					ChatbotMain.print("I know that you hate "+ b +" but lets talk about a different mammal now");
					continueWhile = false;
					triggerMad += 1;
					triggerAbout = b;
				}else {
					ChatbotMain.print("I know that you hate "+ b +" BUT LETS TALK ABOUT A DIFFERENT ANIMAL ALREADY, NOT " + b + " PLEASE.");
					continueWhile = false;
				}
			}
		}
			
		}
		return;
		
	}
	public boolean handleCondition(String b){ // checks for the logic for likes and dislikes
		return (!likes.contains(b) && dislikes.contains(b)) || (likes.contains(b) && dislikes.contains(b)) || (!likes.contains(b) && !dislikes.contains(b));
	}
	public void handleLike(String b) {
		likes += b+" ";
		finishedCounter +=1;
		ChatbotMain.print("Me too I love " + b +"!");
		
		String[] splited = likes.split("\\s+"); // Splits the animals name locally
		
		if(splited.length > 1) { // just added an extra conversation that checks if you like an animal more than another animal
			int randNumber = (int) (Math.floor(Math.random() * splited.length));
			if(splited.length > 1 ) {
				while(splited[randNumber].equals(b)) { // check if it dupes
					 randNumber = (int) (Math.floor(Math.random() * splited.length));
				}
			}
			ChatbotMain.print("Do you like "+b+" more than "+splited[randNumber]);
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
				ChatbotMain.print("Yeah I agree with you "+ b +" are cooler than "+ splited[randNumber]);
			}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
				ChatbotMain.print("Yeah I agree with you "+ splited[randNumber] +" are cooler than "+ b);
			}else {
				ChatbotMain.print("Very interesting answer");
			}
			
		}
		continueWhile = false; // Ends Conversation of liking lions
	}
	public void handleDislikes(String b){
		finishedCounter +=1;
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
		for(int i = 0; i < actualKey.length ; i++ ){
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
	
	public void checkForOtherTypes(String s){ // checks for the other species
		checkingOthers = true;
			if(Derek.isTriggered(s)) {
				ChatbotMain.print("Do you want to talk about reptiles because "+s+" isn't a mammal");
				response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
					checkingOthers = false;
					Derek.talk(response);
				}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
					checkingOthers = false;
				}else {
					checkingOthers = false; // could do a while loop to ask them again if they type gibberish.
				}
			} 
			else if (David.isTriggered(s)) {
				ChatbotMain.print("Do you want to talk about birds because "+s+" isn't a mammal");
				response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
					checkingOthers = false;
					David.talk(response);
				}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
					checkingOthers = false;
				}else {
					checkingOthers = false;
				}
			}
			else if (Raymond.isTriggered(s)) {
				ChatbotMain.print("Do you want to talk about insects because "+s+" isn't a mammal");
				response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, "Yes", 0)>= 0){
					checkingOthers = false;
					Raymond.talk(response);
				}else if(ChatbotMain.findKeyword(response, "No", 0)>= 0) {
					checkingOthers = false;
				}else {
					checkingOthers = false;
				}
			}else {
				checkingOthers = false;
			}
		}
	public void isFinished() {
		if(finishedCounter == actualKey.length) {
			finished = true;
		}
	}
}
