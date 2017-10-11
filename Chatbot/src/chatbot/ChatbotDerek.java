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
	private String response2;
	private String thingLiked;
	private String initialWord;
	//private String[] fact;
	
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
//	String[] fac = {"Vincent is not a snake", "David is a monkey","Derek is not a turtle", "Raymond may be a lizard"};
//		fact = fac;
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
									
		 while(!response.equals(goodbyeKeyword)) {
				for(int i = 0 ; i < keywords.length ; i++) {
					if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
						secretResponse = "Wow! You know about skinks? You are amazing!(you can try repeating my message or move on)";
						copy(response);
						chatbotPrint(secretResponse);
						response = ChatbotMain.getInput();
					}else if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
						talk2(response);
						response = ChatbotMain.getInput();
						copy(response);
						
					}
				} 
				
				 chatbotPrint("Try typing alligator, crocodile, lizard, snake, turtle, or tortoise");
				 response = ChatbotMain.getInput();}
			}
		 
	public void copy(String s) {
		if(initialWord.equals(s)) {
			chatbotPrint("Stop copying me!");
			response = ChatbotMain.getInput();
		}
	} 
	
	public void chatbotPrint(String nanidesu) {
		initialWord = nanidesu;
		ChatbotMain.print(nanidesu);
	}
	
	public void setFto0() {
		if (setFbackto0 == false) {
			f = 0;
			System.out.println(f);
		}
	}
	
	public void talk2(String response) {
		thingLiked = response;
		regularResponse = response + " is/are very interesting. Do you like " + response;
		chatbotPrint(regularResponse);
		copy(response);
		emotion();
	}
	
	public void emotion(){
		response2 = ChatbotMain.getInput();
		for(int i = 0 ; i < response2.length() ; i++) {
		if(ChatbotMain.findKeyword(response2, love[i], 0) >= 0) {
				chatbotPrint(("Wow! I like " +thingLiked+ " too! Do you want to hear a fact about " +thingLiked+ "?"));
				copy(response2);
			}
		}
		for(int j = 0 ; j < response2.length() ; j++) {
			if(ChatbotMain.findKeyword(response2, hate[j], 0) >= 0) {
				chatbotPrint("Aww, thats too bad! I don't think that" +thingLiked+ "sucks but whatever.");
				copy(response2);
				talk(response);
				response = ChatbotMain.getInput();			
			}
		}
	}
	
	
	public void fact() {
		if(thingLiked == "alligator") {
			chatbotPrint("Alligators are all igators made from apple himselfxd");
		}
		if(thingLiked == "alligator") {
			chatbotPrint("Alligators are all igators made from apple himselfxd");
		}
	}
}
