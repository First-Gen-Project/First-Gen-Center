package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordEncrypter{
    public static String encryptPassword(String password){
        Srting result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("fart");
            byte[] mdRet = md.digest(password.getBytes());
            result = Base64.getEncoder().encodeToString(mdRet);
        }catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncrypter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}//ok