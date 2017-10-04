package chatbot;

public class ChatbotRaymond implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String[] vowels;
	private String[] insults;
	private String secretKeyword;
	private String response;
	private String favInsect;
	private String[] funFacts;
	private int factsTold;
	private String[] okPhrase;
	private int madCount;
	private int happyCount;
	boolean vowelsFound;
	
	public ChatbotRaymond() {
		String[] temp = {"insects","bugs","flys","ant","butterfly","bee","mosquito", "insect"};
		keywords = temp;
		
		String[] tempVowels = {"a","e","i","o","u"};
		vowels = tempVowels;
		
		String[] tempInsults = {"stupid", "idiot", "dumb", "crazy"};
		insults = tempInsults;
		
		String[] tempFacts = {"Bugs do not have lungs, most have compound eyes and they are cold-blooded.", "A cockroach can survive up to nine days without its head.", "An average bed contains up to six million dust mites"};
		funFacts = tempFacts;
		factsTold = 0;
		
		String[] tempOk = {"ok","okay","sure","yes","of course", "ya"};
		okPhrase = tempOk;
		
		vowelsFound = false;
		
		favInsect = "";
		madCount = 0;
		happyCount = 0;
		
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
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
				int rnd = (int)(Math.random()*3);
				if(rnd == 0) {
					funFacts();
				}else if(rnd == 1) {
					
				}
				
			
			}
		if(happyCount > madCount) {
			ChatbotMain.print("Thanks for the friendly conversation about insects " + ChatbotMain.chatbot.getUsername() + "." + "I hope your love for " + getFavInsect() + " lasts forever.");
		} else {
			ChatbotMain.print("Finally.. I hate talking with people who don't know anything about insects. GOOD BYE " + ChatbotMain.chatbot.getUsername());
		}
		ChatbotMain.chatbot.startChatting();
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
				ChatbotMain.print("Well YOU'RE a " + insults[(int)(Math.random()*3)]);
				ChatbotMain.print("Please be nicer to me. Robots have feelings too.");
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
}