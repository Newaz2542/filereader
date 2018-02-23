import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadByReadBuilder implements Runnable {
	private int size = readFileToStringBuilder("/Stopwatch/src/Alice-in-Wonderland.txt").length();
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

	@Override
	public void run() {
		readFileToStringBuilder("/Stopwatch/src/Alice-in-Wonderland.txt");
	}

	public String toString() {
		return String.format("StringBuilder Read %d chars in ", size);
	}
}
