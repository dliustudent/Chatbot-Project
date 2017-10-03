package chatbot;

public class ChatbotDavid implements Topic {

	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] eaglesFacts;
	private String[] reply;
	
	
	public ChatbotDavid() {
		String[] temp = {"Eagles","Penguins","Vultures","Hummingbirds","bird"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "feathers";
		response = "";
		
		String[] facts = {"Most of the 60 species of eagles are from Eurasia and Africa. Outside this area, just 14 species can be found – two in North America, nine in Central and South America, and three in Australia.","Eagles normally build their nests, called eyries, in tall trees or on high cliffs. Many species lay two eggs, but the older, larger chick frequently kills its younger sibling once it has hatched.","Like all birds of prey, eagles have very large, hooked beaks for ripping flesh from their prey, strong, muscular legs, and powerful talons.","The Bald eagle can fly to a speed of 75 – 99 mph."};
		eaglesFacts = facts;
		String answer[] = {"yes","no"};
		reply = answer;
		
		
	}
	
	@Override
	public void talk(String response) {
		
		int rageCounter = 0;
		
		ChatbotMain.print("Hey!"+ " "+ ChatbotMain.chatbot.getUsername()+" "+ "So you want to talk about birds, right? What kinds of birds do you want to talk about.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			
			int x = (int) (Math.random()*3)+0;
			
			
			
			if(ChatbotMain.findKeyword(response, keywords[0], 0) >=0 ) {
				ChatbotMain.print("Great eagles are my favorite types of birds. Did you know that"+" "+ eaglesFacts[x] + " " + "So" + " " + ChatbotMain.chatbot.getUsername() + " " + "do you still want to talk about Eagles?" );
				
				
				continueTalking();
				
			}
			if(ChatbotMain.findKeyword(response, keywords[1], 0) >=0 ) {
				ChatbotMain.print("Did you know that penguin are one of a few birds that cannot fly.");
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, keywords[2], 0) >=0 ) {
				ChatbotMain.print("Did you know that vulture are scavenger?");
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, keywords[3], 0) >=0 ) {
				ChatbotMain.print("Did you know that a Hummingbird flaps its wings over 100 times per minutes?");
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >=0 ) {
				ChatbotMain.print("Do you know why bird fly in a V shape?");
				response = ChatbotMain.getInput();
			}
			else
			{
				if(rageCounter<3)
				{
					ChatbotMain.print(response + " is not a type of bird. Please enter a bird.");
					rageCounter++;
					response = ChatbotMain.getInput();
				}
				if(rageCounter>3&&rageCounter<5)
				{
					ChatbotMain.print("PLEASE ENTER A BIRD. BEFORE I GET REALLY MAD!!!");
					rageCounter++;
					response = ChatbotMain.getInput();
				}
				if(rageCounter>5)
				{
					
				}
			}
			
		}
		//access variables from other classes.
		ChatbotMain.print("Well, it was nice talking with you, "+ChatbotMain.chatbot.getUsername()+" "+"I recommend going to the get some food now!");
		ChatbotMain.chatbot.startChatting();
	}

	public void continueTalking() {
		response = ChatbotMain.getInput();
		if(response.equals(reply[0]))
		{
			int x = (int) (Math.random()*3)+1;
			ChatbotMain.print(eaglesFacts[x] + "" + "Do you still want to talk about Eagles?" );
		}
		continueTalking();
	}
	
	
	
	@Override
	public boolean isTriggered(String response) {
		for(int i=0; i < keywords.length; i++) {
			//IMPORTANT (ON THE RUBRIC)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >=0) {
				return true;
			}
		}
		return false;
	}


}