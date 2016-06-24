import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Analyze  {

	private static double a = 1 - (0.099 * 6.3);
	private static double b = 0.099;
	public static ArrayList<int[]> cords = new ArrayList<int[]>();
	public static ArrayList<int[]> buttons = new ArrayList<int[]>();

	public static void main(String[] args) {
		try {
			read();
		} catch (IOException ex) {
			System.out.println(ex);
		}

	}

	public static void read() throws IOException {

		File m = new File("mouse.txt");
		File b = new File("buttons.txt");
		Scanner mouse = new Scanner(m);
		Scanner bs = new Scanner(b);

		while (mouse.hasNextLine()) {
			String ln = mouse.nextLine();
			String[] ln2 = ln.split(" ");
			cords.add(new int[]{Integer.parseInt(ln2[0]), 
					Integer.parseInt(ln2[1]),
					Integer.parseInt(ln2[2])
			});
		}

		while (bs.hasNextLine()) {
			String ln = bs.nextLine();
			String[] ln2 = ln.split(" ");
			buttons.add(new int[]{Integer.parseInt(ln2[0]), 
					Integer.parseInt(ln2[1]),
							Integer.parseInt(ln2[2])
			});
		}
		compute();
	}
	
	public static void compute() {
		int i = 0;
		for (int[] pos: cords) {
			System.out.print(pos[2] + " ");
			for (int[] but: buttons) {
				double v = compV(i++, 1);
				double[] res = eq(pos[0], pos[1], but[0], but[1], but[2], v);
				System.out.print(res[0] + " " + res[1] + " ");
			}
			System.out.println();
		}
	}


	public static double[] eq(int mx, int my, int bx, int by, int r, double v) {
		double d = Math.sqrt((mx - bx) * (mx - bx) + (my - by) * (my - by));
		double left = d / v;
		double right = a + b * (Math.log(d / r) / Math.log(2));
		return new double[]{left, right};
	}
	
	public static double compV(int i, int k) {
		int[] a = cords.get(i);
		if (i+k >= cords.size()) return 0;
		int[] b = cords.get(i+k);
		double dd = Math.sqrt((a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]));
		double dt = b[2] - a[2];
		return dd/dt;
	}
	
}
