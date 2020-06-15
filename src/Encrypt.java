class Encrypt {
    private static final int SHIFT = 25;
    public static void main(String[] args) {
        String sample = "we found a treasure!";
        char[] input = sample.toCharArray();

        for(int i = 0; i < input.length; i++) {
            char letter = sample.charAt(i);
            if(letter >= 'a' && letter <= 'z') {
                letter = (char) ('z' - letter + 'a');
                input[i] = letter;
            }
        }

        //System.out.println(sample);
        sample = new String(input);
        System.out.println(sample);
    }
}
