package com.example.attendancemanageroffline;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;



    public static void setKey(String myKey)
    {
        Logger logger = Logger.getLogger(AES.class.getName());
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            String message = "No Such Algorithm Exception";
            logger.log(Level.ALL, message, e);
        }
        catch (UnsupportedEncodingException e) {
        }
    }

    public static String encrypt(String strToEncrypt, String secret)
    {
        Logger logger = Logger.getLogger(AES.class.getName());
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/GCM/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
            String message = "Exception";
            logger.log(Level.ALL, message, e);
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret)
    {
        Logger logger = Logger.getLogger(AES.class.getName());
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/GCM/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
            String message = "Exception";
            logger.log(Level.ALL, message, e);
        }
        return null;
    }
}