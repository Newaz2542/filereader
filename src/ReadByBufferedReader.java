import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadByBufferedReader implements Runnable {
	private int size = readFileByBufferedReader("/filereader/src/Alice-in-Wonderland.txt").length();

	public static String readFileByBufferedReader(String filename) {
		String data = "";
		BufferedReader reader = null;
		FileReader in = null;
		try {
			in = new FileReader(filename);
			reader = new BufferedReader(in);
			int c;
			while ((c = reader.read()) >= 0) {
				data = data + (char) c;
			}
		} catch (java.io.IOException ex) {
			System.out.print(ex.getMessage());
		}

		if (in != null)
			try {
				in.close();
			} catch (IOException ioe) {
			}
		return data;
	}

	@Override
	public void run() {
		readFileByBufferedReader("/filereader/src/Alice-in-Wonderland.txt");
	}

	public String toString() {
		return String.format("BufferedReader Read %d chars in ", size);
	}
}
