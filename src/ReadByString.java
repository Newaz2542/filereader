import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadByString implements Runnable {
	private int size = readFileToString("/filereader/src/Alice-in-Wonderland.txt").length();

	public static String readFileToString(String filename) {
		String data = "";
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while ((c = reader.read()) >= 0) {
				data = data + (char) c;
			}
		} catch (java.io.IOException ex) {
			System.out.print(ex.getMessage());
		}

		if (in != null) {
			try {
				in.close();
			} catch (IOException ioe) {
			}
		}
		return data;
	}

	@Override
	public void run() {
		readFileToString("/filereader/src/Alice-in-Wonderland.txt");
	}

	public String toString() {
		return String.format("String Read %d chars in ", size);
	}
}
