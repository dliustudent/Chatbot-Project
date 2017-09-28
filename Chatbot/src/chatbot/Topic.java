package chatbot;

public interface Topic {

	boolean isTriggered(String response);

	void talk(String response);

}
