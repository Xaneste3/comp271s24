import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.InputStream;

public class BookReview {

    /**
     * Establishes a Scanner on a weblink. If the connection can not be made,
     * the method returns a null. That's how we can tell something went wrong
     * and decide what to do next.
     * @param link String with link to website with text to scan
     * @return Scanner connected to the website or null if connection cannot be made
     */
    public static Scanner connectToBook(String link) {
        Scanner bookScanner;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            bookScanner = new Scanner(stream);
        } catch (Exception e) {
            bookScanner = null;
        }
        return bookScanner;
    } 

    public static String scanBook(Scanner scanner) {
        String words = "";
        while(Scanner.NextLine()) {
            words += scanner.nextLine();     
        }
        return words;

    }

    public static int uniqueWordCount(String words) {
        String[] Book = words.toLowerCase().replaceAll("[^a-zA-Z0-9 ]");
        DynamicArray<String> uniqueWords = new DynamicArray<>();
        for (String word : book) {
            if (!word.isEmpty() && !uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }
        return uniqueWords.size();
    } 

    public static void main(String[] args) {
        String book = "https://gutenberg.org/cache/epub/98/pg98.txt";

        Scanner bookScanner = connectToBook(book);

        if (bookScanner.equals(null)) {
            System.out.print("No connection");
            return;

            String words = scanBook(bookScanner);

        
        int uniqueWords = uniqueWordCount(words);

        System.out.print("Number of Unique Words: " + uniqueWords);

    } 
} 
}// class BookReview
