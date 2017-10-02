package chatbot; 

public class Chatbot {

	private String username;
	private boolean chatting;
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
	}  
	public String getUsername() {
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
			ChatbotMain.print("What would you like to talk about?");
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
			ChatbotMain.print("Im sorry i never said i was perfect.");
			}
			
			
		}
		

	}
	
	
}



