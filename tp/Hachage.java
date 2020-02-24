
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.util.Scanner;

public class Hachage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre mot de passe");
        String mdp = scanner.nextLine();
        String sha1 = "";
        byte[] tab;
        try {
            tab = Sha1(mdp, sha1);
            sha1=String.format("%040x",new BigInteger(1,tab));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Voici votre mot de passe haché : " +sha1);
        scanner.close();

    }

    private static byte[] Sha1(String mdp, String sha1) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.reset();
        md.update(mdp.getBytes("UTF-8"));
        byte[] tab=md.digest();
        return tab;
    }
}