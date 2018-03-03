package chapter7;

public class Player {
	
	private final static int maxVolume = 10;
	private final static int muteVolume = 0;
	
	private int volume; // volume range is 0-10
	private Mode mode;
	private boolean isPlayed;
	private Song currentSong;
	private Playlist currentPlaylist;
	
	public void increaseVolume(){
		if (volume < maxVolume)
			volume++;
	}
	
	public void decreaseVolume(){
		if (volume > muteVolume)
			volume--;
	}
	
	public void playSong(){
		this.isPlayed = true;
	}
	
	public void pauseSong(){
		this.isPlayed = false;
	}
	
	public void nextSong(){

	}
	
	public Song getCurrentSong(){
		return currentSong;
	}

	public void setMode(Mode mode){
		this.mode = mode;
	}
	
	

}
