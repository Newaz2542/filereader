/**
 * This class is for running all the code.
 * @author Vichakorn Yotboonrueang
 *
 */
public class Main {
	/**
	 * Call TaskTimer.measureAndPrint by different of reader and run.
	 * @param args
	 */
	public static void main(String[] args) {
		TaskTimer.measureAndPrint(new ReadByString());
		TaskTimer.measureAndPrint(new ReadByBufferedReader());
		TaskTimer.measureAndPrint(new ReadByStringBuilder());
	}

}
