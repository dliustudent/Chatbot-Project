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
	private boolean setFbackto0;
	private String response2;
	private String thingLiked;
	private String initialWord;
	
	public ChatbotDerek() {

		
		String[] temp = {"reptile","reptiles", "alligator", "crocodile", "lizard", "snake", "turtle", "tortoise",};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "skink";
		response = "";
		f = 0;
		String[] b = {"love", "like", "yes"};
		love = b;
		String[] d = {"hate", "dislike", "no"};
		hate = d;
		initialWord = "";
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
		
		chatbotPrint("Hi, "+ a + "!" + " Reptiles are extremely cool! What reptile would you like to talk about?");
		
		response = ChatbotMain.getInput();
							
		goodBye(response);
		 while(!response.equals(goodbyeKeyword)) {
				for(int i = 0 ; i < keywords.length ; i++) {
					if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
						secretResponse = "Wow! You know about skinks? You are amazing!(you can try typing out my message again or move on)";
						copy(response);
						chatbotPrint(secretResponse);
						response = ChatbotMain.getInput();
					}else if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
						talk2(response);
						response = ChatbotMain.getInput();
						i=-1;
						copy(response);
						
					}
				} 
				
				 chatbotPrint("Try typing alligator, crocodile, lizard, snake, turtle, or tortoise");
				 response = ChatbotMain.getInput();}
		 		 copy(response);
			}
		 
	public void copy(String s) {
		if(initialWord.equals(s)) {
			chatbotPrint("Stop copying me!");
			response = ChatbotMain.getInput();
		}
	} 
	
	public void chatbotPrint(String d) {
		initialWord = d;
		ChatbotMain.print(d);
	}
	
	public void talk2(String response) {
		thingLiked = response;
		regularResponse = response + " is/are very interesting. Do you like " + response+"?";
		chatbotPrint(regularResponse);
		copy(response);
		emotion();
	}
	
	public void emotion(){
        response2 = ChatbotMain.getInput();
        for(int i = 0 ; i < love.length ; i++) {
        if(ChatbotMain.findKeyword(response2, love[i], 0) >= 0) {
                chatbotPrint(("Wow! I like " +thingLiked+ " too! Do you want to hear a fact about " +thingLiked+ "?"));
                boolean again = false;
                while(again == false) {
                    response = ChatbotMain.getInput();
                    if(ChatbotMain.findKeyword(response, "yes", 0) >=0) {
                        copy(response2);
                        fact();
                        again = true;
                    }else if(ChatbotMain.findKeyword(response, "no", 0) >=0) {
                        chatbotPrint(("Oh...Lets talk about a different reptile then. Which one would you like to talk about?"));
                        break;
                    }else {
                        chatbotPrint(("Please type yes or no."));
                    } 
                }
            }
        }
        for(int j = 0 ; j < hate.length ; j++) {
        	
            if(ChatbotMain.findKeyword(response2, hate[j], 0) >= 0) {
            	
                chatbotPrint("Aww, thats too bad! I don't think that " +thingLiked+ " sucks but whatever.");
                talk(response);  
                   response2 = ChatbotMain.getInput();
                   copy(response2);              	
            	}
        	}
		}


   
	public void fact() {
		if(thingLiked.equals("lizard")) {
			chatbotPrint("Do you often see lizards frequently taking their tongues in and out? They do it to smell. Yes, they smell by tasting the air around them. They can do this because they have something called as vomeronasal organ. Alright, lets talk about another reptile now.");
		}
		else if(thingLiked.equals("alligator")) {
			chatbotPrint("Male American alligators average 8 to 10 feet long, while females tend to be slightly smaller. Very old males can get quite large, up to 15 feet long and weighing over 1,000 pounds. Alright, lets talk about another reptile now.");
		}
		else if(thingLiked.equals("turtle")) {
			chatbotPrint("Turtles date back to the time of the dinosaurs, over 200 million years ago! Alright, lets talk about another reptile now.");
		}
		else if(thingLiked.equals("snake")) {
			chatbotPrint("Snakes kill over 40,000 people a year—though, with unreported incidents, the total may be over 100,000. About half of these deaths are in India. Alright, lets talk about another reptile now.");
		}
		else if(thingLiked.equals("crocodile")) {
			chatbotPrint("A crocodile's belly has gentle skin. The skin on their back contains bony structures (called osteoderms) which make skin bulletproof. Alright, lets talk about another reptile now.");
		}
		else if(thingLiked.equals("tortoise")) {
			chatbotPrint("Tortoises inspired the ancient Roman military. During seiges, soldiers would get in testudo formation, named after the Latin word for tortoise. The men formed rows and held shields in front or above them to completely shelter the unit. Alright, lets talk about another reptiles now.");
		}
	}
	
	public void goodBye(String response) {
		if(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) >= 0) {
			ChatbotMain.chatbot.returnChatting("Reptiles","Normal");
		}
	}
}