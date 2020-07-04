public class Unicode extends Algorithm {
    @Override
    protected String encrypt(String text, int key) {
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

    @Override
    protected String decrypt(String text, int key) {
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
