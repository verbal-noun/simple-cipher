import java.util.Scanner;

class Encrypt {
    private static final int SHIFT = 25;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        int key = scanner.nextInt();

        char[] input = inputText.toCharArray();

        for(int i = 0; i < input.length; i++) {
            char letter = inputText.charAt(i);
            if(letter >= 'a' && letter <= 'z') {
                letter = (char) (letter + key);
                if(letter > 'z') {
                    letter = (char)(letter - 26);
                }
                input[i] = letter;
            }
        }

        //System.out.println(sample);
        inputText = new String(input);
        System.out.println(inputText);
    }
}
