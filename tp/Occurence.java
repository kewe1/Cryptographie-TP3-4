import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;

public class Occurence {

	public static void main(String[] args) {
		collision(10, "poisson");
	}

	public static void collision(int N, String mot) {
		String thisLine = null;
		BufferedReader r;
		int i;
		Hachage sha = new Hachage();
		Hachage sha2 = new Hachage();
		byte[] tab;	
		try {
				r = new BufferedReader(new FileReader("./tp/dictionnaire.txt"));
				
				tab = sha.Sha1(mot);
				String motchercher = conversionByteEnBit(tab, N);
			
				i = 1;
				while ((thisLine = r.readLine()) != null){
					byte[] tab2 = sha2.Sha1(thisLine);
					String motdico = conversionByteEnBit(tab2, N);
						
					if(motchercher.equals(motdico) && !mot.equals(thisLine)){
						System.out.println("Collision de " + mot +" sur " + thisLine + " nb essaie " + i);
						break;
					}						
					i++;
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

	private static String conversionByteEnBit(byte[] mot, int N) {
        StringBuffer str = new StringBuffer();
        for (byte bytes : mot) {
            str.append(String.format("%8s", Integer.toBinaryString(bytes & 0xFF)).replace(' ', '0'));
        }
        return str.toString().substring(0, N);
    }
}