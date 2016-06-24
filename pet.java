
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;


public class pet extends JPanel implements MouseMotionListener, MouseListener{

    private long start = 0;
    //public static JFrame frame = new JFrame("frame");
    public ArrayList<long[]> results = new ArrayList<long[]>();
    public ArrayList<int[]> buttons = new ArrayList<int[]>();
    
    private boolean started = false;

    public pet() throws IOException{
        //setPreferredSize(new Dimension(870, 675));         //configuring panel
        addMouseMotionListener(this);

        StdDraw.setXscale(0, 800);
        StdDraw.setYscale(0, 800);

    }
    
    public void start(int x, int y) throws IOException{
    
        start = System.currentTimeMillis();
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
        

    @Override
    public void mouseMoved(MouseEvent e) {
        long t = System.currentTimeMillis() - start;
        int x = e.getX();
        int y = e.getY();
        results.add(new long[]{x, y, t});

        if (t > 5000) {
            try{
                write();
                System.out.println("Results written");
                System.exit(0);
            }catch(IOException ex){

            }
        }
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

    @Override
    public void mouseDragged(MouseEvent e) {
    // TODO Auto-generated method stub
    
    }
    
    public void	mouseClicked(MouseEvent e) {
    	if (!started){
    		try{
    			start(e.getX(), e.getY());
    		//start(0, 0);
    		} catch (IOException ex) {}
    		started = true;
    	} else {
    		try {
    			write();
    			System.out.println("Results written");
    			System.exit(0);
    		} catch(IOException ex) {
    		}
    	
    	}
    	
    	
    }
    public void	mouseEntered(MouseEvent e){
}
    public void	mouseExited(MouseEvent e){
    }
    public void	mousePressed(MouseEvent e){
    }
    public void	mouseReleased(MouseEvent e){
    }
}
