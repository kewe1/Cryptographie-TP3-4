import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;

public class Occurence {

	public static void main(String[] args) {
		collision(5);
	}

	public static void collision(int N) {
		String thisLine = null;
		HashSet set = new HashSet();
		BufferedReader r;
		int i;
		Hachage sha = new Hachage();
		Hachage sha2 = new Hachage();
		byte[] tab;	
		int first_byte;	
		int first_byte_dico;
		boolean continu = true;
		String mot;
		try {
				r = new BufferedReader(new FileReader("./tp/dictionnaire.txt"));
				
				while ((thisLine = r.readLine()) != null && continu) {
					tab = sha.Sha1(thisLine);
					if (N < 7){
						first_byte = (tab[0] % (1<<N));
					}
					else{
						first_byte = (int) ((tab[0] * Math.pow(2,8) + tab[2]) % (1<<N));
					}
					set.add(first_byte);
					mot = thisLine;
					i = 0;
					while ((thisLine = r.readLine()) != null){
						byte[] tab2 = sha2.Sha1(thisLine);
						if (N < 7){
							 first_byte_dico = (tab2[0] % (1<<N));
						}
						else{
							 first_byte_dico = (int) ((tab2[0] * Math.pow(2,8) + tab2[2]) % (1<<N));
						}						
						if(set.contains(first_byte_dico)){
							System.out.println("Collision de " + mot +" sur " + thisLine + " nb essaie " + i);
							continu = false;
							break;
						}						
						i++;
					}
				}				
			}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
	}
}