package chapter7;

import java.util.ArrayList;

public class Jukebox {
	
	private Display display;
	private ArrayList<User> users;
	
	public void addUser(User user){
		users.add(user);
	}
	
	public void deleteUser(User user){
		users.remove(user);
	}

}
