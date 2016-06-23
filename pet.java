
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
    public static ArrayList<int[]> buttons = new ArrayList<int[]>();

    public pet() throws IOException{
        setPreferredSize(new Dimension(870, 675));         //configuring panel
        addMouseMotionListener(this);
        start = System.currentTimeMillis();
    }

    public static void main(String[] args) throws IOException{
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pet p = new pet();
        JComponent newContentPane = new pet();
        p.setOpaque(true);
        frame.setContentPane(p);
        frame.pack();
        frame.setVisible(true);
        frame.addMouseMotionListener(p);
        drawButtons(frame.getGraphics());
    }

    public static void drawButtons(Graphics g) throws IOException {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10;  j++) {
                buttons.add(new int[]{i * 50 + 20, j * 50 + 20, 30});
            }
        }

        g.setColor(Color.BLACK);
        for (int[] but: buttons) drawButton(g, but[0], but[1], but[2]);
        File file = new File("buttons.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for (int[] but: buttons) {
            writer.write(but[0] + " " + but[1] + " " + but[2] + "\n");
        }
        writer.flush();
        writer.close();
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
}
