package chapter7;

import java.util.ArrayList;

public class Playlist {
	
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist(String name){
		this.name = name;
		this.songs = new ArrayList<Song>();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void addSong(Song song){
		this.songs.add(song);
	}
	
	public void deleteSong(Song song){
		this.songs.remove(song);
	}
		
}
