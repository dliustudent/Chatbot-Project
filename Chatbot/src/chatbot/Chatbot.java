package chatbot; 

public class Chatbot {

	private static String username;
	private boolean chatting;
	private boolean introduction;
	private Topic Derek;
	private Topic David;
	private Topic Raymond;
	private Topic Vincent;
	
	
	
	public Chatbot() { 
		Derek = new ChatbotDerek();
		David = new ChatbotDavid();
		Raymond = new ChatbotRaymond();
		Vincent = new ChatbotVincent();
		username = "Unknown User";
		chatting = true;	
		introduction = false;
	}  
	public static String getUsername() {
		return username;
	}
	
	public Topic getDerek() {
		return Derek;
	}
	
	public Topic getDavid() {
		return David;
	}
	
	public Topic getRaymond() {
		return Raymond;
	}
	
	public Topic getVincent() {
		return Vincent;
	}
	
	public void startChatting() {
		ChatbotMain.print("Hi! I am an inteligent machine that can respond to your input. What is your name?");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What type of animal do you want to talk about?");
			String response = ChatbotMain.getInput();
			if(Derek.isTriggered(response)) {
				chatting = false; //exits the while loop, IMPORTANT FOR GRADE
				Derek.talk(response);
			} 
			else if (David.isTriggered(response)) {
				chatting = false;
				David.talk(response);
			}
			else if (Vincent.isTriggered(response)) {
				chatting = false;
				Vincent.talk(response);
			}
			else if (Raymond.isTriggered(response)) {
				chatting = false;
				Raymond.talk(response);
			}
			else 
			{
			ChatbotMain.print("Try typing birds, reptiles, mammals or insects instead.");
			}
			
			
		}
		

	}
	public void returnChatting(String b,String emotion) {
		chatting = true;
		while(chatting) {
			if (introduction == false) {
				if(emotion.equals("Mad")) {
					ChatbotMain.print("Im still mad at you but what do you want to talk about now ");
					introduction = true;
				}else {
					ChatbotMain.print("Welcome back you just talked about " + b + " what other tpes animals do you want to talk about now!");
					introduction = true;
				}
			}
			String response = ChatbotMain.getInput();
			
			if(Derek.isTriggered(response)) {
				if(b.equals("Reptiles")) {
					ChatbotMain.print("We talked about "+b+" lets talked about another animal");
					returnChatting(b,emotion);
				}else {
					chatting = false;
					Derek.talk(response);
				}
			} 
			else if (David.isTriggered(response)) {
				if(b.equals("Birds")) {
					ChatbotMain.print("We talked about "+b+" lets talked about another animal");
					returnChatting(b,emotion);
				}else {
					chatting = false;
					David.talk(response);
				}
			}
			else if (Vincent.isTriggered(response)) {
				if(b.equals("Mammal")) {
					ChatbotMain.print("We talked about "+b+" lets talked about another animal");
					returnChatting(b,emotion);
				}else {
					chatting = false;
					Vincent.talk(response);
				}
			}
			else if (Raymond.isTriggered(response)) {
				if(b.equals("Insect")){
					ChatbotMain.print("We talked about "+b+" lets talked about another animal");
					returnChatting(b,emotion);
				}else {
					chatting = false;
					Raymond.talk(response);
				}
			}
			else 
			{
			ChatbotMain.print("Try typing birds, reptiles, mammals or insects instead.");
			}
			
		}
	}
	
	
}



