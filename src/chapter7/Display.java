package chapter7;

public class Display {
	
	private User currentUser;
	private Player player;
	
	public User getCurrentUser(){
		return currentUser;
	}
	
	public void switchUser(User user){
		this.currentUser = user;
	}
	
	public void showCurrentSong(){
		this.player.getCurrentSong();
	}

}
