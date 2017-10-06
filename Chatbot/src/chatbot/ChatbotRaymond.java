package chatbot;

public class ChatbotRaymond implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String[] vowels;
	private String[] insults;
	private String response;
	private String favInsect;
	private String[] funFacts;
	private int factsTold;
	private String[] okPhrase;
	private int madCount;
	private int happyCount;
	private String[] beforeInsult;
	private String rndInsect;
	private String[] listInsects;
	private boolean conversation;
	boolean vowelsFound;
	
	public ChatbotRaymond() {
		String[] temp = {"insects","bugs","flys","ant","butterfly","bee","mosquito", "insect"};
		keywords = temp;
		
		String[] tempListInsects = {"flys","ant","butterfly","bee"};
		listInsects = tempListInsects;
		
		String[] tempVowels = {"a","e","i","o","u"};
		vowels = tempVowels;
		
		String[] tempInsults = {"stupid", "idiot", "dumb", "crazy"};
		insults = tempInsults;
		
		String[] tempBeforeInsult = {"", "an", "", ""};
		beforeInsult = tempBeforeInsult;
		
		String[] tempFacts = {"Bugs do not have lungs, most have compound eyes and they are cold-blooded.", "A cockroach can survive up to nine days without its head.", "An average bed contains up to six million dust mites"};
		funFacts = tempFacts;
		factsTold = 0;
		
		String[] tempOk = {"ok","okay","sure","yes","of course", "ya"};
		okPhrase = tempOk;
		
		vowelsFound = false;
		conversation = true;
		
		favInsect = "";
		rndInsect = "";
		
		madCount = 0;
		happyCount = 0;
		
		goodbyeKeyword = "bye";
		response = "";
	}
 
	@Override
	public void talk(String response) {
		ChatbotMain.print("I love talking about insects. What is your favorite insect?");
		response = ChatbotMain.getInput();
		favInsect = response;
		if(isGibberish(response)) {
			ChatbotMain.print("Hmm, interesting. I've never heard of " + response + " before.");
		} else {
			ChatbotMain.print("I think " + getFavInsect() + " are cool too.");
		}
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
				longConversation();
				int rnd = (int)(Math.random()*3);
				if(rnd == 0) {
					funFacts();
				}else if(rnd == 1) {
					thinkingGame();
				}
				
			
			}
		if(happyCount > madCount) {
			ChatbotMain.print("Thanks for the friendly conversation about insects " + ChatbotMain.chatbot.getUsername() + "." + "I hope your love for " + getFavInsect() + " lasts forever.");
		} else {
			ChatbotMain.print("Finally.. I hate talking with people who don't know anything about insects. GOOD BYE " + ChatbotMain.chatbot.getUsername());
		}
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}
	public boolean isGibberish(String response) {
		if(response.indexOf(" ") == -1) {
			for(int i = 0; i < vowels.length; i++) {
				if(response.contains(vowels[i])) {
					vowelsFound = true;
					return false;
				}
			}
		}
		return true;
	}
	public boolean isInsultFound(String response) {
		response = response.toLowerCase();
		for(int i = 0; i < insults.length; i++) {
			if(ChatbotMain.findKeyword(response, insults[i], 0) >= 0) {
				madCount ++;
				return true;
			}
		}
		return false;
	}
	public String getFavInsect() {
		return favInsect;
	}
	public void funFacts() {
		boolean told = false;
		if(factsTold > 2) {
			ChatbotMain.print("It seems like I've told you all the interesting things about insects already.");
			response = ChatbotMain.getInput();
			if(isInsultFound(response) && yourYoure(response)) {
				int rndInsult = (int)(Math.random()*3);
				ChatbotMain.print("Well YOU'RE " + beforeInsult[rndInsult] + insults[rndInsult]);
			} else {
				ChatbotMain.print("Let's talk about something else related to insects.");
			}
		} else {
			ChatbotMain.print("Would you like to hear a fun fact?");
			response = ChatbotMain.getInput();
			for(int i = 0; i < okPhrase.length; i++) {
				if(ChatbotMain.findKeyword(response, okPhrase[i], 0) >= 0) {
					ChatbotMain.multiLinePrint("Ok, here is a fun fact: " + funFacts[factsTold]);
					factsTold ++;
					happyCount ++;
					told = true;
					break;
				}
			}
			if(!told) {
				ChatbotMain.print("Ok fine..");
				madCount ++;
			}
		} 
		response = ChatbotMain.getInput(); 
		
	}
	public boolean yourYoure(String response) {
		if(response.contains("your")) {
			return true;
		}
		return false;
	}
	public void thinkingGame() {
		boolean correct = false;
		ChatbotMain.print("I am thinking of an insect, try to guess it.");
		rndInsect = listInsects[(int)(Math.random()*listInsects.length)];
		while(!correct) {
			response = ChatbotMain.getInput();
			if(isInsultFound(response)) {
				ChatbotMain.print("Mad? Guess again maybe you'll get it eventually");
				continue;
			}
			if(ChatbotMain.findKeyword(response, rndInsect, 0) >= 0) {
				ChatbotMain.print("Correct!");
				correct = true;
			}else {
				ChatbotMain.print("Wrong! Try to guess again.");
			}
		}
		
		
	}
	public boolean longConversation() {
		if(!conversation) {
			return false;
		}else {
			ChatbotMain.print("So, lets talk about insects and we can play games later.");
			response = ChatbotMain.getInput();
			if(isInsultFound(response)) {
				madComments();
				response = ChatbotMain.getInput();
			}
		}
		conversation = false;
		return conversation;
	}
	public void madComments() {
		if(madCount < 2) {
			ChatbotMain.print("A bit mean aren't ya?");
		} else if (madCount < 4) {
			ChatbotMain.print("Now you are really pissing me off.");
		} else if (madCount < 6) {
			ChatbotMain.print("");
		}
	}
}