package AudioTek;

import java.io.IOException;

//import java.awt.Toolkit;
/**
 * @author Sirxvy
 * @author
 */
public class AudioTek {
	public  long timer;
	public long timeOG;
	public long endTime;
	public float ConvertMiltoSec;
	public AudioTek() {
		timer = System.currentTimeMillis();
	}
	
public static void main(String[] args) throws IOException {
	AudioTek go = new AudioTek();
	PlayAnArray ps = new PlayAnArray();
	go.timer();
	for(int i = 0;i<1000;i+=25){
	ps.playSound(i, 3);
	}
	go.endTime();
	System.out.println(go.ConvertMiltoSec());
}
public  long timer(){
	timeOG = System.currentTimeMillis();
	return System.currentTimeMillis();
}
	
public long endTime(){
	return (System.currentTimeMillis()-timeOG);
}

public float ConvertMiltoSec(){
	return (float)endTime()/1000;
}
public int l(){
	int f = (int)(Math.random() * (100 - 0)) + 0;
	if(f>50)return 0;
	return 1;
}

	
	
	
	
	
}
