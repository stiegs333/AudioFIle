/**
 * 
 */
package AudioTek;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
/**
 * @author Sirxvy
 *
 */
public class AudioTekDatabase {
	//public int[][] Note= new int[1000000000][1000000000];
	/**
	 * @throws IOException 
	 * 
	 */
	//boolean append = false;
	public AudioTekDatabase(boolean append){
		   try {
			FileOutputStream us = new FileOutputStream("UserDataBase.txt", append);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		}
		
	}
	
	public void inputUserData(String User,int n, int ct) throws IOException{
		try{
			//creates a new fileoutput steam object and sets appending to true will add to not overwrite
		FileOutputStream us = new FileOutputStream("UserDataBase.txt", true);
		 BufferedOutputStream buffer = new BufferedOutputStream(us);
		DataOutputStream dataOut = new DataOutputStream(buffer);
		dataOut.writeUTF("["+n+"]"+"{"+ct+"}"+",");
		dataOut.close();
		buffer.close();
		us.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public String readUserData(){
	    File file = new File("UserDataBase.txt");
	    int ch;
	    StringBuffer strContent = new StringBuffer("");
	    FileInputStream fin = null; 
	    try
	    {

	      fin = new FileInputStream(file);
	      String UserData = "";
	      while( (ch = fin.read()) != -1){
	        strContent.append((char)ch);
	        char x = (char)ch;
	        UserData += x;
	      }
	      fin.close();
	      return UserData;
	     //System.out.print(UserData);
	    }
	    catch(FileNotFoundException e)
	    {
	      System.out.println("File " + file.getAbsolutePath() +
	                             " could not be found on filesystem");
	      return null;
	    }
	    catch(IOException ioe)
	    {
	      System.out.println("Exception while reading the file" + ioe);
	      return null;
	    }
		
	}

	public void FindData(String str){
		int ct = 0;
		byte[] b = new byte[1000000000];
		String[] a = readUserData().split(",");
		for(int i = a.length;i>=0;i--){
		if(a[i].substring(0,1).equals("}")){
			b[ct]  = Byte.parseByte(a[i-1]);
			System.out.println(b[ct]);
			ct++;
		}
		
		}
		//String[] h =readUserData().split("(?<={)[^}]*(?=})");
	}
}
