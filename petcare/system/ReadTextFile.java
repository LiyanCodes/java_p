
package petcare.system;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

 
public class ReadTextFile {

    private Scanner read;

    public void openTextFile(String fileName) {
        try {
            read = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public void readFromFile() {
        try {

            while (read.hasNextLine()) {
                System.out.println(read.nextLine());
            }
        } catch (NoSuchElementException ex) {
            System.err.println("File improperly formed.");
            System.err.println(ex);
            System.exit(1);
            read.close();
        } catch (IllegalStateException ex) {
            System.err.println("Error reading from file.");
            System.err.println(ex);
        }

    }

    public void closeFile() {
        if (read != null) {
            read.close();
        }
    }
   
}
