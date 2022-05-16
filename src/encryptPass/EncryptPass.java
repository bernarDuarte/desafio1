package encryptPass;
import admModel.Adm;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import static admController.Controller.*;
public class EncryptPass {
    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException{
        System.out.println(createHash("bernar023"));
    }
    
    public static String createHash(String pass) throws NoSuchAlgorithmException{
        String passwordToHash = pass;
        String salt = getSalt();
        return get_SHA_256_SecurePassword(passwordToHash,salt);
    }    
    
    private static String get_SHA_256_SecurePassword(String passwordToHash,
            String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
