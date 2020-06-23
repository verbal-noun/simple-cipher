import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cipher {
    private static final String ENC = "enc";
    private static final String DEC = "enc";

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
        // Check if data is specified
        if(info.contains("-data")) {
            // data mode is used
            inputText = info.get(info.indexOf("-data") + 1);
        } else if (info.contains("-in")) {
            // Read the data from the file
            File file = new File(info.get(info.indexOf("-in") + 1));
            try {
                Scanner scanner = new Scanner(file);
                inputText = scanner.nextLine();
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

        if(info.contains("-out")) {
            File file = new File(info.get(info.indexOf("-out") + 1));
            try {
                // Create output file
                if(file.createNewFile()) {
                    // Write result onto file
                    FileWriter fileWriter = new FileWriter(file);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.print(result);
                    printWriter.close();
                } else {
                    // Open existing file
                    FileWriter fileWriter = new FileWriter(file);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.print(result);
                    printWriter.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Print to standard output
            System.out.println(result);
        }

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
