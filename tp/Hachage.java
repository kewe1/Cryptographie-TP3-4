
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.util.Scanner;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Hachage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre mot de passe");
        String mdp = scanner.nextLine();
        byte[] tab;

        try {
            tab = Sha1(mdp);
            String sha1 = String.format("%040x", new BigInteger(1, tab));
            System.out.println("Voici votre mot de passe haché : " + sha1);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Veuillez saisir une clé pour HMAC : ");
        String key =scanner.nextLine();
        System.out.println("Veuillez saisir un message :");
        String msg=scanner.nextLine();
        try {
            byte[] res1=hmacSha1(key,msg);
            String res1Byte="";
            for (byte b : res1) {
                res1Byte+=b+" ";
            }
            System.out.println("Voici le HMAC SHA1 en chaine d'octet : "+res1Byte);
            String hmacSha1=String.format("%040x", new BigInteger(1,res1));
            System.out.println("Voici le HMAC SHA1 en hexadécimal : "+hmacSha1);

            System.out.println(" ");

            byte[] res512=hmacSha512(key,msg);
            String res512Byte="";
            for (byte b : res512) {
                res512Byte+=b+" ";
            }

            System.out.println("Voici le HMAC SHA512 en chaine d'octet : "+res512Byte);
            String hmacSha512=String.format("%040x", new BigInteger(1,res512));
            System.out.println("Voici le HMAC SHA512 en hexadécimal : "+hmacSha512);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        scanner.close();

    }

    public static byte[] Sha1(String mdp) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.reset();
        md.update(mdp.getBytes("UTF-8"));
        byte[] tab=md.digest();
        return tab;
    }

    public static byte[] hmacSha1(String key, String msg) throws NoSuchAlgorithmException, UnsupportedEncodingException,
            InvalidKeyException {
        byte[] keyByte=key.getBytes("UTF-8");
        SecretKeySpec secretKey=new SecretKeySpec(keyByte,"HmacSHA1");
        Mac mac= Mac.getInstance("HmacSHA1");
        mac.init(secretKey);
        return mac.doFinal(msg.getBytes("UTF-8"));
        
    }
    public static byte[] hmacSha512(String key,String msg) throws NoSuchAlgorithmException, UnsupportedEncodingException,
            InvalidKeyException {
        byte[] keyByte=key.getBytes("UTF-8");
        SecretKeySpec secretKey=new SecretKeySpec(keyByte,"HmacSHA512");
        Mac mac= Mac.getInstance("HmacSHA512");
        mac.init(secretKey);
        return mac.doFinal(msg.getBytes("UTF-8"));
        
    }
}