package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private Topic Derek;
	
	public Chatbot() { 
		Derek = new ChatbotDerek();
		username = "Unknown User";
		chatting = true;		
	}  
	public String getUsername() {
		return username;
	}
	
	public Topic getDerek() {
		return Derek;
	}
	public void startChatting() {
		ChatbotMain.print("Hi! I am an inteligent machine that can respond to your input. What is your name?");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(Derek.isTriggered(response)) {
				chatting = false; //exits the while loop, IMPORTANT FOR GRADE
				Derek.talk(response);
			}else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said i was perfect.");
			}
		}
	}

}
