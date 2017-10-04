package chatbot;

public class ChatbotDavid implements Topic {

	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] eaglesFacts;
	private String[] reply;
	private String question;
	
	public ChatbotDavid() {
		String[] temp = {"Eagle","Penguin","Vulture","Hummingbird","birds"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "bird";
		response = "";
		
		String[] facts = {"Most of the 60 species of eagles are from Eurasia and Africa. Outside this area, just 14 species can be found – two in North America, nine in Central and South America, and three in Australia.","Eagles normally build their nests, called eyries, in tall trees or on high cliffs. Many species lay two eggs, but the older, larger chick frequently kills its younger sibling once it has hatched.","Like all birds of prey, eagles have very large, hooked beaks for ripping flesh from their prey, strong, muscular legs, and powerful talons.","The Bald eagle can fly to a speed of 75 – 99 mph."};
		eaglesFacts = facts;
		String answer[] = {"yes","no"};
		reply = answer;
		
		question = "";
		
	}
	
	@Override
	public void talk(String response) {
		
		int rageCounter = 0;
		
		ChatbotMain.print("Hey!"+ " "+ ChatbotMain.chatbot.getUsername()+" "+ "So you want to talk about birds, right? What kinds of birds do you want to talk about.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			
			if(ChatbotMain.findKeyword(response, keywords[0], 0) >=0 ) {
			
			
				ChatbotMain.print("Great eagles are my favorite types of birds. Did you know that"+" "+ eaglesFacts[0] + " " + "So" + " " + ChatbotMain.chatbot.getUsername() + " " + "do you still want to talk about Eagles?");
				
				continueTalking();
			
			}
			else
			{
				if(rageCounter<2)
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
					ChatbotMain.print("AHHHHHHHHHHHHHHHHH!!!");
					rageCounter++;
					response = ChatbotMain.getInput();
				}
				
			}
			
		}
		//access variables from other classes.
		ChatbotMain.print("Well, it was nice talking with you, "+ChatbotMain.chatbot.getUsername()+" "+"I recommend going to the get some food now!");
		ChatbotMain.chatbot.startChatting();
	}
	//booty
	public void continueTalking() {
		response = ChatbotMain.getInput();
		if(response.equals(reply[0]))
		{
			int i=0;
				
			ChatbotMain.print("Did you know that"+" "+ eaglesFacts[i+1] + " " + "So" + " " + ChatbotMain.chatbot.getUsername() + " " + "do you still want to talk about Eagles?" );
				
			if(i>=eaglesFacts.length) 
			{
				ChatbotMain.print("Sorry I ran out of fact about birds. Do you know any fact about birds?");
				question(response);
			}
				
			i++;	
		}	
		else
		{
			talk(response);
			
		}
		continueTalking();
	}
	
	public void question(String response)
	{
		int rageCounter = 0;
		ChatbotMain.print("Wow you are so smart tell me more.");
		if(response.equals(question))
		{
			if(rageCounter<2)
			{	
				ChatbotMain.print("You already told me this fact.");
				rageCounter++;
			}
			else
			{
				ChatbotMain.print("STOP REPEATING THE SAME THING!!!");
			}
		}
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
