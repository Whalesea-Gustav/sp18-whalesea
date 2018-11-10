public class DrawTriangle {
	public static void drawTriangle(int n) {
		int counter = 1;
		int temp_counter;
		String outString;
		while (counter <= n) {
			temp_counter = counter;
			outString = "";
			while (temp_counter > 0) {
				outString = outString + "*";
				temp_counter = temp_counter - 1;
			}
			System.out.println(outString);
			counter = counter + 1;
		}
	}

	public static void main(String[] args) {
		drawTriangle(10);
	}
}