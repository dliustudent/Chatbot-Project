package chatbot;

public class ChatbotDavid implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
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
	private String bird;
	private String[] birdtype;
	
	public ChatbotDavid() {
		String[] birdlist = {"eagle","penguin","vulture","hummingbird","eagles","penguins","vultures","hummingbirds"};
		birdtype = birdlist; 
		
		String[] temp = {"birds","bird"};
		keywords = temp;
		goodbyeKeyword = "bye";
		response = "";
		String[] facts1 = {"Most of the 60 species of eagles are from Eurasia and Africa. Outside this area, just 14 species can be found two in North America, nine in Central and South America, and three in Australia.","Eagles normally build their nests, called eyries, in tall trees or on high cliffs. Many species lay two eggs, but the older, larger chick frequently kills its younger sibling once it has hatched.","Like all birds of prey, eagles have very large, hooked beaks for ripping flesh from their prey, strong, muscular legs, and powerful talons.","The Bald eagle can fly to a speed of 75 to 99 mph."};
		String[] facts2 = {"Emperor Penguins are the tallest species, standing nearly 4 feet tall.","3. The fastest species is the Gentoo Penguin, which can reach swimming speeds up to 22 mph.","All but two species of penguins breed in large colonies of up to a thousand birds."}; 
		String[] facts3 = {"Vultures are found on every continent except Australia and Antarctica.", "Vultures only lay one egg every year or so.", "A vulture can eat up to 1 kilogram (about 2 pounds) in a single meal (that's over 10% of their body weight)."};
		String[] facts4 = {"Hummingbirds are the only birds that can fly backwards.", "Some hummingbirds fly at speeds greater than 33 miles per hour.", "A hummingbird's hearts can beat as fast as 1,260 beats per minute", "A Hummingbird wings move at a rate of 80 beats per second."};
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
		bird = "";
	}
	
	@Override
	public void talk(String response) {
		if(firstTalk == false)
		{
			//check if user input a bird
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
			while(!response.equals(goodbyeKeyword)) 
			{
				
				while(response.equals(birdtype[0])||response.equals(birdtype[4])) {
					bird = "eagles";
					ChatbotMain.print("Great eagles are my favorite types of birds. Do you like eagles?"); 
					response = ChatbotMain.getInput();
					likesOrDislikes();
					continueTalking(response);
					break;
				}
				
				while(response.equals(birdtype[2])||response.equals(birdtype[6])) 
				{
					bird = "vultures";
					//likes and dislikes
					ChatbotMain.print("Ughhh, why vulture? Don't tell me you like them.");
					response = ChatbotMain.getInput();
					
					if(response.contains(reply[1]))
					{
						ChatbotMain.print("Me too, I find them a little bit creepy.");
						
					}
					else
					{
						if(response.contains(reply[0]))
						{
							likes = ""+"vultures ";
							ChatbotMain.print("What?! You like vultures, well can you tell me why?");
							response = ChatbotMain.getInput();
							reasons = response;
							
							while(reasons.contains("no"))
							{
								ChatbotMain.print("Why not please tell me.");
								response = ChatbotMain.getInput();
								reasons = response;
								
							}
							ChatbotMain.print("I see you like Vultures because"+" "+reasons+".");
						}
						
					}					
					double ran = Math.random()*3;					
					ChatbotMain.print("Well did you know that" +" "+ vulture[(int) ran]+" Do you still want to talk about Vultures?");
					
					response = ChatbotMain.getInput();
					
					if(response.equals(reply[1]))
					{
						ChatbotMain.print("Since you don't like vultures, lets talk about penguins.");
						bird = "penguins";
						response = "penguins";
						talk(response);
					}
					else
					{
						if(likes.contains("vultures"))
						{	
							ChatbotMain.print("Okay, why don't you tell me something about Vulture since you think"+" "+reasons+".");
							response = ChatbotMain.getInput();
							userFacts = ""+response;
							if(userFacts.equals(vulture[(int) ran]))
							{
								ChatbotMain.print("Hey I just told you that!");
								response = ChatbotMain.getInput();
							}
							else
							{	
								if(userFacts.contains("vulture")||userFacts.contains("they"))
								{	
									ChatbotMain.print("Wow you are so smart."+" "+"I never knew that vultures"+userFacts);
									response = ChatbotMain.getInput();
								}	
								else
								{
									ChatbotMain.print("Hey, stop typing nonsense, I thought we are talking about Vultures.");
									ChatbotMain.print("Come on tell me a fact about Vultures.");
									response = ChatbotMain.getInput();

								}
								
								
							}
						}
					
					}
				}	
						
					
			
				while(response.equals(birdtype[1])||response.equals(birdtype[5]))
				{
					if(likes.contains("penguins"))
					{
						double ran = Math.random()*4;	
						ChatbotMain.print("Here is a fun fact "+penguin[(int) ran]+" do you wanna hear more.");
						response = ChatbotMain.getInput();
						if(response.contains("yes"))
						{
							while(response.contains("yes"))
							{	
								ChatbotMain.print("Here is another fun fact "+penguin[(int) ran-1]+" do you wanna hear more.");
								response = ChatbotMain.getInput();
							}
						}	
						else
						{
							otherBirds();
						}
					}
					bird = "penguins";
					ChatbotMain.print("Don't you just find Penguins adorable?");
					response = ChatbotMain.getInput();
					likesOrDislikes();
					
					
				}
				while(response.equals(birdtype[3])||response.equals(birdtype[7]))
				{
					
					if(likes.contains("hummingbird"))
					{
						double ran = Math.random()*4;	
						ChatbotMain.print("Here is a fun fact "+hummingbird[(int) ran]+" do you wanna hear more.");
						response = ChatbotMain.getInput();
						if(response.contains("yes"))
						{
							while(response.contains("yes"))
							{	
								ChatbotMain.print("Here is another fun fact "+hummingbird[(int) ran-1]+" do you wanna hear more.");
								response = ChatbotMain.getInput();
							}
						}	
						else
						{
							otherBirds();
						}
					}
					
					
					bird = "hummingbirds";
					ChatbotMain.print("Do you like hummingbird?");
					response = ChatbotMain.getInput();
					likesOrDislikes();
					
					
				}
			}
			//access variables from other classes.
				ChatbotMain.print("Well, it was nice talking with you, "+ChatbotMain.chatbot.getUsername());
				
				if(likes.contains("eagle") || likes.contains("vulture") || likes.contains("hummingbird") || likes.contains("penguins") )
				{	
					ChatbotMain.print("I learn alot about you like "+likes);
				}
				if(dislikes.contains("eagle") || dislikes.contains("vulture") || dislikes.contains("hummingbird") || dislikes.contains("penguins") )
				{	
					ChatbotMain.print("I still cannot believe you don't like "+dislikes);
				}
				ChatbotMain.chatbot.startChatting();
		}
			
	}
	
	public void continueTalking(String response) {
		
		//display facts until no facts left then ask user for facts

		
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
			
			if(response.equals(reply[3]))
			{
				ChatbotMain.print("Well make up your mind. Do you want to hear another fact or not.");
				continueTalking(response);
			}
			else
			{
				ChatbotMain.print("Okay fine what other birds do you want to talk about?");
				response = ChatbotMain.getInput();
				checkIfBird(response);
				talk(response);
			}
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
		bird = response;
		int check = 0;
		for(int i=0; i<birdtype.length; i++)
		{
			if(birdtype[i].equals(response))
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
							ChatbotMain.print("I don't wanna to talk with you anymore, goodbye.");
							rageCounter++; //ends the chatbot 
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
	public void likesOrDislikes()
	{
		if(bird.equals("eagles"))
		{	
			if(response.equals(reply[1]))
			{
				ChatbotMain.print("What how do you not like eagles.");
				response = ChatbotMain.getInput();
				reasons = response;
				ChatbotMain.print("Oh I see you don't like eagles because"+" "+reasons);
				dislikes = ""+"eagle ";
			}
			else
			{
				likes = ""+"eagle ";
				ChatbotMain.print("What no way you like eagles too"+" "+"Did you know that"+" "+ eaglesFacts[0] + " " + "So" + " " + ChatbotMain.chatbot.getUsername() + " " + "do you still want to talk about Eagles?");
				response = ChatbotMain.getInput();
				continueTalking(response);
			}
		}
		if(bird.equals("penguins"))
		{
			if(response.equals(reply[1]))
			{
				dislikes = ""+"penguins ";
				ChatbotMain.print("What you don't think Penguins are cute?!");
				response = ChatbotMain.getInput();
			}
			else
			{
				likes = ""+"penguins ";
				ChatbotMain.print("I love penguins too. They are so cute.");
				response = ChatbotMain.getInput();
			}
		}
		if(bird.equals("hummingbird"))
		{
			if(response.equals(reply[1]))
			{
				ChatbotMain.print("Why don't you like hummingbird?");
				response = ChatbotMain.getInput();
				reasons = response;
				ChatbotMain.print("I see you don't like hummingbird because "+reasons);
				ChatbotMain.print("Okay since you don't like hummingbird what kind of bird do you wanna talk about?");
				dislikes = ""+"hummingbird ";
				response = ChatbotMain.getInput();
				talk(response);
			}
			else
			{
				ChatbotMain.print("I like hummingbird too. They might be small but they are really cool.");
				likes = ""+"hummingbird ";
				double ran = Math.random()*3;
				ChatbotMain.print(hummingbird[(int) ran]);
				response = ChatbotMain.getInput();
			}
		}
	}
	public void otherBirds()
	{
		ChatbotMain.print("Okay fine what other birds do you want to talk about?");
		response = ChatbotMain.getInput();
		checkIfBird(response);
		talk(response);
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
