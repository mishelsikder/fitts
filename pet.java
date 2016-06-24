
import java.awt.Color;
import java.io.IOException;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;


public class pet {


    
    private long T = 0;
    public ArrayList<long[]> results = new ArrayList<long[]>();
    public ArrayList<int[]> buttons = new ArrayList<int[]>();
    
    private boolean started = false;

    public pet() throws IOException{
        StdDraw.setXscale(0, 800);
        StdDraw.setYscale(0, 800);

        while (true) {

            if (StdDraw.mouseClicked()) {
                start((int)(StdDraw.mouseX()), 
                      (int)(StdDraw.mouseY()));
                break;
            }
        }

        while (true) {
            results.add(new long[]{(long)StdDraw.mouseX(), 
                                    (long)StdDraw.mouseY(),
                                    System.currentTimeMillis() - T});
            if (StdDraw.mousePressed()) {
                write();
                System.exit(0);
            }
        }
    }
    
    public void start(int x, int y) throws IOException{
    
        T = System.currentTimeMillis();
        File file = new File("buttons.txt");
        
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        
        int r = 0;
        int offset = 70 + x;
        int dx = 70;

        for (int i=0; i<10; i++){
        	Random rand = new Random();
        	r = rand.nextInt(dx / 2 - 15) + 15;
        	int[] but = new int[]{i * dx + offset, y, r};

        	buttons.add(but);
        	writer.write(but[0] + " " + but[1] + " " + but[2] + "\n");
        }
        
        writer.flush();
        writer.close();
        

        drawButtons();	
    }
    

    public static void main(String[] args) throws IOException{
        pet p = new pet();
    }

    public void drawButton (int x, int y, int r) {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.circle(x, 50, r);
    }
     public void drawButtons() {
        for (int[] but: buttons) 
        	drawButton(but[0], but[1], but[2]);
     }
        

    private void write() throws IOException{
            File file = new File("mouse.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            for (long[] tuple: results) {
                writer.write(tuple[0] + " " + tuple[1] + " " + tuple[2] + "\n");
            }
            writer.flush();
            writer.close();
    }
}
