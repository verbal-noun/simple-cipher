import java.util.Scanner;

public class Encrypt {
    private static final String ENC = "enc";
    private static final String DEC = "enc";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String inputText = scanner.nextLine();
        int key = scanner.nextInt();

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
