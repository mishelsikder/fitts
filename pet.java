
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;


public class pet extends JPanel implements MouseMotionListener{

    private long start = 0;
    public static JFrame frame = new JFrame("frame");
    public ArrayList<long[]> results = new ArrayList<long[]>();

    public pet() throws IOException{
        setPreferredSize(new Dimension(870, 675));         //configuring panel
        addMouseMotionListener(this);
        start = System.currentTimeMillis();
    }

    public static void main(String[] args) throws IOException{
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new pet();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.addMouseMotionListener(new pet());
        drawButtons(frame.getGraphics());
    }

    public static void drawButtons(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10;  j++) {
                drawButton(g, i * 30 + 20, j * 30 + 20, 15);
            }
        }
    }

    public static void drawButton(Graphics g, int x, int y, int r){
        g.setColor(Color.BLACK);
        g.drawOval(x-r,y-r,r,r);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        long t = System.currentTimeMillis() - start;
        int x = e.getX();
        int y = e.getY();
        results.add(new long[]{x, y, t});

        if (t > 10000) {
            try{
                write();
                System.out.println("Results written");
                System.exit(0);
            }catch(IOException ex){

            }
        }
    }

    private void write() throws IOException{
            File file = new File("records.txt");
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
}
