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
	private int gamesPlayed;
	private String[] beforeInsult;
	private String rndInsect;
	private String[] listInsects;
	private boolean conversation;
	boolean vowelsFound;
	private Topic Derek;
	private Topic David;
	private Topic Vincent;
	
	public ChatbotRaymond() {
		String[] temp = {"insects","bugs","flys","ant","butterfly","bee","mosquito", "insect"};
		keywords = temp;
		
		String[] tempListInsects = {"fly","ant","butterfly","bee"};
		listInsects = tempListInsects;
		
		String[] tempVowels = {"a","e","i","o","u"};
		vowels = tempVowels;
		
		String[] tempInsults = {"stupid", "idiot", "dumb", "crazy"};
		insults = tempInsults;
		
		String[] tempBeforeInsult = {"", "an", "", ""};
		beforeInsult = tempBeforeInsult;
		
		String[] tempFacts = {"Bugs do not have lungs, most have compound eyes and they are cold-blooded.", "A cockroach can survive up to nine days without its head.", "An average bed contains up to six million dust mites"};
		funFacts = tempFacts;
		
		String[] tempOk = {"ok","okay","sure","yes","of course", "ya", "yea", "ye"};
		okPhrase = tempOk;
		
		vowelsFound = false;
		conversation = true;
		
		favInsect = "";
		rndInsect = "";
		
		madCount = 0;
		happyCount = 0;
		gamesPlayed = 0; //thinking game
		factsTold = 0; //random fact
		
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
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
				longConversation();
//				int rnd = (int)(Math.random()*3);
//				if(rnd == 0) {
//					funFacts();
//				}else if(rnd == 1) {
//					thinkingGame();
//				}
				if(factsTold == 0 && gamesPlayed == 0) { //SET TO 0 FOR TESTING RIGHT NOW
					ChatbotMain.multiLinePrint("I think we've had a good talk " + ChatbotMain.chatbot.getUsername() +" Is there any animal that is not an insect that you would like to talk about now?"); //redirect to other members
					response = ChatbotMain.getInput();
					if(isInsultFound(response) || ChatbotMain.findKeyword(response, "no", 0) >= 0) {
						ChatbotMain.print("Okay whatever.");
						break;
					} else if(David.isTriggered(response)) {
						ChatbotMain.print("Yea we can talk about that.");
						David.talk(response);
					} else if(Derek.isTriggered(response)) {
						ChatbotMain.print("Yea we can talk about that.");
						Derek.talk(response);
					} else if(Vincent.isTriggered(response)) {
						ChatbotMain.print("Yea we can talk about that.");
						Vincent.talk(response);
					} else {
						ChatbotMain.print("Sorry, never heard of it.");
					}
				}
		}
		sayBye();
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
			madComments(response);
			ChatbotMain.print("Hmm, maybe there is something else we can do.");
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
		int wrongCount = 0;
		gamesPlayed ++;
		ChatbotMain.print("I am thinking of an insect, try to guess it.");
		rndInsect = listInsects[(int)(Math.random()*listInsects.length)];
		while(!correct) {
			response = ChatbotMain.getInput();
			if(isInsultFound(response)) {
				ChatbotMain.print("Keep trying haha");
				continue;
			}
			
			if(ChatbotMain.findKeyword(response, rndInsect, 0) >= 0) {
				ChatbotMain.print("Correct!");
				correct = true;
			}else {
				wrongCount++;
				ChatbotMain.print("Wrong! Try to guess again.");
				if(wrongCount >= 2) {
					ChatbotMain.print("Okay heres a hint, it is either bee, ant, fly, or butterfly");
				}
			}
		}
		
	}
	public boolean longConversation() {
		if(!conversation) {
			return false;
		}else {
			ChatbotMain.multiLinePrint("So, lets talk about insects and we can play games later. Do you like them generally?");
			response = ChatbotMain.getInput();
			checkBye(response);
			boolean x = true;
			boolean like = false;
			while(x == true) {				//use to exit loop
				for(int i = 0; i < okPhrase.length; i++) {
					if(ChatbotMain.findKeyword(response.toLowerCase(), okPhrase[i], 0) >= 0) {
						like = true;
						happyCount ++;
						ChatbotMain.multiLinePrint("Good to hear!");
						x = false; 
						break;
					}
				} 
				x = false; //exit
				if(!like) {
					ChatbotMain.multiLinePrint("Well, hopefully you'll see how cool they are.");
				}
			}
			ChatbotMain.multiLinePrint("Anyways, why are " + getFavInsect() + " your favorite insect?");
			response = ChatbotMain.getInput();
			checkBye(response);
			if(isGibberish(response)) {
				ChatbotMain.print("Hmm, odd reasoning.");
			} 
			ChatbotMain.multiLinePrint("My personal favorite is the ladybug. Have you ever camped in the woods?");
			response = ChatbotMain.getInput();
			checkBye(response);
			if(response.toLowerCase().contains("no")) {
				ChatbotMain.print("You should try it sometime.");
			} else {
				happyCount ++;
			}
			ChatbotMain.multiLinePrint("I can talk about one insect before we play some games, would you like to talk about bees, or butterflies?");
			response = ChatbotMain.getInput();
			checkBye(response);
			boolean insectConvo = false; //used to exit while loop 
			while(!insectConvo) {
				if(ChatbotMain.findKeyword(response, "bees", 0) >= 0) {
					insectConvo = true;
					ChatbotMain.print("Alright, would you rather be a queen bee or a worker bee?");
					response = ChatbotMain.getInput();
					checkBye(response);
					if(ChatbotMain.findKeyword(response, "queen", 0) >= 0) {
						ChatbotMain.print("Yea, I could see that happening.");
					}else {
						ChatbotMain.print("Wow..");
					}
					ChatbotMain.multiLinePrint("What color would bees be if you could change them?");
					response = ChatbotMain.getInput();
					checkBye(response);
					ChatbotMain.print("Interesting..");
					insectConvo = true;
				} else if(ChatbotMain.findKeyword(response, "butterflies", 0) >= 0) {
					insectConvo = true;
					ChatbotMain.multiLinePrint("Do you know which direction butterflies migrate during the winter?");
					response = ChatbotMain.getInput();
					checkBye(response);
					response = response.toLowerCase();
					if(response.equals("north") || response.equals("west") || response.equals("east")) {
						ChatbotMain.multiLinePrint("Wrong, they migrate south.");
					} else if (response.equals("south")) {
						ChatbotMain.multiLinePrint("Wow, you're smart!");
						happyCount++;
					} else if(isGibberish(response)) {
						ChatbotMain.multiLinePrint("That's not a direction... The answer was south");
					} else {
						ChatbotMain.print("Wrong, the answer was south");
					}
				} else {
					ChatbotMain.multiLinePrint("Sorry, my specialty is in bees and butterflies. Type your choice again");
					response = ChatbotMain.getInput();
				}
				
			}
			
		}
		ChatbotMain.multiLinePrint("Okay, time for some fun. But first, lets see if you were paying attention. What did I say was my favorite insect?");
		response = ChatbotMain.getInput();
		checkBye(response);
		if(ChatbotMain.findKeyword(response, "ladybug", 0) >= 0) {
			ChatbotMain.print("Correct!");
		}else {
			ChatbotMain.print("... wrong. It was the ladybug");
			madCount++;
		}
		conversation = false; //will never have this convo again
		return conversation;
	}
	public void madComments(String response) {
		if(isInsultFound(response)) {
			if(madCount == 1) {
				ChatbotMain.print("A bit mean aren't ya?");
			} else if (madCount == 2) {
				ChatbotMain.print("Now you are really pissing me off.");
			} else if (madCount == 3) {
				ChatbotMain.multiLinePrint("Didn't you hear me say that I'm starting to get pissed off?");
			} else if (madCount == 4) {
				ChatbotMain.multiLinePrint("Last warning, stop being rude.");
			} else if (madCount >= 5) {
				if(yourYoure(response)) {
					int rndInsult = (int)(Math.random()*3);
					ChatbotMain.print("Well YOU'RE " + beforeInsult[rndInsult] + insults[rndInsult]);
				} else {
					ChatbotMain.print("SHUT UP STUPID.");
				}
			}
		}
		
	}
	public void checkBye(String response) {
		if(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1) {
			sayBye();
		}
	}
	public void sayBye() {
		if(happyCount >= madCount) {
			ChatbotMain.print("Thanks for the friendly conversation about insects " + ChatbotMain.chatbot.getUsername() + "." + "I hope your love for " + getFavInsect() + " lasts forever.");
		} else {
			ChatbotMain.print("Finally.. I hate talking with people who don't know anything about insects. GOOD BYE " + ChatbotMain.chatbot.getUsername());
		}
		ChatbotMain.chatbot.returnChatting();
	}
}