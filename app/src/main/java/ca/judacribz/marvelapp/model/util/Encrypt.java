package ca.judacribz.marvelapp.model.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
    public static String getMD5Hash(String publicKey, String privateKey) {

        final String secret = String.format("1%s%s", privateKey, publicKey);
        String md5Hash = null;

        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            final byte[] messageDigest = md.digest(secret.getBytes());
            final BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            md5Hash = hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return md5Hash;
    }
}
