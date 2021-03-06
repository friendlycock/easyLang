//Author: Bohdan Rudenko

package com.company;

import com.company.database.UserDAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class PasswordEncoder {

    public static String getSalt()  {
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    public static String getSHA512SecurePassword(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
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

    public static void main(String[] args) {
        UserDAO dao = UserDAO.getInstance();
        String salt = dao.getUserSalt(4);
        String salt2 = dao.getUserSalt(4);
        System.out.println(getSHA512SecurePassword("Password123", salt));
        System.out.println(getSHA512SecurePassword("Password123", salt2));
        System.out.println(getSHA512SecurePassword("Password123", salt));
        System.out.println(getSHA512SecurePassword("Password123", salt2));
    }
}
