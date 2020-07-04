public class Shift extends Algorithm{
    @Override
    protected String encrypt(String text, int key) {
        // Creating an array of chars
        char[] cipher = text.toCharArray();

        // Decrypt the text using key
        for(int i = 0; i < cipher.length; i++) {
            char letter = text.charAt(i);

            if (letter <= 'z' && letter >= 'a') {
                letter = (char) (letter + key);
                // Keep letter in alphabet
                if(letter > 'z') {
                    letter = (char) (letter - 26);
                }
            }
            else if (letter <= 'Z' && letter >= 'A') {
                letter = (char) (letter + key);
                // Keep letter in alphabet
                if(letter > 'Z') {
                    letter = (char) (letter - 26);
                }
            }
            cipher[i] = letter;
        }
        // Return the changed string
        return new String(cipher);
    }

    @Override
    protected String decrypt(String text, int key) {
        // Creating an array of chars
        char[] cipher = text.toCharArray();

        // Decrypt the text using key
        for(int i = 0; i < cipher.length; i++) {
            char letter = text.charAt(i);

            if (letter <= 'z' && letter >= 'a') {
                letter = (char) (letter - key);
                // Keep letter in alphabet
                if(letter < 'a') {
                    letter = (char) (letter + 26);
                }
            }
            else if (letter <= 'Z' && letter >= 'A') {
                letter = (char) (letter - key);
                // Keep letter in alphabet
                if(letter < 'A') {
                    letter = (char) (letter + 26);
                }
            }
            cipher[i] = letter;
        }
        // Return the changed string
        return new String(cipher);
    }
}
