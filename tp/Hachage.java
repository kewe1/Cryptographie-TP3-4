
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.util.Scanner;

public class Hachage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre mot de passe");
        String mdp = scanner.nextLine();
        String sha1="";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.reset();
            md.update(mdp.getBytes("UTF-8"));
            byte[] tab=md.digest();
            System.out.println(tab);
            sha1=String.format("%040x",new BigInteger(1, md.digest()));
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Voici votre mot de passe haché : " +sha1);
        scanner.close();

    }
}