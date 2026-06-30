
package petcare.system;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class WriteText {
 
    private Formatter output;

    public void openTextFile(String fileName) {
        try {
            output = new Formatter(fileName);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public void writeToFile(service c) {

        try {
            output.format(c.toString() + "\n");
            output.format("\n");
        } catch (FormatterClosedException ex) {
            System.err.println(ex);
        }
    }

    public void closeFile() {
        if (output != null) {
            output.close();
        }
    }
   
}
