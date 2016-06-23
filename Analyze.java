import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class Analyze {

    private static double a = 0.0;
    private static double b = 0.0;


    public static void main(String[] args) {
        try {
            read();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }

    public static void read() throws IOException {

        File m = new File("mouse.txt");
        File b = new File("buttons.txt");
        Scanner mouse = new Scanner(m);
        Scanner buttons = new Scanner(b);

        while (mouse.hasNextLine()) {
            System.out.println(mouse.nextLine());

        }
    }

    public static void eq(int mx, int my, int bx, int by, int r, double v) {
        double d = Math.sqrt((mx-bx)*(mx-bx) + (my-by)*(my-by));
        double left = d / v;
        double right = a + b * (Math.log(d/r) / Math.log(2));
    }
}
