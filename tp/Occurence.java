import java.io.*;
import java.security.NoSuchAlgorithmException;

public class Occurence {

	public static void main(String[] args) {
		collision("motdepasse", 6);
	}

	public static void collision(String mdp, int N) {
		String thisLine = null;
		BufferedReader r;
		int i = 0;
		Hachage sha = new Hachage();
		Hachage sha2 = new Hachage();
		byte[] tab;
		try {
			tab = sha.Sha1(mdp);
			int first_byte = (tab[0] % (1<<N));
			try {
				r = new BufferedReader(new FileReader("./tp/dictionnaire.txt"));
		
				while ((thisLine = r.readLine()) != null) {
					byte[] tab2 = sha2.Sha1(thisLine);
					int first_byte_dico = (tab2[0] % (1<<5));
	
					if(first_byte == first_byte_dico){
						System.out.println("Collision sur " + thisLine + "nb essaie " + i);
						break;
					}
					i++;
				}				
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
	}
}