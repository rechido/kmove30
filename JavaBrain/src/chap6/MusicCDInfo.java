/**
 * 2018. 5. 23. Dev. by D. A. Lee
 */
package chap6;

public class MusicCDInfo extends CDInfo {
	String artist;
	String musicname[];
	public MusicCDInfo(String registerNo, String title, String artist, String[] musicname) {
		super(registerNo, title);
		this.artist = artist;
		this.musicname = musicname;
	}
	

}
