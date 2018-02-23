import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Stopwatch {
	private static final double NANOSECCON = 1.0E-9;
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;
	
	public void start() {
		if(running) return;
		startTime = System.nanoTime();
		this.running = true;
	}
	
	public void stop() {
		if(!running) return;
		stopTime = System.nanoTime();
		this.running = false;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public double getElapsed() {
		if(running) return (System.nanoTime() - startTime)*NANOSECCON;
		else return (stopTime - startTime)*NANOSECCON;
	}
	
	public static String readFileToString(String filename) {
		String data ="";
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while ((c = reader.read()) >= 0) {
				data = data+(char)c;
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
	
	public static String readFileToStringBuilder(String filename) {
		StringBuilder data = new StringBuilder("");
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while ((c = reader.read()) >= 0) {
				data = data.append((char)c);
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
	
	public static String readFileByBufferedReader(String filename) {
		String data ="";
		BufferedReader reader = null;
		FileReader in = null;
		try {
			in = new FileReader(filename);
			reader = new BufferedReader(in);
			int c;
			while ((c = reader.read()) >= 0) {
				data = data+(char)c;
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
	
	public static void main(String[] arg) {
		Stopwatch sw1 = new Stopwatch();
		sw1.start();
		String books = readFileToString("/Stopwatch/src/Alice-in-Wonderland.txt");
		sw1.stop();
		Stopwatch sw2 = new Stopwatch();
		sw2.start();
		String book2 = readFileToStringBuilder("/Stopwatch/src/Alice-in-Wonderland.txt");
		sw2.stop();
		Stopwatch sw3 = new Stopwatch();
		sw3.start();
		String book3 = readFileToStringBuilder("/Stopwatch/src/Alice-in-Wonderland.txt");
		sw3.stop();
		System.out.printf("Read %d chars in %.6f sec by String\n",books.length(),sw1.getElapsed());
		System.out.printf("Read %d chars in %.6f sec by StringBuilder\n",book2.length(),sw2.getElapsed());
		System.out.printf("Read %d chars in %.6f sec by BufferedReader",book3.length(),sw3.getElapsed());
	}
	
}
