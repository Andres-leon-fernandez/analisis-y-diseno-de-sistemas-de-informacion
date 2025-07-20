
package com.mycompany.ecolimpio.util;

import java.security.MessageDigest;

public class Sha256 {

    public static String sha256(String mensaje) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha.digest(mensaje.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
