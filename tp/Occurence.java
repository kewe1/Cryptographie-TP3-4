import java.io.*;
 
public class Occurence {
 
 
	public static void main(String[] args){ 
		String thisLine = null;
		BufferedReader r;
		int i = 0;
		try {
			r = new BufferedReader(new FileReader("/dictionnaire.txt"));
	
			while ((thisLine = r.readLine()) != null) {
				if(thisLine == this.hachage){
					System.out.println("Collision sur " + thisLine + "nb essaie " + i);
				}
				i++;
				System.out.println(thisLine);
			}				
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    }
}