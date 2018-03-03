package chapter7;

import java.util.ArrayList;

public class Library {
	
	private ArrayList<Song> songs;
	private ArrayList<Playlist> playlists;
	
	public void addSong(Song song){
		songs.add(song);
	}
	
	public void deleteSong(Song song){
		this.songs.remove(song);
		for (Playlist playlist : this.playlists)
			playlist.deleteSong(song);
	}
	
	public void importCD(CD cd){
		for (Song song : cd.getSongs())
			this.addSong(song);
	}
	
	public void createPlaylist(String name){
		this.playlists.add(new Playlist(name));
	}
	
	public void deletePlaylist(Playlist playlist){
		this.playlists.remove(playlist);
	}

}
