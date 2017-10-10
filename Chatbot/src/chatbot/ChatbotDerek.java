package chatbot;

public class ChatbotDerek implements Topic {

	private Topic Vincent;
	private Topic David;
	private Topic Raymond;
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	int f;
	private String secretResponse;
	private String regularResponse;
	private String[] love;
	private String[] hate;
	private boolean checkingOthers;
	private boolean setFbackto0;
	private boolean inLikeLoop;
	private String response2;
	private String thingsLiked;
	private boolean userLikeStored;
	
	
	public ChatbotDerek() {

		David = new ChatbotDavid();
		Raymond = new ChatbotRaymond();
		
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
	//	String[] fac = {"same"};
		//fact = fac;
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
		
		ChatbotMain.print("Hi, "+ a + "!" + " Reptiles are extremely cool! What reptile would you like to talk about?");
		
		response = ChatbotMain.getInput();
									
		 while(!response.equals(goodbyeKeyword)) {
				for(int i = 0 ; i < keywords.length ; i++) {
					if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
						secretResponse = "Wow! You know about skinks? You are amazing!";
						copy(response);
						ChatbotMain.print(secretResponse);
						response = ChatbotMain.getInput();
					}else if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
						talk2(response);
						response = ChatbotMain.getInput();
						copy2(response);
						
					}
				} 
				
				 ChatbotMain.print("Try typing alligator, crocodile, lizard, snake, turtle, or tortoise");
				 response = ChatbotMain.getInput();}
			}
		 	
	public void copy(String response) {
		if(secretResponse.equals(response)) {
			ChatbotMain.print("Stop copying me!");
			f++;
			response = ChatbotMain.getInput();
		}
		if (f>1) {
			ChatbotMain.print("Im for real stop!");
			response = ChatbotMain.getInput();
		}
		
		}
	
	public void copy2(String response) {
		if(regularResponse.equals(response)) {
			ChatbotMain.print("Stop copying me!");
			f++;
			response = ChatbotMain.getInput();
		}
		if (f>1) {
			ChatbotMain.print("Im for real stop!");
			response = ChatbotMain.getInput();
			setFbackto0 = false;
			setFto0();

		}
		
	}
	
	public void setFto0() {
		if (setFbackto0 == false) {
			f = 0;
			System.out.println(f);
		}
	}
	
	public void talk2(String response) {
		regularResponse = response + " is/are very interesting. Do you like " + response + "(please type i like *blank*)";
		ChatbotMain.print(regularResponse);
		emotion();
	}
	
	public void emotion()
	{
		response2 = ChatbotMain.getInput();
		int likePsn = ChatbotMain.findKeyword(response2, "like", 0);
		if( likePsn >= 0 ){
			thingsLiked = response2.substring(likePsn+5);
			userLikeStored = true;
			ChatbotMain.print("You are such an "+ "interesting"+ " person, because you like "+thingsLiked+".");
		}
		else {
			ChatbotMain.print("wat");
		}
//		for(int i = 0 ; i < a.length() ; i++) {
//			if(ChatbotMain.findKeyword(a, love[i], 0) >= 0) {
//				ChatbotMain.print("Wow! I like that reptile too!. Wanna hear a fact about this reptile?");
//			}
//		}
//		for(int j = 0 ; j < a.length() ; j++) {
//			if(ChatbotMain.findKeyword(a, hate[j], 0) >= 0) {
//				ChatbotMain.print("Aww, thats too bad! I don't think that reptile sucks but ok.");
//			}
//		}
//	}
		}
}