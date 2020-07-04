import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ENC = "enc";
    private static final String DEC = "enc";

    public static void main(String[] args) {

        String command = ENC;
        String inputText = "";
        int key = 0;
        Algorithm algorithm = new Shift();;
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

        // Check if algorithm is specified or not
        if(info.contains("-alg")) {
            String algoType = info.get(info.indexOf("-alg") + 1);
            if(algoType.equals("shift")) {
                algorithm = new Shift();
            } else if (algoType.equals("unicode")) {
                algorithm = new Unicode();
            }
        }

        // Modify the the string according to the algorithm and arguments
        // Variable to store the modified string
        String result = "";
        // Take action based on command
        if(command.equals(ENC)) {
            // Encrypt the text
            result = algorithm.encrypt(inputText, key);
        } else {
            // Decrypt the text
            result = algorithm.decrypt(inputText, key);
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

}
