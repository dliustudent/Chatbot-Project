package chatbot;

public class ChatbotDavid implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] eaglesFacts;
	private String[] reply;
	private String userFacts;
	int questionNum = 0;
	private String likes;
	private String dislikes;
	private String reasons;
	int rageCounter = 0;
	private String[] penguin;
	private String[] vulture;
	private String[] hummingbird;
	boolean checkbird;
	boolean firstTalk;
	
	public ChatbotDavid() {
		String[] temp = {"eagle","penguin","vulture","hummingbird","birds","bird"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "bird";
		response = "";
		
		String[] facts1 = {"Most of the 60 species of eagles are from Eurasia and Africa. Outside this area, just 14 species can be found two in North America, nine in Central and South America, and three in Australia.","Eagles normally build their nests, called eyries, in tall trees or on high cliffs. Many species lay two eggs, but the older, larger chick frequently kills its younger sibling once it has hatched.","Like all birds of prey, eagles have very large, hooked beaks for ripping flesh from their prey, strong, muscular legs, and powerful talons.","The Bald eagle can fly to a speed of 75 to 99 mph."};
		String[] facts2 = {"Emperor Penguins are the tallest species, standing nearly 4 feet tall.","3. The fastest species is the Gentoo Penguin, which can reach swimming speeds up to 22 mph.","All but two species of penguins breed in large colonies of up to a thousand birds."}; 
		String[] facts3 = {"Vultures are found on every continent except Australia and Antarctica.", "Vultures only lay one egg every year or so.", "A vulture can eat up to 1 kilogram (about 2 pounds) in a single meal (that's over 10% of their body weight)."};
		String[] facts4 = {"Hummingbirds are the only birds that can fly backwards.", "Some hummingbirds fly at speeds greater than 33 miles per hour.", "A hummingbird's wing beats take up so much energy, they spend the majority of their time resting on branches and twigs."};
		
		penguin = facts2;
		vulture = facts3;
		hummingbird = facts4;
		eaglesFacts = facts1;
		String answer[] = {"yes","no","creepy","maybe"};
		reply = answer;
		likes = "";
		dislikes = "";
		reasons = "";
		userFacts = "";
		checkbird = false;
		firstTalk = false;
		
	}
	
	@Override
	public void talk(String response) {
		
		if(firstTalk == false)
		{
			ChatbotMain.print("Hey!"+ " "+ ChatbotMain.chatbot.getUsername()+" "+ "So you want to talk about birds, right? What kinds of birds do you want to talk about?");
			response = ChatbotMain.getInput();
		}

		if(checkbird==false)
		{
			firstTalk = true;
			checkIfBird(response);
		}
		if(checkbird==true)
		{	
			while(!response.equals(goodbyeKeyword)) {
				
				while(response.equals(keywords[0])) {
				
					ChatbotMain.print("Great eagles are my favorite types of birds. Did you know that"+" "+ eaglesFacts[0] + " " + "So" + " " + ChatbotMain.chatbot.getUsername() + " " + "do you still want to talk about Eagles?");
					continueTalking();
					break;
				}
				
				while(ChatbotMain.findKeyword(response, keywords[2], 0) >=0 ) {
					//likes and dislikes	
					ChatbotMain.print("Do you like Vulture?");
					response = ChatbotMain.getInput();
					likes = response;
					if(likes.equals(reply[1]))
					{
						ChatbotMain.print("Me too, I find them a little bit creepy.");
						break;
					}
					else
					{
						ChatbotMain.print("What?! You like vultures, well can you tell me why?");
						response = ChatbotMain.getInput();
						reasons = response;
						ChatbotMain.print("I see you like Vultures because"+" "+reasons+".");
					}
				}

				
			}
			//access variables from other classes.
			ChatbotMain.print("Well, it was nice talking with you, "+ChatbotMain.chatbot.getUsername()+" "+"I recommend going to the get some food now!");
			ChatbotMain.chatbot.startChatting();
		}	
	}
	
	public void continueTalking() {
		response = ChatbotMain.getInput();
		//display facts until no facts left then ask user for facts
		if(response.equals(reply[3]))
		{
			ChatbotMain.print("Well make up your mind. Do you want to hear another fact or not.");
			continueTalking();
		}
		else
		{
			ChatbotMain.print("Okay fine what other birds do you want to talk about?");
		}
		
		if(response.equals(reply[0]))
		{
			ChatbotMain.print("Okay here is another fact did you know that"+" "+ eaglesFacts[questionNum] + " " + "So" + " " + ChatbotMain.chatbot.getUsername() + " " + "do you still want to talk about Eagles?" );
			questionNum++;
			
			if(questionNum>eaglesFacts.length)
			{
				ChatbotMain.print("Sorry I ran out of fact about birds. Do you know any fact about birds?");
				response = ChatbotMain.getInput();
				question(response);
			}				
		}
		else
		{
			ChatbotMain.print("Okay fine what other birds do you want to talk about?");
		}
	}
	
	public void question(String response)
	{
		//stores the user facts
		userFacts = "" + response + " ";
		int rageCounter = 0;
		ChatbotMain.print("Wow you are so smart tell me more.");
		int numFact = 0;
		numFact++;
		//the higher the number of fact the happier the bot will be
		
		if(response.equals(userFacts))
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
	
	public void checkIfBird(String response){
		//check to see if the user enter a bird gets angry when it is not a bird.
		int check = 0;
		for(int i=0; i<keywords.length; i++)
		{
			if(keywords[i].equals(response))
			{
				check++;
				
			}
		}
			if(check==0)
			{
				if(rageCounter<=2)
				{
					ChatbotMain.print(response + " is not a type of bird. Please enter a bird.");
					rageCounter++;
					response = ChatbotMain.getInput();
					checkIfBird(response);
				}
				else
				{
					if(rageCounter>=3&&rageCounter<5)
					{
						ChatbotMain.print("PLEASE ENTER A BIRD. BEFORE I GET REALLY MAD!!!");
						rageCounter++;
						response = ChatbotMain.getInput();
						checkIfBird(response);
					}
					else
					{
						if(rageCounter>=5)
						{
							ChatbotMain.print("I don't want to talk with you anymore.");
							rageCounter++;
							response = ChatbotMain.getInput();
							checkIfBird(response);
						}
					}		
				}
			}
			if(check>0) 
			{
				checkbird = true;
				talk(response);
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
