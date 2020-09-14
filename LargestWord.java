import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*****************************************************************************************************************
 * # 1. Read input from a file of words;
 * 
 * # 2. Find the largest word in the file
 * 
 * # 3. Transpose the letters in the largest word
 * 
 * # 4. Show the largest word and the largest word transposed
 * 
 * # 5. Demonstrate positive and negative test cases
 * 
 * # 6. Ensure you document code and instructions for building and running based
 * on the response best practices above
 *******************************************************************************************************************/

public class LargestWord {

    String fileName;
    BufferedReader reader;
    String largestWord;
    int largestWordLength;
    boolean fileParsed;

    public LargestWord(String fn) {
        fileName = fn;
        reader = null;
        largestWord = null;
        largestWordLength = 0;
        fileParsed = false;
    }

    // Find and stores the first of occurance of the laregest word in the file
    // Assumption:
    // - Each word is separated by space or newline
    // - Only keeps the first occurance of the largest word
    // - Returns null if the file does not have any word
    // - Expect caller to catch the exceptions
    private boolean findLargeWord() throws Exception {

        reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        do {
            // Reading line by line from the file
            line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                // Set the first largest word if there exists more than one large word
                if (words[i].length() > largestWordLength) {
                    largestWordLength = words[i].length();
                    largestWord = words[i];
                }
            }
        } while (line != null);
        fileParsed = true;
        return (largestWordLength != 0);
    }

    // Transposes, which is reversiong, the word.
    public String transpose(String str) {
        // Transpose: which is string reverse
        char twArray[] = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            char temp = twArray[i];
            twArray[i] = twArray[len - i - 1];
            twArray[len - i - 1] = temp;
        }
        return String.valueOf(twArray);
    }

    // Method to return the largest word in a file.
    // This method does not return the transposed word
    public String[] getLargestWord() throws Exception {
        return getLargestWord(false);
    }

    // Method to return the largest word and correspondng transposed word
    public String[] getLargestWord(boolean includeTranspose) throws Exception {
        boolean res = findLargeWord();
        String transpose = null;
        if (includeTranspose) {
            if (largestWordLength != 0) {
                transpose = transpose(largestWord);
            }
        }
        // Return the first occurance of large word along with transpose
        // transpose will be null if includeTranspose flag is not set
        return new String[] { largestWord, transpose };
    }
}
