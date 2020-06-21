

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cipher {
    private static final String ENC = "enc";

    public static void main(String[] args) {

        String command = ENC;
        String inputText = "";
        int key = 0;

        List<String> info = Arrays.asList(args);

        // If mode is specified
        if(info.contains("-mode")) {
            command = info.get(info.indexOf("-mode") + 1);
        }
        // Check if key is specified
        if(info.contains("-key")) {
            key = Integer.parseInt(info.get(info.indexOf("-key") + 1));
        }
        // Check if string is specified
        if(info.contains("-data")) {
            inputText = info.get(info.indexOf("-data") + 1);
        }


        // Variable to store the modified string
        String result = "";
        // Take action based on command
        if(command.equals(ENC)) {
            // Encrypt the text
            result = encrypt(inputText, key);
        } else {
            // Decrypt the text
            result = decrypt(inputText, key);
        }

        System.out.println(result);
    }

    private static String encrypt(String text, int key) {
        char[] cipher = text.toCharArray();

        // Decrypt the text using key
        for(int i = 0; i < cipher.length; i++) {
            char letter = text.charAt(i);
            letter = (char) (letter + key);
            cipher[i] = letter;
        }
        // Return the changed string
        return new String(cipher);
    }

    private static String decrypt(String text, int key) {
        char[] cipher = text.toCharArray();

        // Decrypt the text using key
        for(int i = 0; i < cipher.length; i++) {
            char letter = text.charAt(i);
            letter = (char) (letter - key);
            cipher[i] = letter;
        }
        // Return the changed string
        return new String(cipher);
    }
}
