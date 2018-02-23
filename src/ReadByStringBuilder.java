import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class made for read text file by StringBuilder that have been
 * implemented Runnable for eliminate duplicate code.
 * 
 * @author Vichakorn Yotboonrueang
 *
 */
public class ReadByStringBuilder implements Runnable {
	/**
	 * size save the number of character in the text file.
	 */
	private int size = readFileToStringBuilder("/Stopwatch/src/Alice-in-Wonderland.txt").length();

	/**
	 * this method read the text file char by char then save the char of each
	 * character.In the end char will combine to String.
	 * 
	 * @param filename
	 *            location of file text.
	 * @return String - character of text file.
	 */
	public static String readFileToStringBuilder(String filename) {
		StringBuilder data = new StringBuilder("");
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while ((c = reader.read()) >= 0) {
				data = data.append((char) c);
			}
		} catch (java.io.IOException ex) {
			System.out.print(ex.getMessage());
		}

		if (in != null)
			try {
				in.close();
			} catch (IOException ioe) {
			}
		return data.toString();
	}

	/**
	 * used to create a thread, starting the thread causes the object's run method
	 * to be called in that separately executing thread.
	 */
	@Override
	public void run() {
		readFileToStringBuilder("/Stopwatch/src/Alice-in-Wonderland.txt");
	}

	/**
	 * @return text can tell you how many character that have been reading.
	 */
	public String toString() {
		return String.format("StringBuilder Read %d chars in ", size);
	}
}
